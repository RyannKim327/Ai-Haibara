package mpop.revii.ai;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Overlay extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        setTheme(android.R.style.Theme_DeviceDefault);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
