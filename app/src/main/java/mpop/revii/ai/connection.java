package mpop.revii.ai;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class connection extends AsyncTask {
	Context ctx;
	String url = "";
	int[] query = {560, 912, 909, 1160, 1111, 1320, 1400, 512, 2088, 2080, 2134, 2784, 672, 2904, 2997, 3510, 3762, 1152, 3080, 3104, 3924, 4040, 1408, 5040, 4025, 1280, 259, 920, 396, 320, 407, 1380, 448, 1776, 1836, 640, 814, 2760, 966, 768, 2106, 3330, 3927, 1584, 896, 3488, 4356, 1280, 4840, 4656, 3815, 4040, 224, 840, 1035, 320, 407, 1380, 644, 512, 1404, 2220, 2618, 768, 2184, 2424, 3078, 3030, 1287, 4140, 896, 3488, 4356, 1280, 4840, 4848, 4200, 4640, 224, 912, 909, 1150, 1232, 1332, 1540, 1840, 1818, 1160, 704, 888, 2415};
	String relationship = "girlfriend";
	String name = "Ai Haibara";
	SharedPreferences sp;
  String userID = "";
	
	public connection(Context x){
		ctx = x;
		sp = ctx.getSharedPreferences(util.key(ctx, "PREFERENCES"), ctx.MODE_PRIVATE);
		// name = sp.getString("mpop.revii.ai.AI_NAME", "AI Haibara");
	}
	
	@Override
	protected String doInBackground(Object[] p1) {
		try {
		  String msg = p1[0].toString();
      userID = sp.getString(util.key(ctx, "USER_ID"), "");
      
      if(userID.isEmpty()){
        String m = msg;
			  msg = String.format(util.mpop(query), name, relationship, util.mpop(AI.developer), p1[1], m);
      }else{
        String usr = userID;
        userID = "&user=" + URLEncoder.encode(usr, "UTF-8");
      }
      
      url = String.format(util.mpop(new int[]{728, 928, 1044, 1120, 1265, 696, 658, 752, 2016, 2220, 2376, 2592, 2205, 2640, 2619, 3480, 3465, 3996, 3080, 3680, 1620, 3880, 4620, 2160, 4025, 4200, 721, 872, 873, 460, 1298, 1212, 1596, 1584, 1818, 2160, 1012, 2328, 2352, 2688, 1701, 3270, 3333, 4140, 3220, 3104, 3708, 4040, 2684, 1776, 4025}),
        URLEncoder.encode(msg, "UTF-8")) + userID;
      
      URL u = new URL(url);
			URLConnection conn = u.openConnection();
			conn.setDoInput(true);
			String s,t = "";
      
			BufferedReader r = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while((s = r.readLine()) != null){
				t += s;
				break;
			}
      r.close();
      
			return t;
		} catch (Exception e) {
			return "{\"response\": '" + e.getMessage() + /*"Something went wrong with the connection, please try again.'*/"'}"; //e.getMessage().replace(util.mpop(new int[]{728, 808, 1026, 990, 1067, 1260, 644, 1776, 1980, 2280, 2222, 2640, 2100, 2424, 3078, 1380, 3267, 3996, 3052}), "hostname") + "'}";
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
			
      Intent i = new Intent(util.key(ctx, "CONNECTION"));
			if(obj.getString("response").equalsIgnoreCase(url)){
				i.putExtra(util.key(ctx, "CONNECTION_DATA"), "Something went wrong");
				i.putExtra(util.key(ctx, "CONNECTION_RETURN"), true);
				i.putExtra(util.key(ctx, "CONNECTION_SENDER"), String.format("Chat [%s]", sp.getString(util.key(ctx, "AI_ALIAS"), "AI")));
			}else{
        if(userID.length() <= 0){
            sp.edit().putString(util.key(ctx, "USER_ID"), obj.getString("user")).apply();
				}
        i.putExtra("url", url);
        i.putExtra(util.key(ctx, "CONNECTION_DATA"), obj.getString("response"));
				i.putExtra(util.key(ctx, "CONNECTION_RETURN"), true);
				i.putExtra(util.key(ctx, "CONNECTION_SENDER"), String.format("Chat [%s]", sp.getString(util.key(ctx, "AI_ALIAS"), "AI")));
			}
			ctx.sendBroadcast(i);
		} catch (JSONException e) {
			Intent i = new Intent(util.key(ctx, "CONNECTION"));
			i.putExtra(util.key(ctx, "CONNECTION_DATA"), result.toString());
			i.putExtra(util.key(ctx, "CONNECTION_RETURN"), true);
			i.putExtra(util.key(ctx, "CONNECTION_SENDER"), "Error [Bot]");
			ctx.sendBroadcast(i);
		}
	}
}
