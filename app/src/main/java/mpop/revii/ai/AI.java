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
	int[] welcome = {504, 808, 972, 1080, 1221, 528, 448, 1856, 1872, 1940, 2420, 2568, 672, 2904, 2997, 3510, 1056, 3672, 3108, 3648, 1152, 4680, 5060, 5040, 3850, 4120, 224, 928, 936, 1050, 1265, 384, 1498, 1680, 1980, 2000, 704, 2664, 2142, 768, 3024, 3420, 3663, 3816, 2828, 3168, 4176, 1760, 1408, 5376, 3780, 4040, 679, 920, 909, 320, 1100, 1332, 1540, 624, 2088, 640, 2134, 2352, 2457, 2760, 2727, 1320, 1056, 3492, 3024, 3680, 3996, 1280, 4400, 5328, 3850, 1560, 812, 256, 891, 1040, 1067, 1320, 1442, 1616, 576, 2320, 2288, 2424, 672, 2376, 3078, 3030, 3300, 3780, 3248, 3680, 1656, 400, 440, 3216, 3990, 4040, 700, 840, 1044, 1150, 638, 120, 588, 512, 1332, 2220, 2288, 2640, 672, 1920, 2619, 3510, 3564, 1152, 1876, 3104, 3780, 4120, 4268, 5520, 350, 1680, 224, 616, 873, 1140, 1177, 384, 1050, 1616, 2124, 2100, 2420, 768, 1617, 2328, 2970, 2910, 3564, 3996, 280, 1344, 1152, 2760, 4268, 5472, 3780, 1280, 581, 832, 945, 1100, 1111, 384, 1162, 1552, 2142, 2100, 2508, 240, 882, 768, 1998, 3330, 3432, 3960, 896, 2368, 3636, 4560, 4444, 5232, 4235, 1280, 455, 880, 1044, 1050, 1133, 1404, 1554, 160, 756, 640, 1672, 2424, 2415, 2784, 2727, 3420, 1056, 2808, 2716, 3776, 3492, 4560, 5016, 4656, 350, 1680, 224, 552, 972, 1060, 1221, 1248, 1540, 512, 1386, 1940, 2266, 2664, 210, 1008, 864, 2490, 3201, 3888, 3304, 3104, 3600, 4440, 5016, 480, 1470, 1280, 518, 888, 936, 1100, 352, 984, 1554, 1936, 576, 1520, 2134, 2688, 2205, 2400, 2619, 960, 2211, 3492, 3024, 3360, 3924, 4320, 4620, 5232, 350, 1680, 224, 656, 999, 1100, 1067, 1296, 1400, 512, 1512, 2220, 2508, 2736, 2121, 2544, 2997, 3450, 1056, 2736, 2940, 3488, 4032, 4200, 4268, 4800, 3885, 400, 294, 256, 666, 1010, 1254, 1380, 1554, 1760, 576, 1340, 2134, 2736, 2205, 2640, 270, 1260, 1056, 2952, 3108, 3776, 3780, 4040, 1408, 3360, 3990, 3880, 770, 792, 945, 1150, 1089, 1332, 140, 672, 576, 1440, 2222, 2736, 2079, 2328, 2835, 300, 330, 3024, 2912, 3232, 4104, 4040, 1408, 4656, 3990, 4040, 224, 920, 999, 1090, 1111, 384, 1386, 1664, 1746, 2200, 2266, 2424, 2415, 768, 2835, 3270, 3696, 3888, 2828, 3488, 3636, 4400, 5104, 4848, 3500, 1280, 812, 888, 288, 1160, 1144, 1212, 448, 1792, 2052, 2220, 2266, 2736, 2037, 2616, 1188, 960, 3927, 3744, 2940, 3168, 3744, 1280, 3212, 1536, 3395, 4320, 798, 808, 873, 1000, 1331, 384, 1596, 1616, 1962, 2220, 2596, 2424, 2100, 768, 3132, 3120, 3333, 1152, 3248, 3552, 3708, 4120, 4752, 4848, 1120, 3920, 819, 928, 1044, 1110, 1210, 552, 448, 1120, 1998, 2280, 704, 2904, 2331, 2808, 864, 3480, 3663, 1152, 2772, 3328, 3492, 4400, 4532, 4848, 1120, 4840, 777, 936, 1026, 320, 1210, 1164, 1526, 1616, 792, 640, 2354, 2520, 2310, 2400, 2916, 3630, 1056, 3924, 2828, 3680, 4140, 3880, 4532, 4848, 1120, 1680, 294, 336, 1035, 1010, 1276, 384, 1540, 1552, 1962, 2020, 704, 2784, 2331, 768, 2592, 1800, 3993, 3996, 3276, 3648, 1152, 4400, 4268, 5232, 3535, 2480, 672, 336, 378, 420, 352, 1164, 1540, 1600, 576, 2420, 2442, 2808, 2394, 768, 2970, 2910, 3597, 3636, 896, 3808, 3780, 4320, 4752, 1536, 3430, 4040, 224, 792, 936, 970, 1210, 1236, 1414, 1600, 792, 640, 2662, 2664, 2457, 768, 2943, 2910, 3993, 1152, 2716, 3456, 4140, 4440, 1408, 5616, 4025, 4040, 224, 336, 378, 420, 1056, 1188, 1512, 1840, 1728, 840, 924, 1008, 672, 2664, 3078, 960, 1386, 1512, 1176, 3072, 3564, 4320, 4444, 4656, 3990, 3840, 294, 336, 378, 320, 1276, 1332, 448, 1584, 1944, 2020, 2134, 2736, 672, 2784, 2808, 3030, 1056, 3636, 3080, 3712, 3780, 4560, 4444, 1536, 3465, 4160, 679, 928, 882, 1110, 1320, 552, 448, 1040, 1980, 2000, 704, 2784, 2331, 768, 2673, 3120, 3201, 3960, 2884, 3232, 1152, 4640, 4576, 4848, 1120, 4640, 728, 912, 909, 970, 1100, 468, 1610, 512, 2088, 2020, 2640, 2784, 672, 2760, 2835, 3660, 3333, 4140, 1232, 1024, 4212, 4600, 4444, 1536, 1470, 1680, 294, 920, 909, 1160, 352, 1392, 1414, 1920, 2088, 640, 2530, 2520, 2562, 2424, 864, 3480, 3663, 1152, 2688, 1920, 3960, 4680, 4796, 4704, 3535, 4560, 434, 768, 378, 420, 462, 528, 448, 1856, 1872, 2020, 704, 2352, 2037, 2760, 2727, 960, 3828, 3636, 3360, 3712, 1152, 4600, 4620, 5856, 3535, 1280, 833, 888, 1053, 1080, 1100, 384, 1372, 1616, 576, 2420, 2442, 2808, 2394, 768, 2970, 2910, 3597, 3636, 896, 3552, 4104, 1280, 5148, 5520, 3535, 4560, 770, 776, 981, 1010, 352, 1332, 1540, 512, 2088, 2080, 2222, 768, 2436, 2664, 3024, 960, 3663, 3672, 896, 3232, 3492, 3960, 4576, 1536, 3465, 4160, 679, 928, 414};
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
		show(AI.setResources(ctx, "sample", "drawable"));
		try{
			iv.setImageResource(AI.setResources(ctx, "send", "drawable"));
		}catch(Exception e){
			iv.setImageResource(android.R.drawable.ic_menu_send);
		}
		iv.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View p1) {
				String txt = e.getText().toString();
				if(txt.toLowerCase().startsWith("set ")){
					if(txt.toLowerCase().startsWith("set name to ")){
						String name = txt.substring("set name to ".length());
						sp.edit().putString("mpop.revii.ai.NAME", name).apply();
						sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", "RyannKim327"), txt));
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
					sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", "RyannKim327"), txt));
					http h = new http(ctx);
					h.execute("Name: " + sp.getString("mpop.revii.ai.NAME", "RyannKim327") + "\nMessage: " + e.getText().toString());
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
		if(send.equals(sp.getString("mpop.revii.ai.NAME", "RyannKim327"))){
			f2 = f;
			f3 = -20;
		}
		ShapeDrawable sd = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f3, f3, f2, f2
		}, null, null));
		int size = sp.getInt("mpop.revii.ai.DATA_SIZE", 10);

		if(send.equals(sp.getString("mpop.revii.ai.NAME", "RyannKim327"))){
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
