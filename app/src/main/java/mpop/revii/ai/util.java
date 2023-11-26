package mpop.revii.ai;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import java.io.File;
import java.util.Scanner;

public class util {

	public static int setResources(Context ctx, String name, String type){
		return ctx.getResources().getIdentifier(name, type, ctx.getPackageName());
	}

	public static Toast show(Context ctx, String msg){
		Toast toast = new Toast(ctx);
		float f = 25;
		ShapeDrawable drawable = new ShapeDrawable(new RoundRectShape(new float[]{
				f, f, f, f,
				f, f, f, f
		}, null, null));
		TextView tv = new TextView(ctx);

		drawable.getPaint().setColor(Color.parseColor("#FF0085EE"));

		tv.setText(msg);
		tv.setTypeface(Typeface.SERIF);
		tv.setTextSize(15);
		tv.setTextColor(Color.WHITE);
		tv.setBackground(drawable);
		tv.setPadding(13, 5, 13, 5);
		toast.setView(tv);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
		return toast;
	}

	public static int validator(String num, int def){
		try{
			int n = Integer.parseInt(num);
			if(n > 50 || n < 5){
				n = def;
			}
			return n;
		}catch(Exception e){
			return def;
		}
	}

	public static String mpop(int[] x){
		String s = "";
		int[] t = new int[100];
		int u = 0;
		for(int i = 1; i <= 6; i++){
			for(int j = 7; j <= 12; j++){
				t[u] = i * j;
				u++;
			}
		}
		for(int i = 0; i < x.length; i++){
			int v = x[i] / t[i % 26];
			s += Character.toString((char) v);
		}

		return s.toString();
	}
	public static JSONObject getColors(String filepath) {
		try {
			File file = new File(String.format("file://android_asset/%s", filepath));
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
