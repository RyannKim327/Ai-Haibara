package mpop.revii.ai;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.WindowManager;

public class Overlay extends Service {
	WindowManager manager;
	WindowManager.LayoutParams;
	@Override
	public void onCreate() {
		super.onCreate();
		setTheme(android.R.style.Theme_DeviceDefault);
		AI ai = new AI();
		manager.addView();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
