package com.example.roomwords;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;
    private LiveData<List<Word>> allWord;
    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository= new WordRepository(application);
        allWord=wordRepository.getAllWords();
    }
    public LiveData<List<Word>> getAllWord(){
        return allWord;
    }
    public void insert(Word word){
        wordRepository.insert(word);
    }
}
