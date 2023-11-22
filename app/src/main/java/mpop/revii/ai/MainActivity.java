package mpop.revii.ai;
 
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;

public class MainActivity extends Activity { 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getActionBar().setIcon(AI.setResources(this, "ic_launcher", "drawable"));
		getActionBar().setTitle("Bebe ang AI");
		getActionBar().setSubtitle("Developed by RyannKim327");
		setContentView(R.layout.activity_main);
		NotificationChannel notip = new NotificationChannel("mpop.revii.notif", "MPOP AI", NotificationManager.IMPORTANCE_DEFAULT);
		
	}
}
