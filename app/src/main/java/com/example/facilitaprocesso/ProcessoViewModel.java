package com.example.facilitaprocesso;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProcessoViewModel extends AndroidViewModel {

    private ProcessoRepository mProcessoRepository;

    private final LiveData<List<Processo>> mTodosProcessos;

    public ProcessoViewModel(Application application){
        super(application);
        mProcessoRepository = new ProcessoRepository(application);
        mTodosProcessos = mProcessoRepository.getTodosProcessos();
    }

    LiveData<List<Processo>> getTodosProcessos(){
        return mTodosProcessos;
    }

    public void insert(Processo processo){
        mProcessoRepository.insert(processo);
    }
}
