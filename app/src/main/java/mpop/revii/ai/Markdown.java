package mpop.revii.ai;

import android.content.Context;
import android.text.Html;
import android.widget.TextView;

public class Markdown extends TextView {
	public Markdown(Context ctx){
		super(ctx);
	}
	
	public void setText(String txt){
		String[] text = txt.split("\n");
		String result = "";
		boolean x = true;
		for(int i = 0; i < text.length; i++){
			txt = text[i].replace("<", "&lt;").replace(">", "&gt;");
			if(txt.startsWith("```")){
				x = !x;
				if(!x){
					result += "<font color=\"cyan\">";
				}else{
					result += "</font>";
				}
			}
			if(x){
				result += start(txt);
			}else{
				if(!txt.startsWith("```")){
					result += txt.replaceAll("\t", "&emsp;").replaceAll("    ", "&emsp;").replaceAll("  ", "&emsp;");
				}
			}
			if(i < text.length - 1){
				if(txt.startsWith("* ") && !txt.endsWith("*")){
					
				}else{
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
		
		html = html.replaceAll("\\* (.*)", "&ensp;<li>&ensp;$1</li>");
		html = html.replaceAll("\\> (.*?)", "<blockquote>$1</blockquote>");
		
		return html;
	}
}
