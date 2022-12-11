package com.example.firebasetest;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseDB {
    private static final String TAG = "error";

    //wordbook 객체를 db에 추가
    public static String setWordBook(FirebaseFirestore db, WordBook wordBook) {
        final String[] id = {null};
        db.collection("wordbook").add(wordBook)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        id[0] = documentReference.getId();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
        return id[0];
    }

    //이름을 업데이트
    public static boolean updateName(FirebaseFirestore db, String id, String name) {
        final boolean[] isSuccess = {false};
        DocumentReference wordbook = db.collection("wordbook").document(id);
        wordbook.update("name", name)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        isSuccess[0] = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error updating name", e);
                    }
                });
        return isSuccess[0];
    }

    //좋아요 수를 플러스
    public static boolean plusLikeCount(FirebaseFirestore db, String id) {
        final boolean[] isSuccess = {false};
        DocumentReference docRef = db.collection("wordbook").document(id);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        WordBook wordBook = documentSnapshot.toObject(WordBook.class);
                        assert wordBook != null;
                        int likeCount = wordBook.getLikeCount();
                        likeCount++;
                        docRef.update("likeCount", likeCount)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        isSuccess[0] = true;
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error updating likeCount+", e);
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error getting document", e);
                    }
                });
        return isSuccess[0];
    }

    //좋아요 수를 마이너스
    public static boolean minusLikeCount(FirebaseFirestore db, String id) {
        final boolean[] isSuccess = {false};
        DocumentReference docRef = db.collection("wordbook").document(id);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        WordBook wordBook = documentSnapshot.toObject(WordBook.class);
                        assert wordBook != null;
                        int likeCount = wordBook.getLikeCount();
                        likeCount--;
                        docRef.update("likeCount", likeCount)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        isSuccess[0] = true;
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error updating likeCount-", e);
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error getting document", e);
                    }
                });
        return isSuccess[0];
    }

    //단어언어 업데이트
    public static boolean updateMeanLang(FirebaseFirestore db, String id, String lang) {
        final boolean[] isSuccess = {false};
        DocumentReference wordbook = db.collection("wordbook").document(id);
        wordbook.update("meanLang", lang)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        isSuccess[0] = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error updating meanLang", e);
                    }
                });
        return isSuccess[0];
    }

    //의미언어 업데이트
    public static boolean updateWordLang(FirebaseFirestore db, String id, String lang) {
        final boolean[] isSuccess = {false};
        DocumentReference wordbook = db.collection("wordbook").document(id);
        wordbook.update("wordLang", lang)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        isSuccess[0] = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error updating wordLang", e);
                    }
                });
        return isSuccess[0];
    }

    private static void plusWordCount(FirebaseFirestore db, String id) {
        DocumentReference docRef = db.collection("wordbook").document(id);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        WordBook wordBook = documentSnapshot.toObject(WordBook.class);
                        assert wordBook != null;
                        int wordCount = wordBook.getWordCount();
                        wordCount++;
                        docRef.update("wordCount", wordCount)
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error updating wordCount+", e);
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error getting document", e);
                    }
                });
    }

    private static void minusWordCount(FirebaseFirestore db, String id) {
        DocumentReference docRef = db.collection("wordbook").document(id);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        WordBook wordBook = documentSnapshot.toObject(WordBook.class);
                        assert wordBook != null;
                        int wordCount = wordBook.getWordCount();
                        wordCount--;
                        docRef.update("wordCount", wordCount)
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error updating wordCount-", e);
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error getting document", e);
                    }
                });
    }

    //단어 추가
    public static boolean addWord(FirebaseFirestore db, String id, List<String> wordId, String word, String mean) {
        final boolean[] isSuccess = {false};
        Map<String, String> wordMap = new HashMap<>();
        wordMap.put("word", word);
        wordMap.put("mean", mean);
        db.collection("wordbook").document(id).collection("word").add(wordMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        wordId.add(documentReference.getId());
                        plusWordCount(db, id);
                        isSuccess[0] = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding word", e);
                    }
                });
        return isSuccess[0];
    }

    //단어 업데이트, 둘중 하나만 하고 싶으면 수정 안 할거 null
    public static boolean[] updateWord(FirebaseFirestore db, String wordBookId, String wordId, String word, String mean) {
        final boolean[] isSuccess = {false, false};
        DocumentReference wordbook = db.collection("wordbook").document(wordBookId).collection("word").document(wordId);
        if (word != null) {
            wordbook.update("word", word)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            isSuccess[0] = true;
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error updating word", e);
                        }
                    });
        }
        if (mean != null) {
            wordbook.update("mean", mean)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            isSuccess[1] = true;
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error updating mean", e);
                        }
                    });
        }
        return isSuccess;
    }

    //단어장 삭제
    public static boolean deleteWordBook(FirebaseFirestore db, String id) {
        final boolean[] isSuccess = {false};
        db.collection("wordbook").document(id).delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        isSuccess[0] = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error deleting document", e);
                    }
                });
        return isSuccess[0];
    }

    //단어 삭제
    public static boolean deleteWord(FirebaseFirestore db, String id, String wordId) {
        final boolean[] isSuccess = {false};
        db.collection("wordbook").document(id).collection("word").document(wordId).delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        isSuccess[0] = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error deleting document", e);
                    }
                });
        return isSuccess[0];
    }
}

