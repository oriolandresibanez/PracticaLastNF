package com.example.oriolandres.practicalastnf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class DetailFragment extends Fragment {


    TextView nomTextView, dineroTextView, textoTextView;

    public DetailFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        nomTextView = (TextView) this.getActivity().findViewById(R.id.nomPers);
        dineroTextView = (TextView) this.getActivity().findViewById(R.id.dineroPers);
        textoTextView = (TextView) this.getActivity().findViewById(R.id.textoPers);

        Intent intent = getActivity().getIntent();
        String nombre = intent.getStringExtra(WalletListActivity.nombPers);
        String dinero = intent.getStringExtra(WalletListActivity.dineroPers);
        String texto = intent.getStringExtra(WalletListActivity.textoPers);

        nomTextView.setText(nombre);
        dineroTextView.setText(dinero);
        textoTextView.setText(texto);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }



}
