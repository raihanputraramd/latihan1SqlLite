package com.example.tugasrumah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {

    private List<email> emailList;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView icon,title,subTitle,caption, time;
        public ImageView favourite;

        public ViewHolder(View v){
            super(v);
            icon = (TextView) v.findViewById(R.id.gambar);
            title = (TextView) v.findViewById(R.id.txtNama);
            subTitle = (TextView) v.findViewById(R.id.txtJudul);
            caption = (TextView) v.findViewById(R.id.txtCaption);
            time = (TextView) v.findViewById(R.id.txtJam);
            favourite = (ImageView) v.findViewById(R.id.imgFavourite);
        }
    }
    public EmailAdapter(List<email> emailList){
        this.emailList = emailList;
    }
    @Override
    public EmailAdapter.ViewHolder onCreateViewHolder
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        