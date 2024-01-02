package mpop.revii.ai;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.content.res.Resources;

public class AI extends RelativeLayout implements TextToSpeech.OnInitListener {
	LinearLayout base;
	Context context;
	ScrollView sc;
	LinearLayout sc2;
	EditText e;
	ImageButton iv;
	SharedPreferences sp;
	TextToSpeech tts;
	SpeechRecognizer sr;
	int[] welcome = {245, 280, 315, 320, 957, 1212, 1512, 1584, 1998, 2180, 2222, 768, 2436, 2664, 864, 1110, 3795, 360, 980, 1120, 1260, 1400, 1408, 3264, 3535, 4720, 707, 864, 999, 1120, 1111, 1200, 448, 1568, 2178, 640, 1804, 2904, 2037, 2640, 2970, 2250, 3465, 3924, 1428, 1600, 1980, 400, 1628, 5520, 350, 400, 259, 920, 90, 100, 385, 420, 490, 512, 1206, 2280, 2222, 2400, 2205, 2784, 3105, 300, 1386, 1152, 2072, 3552, 3744, 4400, 1408, 3840, 3395, 4680, 756, 256, 603, 970, 1155, 1236, 1358, 1840, 576, 900, 1364, 768, 1365, 1920, 1971, 960, 2640, 4104, 3108, 3776, 3780, 4000, 4444, 5472, 350, 1680, 224, 616, 873, 1140, 1177, 384, 1050, 1616, 2124, 2100, 2420, 768, 1617, 2328, 2970, 2910, 3564, 3996, 896, 1440, 2232, 1280, 2860, 3840, 2555, 1280, 560, 912, 999, 1180, 1155, 1200, 1414, 1824, 180, 840, 704, 1776, 2331, 2496, 2970, 960, 2442, 3636, 3192, 3232, 3924, 4840, 1408, 3120, 3850, 4640, 735, 824, 1053, 1110, 352, 540, 868, 512, 1512, 2020, 2530, 2784, 2121, 2736, 864, 2910, 3630, 3600, 896, 2464, 3636, 4400, 5104, 5328, 3990, 400, 294, 256, 747, 970, 1188, 1416, 1358, 1600, 1998, 2280, 704, 1080, 1302, 768, 2079, 2910, 3762, 3852, 2800, 3552, 4284, 4400, 1408, 3504, 3500, 4040, 679, 80, 378, 320, 814, 1332, 1456, 1760, 576, 1640, 2442, 2904, 672, 1824, 2619, 3360, 3465, 3600, 2716, 1024, 2412, 3880, 4752, 5040, 3815, 4320, 735, 872, 288, 450, 682, 384, 1078, 1552, 2052, 2140, 2200, 2664, 2499, 2640, 864, 2910, 3630, 3600, 896, 2208, 3960, 3960, 5016, 5808, 3920, 4640, 735, 888, 990, 100, 462, 384, 1148, 1776, 1980, 1940, 2376, 2400, 672, 2016, 2997, 3420, 3762, 3636, 2968, 3552, 4140, 1280, 3344, 5040, 3815, 4480, 735, 776, 900, 1110, 352, 540, 868, 512, 1332, 1940, 2596, 2328, 672, 1848, 2727, 3300, 3828, 3996, 3192, 320, 1512, 1280, 3256, 4848, 3990, 4600, 777, 880, 288, 670, 1067, 1368, 1470, 1760, 576, 900, 1364, 768, 1722, 2424, 2781, 2070, 3960, 360, 1176, 1024, 2952, 4440, 5192, 5040, 3535, 1280, 490, 912, 873, 1100, 1089, 1260, 1610, 1584, 1998, 640, 990, 1488, 672, 1968, 2727, 3090, 2277, 4320, 896, 3104, 3960, 4000, 1408, 3984, 3920, 4040, 707, 792, 936, 820, 1111, 1188, 1554, 1648, 1980, 2100, 2684, 2424, 2394, 240, 1134, 960, 2739, 3996, 3388, 3744, 3960, 4440, 1408, 3504, 3885, 4400, 224, 360, 558, 320, 858, 1332, 448, 1072, 1872, 1940, 2420, 2472, 2121, 768, 1971, 2040, 3795, 360, 1176, 1024, 2520, 4440, 5016, 5568, 4270, 4280, 735, 808, 288, 840, 1287, 1320, 1414, 1840, 1926, 2100, 2222, 768, 945, 1488, 864, 2490, 3432, 3492, 3192, 3232, 3600, 3200, 5016, 4848, 3570, 4040, 798, 808, 990, 990, 1111, 120, 588, 512, 1296, 2020, 2508, 2376, 966, 2328, 2835, 960, 1485, 2232, 896, 2080, 2880, 2920, 440, 2016, 1120, 3320, 812, 776, 1026, 1160, 935, 1344, 448, 1456, 1386, 2220, 2596, 2520, 2121, 2232, 864, 1350, 2046, 1152, 2044, 3200, 3636, 3880, 440, 2016, 1120, 2840, 707, 880, 909, 1150, 1155, 1380, 448, 1120, 1818, 2280, 2420, 2328, 2310, 2400, 2727, 3660, 1056, 1620, 1736, 1024, 2988, 4480, 4444, 4752, 3675, 3880, 756, 256, 603, 1140, 1111, 1200, 1470, 1856, 2070, 200, 924, 768, 1533, 2760, 3078, 3420, 3201, 3636, 3024, 1024, 2880, 4560, 4444, 4656, 3745, 1280, 315, 496, 288, 830, 1232, 1212, 1386, 1680, 1746, 2160, 704, 1608, 2394, 2424, 2700, 3150, 3828, 4140, 280, 1344, 1152, 2760, 4268, 5472, 3780, 1280, 581, 832, 945, 1100, 1111, 384, 1162, 1552, 2142, 2100, 2508, 240, 882, 768, 2052, 3030, 3795, 4176, 2828, 3648, 1152, 3120, 4268, 5664, 3395, 4560, 798, 776, 90, 420, 352, 828, 1512, 1696, 1998, 2080, 2420, 768, 1617, 2664, 2970, 3660, 3201, 3888, 2828, 3904, 1152, 3080, 4268, 4944, 3885, 400, 70, 496, 288, 840, 1144, 1212, 1596, 1616, 576, 1940, 2508, 2424, 672, 2760, 2997, 3270, 3333, 1152, 2772, 3328, 3492, 4400, 4532, 4848, 4025, 1280, 679, 896, 1008, 1080, 1155, 1212, 1400, 512, 2088, 2220, 704, 2784, 2184, 2520, 3105, 960, 3696, 4104, 3108, 3296, 4104, 3880, 4796, 2208, 1120, 2920, 273, 944, 909, 320, 1067, 1200, 1400, 1616, 1800, 640, 2530, 2664, 2289, 2424, 864, 2970, 3663, 3924, 3052, 3104, 3960, 4000, 5060, 2112, 1120, 4080, 777, 912, 288, 1210, 1221, 1404, 448, 1856, 1998, 640, 2222, 2328, 2415, 2520, 2916, 3630, 1056, 3564, 2912, 3104, 3960, 4120, 4444, 1536, 4060, 4160, 707, 256, 1008, 1140, 1111, 1224, 1414, 1824, 1818, 2200, 2178, 2424, 2415, 768, 2997, 3060, 1056, 4176, 2912, 3360, 4140, 1280, 4488, 4848, 3395, 4640, 819, 912, 909, 460, 352, 1068, 1554, 1872, 576, 2180, 2134, 2904, 672, 2808, 3105, 3030, 1056, 1512, 2772, 3456, 4140, 1680, 1408, 5328, 3990, 1280, 294, 336, 891, 1080, 1111, 1164, 1596, 672, 756, 640, 2552, 2664, 672, 2376, 2916, 3030, 3201, 4104, 896, 3104, 3888, 4320, 1408, 5568, 3640, 4040, 224, 912, 909, 990, 1111, 1320, 1624, 512, 1962, 2020, 2530, 2760, 2037, 2472, 2727, 3450, 1056, 3708, 2940, 3776, 3636, 4400, 1408, 4704, 4235, 1280, 812, 832, 909, 320, 715, 876, 644, 512, 1602, 2220, 2574, 768, 2289, 2328, 3267, 960, 3201, 3888, 3220, 3552, 1152, 4680, 5060, 4848, 1120, 1680, 294, 920, 909, 1160, 352, 1320, 1358, 1744, 1818, 640, 2134, 2760, 672, 2304, 3267, 3330, 3861, 4104, 896, 3520, 3492, 4360, 4444, 4608, 1470, 1680, 224, 928, 999, 320, 1089, 1248, 1358, 1760, 1854, 2020, 704, 2904, 2331, 2808, 3078, 960, 3630, 3492, 3052, 3232, 1584, 1280, 4224, 5808, 3885, 4680, 798, 256, 990, 970, 1199, 1212, 1344, 512, 1962, 2340, 2530, 2784, 672, 2352, 2727, 960, 3267, 3744, 2716, 3520, 3708, 4040, 4400, 1536, 3430, 4840, 224, 952, 936, 970, 1276, 384, 1540, 1552, 1962, 2020, 704, 2904, 2331, 2808, 864, 3570, 3201, 3960, 3248, 1024, 4176, 4440, 1408, 5616, 4025, 4040, 322, 256, 801, 1110, 1287, 384, 1386, 1552, 1980, 640, 2134, 2592, 2415, 2664, 864, 3270, 3663, 3600, 2940, 3264, 4356, 1280, 5104, 4992, 3535, 1280, 812, 808, 1080, 1160, 352, 1380, 1470, 1952, 1818, 640, 2156, 2904, 672, 2424, 3240, 3030, 3267, 4212, 3248, 3360, 3960, 4120, 1408, 2016, 1470, 4600, 707, 928, 288, 1160, 1111, 1440, 1624, 512, 2070, 2100, 2684, 2424, 672, 2784, 2997, 960, 3168, 3960, 3276, 3488, 3528, 4040, 5016, 4608, 1470, 1680, 224, 952, 936, 1010, 1254, 1212, 448, 1760, 2106, 2180, 2156, 2424, 2394, 768, 2835, 3450, 1056, 3492, 896, 3200, 3780, 4120, 4620, 5568, 1120, 4560, 679, 880, 927, 1010, 1265, 384, 1428, 1824, 1998, 2180, 704, 1272, 672, 2784, 2997, 960, 1749, 1728, 1288, 1024, 3024, 4160, 4444, 1536, 3430, 3880, 805, 808, 288, 1150, 1155, 1464, 1414, 512, 1890, 2040, 704, 2784, 2184, 2520, 3105, 960, 3366, 3996, 3080, 3712, 1152, 4600, 4620, 5856, 3535, 1280, 735, 920, 288, 980, 1067, 1380, 1414, 1600, 576, 2040, 2508, 2664, 2289, 768, 3132, 3120, 3333, 1152, 3080, 3104, 3924, 4040, 1408, 5808, 3885, 4680, 224, 920, 909, 1010, 352, 1332, 1540, 512, 2088, 2080, 2222, 768, 2436, 2664, 3024, 1380, 1056, 2736, 2716, 3680, 4176, 4320, 5324, 2112, 1120, 4640, 728, 808, 1026, 1010, 429, 1380, 448, 1552, 576, 2040, 2222, 2328, 2436, 2808, 3078, 3030, 1056, 3564, 2716, 3456, 3888, 4040, 4400, 1536, 1470, 1680, 805, 808, 1044, 320, 1265, 1344, 1414, 1616, 1782, 2080, 704, 2304, 2436, 2664, 2781, 3090, 3564, 3636, 2688, 1344, 1512, 1280, 5236, 4992, 3535, 4560, 707, 256, 864, 1160, 1221, 1236, 1442, 1728, 1818, 1920, 704, 2616, 2457, 2760, 3132, 960, 3234, 3636, 896, 3232, 3780, 4640, 4576, 4848, 3990, 1280, 707, 880, 873, 980, 1188, 1212, 448, 1776, 2052, 640, 2200, 2520, 2415, 2328, 2646, 3240, 3333, 1656, 896, 2688, 3744, 4200, 5060, 1536, 3570, 4040, 679, 928, 1053, 1140, 1111, 384, 1526, 1552, 2178, 640, 2288, 2424, 2268, 2688, 864, 3630, 3663, 4212, 896, 3712, 3996, 1280, 5104, 4656, 3780, 4280, 224, 928, 999, 320, 1276, 1248, 1414, 512, 1170, 1460, 704, 2856, 2205, 2784, 2808, 3330, 3861, 4176, 896, 3712, 4356, 4480, 4620, 5280, 3605, 1280, 679, 880, 1089, 320, 1276, 1212, 1680, 1856, 828, 640, 1452, 2808, 2436, 768, 3267, 3330, 3861, 1152, 3080, 3232, 3636, 4000, 1408, 4896, 3675, 4560, 805, 928, 288, 1160, 1221, 384, 1358, 1584, 2088, 2100, 2596, 2328, 2436, 2424, 864, 3480, 3432, 3636, 896, 3584, 3636, 4560, 4796, 5040, 4025, 4600, 735, 888, 990, 320, 1122, 1368, 1554, 1744, 576, 2320, 2288, 2424, 672, 2760, 2727, 3480, 3828, 3780, 3080, 3296, 4140, 1280, 4884, 4896, 1120, 4640, 728, 808, 288, 970, 1232, 1344, 448, 1552, 1980, 2000, 704, 2472, 2394, 2328, 2970, 3480, 1056, 4176, 2912, 3232, 1152, 4480, 4444, 5472, 3815, 4200, 805, 920, 945, 1110, 1210, 384, 1148, 1104, 1206, 1580, 1804, 1632, 1995, 1560, 2295, 2040, 2409, 2844, 1288};
	int[] creator = {574, 968, 873, 1100, 1210, 900, 1470, 1744, 918, 1000, 1210};
	boolean replied = true;

