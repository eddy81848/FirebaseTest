package com.example.firebasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.firebase.ui.firestore.paging.FirestorePagingAdapter;

public class ViewFirebaseContent extends AppCompatActivity {
    private FirestorePagingAdapter<WordBook, WordBookHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_firebase_content);
    }
}