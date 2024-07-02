package com.example.facilitaprocesso;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "processos_table")
public class Processo {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "numero_processo")
    private String numProcesso;

    public Processo(@NonNull String numeroProcesso){
        this.numProcesso = numeroProcesso;
    }

    public String getNumProcesso() {
        return this.numProcesso;
    }
}
