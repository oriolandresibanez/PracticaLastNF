package com.example.oriolandres.practicalastnf;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oriolandres.practicalastnf.Model.ItemModel;
import com.example.oriolandres.practicalastnf.MyAdapter.MyListAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class WalletListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AbsListView.MultiChoiceModeListener {

    private List<ItemModel> model;
    private String walletSelect;
    private int posicionEliminar;
    private ListView listView;
    private MyListAdapter adapter;
    public static final String modelEditarK = "edit";
    static final int PICK_CONTACT = 1;
    static final int MODEL_EDIT = 2;
    public static final String walletaAñad = "cat";


    public static final String nombPers = "nom";
    public static final String dineroPers = "dine";
    public static final String textoPers = "text";
    public static final String wallPers = "wallTyp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_list);
        setTitle(R.string.listam);
        Bundle intent = getIntent().getExtras();
        if(intent !=null) {
            walletSelect = intent.getString(MainActivity.tipoBoton);
        }

        createDataModel();

        listView = (ListView) this.findViewById(R.id.listView);
        adapter = new MyListAdapter(this, model,R.layout.list_item);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(this);

    }

    private void createDataModel() {

        String titulo = null;
        int euro = 0;
        String euros;
        String texto =null;
        model = new ArrayList<ItemModel>();

        switch (walletSelect) {

            case "debes":
                titulo = this.getResources().getString(R.string.nombreAux);
                euros = this.getResources().getString(R.string.dineroAux);
                euro = Integer.parseInt(euros);
                texto = this.getResources().getString(R.string.textAux);
                break;

            case "deben":
                titulo = this.getResources().getString(R.string.nombreAux2);
                euros = this.getResources().getString(R.string.dineroAux2);
                euro = Integer.parseInt(euros);
                texto = this.getResources().getString(R.string.textAux2);
                break;

        }

        ItemModel item = new ItemModel(titulo, euro, texto);
        model.add(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overflow, menu);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        //DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragmentCont);
        String nombre = model.get(position).getNombrePersona();
        String dinero = model.get(position).getDinero();
        String texto = model.get(position).getTexto();

        if(getResources().getConfiguration().smallestScreenWidthDp < 600){

            Intent intent = new Intent(this,DetailWalletActivity.class);
            String wallSele = walletSelect;

            intent.putExtra("NOMB_1", nombre);
            intent.putExtra("DIN_1", dinero);
            intent.putExtra("TEXT_1", texto);
            startActivity(intent);

        }else{

            DetailFragment detailFragment3 = new DetailFragment();

            Bundle bundle = new Bundle();
            bundle.putString("NOMB_1", nombre);
            bundle.putString("DIN_1", dinero);
            bundle.putString("TEXT_1", texto);


            detailFragment3.setArguments(bundle);

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmnTrans = fm.beginTransaction();
            fragmnTrans.add(R.id.detailFragmentCont, detailFragment3);
            fragmnTrans.commit();
        }


    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {


        mode.setTitle(model.get(position).getNombrePersona());
        posicionEliminar = position;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_item:
                Intent intent3 = new Intent(this, AddEditWalletActivity.class);
                String walletInte = walletSelect;
                intent3.putExtra(walletInte,walletaAñad);
                startActivityForResult(intent3, PICK_CONTACT);
                break;
            case R.id.inicio:
                Intent inicioIntent = new Intent (this, MainActivity.class);
                startActivity(inicioIntent);
                break;

        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()){

            case R.id.editar:
                Intent intentEdit = new Intent(this, AddEditWalletActivity.class);
                ItemModel modelEditar = model.get(posicionEliminar);
                intentEdit.putExtra(modelEditarK,modelEditar);
                startActivityForResult(intentEdit, MODEL_EDIT);

                break;
            case R.id.borrar:
                model.remove(posicionEliminar);
                adapter.notifyDataSetChanged();
                mode.finish();
                break;

        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            ItemModel recibido = (ItemModel) data.getExtras().getSerializable(AddEditWalletActivity.INTENT_ADD);
            if (requestCode == PICK_CONTACT) {
                model.add(recibido);
                adapter.notifyDataSetChanged();

            } else if(requestCode == MODEL_EDIT) {
                model.remove(posicionEliminar);
                model.add(posicionEliminar, recibido);
                adapter.notifyDataSetChanged();
            }
        }


    }

}