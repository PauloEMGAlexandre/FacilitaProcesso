package com.example.facilitaprocesso;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AbrirProcessoActivity extends AppCompatActivity {

    private ProcessoViewModel mProcessoViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abrir_processo);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ProcessoListAdapter adapter = new ProcessoListAdapter(new ProcessoListAdapter.ProcessoDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mProcessoViewModel = new ViewModelProvider(this).get(ProcessoViewModel.class);

        mProcessoViewModel.getTodosProcessos().observe(this, processos -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(processos);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}