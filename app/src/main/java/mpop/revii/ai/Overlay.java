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
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Overlay extends Service {
	WindowManager manager;
	WindowManager.LayoutParams params;
	ImageView img;
	AI ai;

	@Override
	public void onCreate() {
		super.onCreate();
		setTheme(android.R.style.Theme_DeviceDefault);

		ai = new AI(this);
		img = new ImageView(this);

		manager = (WindowManager) getSystemService(WINDOW_SERVICE);
		params = new WindowManager.LayoutParams();

		head();
	}
	@SuppressLint("UnspecifiedRegisterReceiverFlag")
	void showUI(){
		ai.setAlpha(0.75f);

		params.height = WindowManager.LayoutParams.WRAP_CONTENT | 300;
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.gravity = Gravity.TOP;
		params.type = (Build.VERSION.SDK_INT <= 25) ? WindowManager.LayoutParams.TYPE_PHONE : WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
		params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		params.format = PixelFormat.TRANSLUCENT;

		registerReceiver(new BroadcastReceiver() {
			@SuppressLint("UnspecifiedRegisterReceiverFlag")
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
		manager.addView(ai, params);
	}

	@SuppressLint("ClickableViewAccessibility")
	void head(){
		params.height = 50;
		params.width = 50;
		params.type = (Build.VERSION.SDK_INT <= 25) ? WindowManager.LayoutParams.TYPE_PHONE : WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
		params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		params.format = PixelFormat.TRANSLUCENT;

		params.gravity = Gravity.TOP | Gravity.START;

		params.x = 0;
		params.y = 0;


		img.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return false;
			}
		});
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
