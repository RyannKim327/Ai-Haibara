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
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;
import mpop.revii.ai.util;

public class AI extends RelativeLayout implements TextToSpeech.OnInitListener {

	Context context;
	LinearLayout base;
	ScrollView sc;
	LinearLayout sc2;
	EditText e;
	ImageButton iv;
	SharedPreferences sp;
	TextToSpeech tts;
	SpeechRecognizer sr;

	// INFO: Welcome messages
	int[] welcome = {245, 280, 315, 320, 407, 1380, 140, 560, 630, 700, 770, 768, 777, 2760, 270, 1110, 3795, 360, 280, 2144, 4104, 4040, 4400, 5040, 4060, 4600, 70, 336, 288, 740, 1221, 1248, 1540, 512, 1440, 1940, 2574, 2592, 672, 1608, 2619, 3150, 3399, 3492, 3220, 1024, 1620, 2480, 1408, 3120, 2800, 2920, 224, 640, 1026, 1110, 1298, 1260, 1400, 1616, 2052, 200, 924, 768, 1617, 2328, 3078, 3210, 1056, 2700, 2828, 3776, 3780, 4400, 1408, 3696, 3395, 4400, 679, 864, 999, 320, 495, 744, 448, 1040, 1440, 1460, 704, 1920, 2394, 2664, 3186, 3150, 3300, 3636, 3192, 320, 1512, 1280, 3256, 5328, 3640, 4400, 224, 592, 909, 1140, 1111, 1308, 1694, 512, 1170, 2200, 2552, 2520, 2163, 2808, 2997, 960, 1485, 2232, 896, 2688, 3636, 4600, 5104, 4848, 3990, 1280, 679, 880, 900, 320, 847, 1212, 1540, 1856, 1998, 2280, 220, 1008, 672, 1992, 2619, 3240, 3894, 3492, 2800, 3552, 4104, 1280, 1980, 2976, 1120, 3080, 679, 912, 963, 1000, 1221, 1428, 1540, 512, 1314, 2000, 2222, 2328, 210, 1008, 864, 2220, 3663, 3744, 3080, 1024, 2952, 4440, 5324, 1536, 2660, 3880, 784, 840, 900, 970, 352, 804, 1358, 1728, 1890, 2180, 2376, 2520, 2289, 768, 1215, 1860, 1056, 2772, 2716, 3648, 3852, 4000, 4884, 5712, 3850, 1280, 679, 880, 900, 320, 759, 1320, 1386, 1824, 2178, 2240, 2552, 2520, 2331, 2640, 270, 1260, 1056, 2952, 3108, 3520, 3492, 4320, 4400, 1536, 2940, 4440, 798, 912, 909, 1060, 1221, 1380, 448, 1216, 1890, 2180, 2464, 2520, 2037, 2400, 2997, 960, 1485, 2232, 896, 2368, 3492, 4720, 4268, 1536, 2695, 4040, 770, 928, 999, 1140, 110, 504, 448, 1184, 1818, 2280, 2530, 2664, 2310, 768, 1809, 2910, 3762, 3780, 3080, 1024, 1620, 2480, 1408, 3936, 3535, 4120, 483, 960, 90, 420, 352, 984, 1554, 1888, 1890, 2020, 704, 1680, 2394, 2328, 2970, 2970, 3465, 4140, 2772, 3552, 1152, 1800, 2728, 1536, 2870, 4040, 721, 552, 1080, 320, 1067, 1320, 1400, 512, 1494, 2240, 2222, 2424, 2079, 2496, 2214, 3030, 3267, 3996, 2884, 3520, 3780, 4880, 4444, 5472, 350, 1680, 224, 664, 999, 1210, 1287, 1320, 1554, 512, 1314, 2220, 2420, 768, 945, 1488, 864, 2340, 3663, 1152, 1876, 3328, 3492, 4400, 4532, 4848, 1120, 2920, 476, 920, 90, 420, 352, 840, 1554, 1824, 2088, 2440, 2354, 2520, 2121, 768, 2268, 3510, 3630, 3636, 3220, 3424, 3780, 4040, 1408, 2160, 2170, 1280, 581, 832, 873, 1140, 1111, 1200, 1120, 1824, 1818, 2040, 2222, 2736, 2121, 2640, 2673, 3030, 330, 1512, 896, 2560, 3996, 4320, 4752, 5040, 3850, 3880, 812, 840, 999, 1100, 1265, 552, 910, 1168, 576, 900, 1364, 768, 1365, 1920, 1971, 300, 1386, 1152, 2324, 3712, 3492, 4560, 5104, 4080, 3920, 1280, 637, 616, 999, 1180, 1155, 1212, 1302, 512, 810, 1240, 704, 1752, 2100, 2424, 2619, 300, 1386, 1152, 1988, 3232, 3960, 4040, 5060, 5040, 4025, 1280, 490, 808, 1026, 1100, 1067, 1320, 1400, 1616, 2196, 640, 990, 1488, 672, 1992, 3024, 3030, 3267, 3780, 2716, 3456, 1152, 2680, 5016, 4848, 3500, 4200, 812, 920, 90, 420, 352, 876, 1610, 1824, 2052, 1940, 2222, 2592, 672, 1920, 3078, 3030, 3201, 3852, 896, 1440, 2232, 1280, 3652, 5376, 3535, 3960, 735, 776, 972, 320, 737, 1368, 1414, 1600, 1890, 2320, 2530, 240, 882, 768, 1782, 3510, 3630, 3600, 2716, 3680, 1152, 2600, 4840, 4800, 3990, 4200, 679, 880, 288, 450, 682, 384, 980, 1056, 576, 1340, 2376, 2424, 2037, 2640, 864, 2310, 3663, 3600, 280, 1344, 1152, 2680, 4576, 4656, 3990, 4320, 777, 912, 873, 1050, 1133, 1320, 1414, 160, 756, 640, 1628, 2328, 2541, 2760, 2997, 3300, 1056, 3204, 3052, 3104, 4176, 3880, 440, 2016, 1120, 2960, 679, 968, 1035, 1110, 1210, 384, 980, 1824, 1746, 2200, 2178, 2520, 2415, 2376, 2997, 300, 1386, 1152, 2072, 3552, 3744, 4400, 1408, 3696, 3675, 3960, 728, 776, 909, 1080, 352, 780, 1596, 1584, 1818, 2200, 2134, 240, 882, 768, 2268, 3420, 3861, 3996, 3080, 3296, 1152, 3080, 4620, 5328, 350, 1680, 224, 552, 873, 1140, 1188, 384, 1162, 1664, 1890, 2200, 2222, 768, 1743, 2328, 3213, 3150, 3762, 360, 1176, 1024, 2736, 4040, 5060, 5568, 3535, 4560, 224, 624, 873, 1180, 1067, 1368, 1596, 1552, 180, 840, 704, 1656, 2268, 2544, 2997, 3120, 3630, 1152, 2156, 3552, 3960, 4880, 4268, 5184, 3535, 4880, 224, 616, 873, 1030, 1221, 120, 588, 512, 1206, 2160, 2134, 2736, 2247, 768, 1782, 2910, 3630, 3600, 2940, 3552, 3888, 3880, 1408, 3408, 4095, 4200, 770, 928, 999, 100, 462, 384, 952, 1824, 1998, 2100, 2200, 1848, 2331, 2400, 2835, 3060, 3465, 3564, 2716, 3712, 3996, 4560, 5060, 480, 1470, 1280, 560, 840, 990, 1110, 1331, 816, 1414, 1760, 180, 840, 704, 2112, 1428, 1560, 1215, 2040, 3333, 4248, 2828, 3456, 3996, 4480, 4444, 5472, 4025, 400, 294, 256, 720, 1050, 1210, 1392, 1414, 1824, 1818, 2300, 2552, 240, 882, 768, 2241, 3630, 3597, 3528, 2940, 3104, 3960, 4200, 5368, 4848, 350, 400, 434, 256, 756, 1040, 1111, 1368, 1414, 512, 1746, 2280, 2222, 768, 2079, 2496, 2619, 3300, 3399, 3636, 3220, 1024, 3744, 3880, 4928, 5376, 3535, 4400, 707, 800, 396, 320, 1067, 1320, 1400, 512, 2088, 2080, 2222, 768, 2079, 2664, 2943, 3270, 3201, 3960, 2800, 3680, 1152, 4760, 4268, 5520, 1120, 3960, 728, 776, 990, 1030, 1111, 1200, 448, 1632, 1998, 2280, 704, 2904, 2331, 2808, 864, 3480, 3663, 1152, 3052, 3104, 3852, 4040, 1408, 5808, 3885, 4680, 798, 256, 891, 1110, 1210, 1224, 1470, 1648, 2106, 2280, 2134, 2784, 2205, 2664, 2970, 3450, 1056, 3636, 2716, 3680, 3780, 4040, 5016, 2208, 1120, 3360, 728, 808, 288, 990, 1221, 1308, 1526, 1552, 1980, 2000, 2530, 768, 2415, 2784, 2619, 3420, 3828, 4140, 896, 3808, 3780, 4640, 4576, 1536, 3395, 1280, 693, 888, 972, 1110, 1210, 384, 588, 672, 1044, 840, 924, 1104, 672, 2016, 2808, 3030, 1056, 3564, 3108, 3488, 3924, 3880, 4840, 4800, 4025, 1280, 686, 808, 972, 1110, 1309, 384, 1358, 1824, 1818, 640, 2552, 2496, 2121, 768, 3024, 3420, 3333, 3672, 2828, 3648, 3636, 4400, 4356, 4848, 4025, 1280, 847, 888, 1053, 320, 1199, 1164, 1694, 512, 2106, 2300, 2222, 1392, 210, 1008, 864, 2880, 1386, 1512, 1624, 3584, 4104, 4040, 4488, 4848, 3990, 4040, 770, 792, 909, 1150, 462, 504, 1344, 512, 810, 640, 1848, 2496, 2205, 2760, 864, 2970, 3663, 3924, 3052, 3104, 3960, 4000, 1408, 5712, 3675, 4320, 756, 256, 1008, 1110, 1232, 1404, 1568, 512, 2088, 2080, 2222, 768, 2079, 2664, 2970, 3060, 3465, 3708, 3276, 3648, 3492, 4640, 4620, 5328, 3850, 1760, 224, 816, 999, 1140, 352, 1452, 1554, 1872, 576, 2320, 2442, 768, 2289, 2328, 2889, 3030, 1056, 3780, 3248, 1024, 3636, 3880, 5060, 5040, 3535, 4560, 224, 928, 999, 320, 1287, 1380, 1414, 736, 180, 840, 704, 2304, 882, 1008, 1566, 3060, 3333, 3636, 2800, 3136, 3492, 3960, 4708, 2016, 1470, 3840, 224, 360, 288, 830, 1155, 1320, 1386, 1616, 576, 2380, 2222, 768, 2499, 2328, 2970, 3480, 1056, 4176, 3108, 1024, 3924, 3880, 4708, 4848, 1120, 4600, 777, 872, 909, 320, 1155, 1308, 1568, 1824, 1998, 2360, 2222, 2616, 2121, 2640, 3132, 1320, 1056, 4356, 3108, 3744, 1152, 4360, 4268, 5808, 1120, 4600, 707, 880, 900, 320, 1331, 1332, 1638, 1824, 576, 2040, 2222, 2424, 2100, 2352, 2619, 2970, 3531, 1152, 3248, 3552, 1152, 4680, 5060, 2208, 350, 1680, 224, 768, 378, 420, 638, 1188, 1512, 1840, 756, 840, 2112, 768, 2331, 2736, 864, 2880, 1386, 1512, 1624, 3168, 3888, 4040, 4268, 5472, 1470, 1680, 672, 256, 405, 320, 924, 1332, 448, 1584, 1944, 2020, 2134, 2736, 672, 2784, 2808, 3030, 1056, 4032, 2716, 3680, 4176, 1280, 4796, 4848, 4025, 4600, 679, 824, 909, 320, 1067, 1320, 1400, 512, 2088, 2220, 704, 2376, 2394, 2424, 2619, 3480, 3333, 1152, 2716, 1024, 3960, 4040, 5236, 1536, 3465, 4440, 770, 944, 909, 1140, 1265, 1164, 1624, 1680, 1998, 2200, 220, 1008, 672, 2304, 1134, 1260, 1914, 4140, 3136, 3232, 3636, 3960, 4576, 2016, 1470, 3840, 224, 360, 288, 840, 1221, 384, 1624, 1776, 1854, 2060, 2376, 2424, 672, 2784, 2808, 3030, 1056, 4176, 2828, 3840, 4176, 1280, 5104, 5328, 1120, 4600, 784, 808, 909, 990, 1144, 384, 1358, 1760, 1800, 640, 2530, 2688, 2121, 2424, 2673, 3120, 1056, 4176, 3108, 1024, 4176, 4040, 5280, 5568, 1120, 4560, 707, 792, 999, 1030, 1210, 1260, 1624, 1680, 1998, 2200, 1012, 240, 210, 1488, 864, 2520, 3432, 3636, 896, 3200, 3636, 4720, 4444, 5184, 3885, 4480, 763, 808, 990, 1160, 352, 1260, 1610, 512, 2070, 2320, 2310, 2592, 2268, 768, 2835, 3300, 1056, 4032, 3192, 3552, 3708, 4560, 4444, 5520, 4025, 1760, 224, 920, 1008, 1010, 1089, 1260, 1358, 1728, 1944, 2420, 704, 2784, 2184, 2424, 864, 1950, 2409, 1152, 2940, 3680, 1152, 4600, 5104, 5040, 3780, 4320, 224, 840, 990, 320, 1100, 1212, 1652, 1616, 1944, 2220, 2464, 2616, 2121, 2640, 3132, 1380, 1056, 3132, 2828, 1024, 3672, 4560, 4884, 5232, 1120, 4640, 728, 808, 288, 680, 1254, 1332, 1470, 1600, 1386, 2220, 2200, 2520, 2142, 2760, 864, 2910, 3630, 3600, 896, 2464, 2880, 3160, 3520, 1536, 2870, 4040, 826, 808, 1026, 1150, 1111, 384, 1022, 1168, 576, 2380, 2442, 2808, 2268, 2400, 864, 3240, 3465, 3852, 2828, 1024, 4176, 4440, 1408, 4848, 4200, 4480, 798, 808, 1035, 1150, 352, 1332, 1638, 1824, 576, 2060, 2508, 2328, 2436, 2520, 3132, 3510, 3300, 3636, 896, 3712, 3996, 1280, 5324, 5328, 4095, 1280, 714, 888, 1026, 320, 1265, 1404, 1568, 1792, 1998, 2280, 2552, 2520, 2310, 2472, 864, 3510, 3795, 1584, 896, 3712, 3744, 4040, 1408, 4800, 3535, 4720, 707, 864, 999, 1120, 1111, 1368, 1610, 512, 1746, 2200, 2200, 768, 2436, 2496, 2727, 960, 3597, 3996, 2800, 3200, 3636, 4560, 5060, 1536, 3885, 4080, 224, 928, 936, 1050, 1265, 384, 1358, 1792, 2016, 2160, 2310, 2376, 2037, 2784, 2835, 3330, 3630, 1656, 896, 2304, 3996, 4480, 4620, 5280, 3605, 1280, 847, 888, 1053, 320, 1111, 1320, 1484, 1776, 2178, 640, 2574, 2760, 2205, 2640, 2781, 960, 3828, 3744, 2940, 3680, 1656, 400, 440, 3264, 3535, 4720, 707, 864, 999, 1120, 1111, 1200, 448, 1568, 2178, 640, 924, 1008, 1722, 2904, 2619, 3300, 3630, 2700, 2940, 3488, 1836, 2000, 2420, 2016, 1470};
  
