package com.example.facilitaprocesso;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.facilitaprocesso.Processo;

import java.util.List;

@Dao
public interface ProcessoDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(Processo processo);

    @Query("SELECT * FROM processos_table")
    LiveData<List<Processo>> getProcessos();
}
