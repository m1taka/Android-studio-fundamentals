package mitko.home4task1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by LUKARSKI on 23.9.2016 г..
 */

public class MainActivity extends Activity implements Observer,IServiceCommunication,ISelectedElement{

    Intent playerServiceIntent;
    final Context ctx = this;
    private List<Song> songsList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SongsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Song mSong;
    IServiceCommunication callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new SongsAdapter(songsList);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        prepareSongData();
    }

    private void prepareSongData() {
        Song song = new Song("Back in Black", "AC/DC . Back in Black");
        songsList.add(song);

        song = new Song("Wake me up", "Avicii . Wake me up");
        songsList.add(song);

        song = new Song("All Summer Song", "Kid Rock . All Summer Song");
        songsList.add(song);

        song = new Song("SAIL", "AWOLNATION . SAIL");
        songsList.add(song);

        song = new Song("Gold On The Ceiling", "The Black Keys . Gold On The Ceiling");
        songsList.add(song);

        song = new Song("Sirtaki Originale", "Zorba . Sirtaki Originale");
        songsList.add(song);

        song = new Song("Give Me One Reason", "Tracy Chapman . Give Me One Reason");
        songsList.add(song);

        song = new Song("Out of space", "Peter Tosh  . Out of space");
        songsList.add(song);

        song = new Song("Raise, Raise", "Rammstein  . Raise, Raise");
        songsList.add(song);

        mAdapter.notifyDataSetChanged();
    }

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(ctx,"Service is ready to roll !!!",Toast.LENGTH_SHORT).show();

            PlayerService.FirstServiceBinder serviceToOperate = (PlayerService.FirstServiceBinder)service;

            serviceToOperate.getService().setServiceCallback(MainActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    public void onServiceStarted(View view)
    {
        playerServiceIntent = new Intent(this,PlayerService.class);
        Toast.makeText(this,"DDSasff",Toast.LENGTH_LONG).show();
        //firstServiceIntent.putExtra("Data","Hello Service");

        bindService(playerServiceIntent,conn, Context.BIND_AUTO_CREATE);

        startService(playerServiceIntent);
    }

    public void onServiceStopped(View view)
    {
        if(playerServiceIntent == null)
            playerServiceIntent = new Intent(this,PlayerService.class);

        unbindService(conn);
        stopService(playerServiceIntent);
    }

    @Override
    public void update(Observable observable, Object o) {  }

    @Override
    public void onServiceCustomInvocation() {
    }

    @Override
    public void songClick(int position) {
        mAdapter.getmListener().songClick(position);
        onServiceStarted(mRecyclerView);
        onServiceStopped(mRecyclerView);
        callback.onServiceCustomInvocation();

    }
}
