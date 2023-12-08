package mpop.revii.ai;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;

public class Markdown extends TextView {
	String _text = "", noCode = "";
	ArrayList<String> codes = new ArrayList<>();
	ArrayList<String> lang = new ArrayList<>();
	Context ctx;
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
	}

	public void setText(String txt){
		String[] text = txt.split("\n");
		String result = "";
		boolean x = true;
		String _code = "";
		for(int i = 0; i < text.length; i++){
			txt = text[i].replaceAll("\\<", "&lt;").replaceAll("\\>", "&gt;");
			if(txt.startsWith("```")){
				if(!txt.equals("```")){
					String[] languages = {
						"html", "css"
					};
					util.show(ctx, String.valueOf(txt.substring("``".length()).length()));
					if(txt.substring("```".length()) != null) {
						char[] c = txt.substring("```".length()).toCharArray();
						String code = String.valueOf(c[0]).toUpperCase();
						if (txt.substring("```".length()).length() > 0) {
							for (int i2 = 1; i2 < c.length; i2++) {
								code += String.valueOf(c[i2]);
							}
							for (int ii = 0; ii < languages.length; ii++) {
								if (languages[ii].equalsIgnoreCase(code)) {
									code = code.toUpperCase();
									break;
								}
							}
							lang.add(code);
						} else {
							lang.add("Unknown");
						}
						result += String.format("<h3><u><i>%s code</i></u></h3>", code);
					}else{
						lang.add("Unknown");
					}
				}
				x = !x;
				result += x ? "</font>" : String.format("<font color=\"%s\">", "#bebebe");
				if(x){
					codes.add(_code);
					_code = "";
				}
			}
			if(x){
				if(txt.startsWith("&gt; ") || txt.startsWith("> ")){
					txt = txt.replaceAll("&gt; (.*)", "&emsp;\"$1\"");
					txt = txt.replace("> (.*)", "&emsp;\"$1\"");
				}
				result += start(txt);
				noCode += start(txt);
			}else{
				if(!txt.startsWith("```")){
					result += txt.replaceAll("\t", "&emsp;").replaceAll("    ", "&emsp;").replaceAll("  ", "&emsp;");
					_code += txt.replaceAll("&lt;", "<").replaceAll( "&gt;", ">");
				}
			}
			if(i < text.length - 1){
				if(!txt.startsWith("* ")){
					result += "<br>";
					_code += (x) ? "" : "\n";
				}
			}
		}
		setText(Html.fromHtml(result));
	}

	public String getWithoutCode(){
		return Html.fromHtml(noCode).toString();
	}

	private String start(String markdown) {
		String html = markdown;

		html = html.replaceAll("###### (.*)", "<h6>$1</h6>");
		html = html.replaceAll("##### (.*)", "<h5>$1</h5>");
		html = html.replaceAll("#### (.*)", "<h4>$1</h4>");
		html = html.replaceAll("### (.*)", "<h3>$1</h3>");
		html = html.replaceAll("## (.*)", "<h2>$1</h2>");
		html = html.replaceAll("# (.*)", "<h1>$1</h1>");
		
		html = html.replaceAll("\\*\\*(.*?)\\*\\*", "<strong>$1</strong>");
		html = html.replaceAll("__(.*?)__", "<strong>$1</strong>");

		html = html.replaceAll("\\*(.*?)\\*", "<em>$1</em>");
		html = html.replaceAll("_(.*?)_", "<em>$1</em>");

		html = html.replaceAll("\\~\\~(.*?)\\~\\~", "<s>$1</s>");

		html = html.replaceAll("\\[(.*?)\\]\\((.*?)\\)", "<a href=\"$2\">$1</a>");

		html = html.replaceAll("`(.*?)`", "<font color=\"yellow\">$1</font>");
		html = html.replaceAll("\t", "&emsp;");
		html = html.replaceAll("    ", "&emsp;");
		html = html.replaceAll("  ", "&emsp;");

		html = html.replaceAll("`", "");

		html = html.replaceAll("\\-\\-\\-", "<hr>");
		
		html = html.replaceAll("\\* (.*)", "&ensp;•&ensp;$1<br>");
		
		return html;
	}
	public ArrayList<String> getAllCodes(){
		return codes;
	}
	public ArrayList<String> getLanguage(){
		return lang;
	}
}