package mpop.revii.ai;
import android.widget.ImageView;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;

public class Toggle extends ImageView {
	public Toggle(final Context ctx, AttributeSet attr){
		super(ctx, attr);
		setVisibility(View.GONE);
		try{
			setImageResource(AI.setResources(ctx, "ic_launcher", "drawable"));
		}catch(Exception e){
			setImageResource(android.R.drawable.ic_dialog_email);
		}
		setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View p1) {
				Intent i = new Intent("mpop.revii.ai.TOGGLE");
				i.putExtra("TOGGLE", View.VISIBLE);
				ctx.sendBroadcast(i);
				setVisibility(View.GONE);
			}
		});
		ctx.registerReceiver(new BroadcastReceiver(){
			@Override
			public void onReceive(Context p1, Intent p2) {
				setVisibility(p2.getIntExtra("IMGT", View.GONE));
			}
		}, new IntentFilter("mpop.revii.ai.IMGT"));
	}
}
