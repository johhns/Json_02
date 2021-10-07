package com.developer.johhns.json02;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.developer.johhns.json02.databinding.FragmentSecondBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    private ArrayList<Contrato> mContratos = new ArrayList<>();
    private FragmentSecondBinding binding;
    String  jsonString = MainActivity.jsonString ;
    private Gson gson = new Gson() ;
    private Type tipo = new TypeToken<ArrayList<Contrato>>() {}.getType() ;


    //private RecyclerView recyclerView ;

    @Override
    public View onCreateView(  LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState  ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //contratos = gson.fromJson( jsonString , tipo ) ;

        int cantidad = 0 ;//mContratos.size() ;

        for ( int n = cantidad ;  n < cantidad + 5 ; n++ ){
            Contrato cnt = new Contrato() ;
            int numero = n + 1 ;
            cnt.setNumero( numero ) ;
            cnt.setNombre( "Contrato " + numero ) ;
            cnt.setArea( numero * 10 ) ;
            cnt.setTonelasdas( numero * 10 * 80 ); ;
            mContratos.add( cnt ) ;
        }

        Snackbar.make(view,"Cantidad = " + mContratos.size(),Snackbar.LENGTH_LONG).show();

        binding.revView.setAdapter( new Adaptador( mContratos ) );

/*
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        */
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}