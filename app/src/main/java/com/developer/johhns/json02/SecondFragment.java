package com.developer.johhns.json02;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developer.johhns.json02.databinding.FragmentSecondBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class SecondFragment extends Fragment {

    private ArrayList<Contrato> mContratos = new ArrayList<>();
    private FragmentSecondBinding binding;
    String  jsonString = MainActivity.jsonString ;
    private Gson gson = new Gson() ;
    private Type tipo = new TypeToken<ArrayList<Contrato>>() {}.getType() ;
    private RecyclerView recyclerView ;

    @Override
    public View onCreateView(  LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState  ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContratos = gson.fromJson( jsonString , tipo ) ;

        recyclerView = view.findViewById(R.id.revView) ;
        recyclerView.setAdapter( new Adaptador( mContratos , getContext() ) );
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}