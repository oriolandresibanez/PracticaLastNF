package com.example.oriolandres.practicalastnf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.oriolandres.practicalastnf.Model.ItemModel;

public class AddEditWalletActivity extends AppCompatActivity {

    private EditText persona,dinero,razon;
    private ItemModel modelo;
    private String personaN,dineroN,razonN;
    private int dineroNN;
    public static final String INTENT_ADD = "ss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_wallet);
        setTitle("ADD / EDIT Wallet");
        Bundle intent = getIntent().getExtras();
        persona = (EditText) findViewById(R.id.personaEdit);
        dinero = (EditText) findViewById(R.id.dineroEdit);
        razon = (EditText) findViewById(R.id.porqueEdit);
        modelo = (ItemModel) intent.getSerializable(WalletListActivity.modelEditarK);

        if(modelo != null) {
            persona.setText(modelo.getNombrePersona());
            dinero.setText(modelo.getDinero());
            razon.setText(modelo.getTexto());

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {

            case R.id.save_item:
                personaN = persona.getText().toString();
                dineroN = dinero.getText().toString();
                razonN = razon.getText().toString();


                String numberOnly= dineroN.replaceAll("[^0-9]", "");
                int dineroNN = Integer.parseInt(numberOnly);

                ItemModel anadirItem = new ItemModel(personaN,dineroNN,razonN);
                Intent intent = new Intent("",null);
                intent.putExtra(INTENT_ADD, anadirItem);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.ayuda:
                Toast.makeText(this, "Ayuda seleccionada", Toast.LENGTH_SHORT).show();
                break;
            case R.id.inicio:
                Intent inicioIntent = new Intent(this, MainActivity.class);
                startActivity(inicioIntent);
                break;


        }

        return super.onOptionsItemSelected(item);
    }


}
