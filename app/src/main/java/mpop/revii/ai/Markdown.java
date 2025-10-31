package mpop.revii.ai;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.QuoteSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;

public class Markdown extends TextView {
	String _text = "", noCode = "";
	ArrayList<String> codes = new ArrayList<>();
	ArrayList<String> lang = new ArrayList<>();
	Context ctx;
	String blockquote = "",
	mark = "#ccff20",
	bgCode = "#303030",
	quote = "#ffffff";
	
	public Markdown(Context ctx){
		super(ctx);
		setup(ctx);
	}

	public Markdown(Context ctx, AttributeSet attr){
		super(ctx, attr);
		setup(ctx);
	}

	void setup(Context context){
		ctx = context;
		if(codes.size() <= 0) {
			setClickable(true);
			setTextIsSelectable(true);
			setLinksClickable(true);
		}
		
		// INFO: Setup for colors from resources
		
		blockquote = util.tocolor(ctx, "blockquote", blockquote);
		mark = util.tocolor(ctx, "mark", mark);
		bgCode =  util.tocolor(ctx, "codebg", bgCode);
		quote = util.tocolor(ctx, "quote", quote);
		
		String txt = getText().toString();
		setText("");
		setText(txt);
	} 

	public void setText(String txt){
		try{
			String[] strArr = txt.split("\n");
			SpannableStringBuilder text = new SpannableStringBuilder();
			boolean trigger = false;
			String code = "";
			int lines = 0;
			for(String s : strArr){
				if(s.startsWith("```")){
					if(!s.equals("```") || !trigger){
						if(!s.equals("```")){
							String _ = s.substring("```".length());
							String __ = "html css js";
							if(__.contains(_)){
								_.toUpperCase();
							}else{
								String x = "";
								for(int i = 0; i < _.length(); i++){
									if(x == ""){
										x += String.valueOf(_.charAt(i)).toUpperCase();
									}else{
										x += String.valueOf(_.charAt(i));
									}
								}
								_ = x;
							}
							lang.add(_);
						}else{
							lang.add("Unknown Language");
						}
					}else{
						code += "";
						codes.add(code);
						code = "";
					}
					trigger = !trigger;
					// code = "";
				}else if(trigger){
					Spanned c = code(s);
					text.append(c);
					code += String.format("%s \n", s);
					if(lines < strArr.length - 1){
						text.append(Html.fromHtml("<br>"));
					}
				}else{
					Spanned t = scan(s);
					text.append(t);
					if(lines < strArr.length - 1){
						text.append(Html.fromHtml("<br>"));
					}
					noCode += t.toString() + "\n";
				}
				lines++;
			}
			setText(new SpannableString(text));
		}catch(Exception e){}
		
	}

	public String getWithoutCode(){
		return Html.fromHtml(noCode).toString();
	}

	private Spanned scan(String str){
		Spanned span = null;
		
		// Headers

		str = str.replaceAll("^###### (.*)$", "<h6 style=\"margin: 0; padding: 0;\">$1</h6>");
		str = str.replaceAll("^##### (.*)$", "<h5 style=\"margin: 0; padding: 0;\">$1</h5>");
		str = str.replaceAll("^#### (.*)$", "<h4 style=\"margin: 0; padding: 0; font-family: monospace;\">$1</h4>");
		str = str.replaceAll("^### (.*)$", "<h3 style=\"margin: 0; padding: 0; font-family: serif;\">$1</h3>");
		str = str.replaceAll("^## (.*)$", "<h2 style=\"margin: 0; padding: 0;\">$1</h2>");
		str = str.replaceAll("^# (.*)$", "<h1 style=\"margin: 0; padding: 0;\">$1</h1>");

		// Bold

		str = str.replaceAll("\\*\\*(.*?)\\*\\*", "<strong style=\"margin: 0; padding: 0;\">$1</strong>");
		str = str.replaceAll("__(.*?)__", "<strong style=\"margin: 0; padding: 0;\">$1</strong>");

		// Italic

		str = str.replaceAll("\\*(.*?)\\*", "<em style=\"margin: 0; padding: 0;\">$1</em>");
		str = str.replaceAll("_(.*?)_", "<em style=\"margin: 0; padding: 0;\">$1</em>");

		// Strikethrough

		str = str.replaceAll("\\~\\~(.*?)\\~\\~", "<s style=\"margin: 0; padding: 0;\">$1</s>");

		// Tabs

		str = str.replaceAll("\t", "&emsp;");
		str = str.replaceAll("	", "&emsp;");
		str = str.replaceAll("    ", "&emsp;");
		str = str.replaceAll("  ", "&emsp;");
		
		// Listing
		
		str = str.replaceAll("^\\* (.*)", "&ensp;•&ensp;$1");
		
		// Mark
		
		str = str.replaceAll("`(.*?)`", String.format("<font face=\"serif\" color=\"%s\"><u>$1</u></font>", mark));
		
		// HTML Anti Bypass
		str = str.replaceAll("\\>", "&gt;");
		str = str.replaceAll("\\<", "&lt;");
		
		if(str.startsWith("&gt; ")){
			str = str.replaceAll("&gt;", ">");
			str = str.replaceAll("&lt;", "<");
			SpannableString st = new SpannableString(Html.fromHtml("&emsp;" + str.substring("> ".length())));
			QuoteSpan qspan = new QuoteSpan(Color.parseColor(quote));
			st.setSpan(qspan, 0, st.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			span = st;
		}else{
			String[] s = str.split("\\s");
			SpannableStringBuilder builder = new SpannableStringBuilder();
			for(String t : s){
				if(t.startsWith("`") && t.endsWith("`")){
					SpannableString st = new SpannableString(t.substring("`".length(), t.length() - 1));
					BackgroundColorSpan bg = new BackgroundColorSpan(Color.parseColor("#30303090"));
					st.setSpan(bg, 0, st.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
					builder.append(st);
				}
			}
			str = str.replaceAll("&gt;", ">");
			str = str.replaceAll("&lt;", "<");
			builder.append(Html.fromHtml(str, Html.FROM_HTML_OPTION_USE_CSS_COLORS));
			span = builder;
		}
		return span;
	}
	private Spanned code(String code){
		SpannableStringBuilder str = new SpannableStringBuilder();
		if(!code.startsWith("```")){
			SpannableString st = new SpannableString(code);
			BackgroundColorSpan bg = new BackgroundColorSpan(Color.parseColor(String.format("%s90", bgCode)));
			st.setSpan(bg, 0, st.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			str.append(st);
		}
		return str;
	}
	public ArrayList<String> getAllCodes(){
		return codes;
	}
	public ArrayList<String> getLanguage(){
		return lang;
	}
}

