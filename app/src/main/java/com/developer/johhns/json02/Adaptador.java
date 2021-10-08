package com.developer.johhns.json02;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    ArrayList<Contrato> contratos ;
    Context contexto ;

    public Adaptador( ArrayList<Contrato> p_contratos , Context p_contexto ) {
        this.contratos = p_contratos;
        this.contexto  = p_contexto ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.card_contrato , null , false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        Contrato cnt = contratos.get(position) ;
        holder.contrato.setText( String.valueOf( cnt.getNumero() ) );
        holder.nombre.setText( cnt.getNombre() );
        holder.area.setText( String.valueOf( cnt.getArea() ) );
        holder.toneladas.setText( String.valueOf( cnt.getToneladas() ) );
    }

    @Override
    public int getItemCount() {
        return contratos.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView contrato, nombre,area, toneladas ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contrato  = (TextView) itemView.findViewById(R.id.txtContrato) ;
            nombre    = (TextView) itemView.findViewById(R.id.txtNombre) ;
            area      = (TextView) itemView.findViewById(R.id.txtArea) ;
            toneladas = (TextView) itemView.findViewById(R.id.txtToneladas) ;
        }
    }
}
