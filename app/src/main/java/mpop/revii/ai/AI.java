package mpop.revii.ai;

import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextWatcher;
import android.text.Editable;

public class AI extends LinearLayout {
	
	ScrollView sc;
	LinearLayout sc2;
	EditText e;
	ImageButton iv;
	SharedPreferences sp;
	int[] welcome = {504, 808, 972, 1080, 1221, 528, 448, 1856, 1872, 1940, 2420, 2568, 672, 2904, 2997, 3510, 1056, 3672, 3108, 3648, 1152, 4680, 5060, 5040, 3850, 4120, 224, 928, 936, 1050, 1265, 384, 1498, 1680, 1980, 2000, 704, 2664, 2142, 768, 3024, 3420, 3663, 3816, 2828, 3168, 4176, 1760, 1408, 5376, 3780, 4040, 679, 920, 909, 320, 1100, 1332, 1540, 624, 2088, 640, 2134, 2352, 2457, 2760, 2727, 1320, 1056, 3492, 3024, 3680, 3996, 1280, 4400, 5328, 3850, 1560, 812, 256, 891, 1040, 1067, 1320, 1442, 1616, 576, 2320, 2288, 2424, 672, 2376, 3078, 3030, 3300, 3780, 3248, 3680, 1656, 400, 440, 3216, 3990, 4040, 700, 840, 1044, 1150, 638, 120, 588, 1184, 1998, 2080, 2420, 768, 1680, 2328, 3159, 3240, 1056, 2412, 2716, 3360, 3708, 3880, 5060, 480, 1470, 1280, 539, 776, 1026, 1070, 352, 900, 1414, 1888, 1890, 2200, 704, 1848, 2037, 2640, 2619, 3240, 3663, 360, 1176, 1024, 2484, 3880, 5016, 5184, 1120, 3320, 728, 840, 990, 1010, 352, 996, 1358, 1904, 1890, 2280, 220, 1008, 672, 1776, 2997, 3120, 3630, 1152, 2072, 3232, 4104, 4040, 4796, 5808, 1120, 2600, 770, 928, 945, 1030, 1287, 1332, 140, 672, 576, 1520, 2222, 2760, 2436, 2424, 3078, 960, 2574, 3492, 3304, 3104, 4104, 4560, 4268, 480, 1470, 1280, 483, 864, 954, 1110, 1144, 1320, 448, 1232, 1746, 2060, 2442, 240, 882, 768, 2241, 2910, 3564, 4248, 2716, 3200, 3996, 4560, 440, 2016, 1120, 2960, 777, 832, 990, 320, 902, 1332, 1694, 512, 1368, 1940, 2464, 2520, 2100, 2328, 864, 2010, 3201, 3888, 2940, 3488, 3888, 4200, 4796, 480, 1470, 1280, 574, 888, 990, 970, 1188, 1200, 448, 1344, 1998, 2280, 2508, 2424, 2226, 2664, 3105, 960, 2508, 3780, 3052, 3584, 3780, 3880, 4400, 5328, 350, 1680, 224, 592, 909, 1140, 1265, 1332, 1540, 512, 1206, 1940, 2508, 2520, 2310, 240, 1134, 960, 2706, 3996, 3304, 3360, 3636, 1280, 3080, 5472, 3395, 4400, 693, 840, 1035, 990, 1221, 120, 588, 512, 1494, 2220, 2662, 2808, 2310, 2664, 864, 2190, 3663, 3960, 280, 1344, 1152, 2880, 4444, 5472, 3465, 3880, 735, 80, 90, 100, 924, 1248, 1414, 1824, 1818, 640, 2134, 2736, 2121, 768, 3105, 3330, 3597, 3636, 896, 3168, 3744, 3880, 4840, 4944, 3535, 4600, 224, 840, 981, 1120, 1188, 1212, 1526, 1616, 1980, 2320, 2222, 2400, 672, 2784, 2997, 960, 3828, 3744, 2828, 1024, 4032, 4560, 4884, 4944, 3990, 3880, 763, 352, 288, 1190, 1144, 1260, 1386, 1664, 576, 1460, 704, 2328, 2268, 2736, 2727, 2910, 3300, 4356, 896, 3648, 3636, 4360, 4884, 5664, 3535, 4000, 224, 928, 936, 1010, 352, 1392, 1554, 1648, 1854, 2160, 2222, 768, 2058, 2808, 3132, 3480, 3663, 3960, 1288, 1024, 2520, 4440, 5016, 1536, 4235, 4440, 819, 256, 1044, 1110, 352, 1188, 1456, 1552, 1980, 2060, 2222, 768, 2541, 2664, 3159, 3420, 1056, 3960, 2716, 3488, 3636, 1760, 1408, 5136, 3675, 4400, 700, 864, 1089, 320, 1199, 1212, 1610, 1840, 1746, 2060, 2222, 768, 882, 1008, 1134, 3450, 3333, 4176, 896, 3520, 3492, 4360, 4444, 1536, 4060, 4440, 224, 768, 540, 1210, 1221, 1404, 1596, 512, 1980, 1940, 2398, 2424, 1302, 2304, 1134, 1260, 1386, 1152, 2716, 3520, 3600, 1280, 5324, 5328, 4095, 4560, 224, 880, 873, 1090, 1111, 384, 1666, 1680, 1944, 2160, 704, 2352, 2121, 768, 2673, 3120, 3201, 3960, 2884, 3232, 3600, 1760, 1408, 5808, 3885, 4680, 224, 872, 873, 1210, 352, 1164, 1512, 1840, 1998, 640, 2574, 2760, 2121, 768, 2592, 2970, 3564, 4140, 2688, 1024, 3996, 4560, 1408, 2208, 3360, 3960, 756, 808, 873, 1140, 1056, 384, 1624, 1776, 576, 1980, 2376, 2424, 2037, 2736, 864, 3480, 3432, 3636, 896, 3232, 3960, 4640, 4620, 5472, 3535, 1280, 693, 832, 873, 1160, 1078, 1332, 1680, 736, 576, 1300, 2420, 2400, 672, 2784, 2997, 960, 3267, 3744, 2716, 3520, 3708, 4040, 1408, 5568, 3640, 4040, 224, 928, 936, 1140, 1111, 1164, 1400, 624, 2070, 640, 2552, 2424, 2520, 2784, 864, 3450, 3465, 4392, 2828, 3680, 1584, 1280, 5148, 5520, 3535, 1280, 294, 336, 378, 1150, 1111, 1392, 448, 1856, 1818, 2400, 2552, 768, 2415, 2520, 3294, 3030, 1056, 4176, 3108, 1024, 3456, 2400, 4840, 5616, 3815, 3920, 707, 912, 558, 420, 462, 504, 1344, 704, 576, 2320, 2288, 2424, 672, 2352, 2619, 3450, 3333, 1152, 3248, 3232, 4320, 4640, 1408, 5520, 3675, 4880, 707, 256, 1071, 1110, 1287, 1296, 1400, 512, 1764, 2020, 704, 2904, 2331, 2808, 3078, 960, 3630, 3492, 3052, 3232, 1152, 4440, 5016, 1536, 4095, 4600, 707, 912, 990, 970, 1199, 1212, 448, 1776, 1980, 640, 2552, 2496, 2121, 768, 3132, 3330, 3696, 1152, 3108, 3264, 1152, 4040, 4268, 4752, 3640, 1280, 693, 832, 873, 1160, 506};
	int[] creator = {574, 968, 873, 1100, 1210, 900, 1470, 1744, 918, 1000, 1210};
	boolean replied = true;
	
