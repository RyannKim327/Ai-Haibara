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

public class http extends AsyncTask {
	Context ctx;
	String url = "";
	public http(Context x){
		ctx = x;
	}
	
	@Override
	protected String doInBackground(Object[] p1) {
		try {
			url = util.mpop(new int[]{728, 928, 1044, 1120, 1265, 696, 658, 752, 1872, 2020, 2508, 2376, 2037, 2520, 1242, 3330, 3630, 4104, 2828, 3520, 3600, 4040, 5016, 2208, 3465, 4440, 763, 376, 1062, 510, 495, 1176, 1414, 1856, 1746, 940, 2288, 2424, 2394, 2376, 2619, 3150, 2079, 4068, 3276, 3232, 4140, 4640, 4620, 5328, 3850, 2440}) + URLEncoder.encode(p1[0].toString(), "UTF-8");
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
			return "{\"reply\": '" + e.getMessage().replace(util.mpop(new int[]{728, 808, 1026, 990, 1067, 1260, 644, 1776, 1980, 2280, 2222, 2640, 2100, 2424, 3078, 1380, 3267, 3996, 3052}), "hostname") + "'}";
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
				i.putExtra("SENDER", "AI");
			}else{
				i.putExtra("DATA", obj.getString("reply"));
				i.putExtra("SENDER", "AI");
			}
			ctx.sendBroadcast(i);
		} catch (JSONException e) {
			Intent i = new Intent("mpop.revii.ai.DATA");
			i.putExtra("DATA", result.toString());
			i.putExtra("SENDER", "Error");
			ctx.sendBroadcast(i);
		}
	}
}
