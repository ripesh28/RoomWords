package com.example.roomwords;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application)
    {
        WordRoomDatabase db=WordRoomDatabase.getDatabase(application);
        mWordDao=db.wordDao();
        mAllWords=mWordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }
    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private class insertAsyncTask extends AsyncTask<Word,Void,Void> {
        private WordDao wordDao;
        public insertAsyncTask(WordDao mWordDao) {
            this.wordDao=mWordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insert(words[0]);
            return null;
        }
    }
}
