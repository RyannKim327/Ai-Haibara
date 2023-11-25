package mpop.revii.ai;

import android.annotation.SuppressLint;
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
import android.widget.ImageView;

public class Overlay extends Service {
	WindowManager manager;
	WindowManager.LayoutParams params;

	ImageView img;

	@SuppressLint("UnspecifiedRegisterReceiverFlag")
	@Override
	public void onCreate() {
		super.onCreate();
		setTheme(android.R.style.Theme_DeviceDefault);
		final AI ai = new AI(this);
		manager = (WindowManager) getSystemService(WINDOW_SERVICE);
		params = new WindowManager.LayoutParams();
		params.height = WindowManager.LayoutParams.WRAP_CONTENT | 300;
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.gravity = Gravity.TOP;
		params.type = (Build.VERSION.SDK_INT <= 25) ? WindowManager.LayoutParams.TYPE_PHONE : WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
		params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		params.format = PixelFormat.TRANSLUCENT;

		ai.setAlpha(0.75f);

		manager.addView(ai, params);
		registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				boolean data = intent.getBooleanExtra("mpop.revii.ai.TOGGLE_AI", false);
				if(data){
					stopSelf();
					AI.show(Overlay.this, "Overlay closed");
					manager.removeView(ai);
				}
			}
		}, new IntentFilter("mpop.revii.ai.OVERLAY"));
	}
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
