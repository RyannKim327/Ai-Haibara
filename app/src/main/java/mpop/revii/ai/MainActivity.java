package mpop.revii.ai;
 
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.LayoutInflater;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.Locale;

public class MainActivity extends Activity {
	SpeechRecognizer sr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sr = SpeechRecognizer.createSpeechRecognizer(this);
		getActionBar().setIcon(util.setResources(this, "ic_launcher", "drawable"));
		getActionBar().setTitle("Bebe ang AI");
		getActionBar().setSubtitle("Developed by RyannKim327");
		setContentView(new AI(this));
		if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
				speak();
			}else{
				requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 0);
			}
		}
	}

	void speak(){
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
		i.putExtra(RecognizerIntent.EXTRA_PREFER_OFFLINE, true);
		i.putExtra(RecognizerIntent.E)
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		switch(requestCode){
			case 0:
				if(grantResults.length > 0 & grantResults[0] == PackageManager.PERMISSION_GRANTED){
					speak();
				}
			break;
		}
	}

	@Override
	public void onBackPressed() {
		AlertDialog.Builder a = new AlertDialog.Builder(this);
		a.setTitle("Confirmation");
		a.setMessage("Are you sure you want to close the app?");
		a.setPositiveButton("No", null);
		a.setNegativeButton("Yes", new DialogInterface.OnClickListener(){
			@Overrie
			public void onClick(DialogInterface p1, int p2) {
				finishAffinity();
			}
		});
		a.setCancelable(true);
		a.show();
	}
}
