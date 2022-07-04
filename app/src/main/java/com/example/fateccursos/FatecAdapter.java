package com.example.fateccursos;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class FatecAdapter extends CursorAdapter {

    public FatecAdapter(Context context, Cursor cursor, int flag) {

        super(context, cursor,0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.linha, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nome,email,telefone,endereco;
        String s;

        nome=view.findViewById(R.id.txtNome);
        s=cursor.getString(cursor.getColumnIndexOrThrow("nome_f"));
        nome.setText(s);

        email=view.findViewById(R.id.txtEmail);
        s=cursor.getString(cursor.getColumnIndexOrThrow("email"));
        email.setText(s);

        telefone=view.findViewById(R.id.txtTelefone);
        s=cursor.getString(cursor.getColumnIndexOrThrow("telefone"));
        telefone.setText(s);

        endereco=view.findViewById(R.id.txtEndereco);
        s=cursor.getString(cursor.getColumnIndexOrThrow("endereco"));
        endereco.setText(s);
    }
}
