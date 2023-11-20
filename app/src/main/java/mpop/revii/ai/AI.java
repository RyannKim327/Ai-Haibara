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
	int[] welcome = {504, 808, 972, 1080, 1221, 528, 448, 1856, 1872, 1940, 2420, 2568, 672, 2904, 2997, 3510, 1056, 3672, 3108, 3648, 1152, 4680, 5060, 5040, 3850, 4120, 224, 928, 936, 1050, 1265, 384, 1498, 1680, 1980, 2000, 704, 2664, 2142, 768, 3024, 3420, 3663, 3816, 2828, 3168, 4176, 1760, 1408, 5376, 3780, 4040, 679, 920, 909, 320, 1100, 1332, 1540, 624, 2088, 640, 2134, 2352, 2457, 2760, 2727, 1320, 1056, 3492, 3024, 3680, 3996, 1280, 4400, 5328, 3850, 1560, 812, 256, 891, 1040, 1067, 1320, 1442, 1616, 576, 2320, 2288, 2424, 672, 2376, 3078, 3030, 3300, 3780, 3248, 3680, 1656, 400, 440, 3216, 3990, 4040, 700, 840, 1044, 1150, 638, 120, 588, 512, 1332, 2220, 2288, 2640, 672, 1920, 2619, 3510, 3564, 1152, 1876, 3104, 3780, 4120, 4268, 5520, 1120, 1800, 434, 256, 585, 800, 803, 384, 1120, 1824, 1998, 2360, 2310, 2400, 2121, 2736, 270, 1260, 1056, 2772, 2716, 3648, 3852, 1280, 3300, 4848, 4130, 4200, 770, 256, 693, 970, 1210, 1164, 1512, 1776, 576, 900, 1364, 768, 1365, 1920, 1971, 960, 2640, 4104, 3108, 3776, 3780, 4000, 4444, 5472, 350, 1680, 224, 592, 999, 1040, 1210, 384, 1036, 1616, 2052, 2020, 2398, 2904, 672, 1560, 2970, 3480, 3465, 3708, 3276, 3552, 1152, 1800, 2728, 1536, 2940, 4040, 805, 928, 909, 1140, 110, 504, 448, 1328, 1746, 2160, 2596, 2328, 2100, 2664, 3078, 960, 1485, 2232, 896, 2464, 3492, 4560, 4708, 4800, 3885, 4760, 770, 256, 1035, 1170, 1133, 1236, 1414, 1840, 2088, 2100, 2442, 2640, 210, 1008, 864, 2220, 3663, 3744, 3080, 1024, 2952, 4440, 5324, 1536, 2660, 3880, 784, 840, 900, 970, 352, 804, 1358, 1728, 1890, 2180, 2376, 2520, 2289, 768, 1215, 1860, 1056, 2772, 2716, 3648, 3852, 4000, 4884, 5712, 3850, 1280, 805, 936, 927, 1030, 1111, 1380, 1624, 1680, 1998, 2200, 704, 2328, 2310, 2400, 864, 3030, 3630, 3564, 3192, 3872, 4032, 4640, 4620, 5328, 3850, 4600, 70, 336, 288, 820, 1221, 1320, 1358, 1728, 1800, 640, 1848, 2664, 2394, 2736, 2727, 3180, 3663, 4140, 896, 2432, 3780, 4360, 4928, 5040, 3395, 4000, 777, 256, 405, 620, 352, 888, 1358, 1888, 1746, 640, 1694, 2424, 2310, 2784, 2997, 3420, 330, 1512, 896, 2368, 3636, 4560, 5060, 5328, 3850, 1280, 469, 776, 1026, 1050, 1210, 384, 630, 992, 576, 1640, 2222, 2472, 1449, 2880, 270, 1260, 1056, 2952, 3108, 3776, 3780, 4040, 1408, 3360, 3990, 3880, 770, 792, 945, 1150, 1089, 1332, 448, 720, 1116, 640, 1804, 2424, 2163, 1656, 3240, 300, 1386, 1152, 2324, 3552, 4356, 4680, 4840, 5328, 1120, 2920, 777, 880, 288, 450, 682, 384, 1092, 1776, 576, 1340, 2288, 2328, 2310, 2472, 2727, 960, 2409, 2448, 3220, 320, 1512, 1280, 3168, 4848, 3990, 3960, 679, 840, 288, 450, 682, 384, 910, 1280, 1314, 200, 924, 768, 1449, 2328, 3078, 3240, 1056, 2988, 2912, 3360, 3960, 4040, 1408, 3984, 3395, 4760, 735, 912, 90, 420, 352, 912, 1414, 1840, 2088, 2020, 2508, 768, 1638, 2328, 3186, 2910, 3762, 4104, 2716, 320, 1512, 1280, 3036, 5184, 3710, 4440, 728, 880, 288, 710, 1221, 1320, 1708, 1552, 1944, 2020, 2530, 768, 1617, 2328, 2781, 3330, 330, 360, 1736, 1024, 3024, 4160, 4444, 5472, 3535, 1280, 679, 912, 909, 320, 1265, 1332, 1526, 1616, 576, 1980, 2288, 2328, 2310, 2472, 2727, 3450, 1056, 3780, 3052, 3584, 3888, 4040, 4796, 4848, 3850, 4640, 707, 800, 288, 1160, 1221, 384, 1624, 1664, 1818, 640, 2464, 2736, 2331, 2472, 3078, 2910, 3597, 1584, 896, 3808, 3744, 4200, 4356, 4992, 1120, 2920, 224, 776, 972, 1140, 1111, 1164, 1400, 1936, 576, 2280, 2222, 2616, 2331, 2832, 2727, 3000, 1056, 4176, 2912, 3232, 1152, 4640, 4884, 4944, 3605, 4320, 707, 256, 882, 1170, 1276, 1392, 1554, 1760, 828, 640, 1540, 2664, 2394, 768, 3267, 3330, 3861, 1152, 3248, 3552, 1152, 3960, 4576, 4656, 3850, 4120, 707, 256, 1089, 1110, 1287, 1368, 448, 1760, 1746, 2180, 2222, 1056, 672, 2568, 2835, 3300, 3300, 3888, 3388, 1024, 3924, 4040, 5060, 5520, 3395, 4120, 707, 256, 378, 420, 1265, 1212, 1624, 512, 1980, 1940, 2398, 2424, 672, 2784, 2997, 960, 1386, 3456, 3388, 3552, 4212, 4560, 1408, 5280, 3395, 4360, 707, 768, 378, 420, 462, 384, 1358, 1760, 1800, 640, 2662, 2664, 2457, 2736, 864, 3300, 3201, 3924, 2828, 1024, 4284, 4200, 4752, 5184, 1120, 3920, 707, 256, 891, 1040, 1067, 1320, 1442, 1616, 1800, 880, 704, 2904, 2331, 2808, 864, 3270, 3201, 4356, 896, 3104, 3888, 4600, 4884, 1536, 4095, 4600, 707, 256, 864, 990, 1188, 1380, 1344, 512, 1998, 2280, 704, 2304, 2079, 2592, 2727, 2910, 3762, 3456, 896, 3712, 3996, 1280, 4356, 5184, 3535, 3880, 798, 256, 1044, 1040, 1111, 384, 1414, 1760, 2088, 2100, 2508, 2424, 672, 2376, 2808, 2910, 3828, 3528, 3108, 3840, 1656, 1280, 2860, 5280, 3500, 1280, 812, 888, 288, 990, 1144, 1164, 1540, 1648, 1818, 640, 2552, 2496, 2121, 768, 3132, 3120, 3762, 3636, 2716, 3200, 1404, 4600, 1408, 5568, 3535, 4800, 812, 256, 1035, 1050, 1342, 1212, 1610, 704, 576, 2340, 2530, 2424, 672, 1008, 1134, 3450, 3333, 4176, 896, 3712, 3636, 4800, 5104, 1536, 4025, 4200, 854, 808, 288, 1160, 1221, 384, 588, 1536, 1980, 2340, 2398, 2352, 2121, 2736, 2592, 1260, 1386, 1512, 1232, 1024, 4176, 4160, 4444, 1536, 3430, 3880, 805, 808, 288, 1160, 1111, 1440, 1624, 512, 2070, 2100, 2684, 2424, 672, 2856, 2997, 3510, 3564, 3600, 896, 3136, 3636, 1280, 5324, 5328, 4095, 4560, 224, 880, 873, 1090, 1111, 384, 1554, 1824, 576, 2340, 2530, 2424, 2394, 2640, 2619, 3270, 3333, 1152, 3108, 3520, 1152, 4640, 4576, 4848, 1120, 4640, 777, 896, 288, 1110, 1122, 384, 1414, 1552, 1782, 2080, 704, 2376, 2184, 2328, 3132, 1380};
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
		
		sd.getPaint().setColor(Color.parseColor(""));
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
