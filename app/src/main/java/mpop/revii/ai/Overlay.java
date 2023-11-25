package mpop.revii.ai;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Overlay extends Service {
	WindowManager manager;
	WindowManager.LayoutParams params;
	ImageView img;
	AI ai;
	LinearLayout layout;
	boolean show = false;
	int posX = 0, posY = 0;

	@Override
	public void onCreate() {
		super.onCreate();
		setTheme(android.R.style.Theme_DeviceDefault);

		layout = new LinearLayout(this);
		ai = new AI(this);
		img = new ImageView(this);

		manager = (WindowManager) getSystemService(WINDOW_SERVICE);
		params = new WindowManager.LayoutParams();

		head();
	}
	@SuppressLint("UnspecifiedRegisterReceiverFlag")
	void showUI(){

		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.gravity = Gravity.TOP;
		params.type = (Build.VERSION.SDK_INT <= 25) ? WindowManager.LayoutParams.TYPE_PHONE : WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
		params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		params.format = PixelFormat.TRANSLUCENT;

		ai.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.8f));

		manager.addView(ai, params);
	}

	@SuppressLint("ClickableViewAccessibility")
	void head(){
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.type = (Build.VERSION.SDK_INT <= 25) ? WindowManager.LayoutParams.TYPE_PHONE : WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
		params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		params.format = PixelFormat.TRANSLUCENT;

		params.gravity = Gravity.TOP | Gravity.START;

		params.x = 0;
		params.y = 0;
		manager.addView(layout, params);

		img.setLayoutParams(new LinearLayout.LayoutParams(75, 75));
		img.setImageResource(AI.setResources(this, "ic_launcher", "drawable"));

		img.setOnTouchListener(new View.OnTouchListener() {
			private int x, y;
			private float X, Y;

			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				switch (motionEvent.getAction()) {
					case MotionEvent.ACTION_DOWN:
					case MotionEvent.ACTION_UP:
						x = params.x;
						y = params.y;
						X = motionEvent.getRawX();
						Y = motionEvent.getRawY();
						return true;
					case MotionEvent.ACTION_MOVE:
						// x = params.x;
						// y = params.y;
						// X = motionEvent.getRawX();
						// Y = motionEvent.getRawY();

						if(params.x == Math.round(x + (motionEvent.getRawX() - X)) && params.y == Math.round(y + (motionEvent.getRawY() - Y))){
							if(!show) {
								posX = params.x;
								posY = params.y;
								params.x = 0;
								params.y = 0;
								manager.updateViewLayout(img, params);
								showUI();
							}else{
								params.x = posX;
								params.y = posX;
								layout.removeView(ai);
							}
							show = !show;
						}else{
							params.x = Math.round(x + (motionEvent.getRawX() - X));
							params.y = Math.round(y + (motionEvent.getRawY() - Y));
							manager.updateViewLayout(img, params);
						}
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
