package mpop.revii.ai;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;
import org.json.JSONObject;
import java.io.File;
import java.util.Scanner;

public class Markdown extends TextView {
	public Markdown(Context ctx){
		super(ctx);
		setup();
	}

	public Markdown(Context ctx, AttributeSet attr){
		super(ctx, attr);
		setup();
	}

	void setup(){
		setClickable(true);
		setTextIsSelectable(true);
		setLinksClickable(true);
	}

	public void setText(String txt){
		String[] text = txt.split("\n");
		String result = "";
		boolean x = true;
		for(int i = 0; i < text.length; i++){
			txt = text[i].replaceAll("\\<", "&lt;").replaceAll("\\>", "&gt;");
			if(txt.startsWith("```")){
				if(!txt.equals("```")){
					char[] c = txt.substring("```".length()).toCharArray();
					String code = String.valueOf(c[0]).toUpperCase();
					for(int i2 = 0; i2 < c.length; i2++){
						code += String.valueOf(c[i2]);
					}
					result += String.format("<h3><u><i>%s code</i></u></h3>", code);
				}
				x = !x;
				result += x ? "</font>" : "<font color=\"#bebebe\">";
			}
			if(x){
				if(txt.startsWith("&gt; ") || txt.startsWith("> ")){
					txt = txt.replaceAll("&gt; (.*)", "&emsp;\"$1\"");
					txt = txt.replace("> (.*)", "&emsp;\"$1\"");
				}
				result += start(txt);
			}else{
				if(!txt.startsWith("```")){
					result += txt.replaceAll("\t", "&emsp;").replaceAll("    ", "&emsp;").replaceAll("  ", "&emsp;");
				}
			}
			
			if(i < text.length - 1){
				if(!txt.startsWith("* ")){
					result += "<br>";
				}
			}
		}
		setText(Html.fromHtml(result));
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
	public static JSONObject getColors() {
		try {
			File file = new File("file://android_asset/a.json");
			Scanner scan = new Scanner(file);
			String txt = "";
			while (scan.hasNext()){
				txt += scan.nextLine();
				if(scan.hasNext()){
					txt += "\n";
				}
			}
			return new JSONObject(txt);
		}catch(Exception e){
			return  null;
		}
	}
}
