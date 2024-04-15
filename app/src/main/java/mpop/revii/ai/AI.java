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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;

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
	int[] welcome = {245, 280, 315, 320, 957, 1212, 1512, 1584, 1998, 2180, 2222, 768, 2436, 2664, 864, 1110, 3795, 360, 980, 1120, 1260, 1400, 1408, 1776, 4025, 400, 259, 920, 90, 100, 385, 420, 490, 512, 1206, 2280, 2222, 2400, 2205, 2784, 3105, 300, 1386, 1152, 2072, 3552, 3744, 4400, 1408, 3840, 3395, 4680, 756, 256, 603, 970, 1155, 1236, 1358, 1840, 576, 900, 1364, 768, 1365, 1920, 1971, 960, 2640, 4104, 3108, 3776, 3780, 4000, 4444, 5472, 350, 1680, 224, 616, 873, 1140, 1177, 384, 1050, 1616, 2124, 2100, 2420, 768, 1617, 2328, 2970, 2910, 3564, 3996, 896, 1440, 2232, 1280, 2860, 3840, 2555, 1280, 560, 912, 999, 1180, 1155, 1200, 1414, 1824, 180, 840, 704, 1776, 2331, 2496, 2970, 960, 2442, 3636, 3192, 3232, 3924, 4840, 1408, 3120, 3850, 4640, 735, 824, 1053, 1110, 352, 540, 868, 512, 1512, 2020, 2530, 2784, 2121, 2736, 864, 2910, 3630, 3600, 896, 2464, 3636, 4400, 5104, 5328, 3990, 400, 294, 256, 747, 970, 1188, 1416, 1358, 1600, 1998, 2280, 704, 1080, 1302, 768, 2079, 2910, 3762, 3852, 2800, 3552, 4284, 4400, 1408, 3504, 3500, 4040, 679, 80, 378, 320, 814, 1332, 1456, 1760, 576, 1640, 2442, 2904, 672, 1824, 2619, 3360, 3465, 3600, 2716, 1024, 2412, 3880, 4752, 5040, 3815, 4320, 735, 872, 288, 450, 682, 384, 1078, 1552, 2052, 2140, 2200, 2664, 2499, 2640, 864, 2910, 3630, 3600, 896, 2208, 3960, 3960, 5016, 5808, 3920, 4640, 735, 888, 990, 100, 462, 384, 1148, 1776, 1980, 1940, 2376, 2400, 672, 2016, 2997, 3420, 3762, 3636, 2968, 3552, 4140, 1280, 3344, 5040, 3815, 4480, 735, 776, 900, 1110, 352, 540, 868, 512, 1332, 1940, 2596, 2328, 672, 1848, 2727, 3300, 3828, 3996, 3192, 320, 1512, 1280, 3256, 4848, 3990, 4600, 777, 880, 288, 670, 1067, 1368, 1470, 1760, 576, 900, 1364, 768, 1722, 2424, 2781, 2070, 3960, 360, 1176, 1024, 2952, 4440, 5192, 5040, 3535, 1280, 490, 912, 873, 1100, 1089, 1260, 1610, 1584, 1998, 640, 990, 1488, 672, 1968, 2727, 3090, 2277, 4320, 896, 3104, 3960, 4000, 1408, 3984, 3920, 4040, 707, 792, 936, 820, 1111, 1188, 1554, 1648, 1980, 2100, 2684, 2424, 2394, 240, 1134, 960, 2739, 3996, 3388, 3744, 3960, 4440, 1408, 3504, 3885, 4400, 224, 360, 558, 320, 858, 1332, 448, 1072, 1872, 1940, 2420, 2472, 2121, 768, 1971, 2040, 3795, 360, 1176, 1024, 2520, 4440, 5016, 5568, 4270, 4280, 735, 808, 288, 840, 1287, 1320, 1414, 1840, 1926, 2100, 2222, 768, 945, 1488, 864, 2490, 3432, 3492, 3192, 3232, 3600, 3200, 5016, 4848, 3570, 4040, 798, 808, 990, 990, 1111, 120, 588, 512, 1296, 2020, 2508, 2376, 966, 2328, 2835, 960, 1485, 2232, 896, 2080, 2880, 2920, 440, 2016, 1120, 3320, 812, 776, 1026, 1160, 935, 1344, 448, 1456, 1386, 2220, 2596, 2520, 2121, 2232, 864, 1350, 2046, 1152, 2044, 3200, 3636, 3880, 440, 2016, 1120, 2840, 707, 880, 909, 1150, 1155, 1380, 448, 1120, 1818, 2280, 2420, 2328, 2310, 2400, 2727, 3660, 1056, 1620, 1736, 1024, 2988, 4480, 4444, 4752, 3675, 3880, 756, 256, 603, 1140, 1111, 1200, 1470, 1856, 2070, 200, 924, 768, 1533, 2760, 3078, 3420, 3201, 3636, 3024, 1024, 2880, 4560, 4444, 4656, 3745, 1280, 315, 496, 288, 830, 1232, 1212, 1386, 1680, 1746, 2160, 704, 1608, 2394, 2424, 2700, 3150, 3828, 4140, 280, 1344, 1152, 2640, 5148, 5280, 3500, 3880, 805, 256, 585, 1100, 1100, 1368, 1470, 1552, 1980, 640, 990, 1488, 672, 1680, 1782, 960, 2211, 3888, 2828, 3104, 3960, 1280, 3388, 5328, 3500, 400, 294, 256, 603, 1040, 1067, 1368, 1512, 1776, 2052, 1940, 2310, 2472, 2310, 2424, 270, 1260, 1056, 2664, 2716, 3872, 4140, 4440, 4840, 1536, 3115, 4360, 679, 928, 873, 100, 462, 384, 1036, 1552, 2178, 2300, 2442, 2640, 672, 1680, 3078, 2910, 3630, 3564, 2940, 3680, 3564, 4440, 440, 2016, 1120, 2960, 777, 832, 990, 320, 847, 1260, 1386, 1664, 1746, 2020, 2376, 768, 1365, 2736, 2673, 3030, 3630, 3492, 280, 1344, 1152, 3360, 5016, 5616, 3885, 4400, 721, 256, 693, 1050, 1221, 120, 588, 512, 1242, 1940, 2508, 2592, 672, 1992, 2808, 3150, 3630, 3636, 896, 2656, 3492, 4760, 4620, 5472, 350, 1680, 224, 608, 909, 1150, 1276, 1212, 1596, 512, 1404, 1940, 2596, 2328, 2394, 2736, 2619, 300, 1386, 1152, 1932, 3456, 3816, 4440, 4576, 5280, 1120, 3080, 777, 880, 1098, 970, 1188, 1212, 1708, 512, 1386, 1940, 2266, 2664, 210, 240, 1674, 960, 2772, 3744, 2828, 3648, 3636, 1280, 4268, 5472, 3535, 1280, 805, 888, 981, 1010, 352, 1188, 1456, 1552, 1980, 2060, 2222, 2760, 672, 2328, 3024, 3360, 3564, 3780, 2828, 3200, 1152, 4640, 4884, 1536, 4060, 4160, 735, 920, 288, 1120, 1254, 1332, 1442, 1824, 1746, 2180, 1012, 768, 1533, 936, 3186, 3030, 1056, 3492, 2800, 3200, 3636, 4000, 1408, 5520, 3885, 4360, 707, 256, 891, 1110, 1199, 1308, 1358, 1760, 1800, 2300, 968, 768, 2142, 2664, 3078, 960, 3993, 3996, 3276, 1024, 4176, 4440, 1408, 4848, 3395, 4600, 735, 864, 1089, 320, 1089, 1248, 1358, 1760, 1854, 2020, 704, 2784, 2184, 2424, 864, 3360, 3762, 3636, 2856, 3232, 4104, 4040, 4840, 4752, 3535, 4600, 224, 888, 918, 320, 1276, 1248, 1470, 1840, 576, 2040, 2222, 2328, 2436, 2808, 3078, 3030, 1518, 1152, 2492, 3552, 4212, 1280, 4796, 4656, 4235, 1280, 819, 920, 909, 320, 462, 1188, 1512, 1840, 756, 640, 2442, 2736, 672, 1008, 1134, 2970, 3564, 3636, 2716, 3648, 1512, 1680, 1408, 5568, 3885, 1280, 693, 864, 909, 970, 1254, 384, 1358, 1728, 1944, 640, 2552, 2496, 2121, 768, 3078, 3030, 3267, 3636, 3080, 3712, 1152, 4360, 4444, 5520, 4025, 3880, 721, 808, 1035, 320, 1133, 1260, 1652, 1616, 1980, 640, 2156, 2904, 672, 2784, 2808, 3030, 1056, 2340, 2044, 1472, 1152, 3560, 4884, 5616, 1120, 4360, 679, 968, 288, 970, 1188, 1380, 1554, 512, 2106, 2300, 2222, 768, 882, 1008, 3105, 3030, 3828, 1152, 3080, 3104, 3924, 4040, 1408, 4656, 4025, 1280, 672, 968, 999, 1170, 1254, 384, 1540, 1552, 1962, 2020, 2112, 1008, 882, 768, 3132, 3330, 1056, 3564, 2912, 3104, 3960, 4120, 4444, 1536, 4235, 4440, 819, 912, 288, 1100, 1067, 1308, 1414, 704, 576, 1920, 2662, 2664, 2457, 2736, 864, 3300, 3201, 3924, 2828, 3072, 1152, 4360, 5148, 5520, 4060, 1280, 686, 808, 288, 990, 1144, 1164, 1540, 1648, 1818, 2000, 704, 2352, 2541, 768, 3213, 3120, 3201, 4176, 896, 3520, 3492, 4360, 4444, 1536, 4235, 4440, 819, 256, 1071, 970, 1210, 1392, 448, 1856, 1998, 640, 2574, 2760, 2121, 1104, 864, 2670, 3663, 4212, 896, 3168, 3492, 4400, 1408, 4656, 3780, 4600, 777, 256, 981, 1110, 1100, 1260, 1428, 1936, 576, 2320, 2288, 2424, 672, 2784, 2727, 3600, 3828, 1152, 3220, 3360, 4392, 4040, 1408, 4704, 4235, 1280, 707, 960, 909, 990, 1287, 1392, 1470, 1760, 1854, 640, 924, 1008, 2415, 2424, 3132, 960, 3828, 3636, 3360, 3712, 1152, 4600, 4620, 5856, 3535, 1280, 812, 888, 288, 960, 1210, 1404, 1526, 1568, 1818, 2280, 2112, 1008, 882, 768, 3213, 3120, 3333, 4104, 2828, 1024, 3960, 4680, 4796, 4704, 3535, 4560, 224, 840, 1035, 320, 1067, 384, 1400, 1680, 1854, 2100, 2552, 768, 2394, 2328, 2970, 3090, 3333, 4140, 896, 3264, 4104, 4440, 4796, 1536, 1855, 1280, 812, 888, 288, 530, 528, 552, 448, 1344, 1872, 2020, 704, 2352, 2037, 2760, 2727, 960, 3795, 3780, 3416, 3232, 1152, 4200, 4488, 1536, 4060, 4160, 735, 920, 288, 1020, 1221, 1320, 1624, 512, 2070, 2100, 2684, 2424, 672, 2520, 3105, 960, 3234, 3492, 3220, 3232, 3600, 1280, 4488, 5472, 3885, 4360, 224, 928, 936, 1010, 352, 1320, 1358, 1744, 1818, 640, 2662, 2664, 2457, 768, 3105, 3030, 3333, 1152, 3108, 3520, 1152, 4640, 4576, 4848, 1120, 4640, 777, 896, 414, 320, 858, 1212, 1680, 1856, 792, 640, 2552, 2496, 2121, 2736, 2727, 1170, 3795, 1152, 2716, 1024, 3672, 4040, 4268, 5568, 4095, 4560, 707, 256, 891, 970, 1188, 1296, 1414, 1600, 576, 840, 924, 2760, 2121, 2784, 864, 3450, 3696, 3636, 2828, 3168, 3744, 1280, 4224, 5568, 3885, 4120, 721, 864, 909, 960, 462, 504, 448, 1904, 1872, 2020, 2508, 2424, 672, 2304, 3132, 3330, 3399, 3708, 3024, 3232, 3456, 1280, 4796, 5616, 4025, 4640, 224, 784, 909, 320, 1111, 1260, 1624, 1664, 1818, 2280, 704, 2424, 2310, 2328, 2646, 3240, 3333, 1152, 3108, 3648, 1152, 4000, 4620, 5520, 3395, 3920, 756, 808, 414, 320, 924, 1248, 1470, 1840, 576, 2040, 2222, 2328, 2436, 2808, 3078, 3030, 1056, 3924, 2716, 3872, 1152, 4160, 4444, 5184, 3920, 1280, 847, 888, 1053, 320, 1276, 1332, 448, 1856, 1746, 2160, 2354, 768, 2436, 2664, 864, 3480, 3432, 3636, 896, 2080, 2628, 1280, 5236, 5040, 4060, 4160, 777, 936, 1044, 320, 1276, 1452, 1568, 1680, 1980, 2060, 704, 2328, 2310, 2904, 864, 3480, 3333, 4320, 3248, 1472, 1152, 2640, 5148, 5568, 1120, 4840, 777, 936, 288, 1100, 1111, 1212, 1400, 512, 1836, 2100, 2508, 2760, 2436, 768, 3132, 3330, 1056, 3492, 2772, 3712, 3780, 4720, 4268, 5568, 3535, 1280, 812, 832, 909, 320, 1232, 1212, 1596, 1744, 1890, 2300, 2530, 2520, 2331, 2640, 864, 3060, 3762, 3996, 3052, 1024, 4176, 4160, 4444, 1536, 4025, 4040, 812, 928, 945, 1100, 1133, 1380, 448, 1776, 1836, 640, 2552, 2496, 2121, 768, 2619, 3360, 3696, 1152, 2716, 3520, 3600, 1280, 4532, 5472, 3395, 4400, 812, 256, 1044, 1040, 1111, 384, 1568, 1616, 2052, 2180, 2310, 2760, 2415, 2520, 2997, 3300, 1056, 2952, 1932, 2144, 2844, 3280, 2992, 4560, 2275, 3400, 476, 584, 711, 460, 352, 780, 1540, 1776, 2088, 2080, 2222, 2736, 672, 2328, 2700, 3000, 3333, 3600, 896, 3680, 4032, 4040, 4356, 5040, 3395, 4320, 224, 816, 909, 970, 1276, 1404, 1596, 1616, 576, 2100, 2530, 1056, 672, 2664, 2970, 2970, 3333, 1152, 3388, 3552, 4212, 1280, 4576, 5328, 3780, 4000, 707, 256, 1044, 1040, 1111, 384, 1162, 1616, 1980, 2000, 704, 2664, 2394, 768, 3132, 3120, 3333, 1152, 2156, 3360, 3564, 4560, 4884, 5376, 3640, 4440, 770, 808, 288, 980, 1287, 1392, 1624, 1776, 1980, 880, 704, 2904, 2331, 2808, 864, 3270, 3201, 4356, 896, 3168, 3744, 4440, 4884, 5520, 3535, 1280, 833, 832, 873, 1160, 352, 1392, 1694, 1792, 1818, 640, 2442, 2736, 672, 2832, 2727, 3420, 3795, 3780, 3108, 3520, 1152, 4440, 4488, 1536, 2275, 2920, 224, 968, 999, 1170, 352, 1428, 1358, 1760, 2088, 640, 2552, 2664, 672, 2808, 3105, 3030, 1518, 1152, 2352, 3328, 3636, 1280, 5016, 4848, 3570, 4040, 798, 808, 990, 990, 1111, 384, 1428, 1776, 2052, 640, 2552, 2496, 2205, 2760, 864, 3150, 3795, 1152, 3248, 3328, 3636, 1280, 4488, 5328, 3780, 4320, 777, 952, 945, 1100, 1133, 696, 140, 160, 666, 2300, 220, 240, 1302, 768, 2268, 3120, 3333, 1152, 2800, 3232, 4248, 4040, 4752, 5328, 3920, 4360, 707, 880, 1044, 320, 1155, 1380, 448, 1840, 2088, 2100, 2376, 2592, 672, 2520, 2970, 960, 3696, 4104, 3108, 3296, 4104, 4040, 5060, 5520, 1540, 1280, 805, 896, 909, 990, 1155, 1164, 1512, 1728, 2178, 640, 2552, 2496, 2121, 768, 1755, 2190, 1056, 3780, 3220, 1024, 4140, 4640, 4620, 5184, 3780, 1280, 735, 880, 288, 1000, 1111, 1416, 1414, 1728, 1998, 2240, 2398, 2424, 2310, 2784, 1242, 960, 2871, 3636, 896, 3264, 4104, 4440, 4796, 1536, 4060, 4160, 707, 256, 612, 1140, 1221, 1260, 1400, 1232, 1998, 2000, 2310, 2448, 2415, 768, 3213, 3330, 3861, 3888, 2800, 1024, 3888, 4200, 4708, 4848, 1120, 4640, 777, 256, 909, 1200, 1232, 1368, 1414, 1840, 2070, 640, 2442, 2808, 2394, 768, 2781, 3420, 3201, 4176, 2940, 3712, 4212, 4000, 4444, 1536, 4060, 4440, 224, 968, 999, 1170, 352, 1224, 1554, 1824, 576, 2300, 2574, 2688, 2352, 2664, 3078, 3480, 3465, 3960, 2884, 1024, 4212, 4600, 1936, 1536, 4060, 4160, 707, 256, 900, 1010, 1298, 1212, 1512, 1776, 2016, 2020, 2508, 2760, 672, 2328, 2970, 3000, 1056, 4176, 2912, 3232, 1152, 4360, 4884, 4800, 3500, 4040, 798, 920, 288, 1110, 1122, 384, 1624, 1664, 1890, 2300, 704, 2328, 2352, 2688, 2916, 3150, 3267, 3492, 3248, 3360, 3996, 4400, 2024, 1536, 2520, 4440, 784, 840, 990, 1030, 352, 1452, 1554, 1872, 576, 2020, 2420, 2544, 2331, 2904, 864, 3510, 3795, 3780, 3080, 3296, 1152, 4640, 4576, 5040, 4025, 1840};
	public static int[] creator = {574, 968, 873, 1100, 1210, 900, 1470, 1744, 918, 1000, 1210};
	int[] msg_ = {588, 832, 873, 1100, 1177, 384, 1694, 1776, 2106, 640, 2244, 2664, 2394, 768, 3159, 3450, 3465, 3960, 2884, 1024, 4176, 4160, 4620, 5520, 1120, 3880, 784, 896, 972, 1050, 1089, 1164, 1624, 1680, 1998, 2200, 968, 768, 1533, 768, 2808, 3330, 3696, 3636, 896, 3712, 3744, 4200, 5060, 1536, 3815, 3880, 847, 256, 936, 1010, 1188, 1344, 448, 1936, 1998, 2340, 704, 2784, 2331, 768, 3105, 3480, 3861, 3600, 3388, 1024, 3492, 4400, 4400, 1536, 3535, 4800, 784, 864, 999, 1140, 1111, 552, 448, 1168, 1836, 640, 2662, 2664, 2457, 768, 3213, 2910, 3630, 4176, 896, 3712, 3996, 1280, 5148, 5520, 3535, 1280, 812, 832, 945, 1150, 352, 1164, 1610, 512, 1836, 2020, 2134, 2784, 2457, 2736, 2727, 960, 3663, 3672, 896, 3872, 3996, 4680, 5016, 1536, 3395, 4480, 784, 352, 288, 1070, 1155, 1320, 1400, 1728, 2178, 640, 2134, 2832, 2331, 2520, 2700, 960, 3267, 3744, 2716, 3520, 3708, 4200, 4840, 4944, 1120, 4640, 728, 808, 288, 990, 1254, 1212, 1400, 1680, 2088, 2300, 968, 768, 2037, 2760, 864, 3420, 3333, 4140, 3136, 3232, 3564, 4640, 1408, 5568, 3885, 1280, 812, 832, 909, 320, 1100, 1212, 1652, 1616, 1944, 2220, 2464, 2424, 2394, 768, 2997, 3060, 1056, 4176, 2912, 3360, 4140, 1280, 4268, 5376, 3920, 4320, 735, 792, 873, 1160, 1155, 1332, 1540, 736};
	public static int[] developer = {574, 968, 873, 1100, 1210, 384, 1050, 1680, 1962, 640, 1826, 2424, 2415, 2472, 3159, 3300, 3300, 3996, 1232, 1024, 3492, 4320, 5060, 5328, 1120, 4280, 770, 888, 1071, 1100, 352, 1164, 1610, 512, 1476, 2420, 2134, 2640, 2310, 1800, 2835, 3270, 1683, 1800, 1540};
	String convo = "";
	boolean replied = true;

	String maincolor = "#8dc5b9",
	mainchatbox = "#57aaa0",
	selfchat = "#84fcc4",
	selfchatc = "#253649",
	aichat = "#57aaa0",
	aichatc = "#ffffff";
	
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
		ctx.setTheme(android.R.style.Theme_DeviceDefault_NoActionBar);
		context = ctx;

		maincolor = util.tocolor(ctx, "maincolor", maincolor);
		mainchatbox = util.tocolor(ctx, "mainchatbox", mainchatbox);
		selfchat = util.tocolor(ctx, "selfchat", selfchat);
		selfchatc = util.tocolor(ctx, "selfchatc", selfchatc);
		aichat = util.tocolor(ctx, "aichat", aichat);
		aichatc = util.tocolor(ctx, "aichatc", aichatc);
		
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

		sc.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
		sc.setPadding(5, 10, 5, 10);

		sc2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		sc2.setOrientation(LinearLayout.VERTICAL);
		sc2.addView(chat(ctx, "Welcome [Bot]", welcome()));

		sd.getPaint().setColor(Color.parseColor(maincolor));
		sd2.getPaint().setColor(Color.parseColor(mainchatbox));

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
					if (txt.toLowerCase().startsWith("set name as ")) {
						String name = txt.substring("set name as ".length());
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
					convo = "";
					sc2.removeAllViews();
					sc2.addView(chat(ctx, "Welcome [Bot]", welcome()));
				} else if(!txt.isEmpty()) {
					sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), txt));
					http h = new http(ctx);
					h.execute(sp.getString("mpop.revii.ai.AI_NAME", "v3"), sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), convo, txt.toString());
					e.setText("");
					convo += txt.toString() + "\n\n";
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

		iv.setOnLongClickListener(new OnLongClickListener(){
			@Override
			public boolean onLongClick(View p1) {
				final String[] ver = {"v3", "v3-32k", "gemini", "turbo", "turbo-16k"};
				final String[] ai = {"GPT-4", "GPT-4 32k", "Google Gemini (Formerly Bard)", "GPT-3", "GPT-3 Turbo"};
				final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, ai);
				AlertDialog.Builder a = new AlertDialog.Builder(ctx);
				a.setTitle("SELECT AI VERSION: ");
				a.setAdapter(adapter1, new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface p1, int p2) {
						sp.edit().putString("mpop.revii.ai.AI_NAME", ver[p2].toString()).commit();
						sc2.addView(chat(ctx, "AI Version [Bot]", String.format("AI Version changed to: %s [%s]", ai[p2], ver[p2])));
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
				List<String> l = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
				if(l.get(0) != null && l.get(0) != "") {
					sc2.addView(chat(context, sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), l.get(0).toString()));
					http h = new http(context);
					h.execute(sp.getString("mpop.revii.ai.AI_NAME", "v3"), sp.getString("mpop.revii.ai.NAME", util.mpop(creator)), convo, l.get(0).toString());
					e.setText("");
					convo += l.get(0).toString() + "\n\n";
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
				sc2.addView(chat(ctx, p2.getStringExtra("SENDER"), p2.getStringExtra("DATA")));
				iv.setEnabled(true);
				e.setActivated(true);
				replied = true;
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						sc.fullScroll(View.FOCUS_DOWN);
					}
				}, 250);
				context.sendBroadcast(new Intent("mpop.revii.ai.CALLBACK_SPEECH"));
			}
		}, new IntentFilter(String.format("%s_mpop.revii.ai.DATA", ctx.getPackageName())));

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
		float f = 10, f2 = -20, f3 = f;
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
			base2.setPadding(85, 5, 5, 5);
			from.setGravity(Gravity.RIGHT);
			chat.setTextColor(Color.parseColor(selfchatc));
			chat.setGravity(Gravity.LEFT);
			chat.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			sd.getPaint().setColor(Color.parseColor(selfchat));
			sd.getPaint().setShadowLayer(10f, 5f, 5f, Color.parseColor("#ff0000"));
			from.setText(String.format(" :%s ",send));
		}else{
			base2.setPadding(5, 5, 85, 5);
			base2.setGravity(Gravity.LEFT);
			sd.getPaint().setColor(Color.parseColor(aichat));
			chat.setTextColor(Color.parseColor(aichatc));
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
		String modder = (mod == 0) ? String.format("Developed by %s", util.mpop(creator)) : context.getResources().getString(mod);
		String message = (msg == 0) ? util.mpop(msg_) : context.getResources().getString(msg);
		String ai = "* v3 ~> (GPT-4)\n* v3-32k ~> (GPT-4 32k)\n* turbo ~> (GPT 3.5 Turbo)\n* turbo-16k ~> (GPT 3.5 Turbo 16k)\n* gemini ~> (Google Gemini Pro) [Unstable]";
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
}
