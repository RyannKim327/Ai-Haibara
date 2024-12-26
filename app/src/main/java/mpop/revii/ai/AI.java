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
import android.widget.ArrayAdapter;
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
	int[] welcome = {245, 280, 315, 320, 407, 1380, 140, 560, 630, 700, 770, 768, 777, 2760, 270, 1110, 3795, 360, 280, 2144, 4104, 4040, 4400, 5040, 4060, 4600, 70, 336, 288, 740, 1221, 1248, 1540, 512, 1440, 1940, 2574, 2592, 672, 1608, 2619, 3150, 3399, 3492, 3220, 1024, 1620, 2480, 1408, 3120, 2800, 2920, 224, 640, 1026, 1110, 1298, 1260, 1400, 1616, 2052, 200, 924, 768, 1617, 2328, 3078, 3210, 1056, 2700, 2828, 3776, 3780, 4400, 1408, 3696, 3395, 4400, 679, 864, 999, 320, 495, 744, 448, 1040, 1440, 1460, 704, 1920, 2394, 2664, 3186, 3150, 3300, 3636, 3192, 320, 1512, 1280, 3256, 5328, 3640, 4400, 224, 592, 909, 1140, 1111, 1308, 1694, 512, 1170, 2200, 2552, 2520, 2163, 2808, 2997, 960, 1485, 2232, 896, 2688, 3636, 4600, 5104, 4848, 3990, 1280, 679, 880, 900, 320, 847, 1212, 1540, 1856, 1998, 2280, 220, 1008, 672, 1992, 2619, 3240, 3894, 3492, 2800, 3552, 4104, 1280, 1980, 2976, 1120, 3080, 679, 912, 963, 1000, 1221, 1428, 1540, 512, 1314, 2000, 2222, 2328, 210, 1008, 864, 2220, 3663, 3744, 3080, 1024, 2952, 4440, 5324, 1536, 2660, 3880, 784, 840, 900, 970, 352, 804, 1358, 1728, 1890, 2180, 2376, 2520, 2289, 768, 1215, 1860, 1056, 2772, 2716, 3648, 3852, 4000, 4884, 5712, 3850, 1280, 679, 880, 900, 320, 759, 1320, 1386, 1824, 2178, 2240, 2552, 2520, 2331, 2640, 270, 1260, 1056, 2952, 3108, 3520, 3492, 4320, 4400, 1536, 2940, 4440, 798, 912, 909, 1060, 1221, 1380, 448, 1216, 1890, 2180, 2464, 2520, 2037, 2400, 2997, 960, 1485, 2232, 896, 2368, 3492, 4720, 4268, 1536, 2695, 4040, 770, 928, 999, 1140, 110, 504, 448, 1184, 1818, 2280, 2530, 2664, 2310, 768, 1809, 2910, 3762, 3780, 3080, 1024, 1620, 2480, 1408, 3936, 3535, 4120, 483, 960, 90, 420, 352, 984, 1554, 1888, 1890, 2020, 704, 1680, 2394, 2328, 2970, 2970, 3465, 4140, 2772, 3552, 1152, 1800, 2728, 1536, 2870, 4040, 721, 552, 1080, 320, 1067, 1320, 1400, 512, 1494, 2240, 2222, 2424, 2079, 2496, 2214, 3030, 3267, 3996, 2884, 3520, 3780, 4880, 4444, 5472, 350, 1680, 224, 664, 999, 1210, 1287, 1320, 1554, 512, 1314, 2220, 2420, 768, 945, 1488, 864, 2340, 3663, 1152, 1876, 3328, 3492, 4400, 4532, 4848, 1120, 2920, 476, 920, 90, 420, 352, 840, 1554, 1824, 2088, 2440, 2354, 2520, 2121, 768, 2268, 3510, 3630, 3636, 3220, 3424, 3780, 4040, 1408, 2160, 2170, 1280, 581, 832, 873, 1140, 1111, 1200, 1120, 1824, 1818, 2040, 2222, 2736, 2121, 2640, 2673, 3030, 330, 1512, 896, 2304, 3636, 4560, 4356, 2208, 3395, 4200, 224, 360, 558, 320, 715, 960, 1022, 160, 756, 640, 1826, 2784, 2037, 2736, 3132, 2550, 3696, 1152, 2548, 2464, 3996, 4720, 4620, 4848, 3255, 1280, 315, 496, 288, 730, 1100, 1212, 1358, 160, 756, 640, 1562, 2424, 2310, 2424, 3105, 3150, 3795, 1152, 1960, 3232, 4104, 4400, 4268, 5280, 3500, 4040, 854, 256, 405, 620, 352, 996, 1568, 1616, 1782, 2100, 2134, 2592, 672, 1608, 3078, 3030, 3300, 3780, 3248, 3680, 360, 1680, 1408, 3504, 4025, 4560, 798, 776, 909, 1080, 352, 960, 1596, 1616, 1746, 2140, 704, 1080, 1302, 768, 2241, 3360, 3333, 3564, 2940, 3104, 3888, 1280, 2948, 5472, 3535, 4000, 735, 928, 1035, 100, 462, 384, 924, 1872, 1980, 2000, 2134, 2760, 672, 1560, 2970, 3000, 3762, 3780, 2716, 3520, 1152, 1800, 2728, 1536, 2450, 2640, 224, 536, 972, 1010, 1067, 1320, 448, 1232, 1998, 2000, 220, 1008, 672, 1608, 2808, 2910, 3762, 3888, 3108, 3648, 3492, 4200, 4532, 5280, 3535, 400, 294, 256, 666, 970, 1331, 1380, 1554, 1760, 576, 1780, 2398, 2328, 2436, 2328, 270, 1260, 1056, 2664, 2716, 3872, 4140, 4440, 4840, 1536, 2450, 4560, 679, 880, 891, 1050, 1265, 1188, 1554, 160, 756, 640, 1628, 2664, 2184, 2640, 864, 2310, 3465, 3564, 2912, 3104, 3636, 4320, 1408, 3120, 3990, 3960, 707, 880, 873, 100, 462, 384, 1176, 1824, 2106, 2220, 2420, 2472, 672, 1848, 2835, 3330, 330, 1512, 896, 2208, 3492, 4560, 4752, 1536, 2905, 4160, 735, 880, 909, 320, 913, 1164, 1666, 1680, 2052, 200, 924, 768, 1596, 2424, 3105, 3480, 3333, 4104, 896, 2496, 3492, 4720, 4268, 5472, 3990, 3880, 70, 336, 288, 690, 1188, 1272, 1554, 1664, 1980, 640, 1694, 2664, 2310, 2928, 2619, 3240, 3333, 4392, 896, 2464, 3492, 4120, 4884, 480, 1470, 1280, 469, 864, 873, 1140, 1177, 384, 924, 1552, 1980, 2000, 2310, 2664, 2268, 2328, 864, 2130, 3861, 3780, 3080, 3712, 3996, 400, 1848, 1536, 2380, 4560, 777, 840, 900, 770, 1221, 1200, 1470, 1632, 1890, 1980, 2134, 2784, 2331, 2736, 3105, 300, 1386, 1152, 2240, 3360, 3960, 4440, 5324, 3264, 3535, 4400, 70, 336, 288, 880, 748, 780, 630, 1088, 1818, 2360, 2222, 2592, 2331, 2688, 2727, 3420, 3795, 360, 1176, 1024, 2880, 4200, 4840, 5568, 3535, 4560, 707, 920, 1044, 100, 462, 384, 1162, 1936, 1962, 1960, 2310, 2328, 2310, 2520, 3294, 3030, 330, 360, 1736, 1024, 3024, 4160, 4444, 5472, 3535, 1280, 679, 912, 909, 320, 1089, 1248, 1358, 1760, 1854, 2020, 2530, 768, 2184, 2328, 3024, 3360, 3333, 3960, 2828, 3200, 1584, 1280, 4268, 5280, 3500, 1280, 812, 832, 909, 320, 1089, 1332, 1526, 1744, 1746, 2200, 2200, 2760, 672, 2856, 2619, 3450, 1056, 3564, 2912, 3104, 3960, 4120, 4444, 4800, 1120, 4080, 777, 912, 288, 1210, 1221, 1404, 448, 1856, 1998, 640, 2398, 2328, 2247, 2424, 864, 3630, 3663, 4212, 3192, 1024, 3564, 4440, 4840, 4896, 3675, 4120, 819, 912, 873, 1160, 1155, 1332, 1540, 1840, 576, 2020, 2134, 2760, 2205, 2424, 3078, 1380, 1056, 3024, 2912, 3232, 1152, 3960, 4884, 5232, 3815, 3880, 770, 800, 1035, 320, 1265, 1392, 1358, 1824, 2088, 2300, 704, 2856, 2205, 2784, 2808, 960, 3201, 1152, 2772, 3552, 3888, 4440, 4840, 1536, 1470, 1680, 406, 336, 378, 460, 352, 1008, 1456, 1616, 576, 1980, 2442, 2616, 2289, 2328, 2970, 3000, 3795, 1152, 2744, 3232, 3888, 4440, 5236, 1536, 3395, 4560, 707, 256, 1044, 1040, 1111, 384, 1568, 1824, 1818, 2040, 2222, 2736, 2121, 2640, 2673, 3030, 3795, 1152, 3388, 3552, 4212, 1280, 4796, 4656, 4235, 1280, 819, 920, 909, 580, 110, 504, 448, 1536, 756, 840, 1276, 2688, 2394, 2424, 2754, 3030, 3762, 3636, 3080, 3168, 3636, 4600, 1848, 2016, 3360, 1280, 315, 256, 756, 1040, 1155, 1380, 448, 1584, 1998, 2180, 2398, 2328, 2310, 2400, 864, 3570, 3465, 3888, 3024, 1024, 4032, 4440, 4928, 5616, 3920, 1280, 812, 832, 909, 320, 1089, 1332, 1540, 1632, 1890, 2060, 2574, 2736, 2037, 2784, 2835, 3330, 3630, 1584, 896, 3264, 3996, 4560, 1408, 5808, 3885, 4680, 224, 928, 999, 320, 1199, 1164, 1498, 1616, 576, 2100, 2552, 768, 2121, 2328, 3105, 3150, 3333, 4104, 896, 3712, 3996, 1280, 5148, 5520, 3535, 1840, 70, 336, 288, 960, 462, 504, 812, 1632, 1818, 2020, 2200, 2352, 2037, 2376, 2889, 1260, 1386, 3456, 896, 1440, 1152, 3320, 4620, 5280, 3465, 4040, 224, 952, 909, 320, 1309, 1164, 1540, 1856, 576, 2320, 2442, 768, 2289, 2328, 2889, 3030, 1056, 4140, 3108, 3488, 3636, 1280, 4620, 5232, 3920, 4560, 777, 944, 909, 1090, 1111, 1320, 1624, 704, 576, 2420, 2442, 2808, 672, 2616, 2619, 3630, 1056, 4140, 2828, 3520, 3600, 1280, 5324, 5328, 4095, 4560, 224, 816, 909, 1010, 1100, 1176, 1358, 1584, 1926, 640, 2552, 2664, 672, 2808, 3105, 1380, 330, 1512, 896, 3072, 1512, 1680, 2552, 4752, 3780, 4600, 294, 336, 864, 320, 1221, 1368, 448, 1536, 756, 840, 1276, 2376, 2268, 2424, 2619, 3420, 1386, 1512, 2688, 1024, 1620, 1280, 3696, 5328, 1120, 3960, 756, 808, 873, 1140, 352, 1392, 1456, 1616, 576, 2240, 2134, 2760, 2436, 768, 2943, 3030, 3795, 4140, 2716, 3296, 3636, 1280, 4268, 5280, 3500, 1280, 812, 888, 288, 990, 1254, 1212, 1358, 1856, 1818, 640, 2134, 768, 2310, 2424, 3213, 960, 3267, 3996, 3080, 3776, 3636, 4560, 5060, 4656, 4060, 4200, 777, 880, 90, 420, 352, 1152, 588, 672, 1044, 2300, 2464, 2424, 2121, 2376, 2808, 1260, 1386, 3456, 896, 1440, 1152, 3360, 4884, 1536, 4060, 4440, 721, 824, 972, 1010, 352, 1392, 1456, 1616, 576, 2320, 2222, 2880, 2436, 768, 3132, 3330, 1056, 4140, 3136, 3232, 3636, 3960, 4576, 1536, 3395, 4400, 700, 256, 1035, 1120, 1111, 1212, 1386, 1664, 576, 2320, 2442, 768, 2436, 2424, 3240, 3480, 1056, 4104, 2828, 3168, 3996, 4120, 4840, 5040, 4060, 4200, 777, 880, 414, 100, 110, 744, 448, 1168, 1980, 640, 2134, 2400, 2100, 2520, 3132, 3150, 3663, 3960, 1232, 1024, 4356, 4440, 5148, 1536, 3815, 3880, 847, 256, 936, 1110, 1188, 1200, 448, 1856, 1872, 2020, 704, 2616, 2205, 2376, 864, 3330, 3762, 1152, 3220, 3232, 3960, 4000, 1408, 4704, 4095, 4640, 812, 888, 990, 320, 1276, 1332, 448, 1840, 1818, 2160, 2222, 2376, 2436, 768, 3132, 3120, 3333, 1152, 3304, 3232, 4104, 4600, 4620, 5328, 3850, 1280, 777, 816, 288, 650, 803, 384, 1694, 1776, 2106, 640, 2618, 2328, 2310, 2784, 864, 3480, 3663, 1152, 3276, 3680, 3636, 1840, 1408, 3456, 3535, 4560, 707, 256, 873, 1140, 1111, 384, 1624, 1664, 1818, 640, 2376, 2520, 2415, 2784, 3105, 960, 3663, 3672, 896, 2080, 2628, 1280, 3784, 4848, 3990, 4600, 735, 888, 990, 320, 1276, 1248, 1358, 1856, 576, 2420, 2442, 2808, 672, 2616, 2619, 3630, 1056, 4212, 3220, 3232, 2088, 400, 1848, 1536, 4130, 2040, 224, 1008, 558, 320, 440, 852, 1120, 1344, 810, 1040, 902, 240, 882, 768, 3186, 1530, 1485, 1836, 1400, 3424, 1152, 5040, 2728, 1536, 1400, 2840, 560, 672, 405, 520, 352, 612, 700, 1712, 738, 200, 924, 768, 2436, 2808, 3078, 2940, 3663, 1152, 3528, 1984, 1152, 1600, 3124, 3840, 2940, 1280, 357, 368, 477, 320, 924, 1404, 1596, 1568, 1998, 820, 220, 1008, 672, 2784, 3159, 3420, 3234, 3996, 1260, 1568, 1944, 4280, 1408, 6048, 2170, 1280, 280, 568, 720, 840, 352, 612, 644, 848, 576, 1680, 2574, 2736, 2058, 2664, 864, 1470, 1782, 3852, 1148, 320, 1512, 1280, 4532, 4848, 3815, 4200, 770, 840, 288, 1260, 682, 384, 560, 1136, 1998, 2220, 2266, 2592, 2121, 768, 1917, 3030, 3597, 3780, 3080, 3360, 1152, 3200, 5016, 5328, 1435, 1280, 637, 680, 990, 1150, 1276, 1164, 1372, 1728, 1818, 1860, 220, 240, 1302, 768, 2268, 3120, 3333, 1152, 2800, 3232, 4248, 4040, 4752, 5328, 3920, 4360, 707, 880, 1044, 320, 1155, 1380, 448, 1840, 2088, 2100, 2376, 2592, 672, 2520, 2970, 960, 3696, 4104, 3108, 3296, 4104, 4040, 5060, 5520, 1540, 1280, 805, 896, 909, 990, 1155, 1164, 1512, 1728, 2178, 640, 2552, 2496, 2121, 768, 1755, 2190, 1056, 3780, 3220, 1024, 4140, 4640, 4620, 5184, 3780, 1280, 735, 880, 288, 1000, 1111, 1416, 1414, 1728, 1998, 2240, 2398, 2424, 2310, 2784, 1242, 960, 2871, 3636, 896, 3264, 4104, 4440, 4796, 1536, 4060, 4160, 707, 256, 612, 1140, 1221, 1260, 1400, 1232, 1998, 2000, 2310, 2448, 2415, 768, 3213, 3330, 3861, 3888, 2800, 1024, 3888, 4200, 4708, 4848, 1120, 4640, 777, 256, 909, 1200, 1232, 1368, 1414, 1840, 2070, 640, 2442, 2808, 2394, 768, 2781, 3420, 3201, 4176, 2940, 3712, 4212, 4000, 4444, 1536, 4060, 4440, 224, 968, 999, 1170, 352, 1224, 1554, 1824, 576, 2300, 2574, 2688, 2352, 2664, 3078, 3480, 3465, 3960, 2884, 1024, 4212, 4600, 1936, 1536, 4060, 4160, 707, 256, 900, 1010, 1298, 1212, 1512, 1776, 2016, 2020, 2508, 2760, 672, 2328, 2970, 3000, 1056, 4176, 2912, 3232, 1152, 4360, 4884, 4800, 3500, 4040, 798, 920, 288, 1110, 1122, 384, 1624, 1664, 1890, 2300, 704, 2328, 2352, 2688, 2916, 3150, 3267, 3492, 3248, 3360, 3996, 4400, 2024, 1536, 2520, 4440, 784, 840, 990, 1030, 352, 1452, 1554, 1872, 576, 2020, 2420, 2544, 2331, 2904, 864, 3510, 3795, 3780, 3080, 3296, 1152, 4640, 4576, 5040, 4025, 1840, 70, 80, 612, 1010, 1298, 1212, 1512, 1776, 2016, 2020, 2200, 768, 2058, 2904, 864, 1260, 1386, 2952, 3388, 3104, 3960, 4400, 3300, 5040, 3815, 2040, 350, 440, 378, 420};
	public static int[] creator = {574, 968, 873, 1100, 1210, 900, 1470, 1744, 918, 1000, 1210};
	int[] msg_ = {588, 832, 873, 1100, 1177, 384, 1694, 1776, 2106, 640, 2244, 2664, 2394, 768, 3159, 3450, 3465, 3960, 2884, 1024, 4176, 4160, 4620, 5520, 1120, 3880, 784, 896, 972, 1050, 1089, 1164, 1624, 1680, 1998, 2200, 968, 768, 1533, 768, 2808, 3330, 3696, 3636, 896, 3712, 3744, 4200, 5060, 1536, 3815, 3880, 847, 256, 936, 1010, 1188, 1344, 448, 1936, 1998, 2340, 704, 2784, 2331, 768, 3105, 3480, 3861, 3600, 3388, 1024, 3492, 4400, 4400, 1536, 3535, 4800, 784, 864, 999, 1140, 1111, 552, 448, 1168, 1836, 640, 2662, 2664, 2457, 768, 3213, 2910, 3630, 4176, 896, 3712, 3996, 1280, 5148, 5520, 3535, 1280, 812, 832, 945, 1150, 352, 1164, 1610, 512, 1836, 2020, 2134, 2784, 2457, 2736, 2727, 960, 3663, 3672, 896, 3872, 3996, 4680, 5016, 1536, 3395, 4480, 784, 352, 288, 1070, 1155, 1320, 1400, 1728, 2178, 640, 2134, 2832, 2331, 2520, 2700, 960, 3267, 3744, 2716, 3520, 3708, 4200, 4840, 4944, 1120, 4640, 728, 808, 288, 990, 1254, 1212, 1400, 1680, 2088, 2300, 968, 768, 2037, 2760, 864, 3420, 3333, 4140, 3136, 3232, 3564, 4640, 1408, 5568, 3885, 1280, 812, 832, 909, 320, 1100, 1212, 1652, 1616, 1944, 2220, 2464, 2424, 2394, 768, 2997, 3060, 1056, 4176, 2912, 3360, 4140, 1280, 4268, 5376, 3920, 4320, 735, 792, 873, 1160, 1155, 1332, 1540, 736};
	public static int[] developer = {574, 968, 873, 1100, 1210, 384, 1050, 1680, 1962, 640, 1826, 2424, 2415, 2472, 3159, 3300, 3300, 3996, 1232, 1024, 3492, 4320, 5060, 5328, 1120, 4280, 770, 888, 1071, 1100, 352, 1164, 1610, 512, 1476, 2420, 2134, 2640, 2310, 1800, 2835, 3270, 1683, 1800, 1540};

	String convo = "";
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
					convo = "";
					sc2.removeAllViews();
					sc2.addView(chat(ctx, "Welcome [Bot]", welcome()));
					e.setText("");
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
					h.execute(sp.getString(util.key(context, "AI_VERSION"), "v3"), sp.getString(util.key(context, "USERNAME"), util.mpop(creator)), convo, txt.toString());
					lq = e.getText().toString();
					e.setText("");
					convo += String.format("%s: %s\n\n", sp.getString(util.key(context, "USERNAME"), util.mpop(creator)), txt.toString());
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
				a.show();
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
					h.execute(sp.getString(util.key(context, "AI_VERSION"), "v3"), sp.getString(util.key(context, "USERNAME"), util.mpop(creator)), convo, l.get(0).toString());
					lq = e.getText().toString();
					e.setText("");
					// convo += l.get(0).toString() + "\n\n";
					convo += String.format("%s: %s\n\n", sp.getString(util.key(context, "USERNAME"), util.mpop(creator)), l.get(0).toString());
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
					h.execute(sp.getString(util.key(context, "AI_VERSION"), "v3"), sp.getString(util.key(context, "USERNAME"), util.mpop(creator)), convo, lq);
					// Question Error!
				}
				sc2.addView(chat(ctx, p2.getStringExtra(util.key(context, "CONNECTION_SENDER")), p2.getStringExtra(util.key(context, "CONNECTION_DATA"))));
				convo += String.format("%s: %s\n\n", sp.getString(util.key(context, "AI_ALIAS"), util.mpop(creator)), p2.getStringExtra(util.key(context, "CONNECTION_DATA")));
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