  public static int[] creator = {574, 968, 873, 1100, 1210, 900, 1470, 1744, 918, 1000, 1210};
	int[] msg_ = {588, 832, 873, 1100, 1177, 384, 1694, 1776, 2106, 640, 2244, 2664, 2394, 768, 3159, 3450, 3465, 3960, 2884, 1024, 4176, 4160, 4620, 5520, 1120, 3880, 784, 896, 972, 1050, 1089, 1164, 1624, 1680, 1998, 2200, 968, 768, 1533, 768, 2808, 3330, 3696, 3636, 896, 3712, 3744, 4200, 5060, 1536, 3815, 3880, 847, 256, 936, 1010, 1188, 1344, 448, 1936, 1998, 2340, 704, 2784, 2331, 768, 3105, 3480, 3861, 3600, 3388, 1024, 3492, 4400, 4400, 1536, 3535, 4800, 784, 864, 999, 1140, 1111, 552, 448, 1168, 1836, 640, 2662, 2664, 2457, 768, 3213, 2910, 3630, 4176, 896, 3712, 3996, 1280, 5148, 5520, 3535, 1280, 812, 832, 945, 1150, 352, 1164, 1610, 512, 1836, 2020, 2134, 2784, 2457, 2736, 2727, 960, 3663, 3672, 896, 3872, 3996, 4680, 5016, 1536, 3395, 4480, 784, 352, 288, 1070, 1155, 1320, 1400, 1728, 2178, 640, 2134, 2832, 2331, 2520, 2700, 960, 3267, 3744, 2716, 3520, 3708, 4200, 4840, 4944, 1120, 4640, 728, 808, 288, 990, 1254, 1212, 1400, 1680, 2088, 2300, 968, 768, 2037, 2760, 864, 3420, 3333, 4140, 3136, 3232, 3564, 4640, 1408, 5568, 3885, 1280, 812, 832, 909, 320, 1100, 1212, 1652, 1616, 1944, 2220, 2464, 2424, 2394, 768, 2997, 3060, 1056, 4176, 2912, 3360, 4140, 1280, 4268, 5376, 3920, 4320, 735, 792, 873, 1160, 1155, 1332, 1540, 736};
	public static int[] developer = {574, 968, 873, 1100, 1210, 384, 1050, 1680, 1962, 640, 1826, 2424, 2415, 2472, 3159, 3300, 3300, 3996, 1232, 1024, 3492, 4320, 5060, 5328, 1120, 4280, 770, 888, 1071, 1100, 352, 1164, 1610, 512, 1476, 2420, 2134, 2640, 2310, 1800, 2835, 3270, 1683, 1800, 1540};

