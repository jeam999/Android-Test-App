package alexeykafeev.android_test_app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.ArrayList;

public class ThreadInService extends Service {
    public ThreadInService() {

    }


    @Override
    public void onCreate() {
        super.onCreate();

        ArrayList<ArrayList> arrayLists=new ArrayList<>();
        arrayLists.add(MainActivity.vehicles);
        arrayLists.add(MainActivity.planes);
        arrayLists.add(MainActivity.ships);

        ThreadManager threadManager=new ThreadManager(arrayLists);
        threadManager.Start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
