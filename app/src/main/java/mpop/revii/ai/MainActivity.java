package mpop.revii.ai;
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setIcon(util.setResources(this, "ic_launcher", "drawable"));
		getActionBar().setTitle("Bebe ang AI");
		getActionBar().setSubtitle("Developed by RyannKim327");
		setContentView(new AI(this));
		// startService(new Intent(this, Overlay.class));
	}
	@Override
	public void onBackPressed() {
		AlertDialog.Builder a = new AlertDialog.Builder(this);
		a.setTitle("Confirmation");
		a.setMessage("Are you sure you want to close the app?");
		a.setPositiveButton("No", null);
		a.setNegativeButton("Yes", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface p1, int p2) {
				finishAffinity();
			}
		});
		a.setCancelable(true);
		a.show();
	}
}
