package com.example.oriolandres.practicalastnf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String tipoBoton = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nuevaSeleccion(View view) {

        Intent intent = new Intent(this, WalletListActivity.class);

        switch (view.getId()) {

            case R.id.buttonDebes:
                intent.putExtra(tipoBoton, "debes");
                break;
            case R.id.buttonDeben:
                intent.putExtra(tipoBoton, "deben");
                break;

        }

        startActivity(intent);

    }
}
