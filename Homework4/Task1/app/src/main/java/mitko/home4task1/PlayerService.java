package mitko.home4task1;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by LUKARSKI on 23.9.2016 г..
 */

public class PlayerService extends Service {

    IBinder binder = new FirstServiceBinder();
    IServiceCommunication callback;
    MediaPlayer player;

    public void setServiceCallback(IServiceCommunication callback)
    {
        this.callback = callback;


        if(callback != null)
        {
            callback.onServiceCustomInvocation();
        }

    }


    public class FirstServiceBinder extends Binder
    {
        PlayerService getService()
        {
          return PlayerService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        player = new MediaPlayer();
        
        initMediaPlayerPreference();
    }

    private void initMediaPlayerPreference() {
        player.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);

        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try{
            player.setDataSource("/Home4Task1/app/src/main/res/songs");
            player.prepare();
            player.setLooping(true);
            player.start();
        } catch(IOException ex) {

        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
      return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(player != null)
            player.stop();
    }
}
