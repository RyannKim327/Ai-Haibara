package mpop.revii.ai;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.SpeechRecognizer;

public class MainActivity extends Activity {
	SpeechRecognizer sr;
	// GregorianCalendar cal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
   	sr = SpeechRecognizer.createSpeechRecognizer(this);
		// getActionBar().setIcon(util.setResources(this, "ic_launcher", "drawable"));
		// getActionBar().setTitle("Ai Haibara");
		// getActionBar().setSubtitle("Developed by RyannKim327");
		// setTheme(android.R.style.Theme_DeviceDefault_NoActionBar);
		// NOTE: This nothing more special than applying the AI.java into the setContentView
		setContentView(new AI(this));
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if(checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
				requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 0);
			}
		}
	}

	@Override
	public void onBackPressed() {
		AlertDialog.Builder a = new AlertDialog.Builder(this);
		a.setTitle("Confirmation");
		a.setMessage("Are you sure you want to close the app?");
		a.setNegativeButton("No", null);
		a.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface p1, int p2) {
				finishAffinity();
			}
		});
		a.setCancelable(true);
		a.show();
	}

	@Override
	protected void onPause() {
		super.onPause();
		finishAffinity();
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		switch (requestCode){
			case 0:
				if(grantResults.length > 0 & grantResults[0] == PackageManager.PERMISSION_GRANTED){
					util.show(this, "Your may now start");
					recreate();
				}else{
					finishAffinity();
				}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		/*if(new GregorianCalendar().after(new GregorianCalendar(2024, 05, 10))){
			AlertDialog.Builder b = new AlertDialog.Builder(this);
			b.setTitle("Notice");
			b.setMessage("Expired na po");
			b.setPositiveButton("Close", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface p1, int p2) {
					finishAndRemoveTask();
				}
			});
			b.setCancelable(false);
			b.show();
		}*/
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if(checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
				requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 0);
			}
		}
	}
}
