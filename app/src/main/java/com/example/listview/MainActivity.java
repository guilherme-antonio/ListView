package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        listView.setAdapter(adapter);
    }
}
