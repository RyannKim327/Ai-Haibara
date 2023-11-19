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
import android.text.Editable;
import android.text.TextWatcher;
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

public class AI extends LinearLayout {
	
	ScrollView sc;
	LinearLayout sc2;
	EditText e;
	ImageButton iv;
	SharedPreferences sp;
	int[] welcome = {504, 808, 972, 1080, 1221, 528, 448, 1856, 1872, 1940, 2420, 2568, 672, 2904, 2997, 3510, 1056, 3672, 3108, 3648, 1152, 4680, 5060, 5040, 3850, 4120, 224, 928, 936, 1050, 1265, 384, 1498, 1680, 1980, 2000, 704, 2664, 2142, 768, 3024, 3420, 3663, 3816, 2828, 3168, 4176, 1760, 1408, 5376, 3780, 4040, 679, 920, 909, 320, 1100, 1332, 1540, 624, 2088, 640, 2134, 2352, 2457, 2760, 2727, 1320, 1056, 3492, 3024, 3680, 3996, 1280, 4400, 5328, 3850, 1560, 812, 256, 891, 1040, 1067, 1320, 1442, 1616, 576, 2320, 2288, 2424, 672, 2376, 3078, 3030, 3300, 3780, 3248, 3680, 1656, 400, 440, 3216, 3990, 4040, 700, 840, 1044, 1150, 638, 120, 588, 512, 1332, 2220, 2288, 2640, 672, 1920, 2619, 3510, 3564, 1152, 1876, 3104, 3780, 4120, 4268, 5520, 1120, 1800, 434, 256, 585, 800, 803, 384, 1120, 1824, 1998, 2360, 2310, 2400, 2121, 2736, 270, 1260, 1056, 2772, 2716, 3648, 3852, 1280, 3300, 4848, 4130, 4200, 770, 256, 693, 970, 1210, 1164, 1512, 1776, 576, 900, 1364, 768, 1365, 1920, 1971, 960, 2640, 4104, 3108, 3776, 3780, 4000, 4444, 5472, 350, 1680, 224, 592, 999, 1040, 1210, 384, 1036, 1616, 2052, 2020, 2398, 2904, 672, 1560, 2970, 3480, 3465, 3708, 3276, 3552, 1152, 1800, 2728, 1536, 2940, 4040, 805, 928, 909, 1140, 110, 504, 448, 1328, 1746, 2160, 2596, 2328, 2100, 2664, 3078, 960, 1485, 2232, 896, 2464, 3492, 4560, 4708, 4800, 3885, 4760, 770, 256, 1035, 1170, 1133, 1236, 1414, 1840, 2088, 2100, 2442, 2640, 210, 1008, 864, 2220, 3663, 3744, 3080, 1024, 2952, 4440, 5324, 1536, 2660, 3880, 784, 840, 900, 970, 352, 804, 1358, 1728, 1890, 2180, 2376, 2520, 2289, 768, 1215, 1860, 1056, 2772, 2716, 3648, 3852, 4000, 4884, 5712, 3850, 1280, 805, 936, 927, 1030, 1111, 1380, 1624, 1680, 1998, 2200, 704, 2328, 2310, 2400, 864, 3030, 3630, 3564, 3192, 3872, 4032, 4640, 4620, 5328, 3850, 4600, 70, 336, 288, 820, 1221, 1320, 1358, 1728, 1800, 640, 1848, 2664, 2394, 2736, 2727, 3180, 3663, 4140, 896, 2432, 3780, 4360, 4928, 5040, 3395, 4000, 777, 256, 405, 620, 352, 888, 1358, 1888, 1746, 640, 1694, 2424, 2310, 2784, 2997, 3420, 330, 1512, 896, 2368, 3636, 4560, 5060, 5328, 3850, 1280, 469, 776, 1026, 1050, 1210, 384, 630, 992, 576, 1640, 2222, 2472, 1449, 2880, 270, 1260, 1056, 2952, 3108, 3776, 3780, 4040, 1408, 3360, 3990, 3880, 770, 792, 945, 1150, 1089, 1332, 448, 720, 1116, 640, 1804, 2424, 2163, 1656, 3240, 300, 1386, 1152, 2324, 3552, 4356, 4680, 4840, 5328, 1120, 2920, 777, 880, 288, 450, 682, 384, 1092, 1776, 576, 1340, 2288, 2328, 2310, 2472, 2727, 960, 2409, 2448, 3220, 320, 1512, 1280, 3168, 4848, 3990, 3960, 679, 840, 288, 450, 682, 384, 910, 1280, 1314, 200, 924, 768, 1449, 2328, 3078, 3240, 1056, 2988, 2912, 3360, 3960, 4040, 1408, 3984, 3395, 4760, 735, 912, 90, 420, 352, 912, 1414, 1840, 2088, 2020, 2508, 768, 1638, 2328, 3186, 2910, 3762, 4104, 2716, 320, 1512, 1280, 3036, 5184, 3710, 4440, 728, 880, 288, 710, 1221, 1320, 1708, 1552, 1944, 2020, 2530, 768, 1617, 2328, 2781, 3330, 330, 360, 2352, 3328, 3636, 4560, 4444, 1536, 3395, 4560, 707, 256, 1035, 1110, 1199, 1212, 448, 1584, 1872, 1940, 2420, 2472, 2121, 2760, 864, 3150, 3597, 4032, 3024, 3232, 3924, 4040, 4840, 5568, 3535, 4000, 224, 928, 999, 320, 1276, 1248, 1414, 512, 2016, 2280, 2442, 2472, 2394, 2328, 2943, 1320, 1056, 4284, 2912, 3360, 3564, 4160, 1408, 3504, 1120, 3880, 756, 912, 909, 970, 1100, 1452, 448, 1824, 1818, 2180, 2442, 2832, 2121, 2400, 864, 3480, 3432, 3636, 896, 3712, 3996, 4120, 4532, 5184, 3535, 1280, 686, 936, 1044, 1160, 1221, 1320, 644, 512, 1260, 2220, 2508, 768, 2541, 2664, 3159, 960, 3828, 3996, 896, 3168, 3744, 3880, 4840, 4944, 3535, 1280, 847, 888, 1053, 1140, 352, 1320, 1358, 1744, 1818, 880, 704, 2568, 2205, 2640, 2700, 3240, 3993, 1152, 3052, 3232, 4140, 4600, 4268, 4944, 3535, 1280, 294, 336, 1035, 1010, 1276, 384, 1540, 1552, 1962, 2020, 704, 2784, 2331, 768, 1134, 2880, 3993, 3996, 3276, 3648, 1152, 4400, 4268, 5232, 3535, 3840, 294, 336, 378, 320, 1067, 1320, 1400, 512, 2178, 2220, 2574, 2736, 672, 2640, 2619, 3270, 3333, 1152, 3332, 3360, 3888, 4320, 1408, 4704, 3535, 1280, 693, 832, 873, 1100, 1133, 1212, 1400, 704, 576, 2420, 2442, 2808, 672, 2616, 2619, 3630, 1056, 3492, 3024, 3680, 3996, 1280, 5148, 5520, 3535, 1280, 672, 792, 972, 1150, 1056, 384, 1554, 1824, 576, 1920, 2178, 2592, 2121, 2328, 3078, 2880, 1056, 4176, 3108, 1024, 3564, 4320, 4444, 4656, 3990, 1280, 812, 832, 909, 320, 1111, 1320, 1624, 1680, 2052, 2020, 704, 2376, 2184, 2328, 3132, 2940, 3663, 4320, 1288, 1024, 2340, 4400, 4400, 1536, 4060, 4440, 224, 792, 936, 970, 1210, 1236, 1414, 512, 2088, 2080, 2222, 768, 2436, 2496, 3078, 3030, 3201, 3600, 1092, 3680, 1152, 4640, 4444, 5760, 4060, 1280, 805, 840, 1098, 1010, 1265, 528, 448, 1872, 2070, 2020, 704, 1008, 882, 2760, 2727, 3480, 1056, 4176, 2828, 3840, 4176, 1280, 5060, 5040, 4270, 4040, 224, 928, 999, 320, 462, 1152, 1540, 1872, 1962, 1960, 2222, 2736, 2016, 1008, 1134, 1260, 1452, 1152, 3248, 3328, 3636, 1280, 4312, 4656, 4025, 4040, 224, 928, 909, 1200, 1276, 384, 1610, 1680, 2196, 2020, 704, 2856, 2331, 2808, 2916, 3000, 1056, 3528, 2828, 1024, 4356, 4440, 5148, 5472, 1120, 4400, 679, 872, 909, 320, 1221, 1368, 448, 1872, 2070, 2020, 2508, 2640, 2037, 2616, 2727, 960, 3663, 3960, 896, 3712, 3744, 4040, 1408, 5568, 3885, 4480, 224, 888, 918, 320, 1111, 1164, 1386, 1664, 576, 1980, 2288, 2328, 2436, 1104};
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

		if(send.equals(sp.getString("mpop.revii.ai.NAME", mpop(creator)))){
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
