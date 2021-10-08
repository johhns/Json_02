package com.developer.johhns.json02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.developer.johhns.json02.databinding.FragmentSecondBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ConvertirGsonArray extends AppCompatActivity {


    private ArrayList<Contrato> mContratos = new ArrayList<>();
    private Gson gson = new Gson() ;
    private Type tipo = new TypeToken<ArrayList<Contrato>>() {}.getType() ;
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertir_gson_array);

        mContratos.add( new Contrato( 1 , "Contrato 1", 5 , 500 ) ) ;

        recyclerView = findViewById(R.id.recView02) ;
        recyclerView.setAdapter( new Adaptador( mContratos , this.getBaseContext() ) ) ;
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

    }
}