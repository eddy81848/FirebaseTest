package com.example.firebasetest;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordBookHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView count;
    public WordBookHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(android.R.id.text1);
        count = itemView.findViewById(android.R.id.text2);
    }

    void bind(@NonNull WordBook wordBook){
        name.setText(wordBook.getName());
        count.setText(wordBook.getWordCount());
    }
}
