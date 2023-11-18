package mpop.revii.ai;

import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextWatcher;
import android.text.Editable;

public class AI extends LinearLayout {
	
	ScrollView sc;
	LinearLayout sc2;
	EditText e;
	ImageButton iv;
	SharedPreferences sp;
	String welcome = "Hello, thank you for using this kind of project, please don't abuse, also don't change the credits.\n\nCredits:\n* John Paul Caigas\n* Mark Kevin Manalo\n* Earl Shine Sawir\n* John Jeremy Antiguo\n* Lester Navarra\n* Eljohn Mago\n* Salvador\n* John Roy Lapida Calimlim\n* Ronald Torrejos Limpiado\n* Jerson Carin\n* Rovie Francisco\n* Hercai\nThere are some changes implemented to the program, which I already removed the toggle button. For you to change your name, kindly message ***set name to `<your name>`*** and your name will be changed, you may also use ***`cls`*** or ***`clear`*** to clear the entire chatbox. And to change the thread's text sizes, use ***set text size to `<number>`***, the base text size would be your name or username on the top of each chat.";
	boolean replied = true;
	
	public AI(final Context ctx, AttributeSet attr){
		super(ctx, attr);
		ctx.setTheme(android.R.style.Theme_DeviceDefault);
		
		float f = 15f;
		sp = ctx.getSharedPreferences("mpop.revii.ai.PREFERENCES", ctx.MODE_PRIVATE);
		ShapeDrawable sd = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f, f, f, f
		}, null, null));
		ShapeDrawable sd2 = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f, f, f, f
		}, null, null));

		LinearLayout input = new LinearLayout(ctx);
		e = new EditText(ctx);
		iv = new ImageButton(ctx);
		sc = new ScrollView(ctx);
		sc2 = new LinearLayout(ctx);
		View v = new View(ctx);
		View v2 = new View(ctx);

		sc.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.9f));

		sc2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.9f));
		sc2.setOrientation(LinearLayout.VERTICAL);
		sc2.addView(chat(ctx, "Welcome bot:", welcome));
		
		sd.getPaint().setColor(Color.DKGRAY);
		sd2.getPaint().setColor(Color.LTGRAY);
		
		setBackground(sd);
		setOrientation(LinearLayout.VERTICAL);
		setPadding(5, 10, 5, 10);
		setVisibility(View.VISIBLE);
		setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View p1) {
			}
		});
		
		input.setOrientation(LinearLayout.HORIZONTAL);
		input.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 75));
		input.setGravity(Gravity.BOTTOM);
		input.setPadding(5, 5, 5, 5);
		
		e.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 0.9f));
		e.setHint("Post your question here");
		e.setBackground(sd2);
		e.setTextColor(Color.BLACK);
		e.setHintTextColor(Color.DKGRAY);
		e.setPadding(8, 5, 8, 5);

		try{
			iv.setImageResource(AI.setResources(ctx, "send", "drawable"));
		}catch(Exception e){
			iv.setImageResource(android.R.drawable.ic_menu_send);
		}
		iv.setBackgroundColor(Color.TRANSPARENT);
		iv.setEnabled(false);
		iv.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View p1) {
				String txt = e.getText().toString();
				if(txt.toLowerCase().startsWith("set ")){
					if(txt.toLowerCase().startsWith("set name to ")){
						String name = txt.substring("set name to ".length());
						sp.edit().putString("mpop.revii.ai.NAME", name).apply();
						sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", "RyannKim327"), txt));
						sc2.addView(chat(ctx, "Preferences [Name]:", String.format("Name changed to `%s`", name)));
					}else if(txt.toLowerCase().startsWith("set text size to ")){
						int size = validator(txt.substring("set text size to ".length()));
						if(size == sp.getInt("mpop.revii.ai.DATA_SIZE", 10)){
							show(ctx, "Nothing changed");
						}
						Intent i = new Intent("mpop.revii.ai.TEXT_SIZE");
						i.putExtra("mpop.revii.ai.DATA_SIZE", size);
						ctx.sendBroadcast(i);
						sp.edit().putInt("mpop.revii.ai.DATA_SIZE", size).commit();
						sc2.addView(chat(ctx, "Preferences [Name]:", String.format("Text sized changed to `%d`", size)));
					}
					e.setText("");
				}else if(txt.equalsIgnoreCase("clear") || txt.equalsIgnoreCase("cls")){
					e.setText("");
					sc2.removeAllViews();
					sc2.addView(chat(ctx, "Welcome bot:", welcome));
				}else{
					sc2.addView(chat(ctx, sp.getString("mpop.revii.ai.NAME", "RyannKim327"), txt));
					http h = new http(ctx);
					h.execute("Name: " + sp.getString("mpop.revii.ai.NAME", "RyannKim327") + "\nMessage: " + e.getText().toString());
					e.setText("");
					iv.setEnabled(false);
					replied = false;
				}
				new Handler().postDelayed(new Runnable(){
					@Override
					public void run() {
						sc.fullScroll(View.FOCUS_DOWN);
					}
				}, 100);
			}
		});
		
		e.addTextChangedListener(new TextWatcher(){
			@Override
			public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {}
			@Override
			public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
				String text = e.getText().toString().trim();
				iv.setEnabled(!text.isEmpty() && replied);
			}
			@Override
			public void afterTextChanged(Editable p1) {}
		});
		
		v.setLayoutParams(new LayoutParams(25, 1));
		v2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 2));
		v2.setBackgroundColor(Color.LTGRAY);
		
		ctx.registerReceiver(new BroadcastReceiver(){
			@Override
			public void onReceive(Context p1, Intent p2) {
				sc2.addView(chat(ctx, "AI:", p2.getStringExtra("DATA")));
				iv.setEnabled(true);
				replied = true;
				new Handler().postDelayed(new Runnable(){
					@Override
					public void run() {
						sc.fullScroll(View.FOCUS_DOWN);
					}
				}, 100);
			}
		}, new IntentFilter("mpop.revii.ai.DATA"));
		
		/*ctx.registerReceiver(new BroadcastReceiver(){
			@Override
			public void onReceive(Context p1, Intent p2) {
				int size = p2.getIntExtra("mpop.revii.ai.DATA_SIZE", 10);
				e.setTextSize(size + (size / 2));
				iv.setLayoutParams(new LayoutParams((size * 2) + (size / 2), (size * 2) + (size / 2)));
			}
		}, new IntentFilter("mpop.revii.ai.TEXT_SIZE"));
		*/
		input.addView(e);
		input.addView(v);
		input.addView(iv);
		sc.addView(sc2);
		addView(sc);
		addView(v2);
		addView(input);
	}
	public LinearLayout chat(final Context ctx, String send, String msg){
		LinearLayout base = new LinearLayout(ctx);
		final Markdown chat = new Markdown(ctx);
		final TextView from = new TextView(ctx);
		float f = 13, f2 = -20, f3 = f;
		if(send.equals(sp.getString("mpop.revii.ai.NAME", "RyannKim327"))){
			f2 = f;
			f3 = -20;
		}
		ShapeDrawable sd = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f3, f3, f2, f2
		}, null, null));
		int size = sp.getInt("mpop.revii.ai.DATA_SIZE", 10);

		if(send.equals(sp.getString("mpop.revii.ai.NAME", "RyannKim327"))){
			base.setGravity(Gravity.RIGHT);
			base.setPadding(75, 5, 5, 5);
			
			from.setGravity(Gravity.RIGHT);
			
			chat.setTextColor(Color.WHITE);
			chat.setGravity(Gravity.LEFT);
			chat.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			
			sd.getPaint().setColor(Color.parseColor("#FF0085EE"));
		}else{
			base.setPadding(5, 5, 75, 5);
			base.setGravity(Gravity.LEFT);
			
			sd.getPaint().setColor(Color.parseColor("#303030"));
			chat.setTextColor(Color.WHITE);
		}

		base.setOrientation(LinearLayout.VERTICAL);
		base.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		
		from.setText(String.format(" %s ",send));
		from.setPadding(10, 10, 10, 10);
		from.setTextSize(size);
		from.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
		
		chat.setPadding(8, 10, 8, 10);
		chat.setBackground(sd);
		chat.setTextSize(size + (size / 2));
		chat.setTypeface(Typeface.SERIF);
		chat.setText(msg);
		chat.setOnLongClickListener(new OnLongClickListener(){
			@Override
			public boolean onLongClick(View p1) {
				((ClipboardManager) ctx.getSystemService(ctx.CLIPBOARD_SERVICE)).setText(chat.getText().toString());
				AI.show(ctx, "Text copied to clipboard");
				return false;
			}
		});
		
		ctx.registerReceiver(new BroadcastReceiver(){
			@Override
			public void onReceive(Context p1, Intent p2) {
				int size = p2.getIntExtra("mpop.revii.ai.DATA_SIZE", 10);
				from.setTextSize(size);
				chat.setTextSize(size + (size / 2));
			}
		}, new IntentFilter("mpop.revii.ai.TEXT_SIZE"));
		
		base.addView(from);
		base.addView(chat);
		return base;
	}
	public static int setResources(Context ctx, String name, String type){
		return ctx.getResources().getIdentifier(name, type, ctx.getPackageName());
	}
	public static Toast show(Context ctx, String msg){
		Toast toast = new Toast(ctx);
		float f = 25;
		ShapeDrawable drawable = new ShapeDrawable(new RoundRectShape(new float[]{
			f, f, f, f,
			f, f, f, f
		}, null, null));
		TextView tv = new TextView(ctx);

		drawable.getPaint().setColor(Color.parseColor("#FF0085EE"));

		tv.setText(msg);
		tv.setTypeface(Typeface.SERIF);
		tv.setTextSize(15);
		tv.setTextColor(Color.WHITE);
		tv.setBackground(drawable);
		tv.setPadding(13, 5, 13, 5);
		toast.setView(tv);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
		return toast;
	}
	public int validator(String num){
		try{
			return Integer.parseInt(num);
		}catch(Exception e){
			return sp.getInt("mpop.revii.ai.DATA_SIZE", 10);
		}
	}
}
