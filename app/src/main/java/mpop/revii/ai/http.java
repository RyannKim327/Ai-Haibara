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
			url = "https://hercai.onrender.com/v3-beta/hercai?question=";
			String q = url + URLEncoder.encode(p1[0].toString(), "UTF-8");
			URL u = new URL(q);
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
			return "{\"reply\": '" + e.getMessage().replace("\"hercai.onrender.com\"", "hostname") + "'}";
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
			i.putExtra("DATA", obj.getString("reply"));
			ctx.sendBroadcast(i);
		} catch (JSONException e) {
			Intent i = new Intent("mpop.revii.ai.DATA");
			i.putExtra("DATA", result.toString());
			ctx.sendBroadcast(i);
		}
	}
}
