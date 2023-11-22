package mpop.revii.ai;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Overlay extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
