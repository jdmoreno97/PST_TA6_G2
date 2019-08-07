package com.example.pst_ta6_g2;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class perfil extends Fragment {

    public perfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        String [] jugadore = {"Bryan Angulo","Anderson Julio","Sebastian Perez","Bruno Vides","Luis Uchuari"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,jugadore);
        spinner.setAdapter(adapter);

        Button votacion = v.findViewById(R.id.button);
        votacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "GRACIAS POR SU VOTO", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
    public void votar(View view){

    }



}
