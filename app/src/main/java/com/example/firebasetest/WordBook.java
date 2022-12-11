package com.example.firebasetest;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.ServerTimestamp;

public class WordBook {
    private String name;
    @ServerTimestamp
    private Timestamp createDate;
    private int likeCount;
    private int wordCount;
    private String meanLang;
    private String wordLang;


    public WordBook() {
    }

    public WordBook(String name, int likeCount, int wordCount, String meanLang, String wordLang) {
        this.name = name;
        this.likeCount = 0;
        this.wordCount = 0;
        this.meanLang = meanLang;
        this.wordLang = wordLang;

    }

    public String getName() {
        return name;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String getMeanLang() {
        return meanLang;
    }

    public String getWordLang() {
        return wordLang;
    }

}
