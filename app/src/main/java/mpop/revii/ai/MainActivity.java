package mpop.revii.ai;
 
import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.LayoutInflater;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import android.icu.util.GregorianCalendar;
import android.view.View.OnClickListener;
import android.view.View;

public class MainActivity extends Activity {
	SpeechRecognizer sr;
	GregorianCalendar cal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sr = SpeechRecognizer.createSpeechRecognizer(this);
		getActionBar().setIcon(util.setResources(this, "ic_launcher", "drawable"));
		getActionBar().setTitle("Talking AI");
		getActionBar().setSubtitle("Developed by RyannKim327");
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
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if(checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
				requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 0);
			}
		}
	}
}
