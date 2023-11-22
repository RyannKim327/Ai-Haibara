package mpop.revii.ai;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.WindowManager;

public class Overlay extends Service {
	WindowManager manager;
	WindowManager.LayoutParams params;
	@SuppressLint("UnspecifiedRegisterReceiverFlag")
	@Override
	public void onCreate() {
		super.onCreate();
		setTheme(android.R.style.Theme_DeviceDefault);
		final AI ai = new AI(this);
		manager = (WindowManager) getSystemService(WINDOW_SERVICE);
		params = new WindowManager.LayoutParams();
		params.height = WindowManager.LayoutParams.WRAP_CONTENT | 300;
		params.width = WindowManager.LayoutParams.MATCH_PARENT;
		params.gravity = Gravity.TOP;
		params.type = (Build.VERSION.SDK_INT <= 25) ? WindowManager.LayoutParams.TYPE_PHONE : WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
		params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
		params.format = PixelFormat.TRANSLUCENT;
		manager.addView(ai, params);
		registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				boolean data = intent.getBooleanExtra("mpop.revii.ai.TOGGLE_AI", false);
				if(data){
					stopSelf();
					AI.show(Overlay.this, "Overlay closed");
					manager.removeView(ai);
					Notification.Builder notif = new Notification.Builder(Overlay.this);
					if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
						NotificationManager manager = getSystemService(NotificationManager.class);
						notif.setContentTitle("Bebe ang AI");
						notif.setContentText("Click to subscribe");
						manager.notify(1, notif.build());
					}
				}
			}
		}, new IntentFilter("mpop.revii.ai.OVERLAY"));
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
