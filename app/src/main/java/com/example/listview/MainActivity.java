package com.example.listview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

//        String[] arrayString = new String[] { "Rafael", "Erica", "Fran", "Vinicius", "Tailor" };
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayString);

        Frutas frutas = new Frutas();

        ArrayList<Fruta> listaFrutas = new ArrayList<>();

        for (Fruta fruta: frutas.FRUTAS)
        {
            listaFrutas.add(fruta);
        }

        FrutaAdapter adapter = new FrutaAdapter(
                getApplicationContext(),
                R.layout.layout_lista_personalizada,
                listaFrutas
        );

        SQLiteDatabase bd;

        bd = openOrCreateDatabase("banco", MODE_PRIVATE, null);

        bd.execSQL("CREATE TABLE IF NOT EXISTS alunos ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR )");

        bd.execSQL("INSERT INTO alunos (nome) VALUES ('Romulo Beninca' )");
        bd.execSQL("INSERT INTO alunos (nome) VALUES ('Mateus Nunes' )");
        bd.execSQL("INSERT INTO alunos (nome) VALUES ('Andreu Carminatti' )");

        Cursor cursor = bd.rawQuery("SELECT id, nome  FROM  alunos ", null);
        cursor.moveToFirst();

        do
        {
            String s = cursor.getString( 1);
            Log.i(" Resultado Sql :",s );
        }
        while
        (cursor.moveToNext()) ;

        listView.setAdapter(adapter);
    }
}
