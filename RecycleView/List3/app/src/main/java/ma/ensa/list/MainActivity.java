package ma.ensa.list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import ma.ensa.list.adapter.FruitAdapter;
import ma.ensa.list.beans.Fruit;
import ma.ensa.list.service.FruitService;

public class MainActivity extends AppCompatActivity {

    FruitService fs = new FruitService();
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fs.create(new Fruit("Apple",10, R.mipmap.apple));
        fs.create(new Fruit("Banane",10, R.mipmap.bananas));
        fs.create(new Fruit("Pineaplle",10, R.mipmap.pineapple));
        fs.create(new Fruit("Strawberry",10, R.mipmap.strawberry));
        fs.create(new Fruit("Apple",10, R.mipmap.apple));
        fs.create(new Fruit("Banane",10, R.mipmap.bananas));
        fs.create(new Fruit("Pineaplle",10, R.mipmap.pineapple));
        fs.create(new Fruit("Strawberry",10, R.mipmap.strawberry));
        fs.create(new Fruit("Apple",10, R.mipmap.apple));
        fs.create(new Fruit("Banane",10, R.mipmap.bananas));
        fs.create(new Fruit("Pineaplle",10, R.mipmap.pineapple));
        fs.create(new Fruit("Strawberry",10, R.mipmap.strawberry));
        fs.create(new Fruit("Apple",10, R.mipmap.apple));
        fs.create(new Fruit("Banane",10, R.mipmap.bananas));
        fs.create(new Fruit("Pineaplle",10, R.mipmap.pineapple));
        fs.create(new Fruit("Strawberry",10, R.mipmap.strawberry));

        list = findViewById(R.id.list);
        list.setAdapter(new FruitAdapter(fs.findAll(), this));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("Voulez vous supprimer ce fruit");
                alertDialogBuilder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        TextView idd = view.findViewById(R.id.id);
                        fs.delete(fs.findById(Integer.parseInt(idd.getText().toString())));
                        list.setAdapter(new FruitAdapter(fs.findAll(), MainActivity.this));
                        Toast.makeText(MainActivity.this, idd.getText().toString(), Toast.LENGTH_LONG).show();

                    }
                });
                alertDialogBuilder.setNegativeButton("Non",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();



             }
        });
    }
}