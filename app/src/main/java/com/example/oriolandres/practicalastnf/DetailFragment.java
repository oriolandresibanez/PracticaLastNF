package com.example.oriolandres.practicalastnf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class DetailFragment extends Fragment {


    TextView nomTextView, dineroTextView, textoTextView;

    public DetailFragment() {
        // Required empty public constructor
    }

    private String nom,din,tex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        Bundle args = getArguments();
        if (args != null) {
             nom =  args.getString("NOMB_1");
             din =  args.getString("DIN_1");
             tex =  args.getString("TEXT_1");

        }else{
             Intent intent = getActivity().getIntent();
             nom = intent.getStringExtra("NOMB_1");
             din = intent.getStringExtra("DIN_1");
             tex  = intent.getStringExtra("TEXT_1");
        }


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        nomTextView = (TextView) this.getActivity().findViewById(R.id.nomPers);
        dineroTextView = (TextView) this.getActivity().findViewById(R.id.dineroPers);
        textoTextView = (TextView) this.getActivity().findViewById(R.id.textoPers);

        if(din != null){
            nomTextView.setText(nom);
            dineroTextView.setText(din);
            textoTextView.setText(tex);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.inicio:
                Intent inicioIntent = new Intent (getActivity(), MainActivity.class);
                startActivity(inicioIntent);
                break;

        }



        return super.onOptionsItemSelected(item);
    }



}
