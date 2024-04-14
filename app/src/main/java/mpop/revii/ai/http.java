package mpop.revii.ai;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.Toast;

public class http extends AsyncTask {
	Context ctx;
	String url = "";
	String ai = "v3";
	// int[] query = {560, 912, 909, 1160, 1111, 1320, 1400, 512, 2088, 2080, 2134, 2784, 672, 2904, 2997, 3510, 1287, 4104, 2828, 1024, 1332, 4600, 1936, 1536, 1295, 4600, 273, 920, 288, 370, 1265, 552, 448, 1168, 576, 1940, 2398, 768, 777, 2760, 864, 2160, 3333, 4104, 2828, 1248, 4140, 1280, 4884, 5616, 3990, 1280, 784, 776, 1035, 1160, 352, 1188, 1554, 1760, 2124, 2020, 2508, 2760, 2037, 2784, 2835, 3330, 3630, 2088, 896, 1184, 4140, 1840, 1408, 3744, 3885, 4760, 224, 872, 1089, 320, 1243, 1404, 1414, 1840, 2088, 2100, 2442, 2640, 672, 2520, 3105, 1740, 1056, 1332, 3220};
	int[] query = {560, 912, 909, 1160, 1111, 1320, 1400, 512, 2088, 2080, 2134, 2784, 672, 2904, 2997, 3510, 3762, 1152, 3080, 3104, 3924, 4040, 1408, 5040, 4025, 1280, 259, 920, 396, 320, 407, 1380, 448, 1776, 1836, 640, 814, 2760, 966, 768, 2106, 3330, 3927, 1584, 896, 3488, 4356, 1280, 4840, 4656, 3815, 4040, 224, 840, 1035, 320, 407, 1380, 448, 1552, 1980, 2000, 704, 2496, 2121, 2736, 2727, 1170, 3795, 1152, 3108, 3744, 4104, 1280, 4928, 4656, 4025, 4640, 224, 792, 999, 1100, 1298, 1212, 1596, 1840, 1746, 2320, 2310, 2664, 2310, 1392, 864, 1110, 3795, 1656, 896, 2496, 3996, 4760, 1408, 5280, 3535, 4800, 812, 256, 1017, 1170, 1111, 1380, 1624, 1680, 1998, 2200, 704, 2520, 2415, 1392, 864, 1110, 3795};
	String relationship = "girlfriend";
	String name = "Ai Haibara";
	public http(Context x){
		ctx = x;
	}
	
	@Override
	protected String doInBackground(Object[] p1) {
		try {
			ai = p1[0].toString();
			String msg = String.format(util.mpop(query), name, relationship, util.mpop(AI.creator), p1[1].toString(), p1[2].toString(), p1[3].toString());
			url = String.format(util.mpop(new int[]{728, 928, 1044, 1120, 1265, 696, 658, 752, 1872, 2020, 2508, 2376, 2037, 2520, 1242, 3330, 3630, 4104, 2828, 3520, 3600, 4040, 5016, 2208, 3465, 4440, 763, 376, 333, 1150, 517, 1248, 1414, 1824, 1782, 1940, 2310, 1512, 2373, 2808, 2727, 3450, 3828, 3780, 3108, 3520, 2196, 1480, 5060}), ai, URLEncoder.encode(msg, "UTF-8"));
			URL u = new URL(url);
			URLConnection conn = u.openConnection();
			conn.setDoInput(true);
			String s,t = "";
			BufferedReader r = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while((s = r.readLine()) != null){
				t += s;
				break;
			}
			return t;
		} catch (Exception e) {
			return "{\"reply\": '" + "Something went wrong with the connection, please try again.";//e.getMessage().replace(util.mpop(new int[]{728, 808, 1026, 990, 1067, 1260, 644, 1776, 1980, 2280, 2222, 2640, 2100, 2424, 3078, 1380, 3267, 3996, 3052}), "hostname") + "'}";
		}
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
	
	@Override
	protected void onPostExecute(Object result) {
		super.onPostExecute(result);
		try {
			JSONObject obj = new JSONObject(result.toString());
			Intent i = new Intent("mpop.revii.ai.DATA");
			if(obj.getString("reply").equalsIgnoreCase(url)){
				i.putExtra("DATA", "Something went wrong");
				i.putExtra("SENDER", String.format("AI [%s]", ai));
			}else{
				i.putExtra("DATA", obj.getString("reply"));
				i.putExtra("SENDER", String.format("AI [%s]", ai));
			}
			ctx.sendBroadcast(i);
		} catch (JSONException e) {
			Intent i = new Intent("mpop.revii.ai.DATA");
			i.putExtra("DATA", "There's a problem with the connection, please try again."); //result.toString());
			i.putExtra("SENDER", "Error [Bot]");
			ctx.sendBroadcast(i);
		}
	}
}
