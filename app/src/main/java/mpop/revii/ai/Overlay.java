package mpop.revii.ai;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Overlay extends Service {
	WindowManager managerImg, manager;
	WindowManager.LayoutParams paramsImg, params;
	ImageView img;
	AI ai;
	boolean show = false;
	int posX = 0, posY = 0;

	@Override
	public void onCreate() {
		super.onCreate();
		setTheme(android.R.style.Theme_DeviceDefault);

		ai = new AI(this);
		img = new ImageView(this);

		manager = (WindowManager) getSystemService(WINDOW_SERVICE);
		params = new WindowManager.LayoutParams();

		managerImg = (WindowManager) getSystemService(WINDOW_SERVICE);
		paramsImg = new WindowManager.LayoutParams();

		head();
	}
	@SuppressLint("UnspecifiedRegisterReceiverFlag")
	void showUI(){

		params.height = manager.getDefaultDisplay().getHeight() - 150;
		params.width = WindowManager.LayoutParams.MATCH_PARENT;
		params.gravity = Gravity.BOTTOM;
		params.type = (Build.VERSION.SDK_INT <= 25) ? WindowManager.LayoutParams.TYPE_PHONE : WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
		params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		params.format = PixelFormat.TRANSLUCENT;

		ai.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.8f));

		manager.addView(ai, params);
	}

	@SuppressLint("ClickableViewAccessibility")
	void head(){
		paramsImg.height = 100;
		paramsImg.width = 100;
		paramsImg.type = (Build.VERSION.SDK_INT <= 25) ? WindowManager.LayoutParams.TYPE_PHONE : WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
		paramsImg.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		paramsImg.format = PixelFormat.TRANSLUCENT;

		paramsImg.gravity = Gravity.TOP | Gravity.START;

		paramsImg.x = 0;
		paramsImg.y = 0;
		managerImg.addView(img, paramsImg);

		img.setImageResource(AI.setResources(this, "ic_launcher", "drawable"));

		img.setOnTouchListener(new View.OnTouchListener() {
			private int x, y;
			private float X, Y;

			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
					case MotionEvent.ACTION_DOWN:
					case MotionEvent.ACTION_UP:
						x = paramsImg.x;
						y = paramsImg.y;
						X = motionEvent.getRawX();
						Y = motionEvent.getRawY();
						return true;
					case MotionEvent.ACTION_MOVE:
						// x = params.x;
						// y = params.y;
						// X = motionEvent.getRawX();
						// Y = motionEvent.getRawY();
						final boolean moved = paramsImg.x != Math.round(x + (motionEvent.getRawX() - X)) || paramsImg.y != Math.round(y + (motionEvent.getRawY() - Y));
						paramsImg.x = Math.round(x + (motionEvent.getRawX() - X));
						paramsImg.y = Math.round(y + (motionEvent.getRawY() - Y));
						managerImg.updateViewLayout(img, paramsImg);
						new Handler().postDelayed(new Runnable() {
							@Override
							public void run() {
								if (!moved) {
									if (!show) {
										posX = paramsImg.x;
										posY = paramsImg.y;
										paramsImg.x = 0;
										paramsImg.y = 0;
										managerImg.updateViewLayout(img, paramsImg);
										showUI();
									} else {
										paramsImg.x = posX;
										paramsImg.y = posX;
										manager.removeView(ai);
										managerImg.updateViewLayout(img, paramsImg);
									}
									show = !show;
								}
							}
						}, 100);
						return true;
				}
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