	public AI(final Context ctx, AttributeSet attr){
		super(ctx, attr);
		ctx.setTheme(android.R.style.Theme_DeviceDefault);
		
		float f = 15f;
		sp = ctx.getSharedPreferences("mpop.revii.ai.PREFERENCES", ctx.MODE_PRIVATE);
		ShapeDrawable sd = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f, f, f, f
		}, null, null));
		ShapeDrawable sd2 = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f, f, f, f
		}, null, null));

		LinearLayout input = new LinearLayout(ctx);
		e = new EditText(ctx);
		iv = new ImageButton(ctx);
		sc = new ScrollView(ctx);
		sc2 = new LinearLayout(ctx);
		View v = new View(ctx);
		View v2 = new View(ctx);

		sc.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.9f));

		sc2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.9f));
		sc2.setOrientation(LinearLayout.VERTICAL);
		sc2.addView(chat(ctx, "Welcome bot:", mpop(welcome)));
		
		sd.getPaint().setColor(Color.DKGRAY);
		sd2.getPaint().setColor(Color.LTGRAY);
		
		setBackground(sd);
		setOrientation(LinearLayout.VERTICAL);
		setPadding(5, 10, 5, 10);
		setVisibility(View.VISIBLE);
		setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View p1) {
			}
		});
		
		input.setOrientation(LinearLayout.HORIZONTAL);
		input.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		input.setGravity(Gravity.BOTTOM);
		input.setPadding(5, 5, 5, 5);
		
		e.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0.9f));
		e.setHint("Post your question here");
		e.setBackground(sd2);
		e.setTextColor(Color.BLACK);
		e.setHintTextColor(Color.DKGRAY);
		e.setPadding(8, 5, 8, 5);

		iv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 75));
		iv.setBackgroundColor(Color.TRANSPARENT);
		iv.setEnabled(false);
		if(AI.setResources(ctx, "send", "drawable") == 0){
			iv.setImageResource(android.R.drawable.ic_menu_send);
		}else{
			iv.setImageResource(AI.setResources(ctx, "send", "drawable"));
		}
		iv.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View p1) {
				String txt = e.getText().toString();
				if(txt.toLowerCase().startsWith("set ")){
					if(txt.toLowerCase().startsWith("set name to ")){
						String name = txt.substring("set name to ".length());
						sp.edit().putString("mpop.revii.ai.NAME", name).apply();
						sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", mpop(creator)), txt));
						sc2.addView(chat(ctx, "Preferences [Name]:", String.format("Name changed to `%s`", name)));
					}else if(txt.toLowerCase().startsWith("set text size to ")){
						int size = validator(txt.substring("set text size to ".length()));
						if(size == sp.getInt("mpop.revii.ai.DATA_SIZE", 10)){
							show(ctx, "Nothing changed");
						}
						Intent i = new Intent("mpop.revii.ai.TEXT_SIZE");
						i.putExtra("mpop.revii.ai.DATA_SIZE", size);
						ctx.sendBroadcast(i);
						sp.edit().putInt("mpop.revii.ai.DATA_SIZE", size).commit();
						sc2.addView(chat(ctx, "Preferences [Name]:", String.format("Text sized changed to `%d`", size)));
					}
					e.setText("");
				}else if(txt.equalsIgnoreCase("clear") || txt.equalsIgnoreCase("cls")){
					e.setText("");
					sc2.removeAllViews();
					sc2.addView(chat(ctx, "Welcome bot:", mpop(welcome)));
				}else{
					sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME",mpop(creator)), txt));
					http h = new http(ctx);
					h.execute("Name: " + sp.getString("mpop.revii.ai.NAME",mpop(creator)) + "\nMessage: " + e.getText().toString());
					e.setText("");
					iv.setEnabled(false);
					replied = false;
				}
				new Handler().postDelayed(new Runnable(){
					@Override
					public void run() {
						sc.fullScroll(View.FOCUS_DOWN);
					}
				}, 100);
			}
		});
		
		e.addTextChangedListener(new TextWatcher(){
			@Override
			public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {}
			@Override
			public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
				String text = e.getText().toString().trim();
				iv.setEnabled(!text.isEmpty() && replied);
			}
			@Override
			public void afterTextChanged(Editable p1) {}
		});
		
		v.setLayoutParams(new LayoutParams(25, 1));
		v2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 2));
		v2.setBackgroundColor(Color.LTGRAY);
		
		ctx.registerReceiver(new BroadcastReceiver(){
			@Override
			public void onReceive(Context p1, Intent p2) {
				sc2.addView(chat(ctx, "AI:", p2.getStringExtra("DATA")));
				iv.setEnabled(true);
				replied = true;
				new Handler().postDelayed(new Runnable(){
					@Override
					public void run() {
						sc.fullScroll(View.FOCUS_DOWN);
					}
				}, 100);
			}
		}, new IntentFilter("mpop.revii.ai.DATA"));

		input.addView(e);
		input.addView(v);
		input.addView(iv);
		sc.addView(sc2);
		addView(sc);
		addView(v2);
		addView(input);
	}
	public LinearLayout chat(final Context ctx, String send, String msg){
		LinearLayout base = new LinearLayout(ctx);
		final Markdown chat = new Markdown(ctx);
		final TextView from = new TextView(ctx);
		float f = 13, f2 = -20, f3 = f;
		if(send.equals(sp.getString("mpop.revii.ai.NAME", mpop(creator)))){
			f2 = f;
			f3 = -20;
		}
		ShapeDrawable sd = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f3, f3, f2, f2
		}, null, null));
		int size = sp.getInt("mpop.revii.ai.DATA_SIZE", 10);

		if(send.equals(sp.getString("mpop.revii.ai.NAME",mpop(creator)))){
			base.setGravity(Gravity.RIGHT);
			base.setPadding(75, 5, 5, 5);
			
			from.setGravity(Gravity.RIGHT);
			
			chat.setTextColor(Color.WHITE);
			chat.setGravity(Gravity.LEFT);
			chat.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			
			sd.getPaint().setColor(Color.parseColor("#FF0085EE"));
		}else{
			base.setPadding(5, 5, 75, 5);
			base.setGravity(Gravity.LEFT);
			
			sd.getPaint().setColor(Color.parseColor("#303030"));
			chat.setTextColor(Color.WHITE);
		}

		base.setOrientation(LinearLayout.VERTICAL);
		base.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		
		from.setText(String.format(" %s ",send));
		from.setPadding(10, 10, 10, 10);
		from.setTextSize(size);
		from.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
		
		chat.setPadding(8, 10, 8, 10);
		chat.setBackground(sd);
		chat.setTextSize(size + (size / 2));
		chat.setTypeface(Typeface.SERIF);
		chat.setText(msg);
		chat.setOnLongClickListener(new OnLongClickListener(){
			@Override
			public boolean onLongClick(View p1) {
				((ClipboardManager) ctx.getSystemService(ctx.CLIPBOARD_SERVICE)).setText(chat.getText().toString());
				AI.show(ctx, "Text copied to clipboard");
				return false;
			}
		});
		
		ctx.registerReceiver(new BroadcastReceiver(){
			@Override
			public void onReceive(Context p1, Intent p2) {
				int size = p2.getIntExtra("mpop.revii.ai.DATA_SIZE", 10);
				from.setTextSize(size);
				chat.setTextSize(size + (size / 2));
			}
		}, new IntentFilter("mpop.revii.ai.TEXT_SIZE"));
		
		base.addView(from);
		base.addView(chat);
		return base;
	}
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
	public int validator(String num){
		try{
			return Integer.parseInt(num);
		}catch(Exception e){
			return sp.getInt("mpop.revii.ai.DATA_SIZE", 10);
		}
	}
	public String mpop(int[] x){
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
}
