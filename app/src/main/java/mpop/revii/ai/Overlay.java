package mpop.revii.ai;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.WindowManager;

public class Overlay extends Service {
	WindowManager manager;
	WindowManager.LayoutParams params;
	@Override
	public void onCreate() {
		super.onCreate();
		setTheme(android.R.style.Theme_DeviceDefault);
		AI ai = new AI(this);
		manager = (WindowManager) getSystemService(WINDOW_SERVICE);
		params = new WindowManager.LayoutParams();
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
		params.width = WindowManager.LayoutParams.MATCH_PARENT;
		params.gravity = Gravity.CENTER;
		params.type = (Build.VERSION.SDK_INT <= 25) ? WindowManager.LayoutParams.TYPE_PHONE : WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
		manager.addView(ai, params);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
