package mitko.home4task1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LUKARSKI on 23.9.2016 г..
 */

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder>{

    private List<Song> songsList;
    private ISelectedElement mListener;
    IServiceCommunication callback;

    public SongsAdapter (List<Song> songsList){
        this.songsList = songsList;
    }

    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.songs_list_row, parent, false);
        return new SongsViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(SongsViewHolder holder, int position) {
        Song song = songsList.get(position);
        holder.title.setText(song.getTitle());
        holder.artist.setText(song.getArtistName());
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public ISelectedElement getmListener() {
        return mListener;
    }

    public void setmListener(ISelectedElement mListener) {
        this.mListener = mListener;
    }

    public IServiceCommunication getService() {
        return callback;
    }

    public void setService(IServiceCommunication callback) {
        this.callback = callback;
    }
    public class SongsViewHolder extends RecyclerView.ViewHolder{

        public TextView title, artist;
        TextView mTextView;
        int position;

        public SongsViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            artist = (TextView) view.findViewById(R.id.artist);

           mTextView = (TextView) view.findViewById(R.id.artist);

            view.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    if(mListener!=null)
                        setService(callback);

                }
            });
        }


    }

}
