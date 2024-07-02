package com.example.facilitaprocesso;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class CriarNovoProcesso extends AppCompatActivity {


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_criar_novo_processo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    */

    //public static final String EXTRA_REPLY = "com.example.android.facilitaprocesso.REPLY";
    public static final String EXTRA_REPLY = "com.example.facilitaprocesso.REPLY";

    private EditText mEditProcessoView;

    public static final int NEW_PROCESSO_ACTIVITY_REQUEST_CODE = 1;

    private ProcessoViewModel mProcessoViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_novo_processo);
        mEditProcessoView = findViewById(R.id.numeroProcessoEditText);

        mProcessoViewModel = new ViewModelProvider(this).get(ProcessoViewModel.class);

        final Button button = findViewById(R.id.salvarProcessoButton);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditProcessoView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String processo = mEditProcessoView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, processo);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_PROCESSO_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Processo processo = new Processo(data.getStringExtra(CriarNovoProcesso.EXTRA_REPLY));
            mProcessoViewModel.insert(processo);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void salvarProcesso(){
        Intent intent = new Intent(CriarNovoProcesso.this, CriarNovoProcesso.class);
        //startActivityForResult(intent, NEW_PROCESSO_ACTIVITY_REQUEST_CODE);
    }

}