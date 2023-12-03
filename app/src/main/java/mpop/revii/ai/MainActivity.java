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
		sr.setRecognitionListener(new RecognitionListener() {
			@Override
			public void onReadyForSpeech(Bundle bundle) {
				util.show(MainActivity.this, "Starting");
			}
			@Override
			public void onBeginningOfSpeech() {}
			@Override
			public void onRmsChanged(float v) {}
			@Override
			public void onBufferReceived(byte[] bytes) {}
			@Override
			public void onEndOfSpeech() {}
			@Override
			public void onError(int i) {
				switch (i){
					case SpeechRecognizer.ERROR_AUDIO:
						util.show(MainActivity.this, "Audio Error");
					break;
					case SpeechRecognizer.ERROR_CLIENT:
						util.show(MainActivity.this, "Client Error");
					break;
					case SpeechRecognizer.ERROR_NETWORK:
						util.show(MainActivity.this, "Network Error");
					break;
					case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
						util.show(MainActivity.this, "Speech Recognizer is busy");
					break;
					case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
						util.show(MainActivity.this, "Network Timeout");
					break;
					case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
						util.show(MainActivity.this, "Speech Timeout");
					break;
				}
			}
			@Override
			public void onResults(Bundle bundle) {
				List<String> l = 
			}
			@Override
			public void onPartialResults(Bundle bundle) {}
			@Override
			public void onEvent(int i, Bundle bundle) {}
		});
		registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
						speak();
					}else{
						requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 0);
					}
				}else{
					speak();
				}
			}
		}, new IntentFilter("mpop.revii.ai.CALLBACK_SPEECH"));
		sendBroadcast(new Intent("mpop.revii.ai.CALLBACK_SPEECH"));
	}

	void speak(){
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");
		try{
			util.show(this, "Listening");
			startActivityForResult(i, -1);
		}catch (Exception e){
			util.show(MainActivity.this, "Error: " + e.getMessage());
		}
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
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		util.show(this, data.toString());
		switch(requestCode){
			case -1:
				if(requestCode == RESULT_OK && data != null) {
					ArrayList<String> l = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
					Intent i = new Intent("mpop.revii.ai.SEND_SPEECH");
					i.putExtra("mpop.revii.ai.DATA_SPEECH", l.get(0));
					sendBroadcast(i);
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
			@Override
			public void onClick(DialogInterface p1, int p2) {
				finishAffinity();
			}
		});
		a.setCancelable(true);
		a.show();
	}
}
