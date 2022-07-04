package com.example.fateccursos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spnCursos;
    private Button btnBusca;
    private ListView lstCursosFatecs;
    private TextView txtTeste;
    private FatecAdapter fatecAdapter;
    private Cursor fatecCursor;

    DBO dbo = new DBO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCursos = findViewById(R.id.spnCursos);
        btnBusca = findViewById(R.id.btnBusca);
        lstCursosFatecs = findViewById(R.id.lstCursosFatecs);
        ArrayAdapter<String> adapter_spinner = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,dbo.BuscaCursos());
        spnCursos.setAdapter(adapter_spinner);

    }
    public void btnBuscaOnClick(View view){
        setAdaptadorPersonalizado();

    }
    @Override protected void onRestart() {
        super.onRestart(); setAdaptadorPersonalizado();
    }
    public void setAdaptadorPersonalizado(){
        try {
            fatecCursor = dbo.getCursorFatecs(spnCursos.getSelectedItem().toString());
            fatecAdapter = new FatecAdapter(getApplicationContext(),fatecCursor,0);
            lstCursosFatecs.setAdapter(fatecAdapter);
            Toast.makeText(this, "Com sucesso", Toast.LENGTH_SHORT).show();
        }catch (SQLiteException e){
            Toast.makeText(this, "Falha de acesso ao Banco de Dados", Toast.LENGTH_SHORT).show();
        }
    }
}