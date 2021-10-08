package com.developer.johhns.json02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.developer.johhns.json02.databinding.FragmentFirstBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {


    public  static Gson  gson = new Gson();
    private static Type  tipo = new TypeToken<ArrayList<Contrato>>() {}.getType() ;
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (  MainActivity.contratos == null ) {
            MainActivity.contratos = new ArrayList<>() ;
        } else {
            convertirJSON();
        }


        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad = MainActivity.contratos.size() ;

                for ( int n = cantidad ;  n < cantidad + 5 ; n++ ){
                    Contrato cnt = new Contrato() ;
                    int numero = n + 1 ;
                    cnt.setNumero( numero ) ;
                    cnt.setNombre( "Contrato " + numero ) ;
                    cnt.setArea( numero * 10 ) ;
                    cnt.setToneladas( numero * 10 * 80 ); ;
                    MainActivity.contratos.add( cnt ) ;
                }
                convertirJSON();
            }
        });

        binding.btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertirJSON();
            }
        });


    }

    private void convertirJSON(){
       MainActivity.jsonString = gson.toJson( MainActivity.contratos , tipo ) ;
       binding.txtResultado.setText( gson.toJson( MainActivity.contratos , tipo ) );
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}