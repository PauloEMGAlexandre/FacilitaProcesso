package com.example.facilitaprocesso.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.facilitaprocesso.Processo;
import com.example.facilitaprocesso.ProcessoDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Processo.class}, version = 1, exportSchema = false)
public abstract class FacilitaProcessoRoomDB extends RoomDatabase {

    public abstract ProcessoDAO processoDAO();

    private static volatile FacilitaProcessoRoomDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static FacilitaProcessoRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FacilitaProcessoRoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    FacilitaProcessoRoomDB.class, "processo_database").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);


            /*
            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ProcessoDAO dao = INSTANCE.processoDAO();
                dao.deleteAll();

                Word word = new Word("Hello");
                dao.insert(word);
                word = new Word("World");
                dao.insert(word);
            });*/
        }
    };
}
