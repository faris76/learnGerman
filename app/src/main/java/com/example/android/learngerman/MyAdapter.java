package com.example.android.learngerman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.Objects;

public class MyAdapter extends FirebaseRecyclerAdapter<Model, MyAdapter.MyViewHolder> {
    Speech speech = new Speech();
    Context context;
    public MyAdapter(@NonNull FirebaseRecyclerOptions<Model> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Model model) {

        holder.german.setText(model.getGerman());
        holder.english.setText(model.getEnglish());
        holder.play.setImageResource(R.drawable.ic_play);

        holder.german.setOnClickListener(v -> {
            speakGerman(Objects.requireNonNull(holder).german.getText().toString());
        });

        holder.play.setOnClickListener(v -> {
            speakGerman(Objects.requireNonNull(holder).german.getText().toString());
        });

        holder.english.setOnClickListener(v -> {
            speakGerman(Objects.requireNonNull(holder).german.getText().toString());
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_row,parent,false);
        return new MyViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView german,english;
        ImageView play;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            play = itemView.findViewById(R.id.playButton);
            german = itemView.findViewById(R.id.germanWord);
            english = itemView.findViewById(R.id.englishWord);
        }
    }

    public void speakGerman(String st){
        Speech.talk(st);
    }
}
