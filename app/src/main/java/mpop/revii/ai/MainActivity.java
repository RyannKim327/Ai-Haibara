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

public class MainActivity extends Activity {
	SpeechRecognizer sr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sr = SpeechRecognizer.createSpeechRecognizer(this);
		getActionBar().setIcon(util.setResources(this, "ic_launcher", "drawable"));
		getActionBar().setTitle("Talking AI");
		getActionBar().setSubtitle("Developed by RyannKim327");
		setContentView(new AI(this));
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
}
