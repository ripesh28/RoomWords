package com.example.roomwords;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private List<Word> mWords;
    private LayoutInflater inflater;
    public WordListAdapter(Context context)
    {
        inflater=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recycler_view_item,parent,false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if(mWords!=null) {
            Word current=mWords.get(position);
            Log.d("Word",current.getWord());
            holder.textView.setText(current.getWord());
        }
        else {
            holder.textView.setText("No Words :)");
        }
    }
    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }
    public class WordViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
        }
    }

}