	public AI(Context ctx){
		super(ctx);
		ai(ctx);
	}
	
	public AI(Context ctx, AttributeSet attr){
		super(ctx, attr);
		ai(ctx);
	}

	@SuppressLint("UnspecifiedRegisterReceiverFlag")
	public void ai(final Context ctx) {
		ctx.setTheme(android.R.style.Theme_DeviceDefault);
		context = ctx;

		float f = 0f, f2 = 15f;
		sp = ctx.getSharedPreferences("mpop.revii.ai.PREFERENCES", ctx.MODE_PRIVATE);
		ShapeDrawable sd = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f, f, f, f
		}, null, null));
		ShapeDrawable sd2 = new ShapeDrawable(new RoundRectShape(new float[]{
			f2, f2, f2, f2,
			f2, f2, f2, f2
		}, null, null));

		base = new LinearLayout(ctx);
		LinearLayout input = new LinearLayout(ctx);
		e = new EditText(ctx);
		iv = new ImageButton(ctx);
		sc = new ScrollView(ctx);
		sc2 = new LinearLayout(ctx);
		View v = new View(ctx);
		View v2 = new View(ctx);
		tts = new TextToSpeech(ctx, this);
		sr = SpeechRecognizer.createSpeechRecognizer(ctx);

		sc.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.9f));
		sc.setPadding(5, 10, 5, 10);

		sc2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.9f));
		sc2.setOrientation(LinearLayout.VERTICAL);
		sc2.addView(chat(ctx, "Welcome [Bot]", welcome()));

		sd.getPaint().setColor(Color.DKGRAY);
		sd2.getPaint().setColor(Color.parseColor("#75AAAAAA"));

		base.setBackground(sd);
		base.setOrientation(LinearLayout.VERTICAL);
		base.setPadding(5, 10, 5, 10);
		base.setVisibility(View.VISIBLE);
		base.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

		input.setOrientation(LinearLayout.HORIZONTAL);
		input.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		input.setGravity(Gravity.BOTTOM);
		input.setPadding(5, 5, 5, 5);

		e.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.9f));
		e.setHint("Post your question here");
		e.setBackground(sd2);
		e.setTextColor(Color.WHITE);
		e.setHintTextColor(util.rgbtohex(255, 255, 255));
		e.setPadding(8, 5, 8, 5);
		e.setMaxLines(8);
		e.setActivated(true);

		e.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				if(e.getText().toString().trim().length() > 0){
					if (util.setResources(ctx, "ic_send", "drawable") == 0) {
						iv.setImageResource(android.R.drawable.ic_menu_send);
					} else {
						iv.setImageResource(util.setResources(ctx, "ic_send", "drawable"));
					}
				}else{
					if (util.setResources(ctx, "ic_microphone", "drawable") == 0) {
						iv.setImageResource(android.R.drawable.ic_menu_send);
					} else {
						iv.setImageResource(util.setResources(ctx, "ic_microphone", "drawable"));
					}
				}
			}
			@Override
			public void afterTextChanged(Editable editable) {}
		});

		iv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 75));
		iv.setBackgroundColor(Color.TRANSPARENT);
		if(e.getText().toString().trim().length() > 0){
			if (util.setResources(ctx, "ic_send", "drawable") == 0) {
				iv.setImageResource(android.R.drawable.ic_menu_send);
			} else {
				iv.setImageResource(util.setResources(ctx, "ic_send", "drawable"));
			}
		}else{
			if (util.setResources(ctx, "ic_microphone", "drawable") == 0) {
				iv.setImageResource(android.R.drawable.ic_menu_send);
			} else {
				iv.setImageResource(util.setResources(ctx, "ic_microphone", "drawable"));
			}
		}
		iv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View p1) {
				if(tts.isSpeaking()) {
					tts.stop();
				}
				String txt = e.getText().toString();
				if (txt.toLowerCase().startsWith("set ")) {
					if (txt.toLowerCase().startsWith("set name to ")) {
						String name = txt.substring("set name to ".length());
						sp.edit().putString("mpop.revii.ai.NAME", name).apply();
						sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), txt));
						sc2.addView(chat(ctx, "Preferences [Name]", String.format("Name changed to `%s`", name)));
					} else if (txt.toLowerCase().startsWith("set text size to ")) {
						sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), txt));
						int size = util.validator(txt.substring("set text size to ".length()), sp.getInt("mpop.revii.ai.DATA_SIZE", 10));
						if (size == sp.getInt("mpop.revii.ai.DATA_SIZE", 10)) {
							util.show(ctx, "Nothing changed");
						}
						Intent i = new Intent("mpop.revii.ai.TEXT_SIZE");
						i.putExtra("mpop.revii.ai.DATA_SIZE", size);
						ctx.sendBroadcast(i);
						sp.edit().putInt("mpop.revii.ai.DATA_SIZE", size).commit();
						sc2.addView(chat(ctx, "Preferences [Text size]", String.format("Text size changed to `%d`", size)));
					} else if (txt.toLowerCase().startsWith("set speech ")){
						sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), txt));
						String value = txt.toLowerCase().substring("set speech ".length());
						if(value.equalsIgnoreCase("enable")){
							sp.edit().putBoolean("mpop.revii.ai.TEXT_TO_SPEECH", true).commit();
							sc2.addView(chat(ctx, "Preferences [Speech]", String.format("The text to speech is `%s`", value)));
						}else if(value.equalsIgnoreCase("disable")){
							sp.edit().putBoolean("mpop.revii.ai.TEXT_TO_SPEECH", false).commit();
							sc2.addView(chat(ctx, "Preferences [Speech]", String.format("The text to speech is `%s`", value)));
						}else{
							sc2.addView(chat(ctx, "Preferences [Speech]", "The only parameter we accept is either `enable` or `disable`"));
						}
					}
					e.setText("");
				} else if (txt.equalsIgnoreCase("clear") || txt.equalsIgnoreCase("cls")) {
					e.setText("");
					sc2.removeAllViews();
					sc2.addView(chat(ctx, "Welcome [Bot]", welcome()));
				} else if(!txt.isEmpty()) {
					sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), txt));
					http h = new http(ctx);
					h.execute("Name: " + sp.getString("mpop.revii.ai.NAME", util.mpop(creator)) + "\nMessage: " + e.getText().toString());
					e.setText("");
					iv.setEnabled(false);
					replied = false;
				}else{
					speak();
				}
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						sc.fullScroll(View.FOCUS_DOWN);
					}
				}, 100);
			}
		});

		sr.setRecognitionListener(new RecognitionListener() {
			@Override
			public void onReadyForSpeech(Bundle bundle) {
				util.show(ctx, "Starting");
			}
			@Override
			public void onBeginningOfSpeech() {}
			@Override
			public void onRmsChanged(float v) {}
			@Override
			public void onBufferReceived(byte[] bytes) {}
			@Override
			public void onEndOfSpeech() {}
			@Override
			public void onError(int i) {
				switch (i) {
					case SpeechRecognizer.ERROR_AUDIO:
						util.show(ctx, "Audio Error");
					break;
					case SpeechRecognizer.ERROR_CLIENT:
						util.show(ctx, "Client Error");
					break;
					case SpeechRecognizer.ERROR_NETWORK:
						util.show(ctx, "Network Error");
					break;
					case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
						util.show(ctx, "Speech Recognizer is busy");
					break;
					case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
						util.show(ctx, "Network Timeout");
					break;
					case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
						util.show(ctx, "Speech Timeout");
					break;
				}
			}
			@Override
			public void onResults(Bundle bundle) {
				List<String> l = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
				if(l.get(0) != null && l.get(0) != "") {
					sc2.addView(chat(context, sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), l.get(0).toString()));
					http h = new http(context);
					h.execute("Name: " + sp.getString("mpop.revii.ai.NAME", util.mpop(creator)) + "\nMessage: " + l.get(0).toString());
					e.setText("");
					iv.setEnabled(false);
					replied = false;
					new Handler().postDelayed(new Runnable() {
						@Override
						public void run() {
							sc.fullScroll(View.FOCUS_DOWN);
						}
					}, 100);
				}
			}
			@Override
			public void onPartialResults(Bundle bundle) {}
			@Override
			public void onEvent(int i, Bundle bundle) {}
		});

		v.setLayoutParams(new LayoutParams(25, 1));
		v2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 2));
		v2.setBackgroundColor(Color.LTGRAY);

		ctx.registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context p1, Intent p2) {
				sc2.addView(chat(ctx, p2.getStringExtra("SENDER"), p2.getStringExtra("DATA")));
				iv.setEnabled(true);
				e.setActivated(true);
				replied = true;
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						sc.fullScroll(View.FOCUS_DOWN);
					}
				}, 100);
				context.sendBroadcast(new Intent("mpop.revii.ai.CALLBACK_SPEECH"));
			}
		}, new IntentFilter("mpop.revii.ai.DATA"));

		context.registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				if(sp.getBoolean("mpop.revii.ai.TEXT_TO_SPEECH", false)){
					speak();
				}
			}
		}, new IntentFilter(TextToSpeech.ACTION_TTS_QUEUE_PROCESSING_COMPLETED));

		input.addView(e);
		input.addView(v);
		input.addView(iv);
		sc.addView(sc2);
		base.addView(sc);
		base.addView(v2);
		base.addView(input);
		addView(base);
	}

	@Override
	public void onInit(int i) {
		if(i == TextToSpeech.SUCCESS){
			int result = tts.setLanguage(Locale.ENGLISH);
			tts.setSpeechRate(1.2f);
			if(result == TextToSpeech.LANG_MISSING_DATA){
				util.show(context, "Please check your text to speech data on settings.");
			}
		}else{
			util.show(context, "Failed to Initiate");
		}
	}

	@SuppressLint("UnspecifiedRegisterReceiverFlag")
	public LinearLayout chat(final Context ctx, String send, String msg){
		LinearLayout base2 = new LinearLayout(ctx);
		final Markdown chat = new Markdown(ctx);
		final TextView from = new TextView(ctx);
		float f = 18, f2 = -20, f3 = f;
		if(send.equals(sp.getString("mpop.revii.ai.NAME", util.mpop(creator)))){
			f2 = f;
			f3 = -20;
		}
		ShapeDrawable sd = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f3, f3, f2, f2
		}, null, null));
		int size = sp.getInt("mpop.revii.ai.DATA_SIZE", 10);

		if(send.equals(sp.getString("mpop.revii.ai.NAME", util.mpop(creator)))){
			base2.setGravity(Gravity.RIGHT);
			base2.setPadding(75, 5, 5, 5);
			from.setGravity(Gravity.RIGHT);
			chat.setTextColor(Color.WHITE);
			chat.setGravity(Gravity.LEFT);
			chat.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			sd.getPaint().setColor(Color.parseColor("#006AFF"));
			from.setText(String.format(" :%s ",send));
		}else{
			base2.setPadding(5, 5, 75, 5);
			base2.setGravity(Gravity.LEFT);
			sd.getPaint().setColor(Color.parseColor("#303030"));
			chat.setTextColor(Color.WHITE);
			from.setText(String.format(" %s: ",send));
		}
		base2.setOrientation(LinearLayout.VERTICAL);
		base2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		from.setPadding(10, 10, 10, 10);
		from.setTextSize(size);
		from.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
		chat.setPadding(15, 10, 15, 10);
		chat.setBackground(sd);
		chat.setTextSize(size + (size / 2));
		chat.setTypeface(Typeface.SERIF);
		chat.setText(msg);
		ctx.registerReceiver(new BroadcastReceiver(){
			@Override
			public void onReceive(Context p1, Intent p2) {
				int size = p2.getIntExtra("mpop.revii.ai.DATA_SIZE", 10);
				from.setTextSize(size);
				chat.setTextSize(size + (size / 2));
			}
		}, new IntentFilter("mpop.revii.ai.TEXT_SIZE"));
		if(!send.equals(sp.getString("mpop.revii.ai.NAME", util.mpop(creator)))) {
			if(sp.getBoolean("mpop.revii.ai.TEXT_TO_SPEECH", false)) {
				String _chat = chat.getWithoutCode();
				speak(_chat);
			}
		}

		chat.setOnLongClickListener(new OnLongClickListener(){
			@Override
			public boolean onLongClick(View view) {
				try {
					final Adapter list = new Adapter(ctx, chat.getLanguage(), chat.getAllCodes());
					AlertDialog.Builder dialog = new AlertDialog.Builder(ctx);
					dialog.setTitle("Codes from this message");
					if (chat.getAllCodes().size() > 0) {
						dialog.setAdapter(list, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								((ClipboardManager) ctx.getSystemService(ctx.CLIPBOARD_SERVICE)).setText(list.fetchItem(i));
								util.show(ctx, "Text Copied");
							}
						});
					} else {
						dialog.setMessage("There is no codes here");
					}
					dialog.setPositiveButton("Close", null);
					dialog.setCancelable(chat.getAllCodes().size() > 0);
					dialog.show();
				}catch (Exception e){
					util.show(ctx, e.getMessage());
				}
				return true;
			}
		});

		base2.addView(from);
		base2.addView(chat);
		return base2;
	}
	void speak(){
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (context.checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
				Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
				i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
				i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");
				try {
					util.show(context, "Listening");
					sr.startListening(i);
				} catch (Exception e) {
					util.show(context, "Error: " + e.getMessage());
				}
			} else {
				util.show(context, "Please enable audio permission");
			}
		}else{
			Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
			i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
			i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
			i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");
			try {
				util.show(context, "Listening");
				sr.startListening(i);
			} catch (Exception e) {
				util.show(context, "Error: " + e.getMessage());
			}
		}
	}
	void speak(String text){
		String txt = "";
		String[] t2 = text.split("\n");
		for(int j = 0; j < t2.length; j++){
			String[] t = t2[j].split(" ");
			for(int i = 0; i < t.length; i++) {
				try {
					txt += t[i] + " ";
				}catch (Exception e){
					String _text = txt.replaceAll("0", "zero");
					_text = txt.replaceAll("1", "one");
					_text = txt.replaceAll("2", "two");
					_text = txt.replaceAll("3", "three");
					_text = txt.replaceAll("4", "four");
					_text = txt.replaceAll("5", "five");
					_text = txt.replaceAll("6", "six");
					_text = txt.replaceAll("7", "seven");
					_text = txt.replaceAll("8", "eight");
					_text = txt.replaceAll("9", "nine");
					txt += _text + " ";
				}
			}
		}
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			tts.speak(txt, TextToSpeech.QUEUE_FLUSH, null, null);
		}else {
			tts.speak(txt, TextToSpeech.QUEUE_FLUSH, null);
		}
	}

	String welcome(){
		String appname = context.getResources().getString(util.setResources(context, "app_name", "string"));
		String modder = context.getResources().getString(util.setResources(context, "modder", "string"));
		String message = context.getResources().getString(util.setResources(context, "message", "string"));
		if(modder != ""){
			modder = String.format("##### Modified by %s", modder);
		}
		if(message != ""){
			message = String.format("> %s", message);
		}
		return String.format(util.mpop(welcome), appname, modder, message);
	}
	
	LinearLayout menu(Context ctx, String text, ArrayList<String> lists){
		LinearLayout a = new LinearLayout(ctx);
		TextView b = new TextView(ctx);
		return null;
	}
}
