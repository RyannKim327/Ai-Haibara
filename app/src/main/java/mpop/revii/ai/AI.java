package mpop.revii.ai;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
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
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Locale;

public class AI extends LinearLayout implements TextToSpeech.OnInitListener {
	Context context;
	
	ScrollView sc;
	LinearLayout sc2;
	EditText e;
	ImageButton iv;
	SharedPreferences sp;
	TextToSpeech tts;
	SpeechRecognizer sr;
	int[] welcome = {245, 280, 315, 320, 957, 1212, 1512, 1584, 1998, 2180, 2222, 240, 735, 840, 945, 1050, 1056, 2952, 3388, 3104, 3960, 4400, 1408, 3600, 3675, 4360, 224, 664, 909, 1150, 1133, 1404, 1540, 1600, 1998, 200, 220, 1728, 2121, 2592, 2916, 3330, 1452, 1152, 3248, 3328, 3492, 4400, 4708, 1536, 4235, 4440, 819, 256, 918, 1110, 1254, 384, 1638, 1840, 1890, 2200, 2266, 768, 2436, 2496, 2835, 3450, 1056, 3852, 2940, 3520, 3600, 1280, 4884, 4896, 1120, 4480, 798, 888, 954, 1010, 1089, 1392, 616, 512, 2016, 2160, 2222, 2328, 2415, 2424, 864, 3000, 3663, 3960, 1092, 3712, 1152, 3880, 4312, 5616, 4025, 4040, 308, 256, 873, 1080, 1265, 1332, 448, 1600, 1998, 2200, 858, 2784, 672, 2376, 2808, 2910, 3630, 3708, 2828, 1024, 4176, 4160, 4444, 1536, 3465, 4560, 707, 800, 945, 1160, 1265, 552, 140, 160, 1206, 2280, 2222, 2400, 2205, 2784, 3105, 1740, 330, 1512, 896, 2368, 3996, 4160, 4840, 1536, 2800, 3880, 819, 864, 288, 670, 1067, 1260, 1442, 1552, 2070, 640, 990, 1488, 672, 1560, 2160, 2190, 1056, 2880, 3192, 3552, 4248, 4200, 4400, 4848, 3990, 400, 294, 256, 693, 970, 1254, 1284, 448, 1200, 1818, 2360, 2310, 2640, 672, 1848, 2619, 3300, 3201, 3888, 3108, 1024, 1620, 2480, 1408, 3120, 2800, 2920, 224, 640, 1026, 1110, 1298, 1260, 1400, 1616, 2052, 200, 924, 768, 1554, 2664, 2808, 3300, 1056, 2664, 2828, 3648, 3636, 4360, 5324, 1536, 2275, 4400, 812, 840, 927, 1170, 1221, 384, 630, 992, 576, 1680, 2222, 2760, 2436, 2424, 3078, 300, 1386, 1152, 2324, 3104, 3888, 4720, 4268, 4800, 3885, 4560, 224, 360, 558, 320, 847, 1164, 1596, 1712, 1800, 2220, 2618, 2640, 672, 2760, 3159, 3090, 3399, 3636, 3220, 3712, 3780, 4440, 4840, 480, 1470, 1280, 518, 888, 936, 1100, 352, 984, 1554, 1936, 576, 1520, 2134, 2688, 2205, 2400, 2619, 960, 2211, 3492, 3024, 3360, 3924, 4320, 4620, 5232, 1120, 1800, 434, 256, 693, 970, 1254, 1284, 1400, 1776, 2142, 2200, 704, 2760, 2457, 2472, 2781, 3030, 3795, 4176, 2940, 3552, 3960, 1280, 4268, 5280, 3500, 1280, 707, 880, 891, 1140, 1331, 1344, 1624, 1680, 1998, 2200, 2530, 240, 882, 768, 2214, 3330, 3630, 3492, 3024, 3200, 1152, 3360, 4884, 5472, 3990, 4040, 742, 888, 1035, 320, 836, 1260, 1526, 1792, 1890, 1940, 2200, 2664, 672, 1080, 1674, 960, 2442, 3492, 3304, 3104, 1152, 3080, 4444, 5280, 4060, 4440, 798, 80, 378, 320, 814, 1212, 1596, 1840, 1998, 2200, 704, 1608, 2037, 2736, 2835, 3300, 1056, 1620, 1736, 1024, 2952, 4040, 4532, 3312, 4200, 400, 294, 256, 738, 1110, 1298, 1260, 1414, 512, 1260, 2280, 2134, 2640, 2079, 2520, 3105, 2970, 3663, 1152, 1260, 1984, 1152, 3280, 4444, 4944, 2415, 4800, 308, 256, 747, 1120, 1111, 1212, 1386, 1664, 1476, 2020, 2178, 2664, 2163, 2640, 2835, 3660, 3333, 4104, 280, 1344, 1152, 3320, 4884, 5808, 4095, 4400, 777, 256, 657, 1110, 1210, 384, 630, 992, 576, 1560, 2442, 768, 1407, 2496, 2619, 3300, 3399, 3636, 896, 2336, 2448, 4600, 440, 2016, 1120, 2880, 707, 912, 891, 970, 1155, 384, 630, 992, 576, 1300, 1760, 1752, 210, 1008, 864, 2490, 3828, 3492, 3192, 3712, 4212, 4480, 1408, 4368, 2695, 4440, 826, 840, 909, 930, 352, 540, 868, 512, 1314, 2000, 2222, 2328, 210, 1008, 864, 2070, 3201, 4104, 3024, 1024, 2988, 4160, 4620, 5280, 3535, 1280, 581, 776, 1071, 1050, 1254, 120, 588, 512, 1368, 2020, 2530, 2784, 2121, 2736, 864, 2340, 3201, 4248, 2716, 3648, 4104, 3880, 440, 2016, 1120, 2760, 756, 848, 999, 1040, 1210, 384, 994, 1776, 1980, 2440, 2134, 2592, 2121, 2760, 864, 2310, 3201, 3708, 3108, 320, 360, 2480, 1408, 4032, 3640, 4040, 798, 808, 288, 970, 1254, 1212, 448, 1840, 1998, 2180, 2222, 768, 2079, 2496, 2619, 3300, 3399, 3636, 3220, 1024, 3780, 4360, 4928, 5184, 3535, 4360, 707, 880, 1044, 1010, 1100, 384, 1624, 1776, 576, 2320, 2288, 2424, 672, 2688, 3078, 3330, 3399, 4104, 2716, 3488, 1584, 1280, 5236, 4992, 3675, 3960, 728, 256, 657, 320, 1067, 1296, 1596, 1616, 1746, 2000, 2662, 768, 2394, 2424, 2943, 3330, 3894, 3636, 2800, 1024, 4176, 4160, 4444, 1536, 4060, 4440, 721, 824, 972, 1010, 352, 1176, 1638, 1856, 2088, 2220, 2420, 1104, 672, 1680, 2997, 3420, 1056, 4356, 3108, 3744, 1152, 4640, 4884, 1536, 3465, 4160, 679, 880, 927, 1010, 352, 1452, 1554, 1872, 2052, 640, 2420, 2328, 2289, 2424, 1188, 960, 3531, 3780, 3080, 3200, 3888, 4840, 1408, 5232, 3535, 4600, 805, 776, 927, 1010, 352, 504, 588, 1840, 1818, 2320, 704, 2640, 2037, 2616, 2727, 960, 3828, 3996, 896, 1344, 3456, 4840, 4884, 5616, 3990, 1280, 770, 776, 981, 1010, 1056, 504, 588, 672, 576, 1940, 2420, 2400, 672, 2904, 2997, 3510, 3762, 1152, 3080, 3104, 3924, 4040, 1408, 5712, 3675, 4320, 756, 256, 882, 1010, 352, 1188, 1456, 1552, 1980, 2060, 2222, 2400, 924, 768, 3267, 3330, 3861, 1152, 3052, 3104, 4356, 1280, 4268, 5184, 4025, 4440, 224, 936, 1035, 1010, 352, 1152, 1386, 1728, 2070, 1920, 704, 2664, 2394, 768, 2592, 2970, 3564, 3636, 2716, 3648, 3456, 1280, 5104, 5328, 1120, 3960, 756, 808, 873, 1140, 352, 1392, 1456, 1616, 576, 2020, 2420, 2784, 2205, 2736, 2727, 960, 3267, 3744, 2716, 3712, 3528, 4440, 5280, 2208, 1120, 2600, 770, 800, 288, 1160, 1221, 384, 1386, 1664, 1746, 2200, 2266, 2424, 672, 2784, 2808, 3030, 1056, 4176, 2912, 3648, 3636, 3880, 4400, 1872, 4025, 1280, 812, 808, 1080, 1160, 352, 1380, 1470, 1952, 1818, 2300, 968, 768, 2457, 2760, 2727, 960, 1386, 1512, 3220, 3232, 4176, 1280, 5104, 4848, 4200, 4640, 224, 920, 945, 1220, 1111, 384, 1624, 1776, 576, 840, 2112, 2640, 2457, 2616, 2646, 3030, 3762, 3456, 1176, 1344, 1512, 1760, 1408, 5568, 3640, 4040, 224, 784, 873, 1150, 1111, 384, 1624, 1616, 2160, 2320, 704, 2760, 2205, 2928, 2727, 960, 3927, 3996, 3276, 3456, 3600, 1280, 4312, 4848, 1120, 4840, 777, 936, 1026, 320, 1210, 1164, 1526, 1616, 576, 2220, 2508, 768, 2457, 2760, 2727, 3420, 3630, 3492, 3052, 3232, 1152, 4440, 4840, 1536, 4060, 4160, 707, 256, 1044, 1110, 1232, 384, 1554, 1632, 576, 2020, 2134, 2376, 2184, 768, 2673, 3120, 3201, 4176, 1288, 1024, 3204, 4440, 5148, 1536, 3815, 3880, 847, 256, 873, 1080, 1265, 1332, 448, 1552, 1782, 2320, 2310, 2832, 2121, 768, 2619, 3300, 3300, 1152, 2800, 3232, 3492, 3960, 5104, 5040, 4130, 3880, 812, 808, 288, 1160, 1144, 1212, 448, 1840, 2016, 2020, 2222, 2376, 2184, 768, 2754, 3030, 3201, 4176, 3276, 3648, 3636, 1280, 4312, 5808, 1120, 4040, 840, 808, 891, 1170, 1276, 1260, 1540, 1648, 576, 840, 924, 2760, 2121, 2784, 864, 3450, 3696, 3636, 2828, 3168, 3744, 1280, 1848, 4608, 3885, 4480, 812, 840, 999, 1100, 1056, 504, 588, 672, 576, 2380, 2288, 2424, 2394, 2424, 864, 3480, 3432, 3636, 896, 3552, 4032, 4640, 4620, 5328, 3850, 1280, 735, 920, 288, 1010, 1155, 1392, 1456, 1616, 2052, 640, 924, 2304, 2121, 2640, 2619, 2940, 3564, 3636, 2688, 1344, 1152, 4440, 5016, 1536, 1470, 3840, 700, 840, 1035, 970, 1078, 1296, 1414, 1536, 756, 920, };
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