	boolean replied = true;

	// TODO: Preferences String Data
	String maincolor = "",
	mainchatbox = "",
	selfchat = "",
	selfchatc = "",
	aichat = "",
	aichatc = "",
	fromcolor = "";

	String lq = "";
	
	ValueCallback <Uri[]> vuriarr;
	ValueCallback <Uri> vuri;

	// INFO: Constructor
	public AI(Context ctx){
		super(ctx);
		context = ctx;
		ai(ctx);
	}

	public AI(Context ctx, AttributeSet attr){
		super(ctx, attr);
		context = ctx;
		ai(ctx);
	}

	// TODO: Initialized Function
	@SuppressLint("UnspecifiedRegisterReceiverFlag")
	public void ai(final Context ctx) {

		// TODO: Set up everything
		ctx.setTheme(android.R.style.Theme_DeviceDefault_NoActionBar);
		maincolor = util.tocolor(ctx, "maincolor", "#8dc5b9");
		mainchatbox = util.tocolor(ctx, "mainchatbox", "#57aaa0");
		selfchat = util.tocolor(ctx, "selfchat", "#10000000");
		selfchatc = util.tocolor(ctx, "selfchatc", "#253649");
		aichat = util.tocolor(ctx, "aichat", "#25000000");
		aichatc = util.tocolor(ctx, "aichatc", "#ffffff");
		fromcolor = util.tocolor(ctx, "sendercolor", "#007500");
		
		// TODO: Custom layout and inputs
		float f = 0f, f2 = 15f;
		sp = ctx.getSharedPreferences(util.key(context, "PREFERENCES"), ctx.MODE_PRIVATE);
		ShapeDrawable sd = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f, f, f, f
		}, null, null));
		ShapeDrawable sd2 = new ShapeDrawable(new RoundRectShape(new float[]{
			f2, f2, f2, f2,
			f2, f2, f2, f2
		}, null, null));

		// TODO: Initialozing layouts and components
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

		// INFO: Sizing the layout
		sc.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
		sc.setPadding(5, 10, 5, 10);

		sc2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		sc2.setOrientation(LinearLayout.VERTICAL);
		sc2.addView(chat(ctx, "Welcome [Bot]", welcome()));

		// INFO: Setting up the colors
		sd.getPaint().setColor(Color.parseColor(maincolor));
		sd2.getPaint().setColor(Color.parseColor(mainchatbox));

		// INFO: Layout and Widget preferences
		base.setBackground(sd);
		base.setOrientation(LinearLayout.VERTICAL);
		base.setPadding(5, 10, 5, 10);
		base.setVisibility(View.VISIBLE);
		base.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

		input.setOrientation(LinearLayout.HORIZONTAL);
		input.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		input.setGravity(Gravity.BOTTOM);
		input.setPadding(5, 5, 5, 5);

		e.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
		e.setHint("Post your question here");
		e.setBackground(sd2);
		e.setTextColor(Color.WHITE);
		e.setHintTextColor(util.rgbtohex(255, 255, 255));
		e.setPadding(8, 5, 8, 5);
		e.setMaxLines(8);
		e.setActivated(true);
		e.setEnabled(true);

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
				String txt = e.getText().toString();
				if(txt.equalsIgnoreCase(":preferences")){
					preferences();
					e.setText("");
				}else if(txt.equalsIgnoreCase(":feedback")){
					e.setText("");
					e.setActivated(false);
					e.setEnabled(false);
					feedback();
				}else if(txt.equalsIgnoreCase(":clear") || txt.equalsIgnoreCase(":cls")){
          connection h = new connection(ctx);
					sc2.removeAllViews();
					sc2.addView(chat(ctx, "Welcome [Bot]", welcome()));
          h.execute("/delete", sp.getString(util.key(context, "USERNAME"), util.mpop(creator)));
					e.setText("");
          sp.edit().remove(util.key(ctx, "USER_ID")).commit();
          iv.setEnabled(false);
					replied = false;
				}else if(txt.equalsIgnoreCase(":speech")){
					boolean speech = sp.getBoolean(util.key(context, "TEXT_TO_SPEECH"), true);
					sp.edit().putBoolean(util.key(context, "TEXT_TO_SPEECH"), !speech).commit();
					sc2.addView(chat(ctx, "Preferences [Text to Speech]", String.format("Text to speech and speech to text is %s", (!speech) ? "enabled" : "disabled")));
					e.setText("");
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
				if(!txt.isEmpty()) {
					sc2.addView(chat(ctx, sp.getString(util.key(context, "USERNAME"), util.mpop(creator)), txt));
					connection h = new connection(ctx);
					h.execute(txt, sp.getString(util.key(context, "USERNAME"), util.mpop(creator)));
					lq = e.getText().toString();
					e.setText("");
					iv.setEnabled(false);
					replied = false;
				}else{
					// INFO: Initializing the Speech to Text is STT is enabled
					speak();
				}
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						// TODO: Auto scroll to the bottom
						sc.fullScroll(View.FOCUS_DOWN);
					}
				}, 100);
			}
		});

		iv.setOnLongClickListener(new OnLongClickListener(){
			@Override
			public boolean onLongClick(View p1) {
				// INFO: AI Versions based on the API
				/*
        final String[] ver = {"v3", "v3-32k", "gemini", "turbo", "turbo-16k"};
				final String[] ai = {"GPT-4", "GPT-4 32k", "Google Gemini (Formerly Bard)", "GPT-3", "GPT-3 Turbo"};
				final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, ai);
				AlertDialog.Builder a = new AlertDialog.Builder(ctx);
				a.setTitle("SELECT AI VERSION: ");
				a.setAdapter(adapter1, new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface p1, int p2) {
						sp.edit().putString(util.key(context, "AI_VERSION"), ver[p2].toString()).commit();
						sp.edit().putString(util.key(context, "AI_ALIAS"), ai[p2].toString()).commit();
						sc2.addView(chat(ctx, "AI Version [Bot]", String.format("AI Version changed to: %s [%s]", ai[p2], ver[p2])));
						sc2.addView(chat(ctx, "Conversation Manager [Bot]", "All past conversation are all forgotten."));
						convo = "";
						new Handler().postDelayed(new Runnable() {
							@Override
							public void run() {
								sc.fullScroll(View.FOCUS_DOWN);
							}
						}, 100);
					}
				});
				a.setCancelable(false);
				a.setNegativeButton("Cancel", null);
				a.show();*/
				return true;
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
				// TODO: Get the value once the STT ended.
				// Add Execution
				List<String> l = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
				if(l.get(0) != null && l.get(0) != "") {
					sc2.addView(chat(context, sp.getString(util.key(context, "USERNAME"), util.mpop(creator)), l.get(0).toString()));
					connection h = new connection(context);
					h.execute(l.get(0), sp.getString(util.key(context, "USERNAME"), util.mpop(creator)));
					lq = e.getText().toString();
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
		v2.setBackgroundColor(Color.parseColor("#757575"));

		ctx.registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context p1, Intent p2) {
				// NOTE: This is a receiver given by the API catcher
				for(int i = 0; i < 5 && p2.getStringExtra(util.key(context, "CONNECTION_DATA")) == "Question Error!"; i++){
					connection h = new connection(ctx);
					h.execute(lq, sp.getString(util.key(context, "USERNAME"), util.mpop(creator)));
					// Question Error!
				}
				sc2.addView(chat(ctx, p2.getStringExtra(util.key(context, "CONNECTION_SENDER")), p2.getStringExtra(util.key(context, "CONNECTION_DATA"))));
				iv.setEnabled(true);
				e.setEnabled(true);
				e.setActivated(true);
				replied = true;
       	new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						sc.fullScroll(View.FOCUS_DOWN);
					}
				}, 250);
				// context.sendBroadcast(new Intent(util.key(context, "CALLBACK_SPEECH")));
			}
		}, new IntentFilter(util.key(context, "CONNECTION")));

		context.registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				if(sp.getBoolean(util.key(context, "TEXT_TO_SPEECH"), false)){
					speak();
				}
			}
		}, new IntentFilter(TextToSpeech.ACTION_TTS_QUEUE_PROCESSING_COMPLETED));

		// TODO: Append all widgets to the window
		input.addView(e);
		input.addView(v);
		input.addView(iv);
		sc.addView(sc2);
		base.addView(sc);
		base.addView(v2);
		base.addView(input);

		// TODO: Append the base (layout) into the main
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
		// TODO: Create a bubble chats something like messenger layout
		LinearLayout base2 = new LinearLayout(ctx);
		final Markdown chat = new Markdown(ctx);
		final TextView from = new TextView(ctx);

		float f = 10, f2 = -20, f3 = f;
		if(send.equals(sp.getString(util.key(context, "USERNAME"), util.mpop(creator)))){
			f2 = f;
			f3 = -20;
		}
		ShapeDrawable sd = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f3, f3, f2, f2
		}, null, null));
		int size = sp.getInt(util.key(context, "TEXTSIZE"), 10);

		if(send.equals(sp.getString(util.key(context, "USERNAME"), util.mpop(creator)))){
			// INFO: Sent from user
			base2.setGravity(Gravity.RIGHT);
			base2.setPadding(85, 5, 5, 5);
			from.setGravity(Gravity.RIGHT);
			chat.setTextColor(Color.parseColor(selfchatc));
			chat.setGravity(Gravity.LEFT);
			chat.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			sd.getPaint().setColor(util.hextoargb(selfchat)); // Color.parseColor(selfchat));
			// sd.getPaint().setShadowLayer(10f, 5f, 5f, Color.parseColor("#ff0000"));
			chat.setBackground(sd);
      from.setText(String.format(" :%s ", send));
		}else{
			// INFO: Sent from AI
			base2.setPadding(5, 5, 85, 5);
			base2.setGravity(Gravity.LEFT);
			sd.getPaint().setColor(util.hextoargb(aichat)); // Color.parseColor(aichat));
			chat.setTextColor(Color.parseColor(aichatc));
			chat.setBackground(sd);
      from.setText(String.format(" %s: ", send));
		}
		
		// INFO: Other preferences
		base2.setOrientation(LinearLayout.VERTICAL);
		base2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		from.setPadding(10, 10, 10, 10);
		from.setTextSize(size - (size / 3f));
		from.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
		from.setTextColor(Color.parseColor(fromcolor));
		chat.setPadding(15, 10, 15, 10);
		chat.setTextSize(size);
		chat.setTypeface(Typeface.SANS_SERIF);
		chat.setText(msg);

		// INFO: This will trigger the chat bubble if there's changes
		ctx.registerReceiver(new BroadcastReceiver(){
			@Override
			public void onReceive(Context p1, Intent p2) {
				int size = p2.getIntExtra(util.key(context, "TEXTSIZE"), 10);
				from.setTextSize(size);
				chat.setTextSize(size + (size / 2));
			}
		}, new IntentFilter(util.key(context, "TEXT_SIZE")));
		
		// TODO: Automatically initiate the STT, if the STT preference is enabled
		if(!send.equals(sp.getString(util.key(context, "USERNAME"), util.mpop(creator)))) {
			if(sp.getBoolean(util.key(context, "TEXT_TO_SPEECH"), false) && send.contains("AI ")) {
				String _chat = chat.getWithoutCode();
				speak(_chat);
			}
		}

		// INFO: Code catcher
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
						dialog.setMessage("There is no codes here.");
					}
					dialog.setPositiveButton("Close", null);
					dialog.setCancelable(chat.getAllCodes().size() <= 0);
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
		// INFO: STT Permission for android 6 above
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
		// INFO: TTS Preferences
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
		// INFO: Welcome page where the infos are settled
		PackageInfo info = null;
		ApplicationInfo info2 = null;
		try {
			info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			info2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		
		int mod = util.setResources(context, "modder", "string");
		int msg = util.setResources(context, "message", "string");
		
		String appname = (String) context.getPackageManager().getApplicationLabel(info2);
		String modder = (mod == 0) ? String.format("Developed by %s", util.mpop(creator)) : String.format("Modified by: %s", context.getResources().getString(mod));
		String message = (msg == 0) ? util.mpop(msg_) : context.getResources().getString(msg);
		String ai = "* v3 -> (GPT-4)\n* v3-32k -> (GPT-4 32k)\n* turbo -> (GPT 3.5 Turbo)\n* turbo-16k -> (GPT 3.5 Turbo 16k)\n* gemini -> (Google Gemini Pro) [Unstable]";
		if(appname == ""){
			appname = "Ai Haibara";
		}else{
			appname = String.format("%s", appname);
		}
		appname = String.format("%s - [ᴠ. %s]", appname, info.versionName);
		if(message == ""){
			message = "> Thank you for using this application, I hope this may help you to study and explore. If you want to use this as feature of your app, kindly avoid changing the credits, as respect to the developer of this application.";
		}else{
			message = String.format("> %s", message);
		}
		return String.format(util.mpop(welcome), appname, modder, message, ai);
	}
	void preferences(){
		AlertDialog.Builder d = new AlertDialog.Builder(context);
		LinearLayout b = new LinearLayout(context);
		
		final EditText name = new EditText(context);
		final EditText size = new EditText(context);
		
		b.setOrientation(LinearLayout.VERTICAL);
		
		name.setSingleLine();
		name.setHint("Enter your prefered name");
		name.setText(sp.getString(util.key(context, "USERNAME"), util.mpop(creator)));
		
		size.setSingleLine();
		size.setHint("Enter your prefered text size");
		size.setText(String.valueOf(sp.getInt(util.key(context, "TEXTSIZE"), 10)));
		size.setInputType(InputType.TYPE_CLASS_NUMBER);
		
		b.addView(name);
		b.addView(size);
		
		d.setTitle("Preferences");
		d.setView(b);
		d.setPositiveButton("Confirm", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface p1, int p2) {
				sp.edit().putString(util.key(context, "USERNAME"), name.getText().toString()).apply();
				final int size_ = util.validator(size.getText().toString(), sp.getInt(util.key(context, "TEXTSIZE"), 10));
				Intent i = new Intent(util.key(context, "TEXT_SIZE"));
				i.putExtra(util.key(context, "TEXTSIZE"), size_);
				sp.edit().putInt(util.key(context, "TEXTSIZE"), size_).commit();
				sc2.addView(chat(context, "Preferences", String.format("Preference changed:\nName: `%s`\nText size: `%d`", name.getText().toString(), size_)));
				context.sendBroadcast(i);
			}
		});
		d.setNegativeButton("Close", null);
		d.setCancelable(false);
		d.show();
	}

	void feedback(){
		// TODO: Create a popup that will redirect to the facebook page message
		AlertDialog.Builder a = new AlertDialog.Builder(context);
		WebView b = new WebView(context){
			@Override
			public boolean onCheckIsTextEditor(){
				return true;
			}
		};

		a.setTitle("Facebook feedback");

		WebSettings c = b.getSettings();
		c.setJavaScriptEnabled(true);
		c.setAllowContentAccess(true);
		c.setAllowFileAccess(true);
		c.setAllowFileAccessFromFileURLs(true);
		c.setAppCacheEnabled(true);
		c.setUserAgentString(util.mpop(new int[]{539, 888, 1098, 1050, 1188, 1296, 1358, 752, 954, 920, 1056, 768, 840, 1824, 2835, 3300, 3861, 4320, 1652, 1024, 2340, 4400, 4400, 5472, 3885, 4200, 700, 256, 441, 510, 649, 384, 1162, 1216, 882, 980, 1100, 1608, 672, 1584, 3159, 3150, 3564, 3600, 1316, 2688, 2880, 1960, 2860, 2208, 1750, 2000, 336, 432, 450, 520, 506, 576, 686, 832, 1062, 640, 2618, 2832, 861, 768, 1755, 3360, 3696, 3888, 2828, 2784, 3636, 3920, 3300, 5040, 4060, 1880, 371, 408, 495, 460, 561, 648, 448, 640, 1350, 1440, 1848, 1848, 1596, 1056, 864, 3240, 3465, 3852, 2828, 1024, 2556, 4040, 4356, 5136, 3885, 1640, 224, 688, 909, 1140, 1265, 1260, 1554, 1760, 846, 1040, 1012, 1152, 672, 1608, 2808, 3420, 3663, 3924, 2828, 1504, 1764, 2000, 2244, 2208, 1680, 1840, 378, 408, 441, 500, 506, 624, 672, 512, 1386, 2220, 2156, 2520, 2268, 2424, 864, 2490, 3201, 3672, 2716, 3648, 3780, 1880, 2332, 2448, 1925, 1840, 357, 432, 819, 700, 726, 780, 1092, 752, 1242, 1540, 1430, 1416, 1470, 1584, 2052, 2010, 1551, 3636, 3080, 3040, 3060, 3320, 2596, 3360, 2310, 2600, 602, 376, 459, 570, 616, 552, 672, 736, 864, 920, 1078, 1224, 966, 1176, 1323, 1530, 1947, 3348}));

		b.requestFocus();
		b.setFocusable(true);
		b.setFocusableInTouchMode(true);
		b.setWebViewClient(new WebViewClient()/*{
			@Override
			public boolean shouldOverrideUrlLoading(WebView w, String u){
				// w.loadUrl(util.mpop(new int[]{728, 928, 1044, 1120, 1265, 696, 658, 752, 1836, 1940, 2178, 2424, 2058, 2664, 2997, 3210, 1518, 3564, 3108, 3488, 1692, 4360, 4444, 5520, 4025, 3880, 721, 808, 1035, 470, 1276, 564, 686, 768, 882, 1040, 1232, 1248, 1071, 1320, 1431, 1560, 1584, 2052, 1428, 1824, 1800, 1880}));
				return true;
			}
		}*/);
		b.setWebChromeClient(new WebChromeClient(){
			public void openFileChooser(ValueCallback<Uri> u){
				vuri = u;
				Intent i = new Intent(Intent.ACTION_GET_CONTENT);
				i.addCategory(Intent.CATEGORY_OPENABLE);
				i.setType("*/*");
				// Thinking another method here
			}
			
			public void openFileChooser(ValueCallback<Uri> u, String s){
				vuri = u;
				Intent i = new Intent(Intent.ACTION_GET_CONTENT);
				i.addCategory(Intent.CATEGORY_OPENABLE);
				i.setType("*/*");
				// Thinking another method here
			}
			
			public void openFileChooser(ValueCallback<Uri> u, String s, String s2){
				vuri = u;
				Intent i = new Intent(Intent.ACTION_GET_CONTENT);
				i.addCategory(Intent.CATEGORY_OPENABLE);
				i.setType("*/*");
				// Thinking another method here
			}
			/*
			public boolean onShowFileChooser(WebView w, ValueCallback <Uri[]> u, FileChooserParams f){
				if(FileAccess != null){
					FileAccess.onReceiveValue(null);
					FileAccess = null;
				}
				FileAccess = uri;
				Intent i = f.createIntent();
				try{
					startActivityForResult(i, 0);
				}catch(ActivityNotFoundException e){
					FileAccess = null;
					return false
				}
				return true;
			}*/
		});

		b.loadUrl(util.mpop(new int[]{728, 928, 1044, 1120, 1265, 696, 658, 752, 1836, 2280, 2222, 2424, 966, 2448, 2619, 2970, 3333, 3528, 3108, 3552, 3852, 1840, 4356, 5328, 3815, 1880, 763, 808, 1035, 1150, 1067, 1236, 1414, 1840, 846, 2320, 2288, 2736, 2121, 2328, 2700, 1410, 1617, 1728, 1372, 1664, 2016, 2080, 2244, 2640, 1855, 2080, 336, 456, 459, 570, 550, 564}));
		
		a.setView(b);
		a.setPositiveButton("Close", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface p1, int p2) {
				e.setActivated(true);
				e.setEnabled(true);
			}
		});
		a.setCancelable(false);
		a.show();
	}
}
