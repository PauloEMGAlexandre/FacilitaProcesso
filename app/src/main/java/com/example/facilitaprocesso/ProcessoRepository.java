package com.example.facilitaprocesso;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.facilitaprocesso.db.FacilitaProcessoRoomDB;

import java.util.List;

public class ProcessoRepository {

    private ProcessoDAO mProcessoDAO;
    private LiveData<List<Processo>> mTodosProcessos;

    ProcessoRepository(Application application){
        FacilitaProcessoRoomDB db = FacilitaProcessoRoomDB.getDatabase(application);
        mProcessoDAO = db.processoDAO();
        mTodosProcessos = mProcessoDAO.getProcessos();
    }

    LiveData<List<Processo>> getTodosProcessos(){
        return mTodosProcessos;
    }

    void insert(Processo processo){
        FacilitaProcessoRoomDB.databaseWriteExecutor.execute(() -> {
            mProcessoDAO.insert(processo);
        });
    }
}