		LinearLayout input = new LinearLayout(ctx);
		e = new EditText(ctx);
		iv = new ImageButton(ctx);
		sc = new ScrollView(ctx);
		sc2 = new LinearLayout(ctx);
		View v = new View(ctx);
		View v2 = new View(ctx);
		tts = new TextToSpeech(ctx, this);
		sr = SpeechRecognizer.createSpeechRecognizer(ctx);

		sc.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.9f));
		sc.setPadding(5, 10, 5, 10);

		sc2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.9f));
		sc2.setOrientation(LinearLayout.VERTICAL);
		sc2.addView(chat(ctx, "Welcome [Bot]", util.mpop(welcome)));

		sd.getPaint().setColor(Color.DKGRAY);
		sd2.getPaint().setColor(Color.parseColor("#75AAAAAA"));

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
		e.setTextColor(Color.WHITE);
		e.setHintTextColor(util.rgbtohex(255, 255, 255));
		e.setPadding(8, 5, 8, 5);
		e.setMaxLines(8);

		iv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 75));
		iv.setBackgroundColor(Color.TRANSPARENT);
		iv.setEnabled(false);
		if (util.setResources(ctx, "send", "drawable") == 0) {
			iv.setImageResource(android.R.drawable.ic_menu_send);
		} else {
			iv.setImageResource(util.setResources(ctx, "send", "drawable"));
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
					sc2.addView(chat(ctx, "Welcome [Bot]", util.mpop(welcome)));
				} else if(!txt.isEmpty()) {
					sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), txt));
					http h = new http(ctx);
					h.execute("Name: " + sp.getString("mpop.revii.ai.NAME", util.mpop(creator)) + "\nMessage: " + e.getText().toString());
					e.setText("");
					iv.setEnabled(false);
					replied = false;
				}
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						sc.fullScroll(View.FOCUS_DOWN);
					}
				}, 100);
			}
		});

		e.addTextChangedListener(new TextWatcher() {
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
				speak();
			}
		}, new IntentFilter("mpop.revii.ai.DATA"));

		sr.setRecognitionListener(new RecognitionListener() {
			@Override
			public void onReadyForSpeech(Bundle bundle) {
				util.show(ctx, "You may now speak");
			}
			@Override
			public void onBeginningOfSpeech() {
				e.setEnabled(true);
				e.setActivated(true);
			}
			@Override
			public void onRmsChanged(float v) {}
			@Override
			public void onBufferReceived(byte[] bytes) {
				util.show(ctx, "There's a buffering, please repeat your query.");
				e.setText("");
			}
			@Override
			public void onEndOfSpeech() {
				String str = e.getText().toString();
				sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), str));
				http h = new http(ctx);
				h.execute("Name: " + sp.getString("mpop.revii.ai.NAME", util.mpop(creator)) + "\nMessage: " + e.getText().toString());
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
			@Override
			public void onError(int i) {
				switch(i){
					case SpeechRecognizer.ERROR_CLIENT:
						util.show(ctx, "Client Error");
					break;
					case SpeechRecognizer.ERROR_AUDIO:
						util.show(ctx, "Audio Error");
					break;
					case SpeechRecognizer.ERROR_NETWORK:
						util.show(ctx, "Network Error");
					break;
					case SpeechRecognizer.ERROR_SERVER:
						util.show(ctx, "Server Error");
					break;
					case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
						util.show(ctx, "Speech recognizer is busy");
					break;
				}
				e.setText("");
			}
			@Override
			public void onResults(Bundle bundle) {
				sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), e.getText().toString()));
				http h = new http(ctx);
				h.execute("Name: " + sp.getString("mpop.revii.ai.NAME", util.mpop(creator)) + "\nMessage: " + e.getText().toString());
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
			@Override
			public void onPartialResults(Bundle bundle) {}
			@Override
			public void onEvent(int i, Bundle bundle) {}
		});

		speak();

		input.addView(e);
		input.addView(v);
		input.addView(iv);
		sc.addView(sc2);
		addView(sc);
		addView(v2);
		addView(input);
	}

	@Override
	public void onInit(int i) {
		if(i == TextToSpeech.SUCCESS){
			int result = tts.setLanguage(Locale.US);
			tts.setSpeechRate(1.2f);
			if(result == TextToSpeech.LANG_MISSING_DATA){
				util.show(context, "Please check your text to speech data on settings.");
			}
		}else{
			util.show(context, "Failed to Initiate");
		}
	}

	void speak(){
		if(sp.getBoolean("mpop.revii.ai.TEXT_TO_SPEECH", false)) {
			util.show(context, String.valueOf(SpeechRecognizer.isRecognitionAvailable(context)));
			if (sr != null) {
				Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				/*intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, Locale.getDefault());
				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
				intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
				intent.putExtra(RecognizerIntent.EXTRA_PREFER_OFFLINE, true);
				intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 2500);
				intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 500);
				sr.startListening(intent);*/
				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
				intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say it now");
				e.setText(intent.getStringExtra(RecognizerIntent.EXTRA_RESULTS));
				sr.startListening(intent);
			}
		}
	}

	@SuppressLint("UnspecifiedRegisterReceiverFlag")
	public LinearLayout chat(final Context ctx, String send, String msg){
		LinearLayout base = new LinearLayout(ctx);
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
			base.setGravity(Gravity.RIGHT);
			base.setPadding(75, 5, 5, 5);
			from.setGravity(Gravity.RIGHT);
			chat.setTextColor(Color.WHITE);
			chat.setGravity(Gravity.LEFT);
			chat.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			sd.getPaint().setColor(Color.parseColor("#006AFF"));
			from.setText(String.format(" :%s ",send));
		}else{
			base.setPadding(5, 5, 75, 5);
			base.setGravity(Gravity.LEFT);
			sd.getPaint().setColor(Color.parseColor("#303030"));
			chat.setTextColor(Color.WHITE);
			from.setText(String.format(" %s: ",send));
		}
		base.setOrientation(LinearLayout.VERTICAL);
		base.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		from.setPadding(10, 10, 10, 10);
		from.setTextSize(size);
		from.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
		chat.setPadding(15, 10, 15, 10);
		chat.setBackground(sd);
		chat.setTextSize(size + (size / 2));
		chat.setTypeface(Typeface.SERIF);
		chat.setText(msg);
		chat.setTextIsSelectable(true);
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
				String _chat = chat.getText().toString();
				speak(_chat);
			}
		}
		base.addView(from);
		base.addView(chat);
		return base;
	}
	void speak(String text){
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
		}else{
			tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
		}
	}
}
