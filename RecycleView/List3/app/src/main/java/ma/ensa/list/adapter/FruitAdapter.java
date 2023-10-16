package ma.ensa.list.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ma.ensa.list.R;
import ma.ensa.list.beans.Fruit;

public  class FruitAdapter extends BaseAdapter {
    private List<Fruit> fruits;
    private LayoutInflater inflater;

    public FruitAdapter(List<Fruit> fruits, Activity activity) {
        this.fruits = fruits;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return fruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return fruits.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.item, null);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView prix = convertView.findViewById(R.id.prix);
        ImageView image = convertView.findViewById(R.id.image);
        TextView id = convertView.findViewById(R.id.id);

        nom.setText(fruits.get(position).getNom());
        prix.setText(fruits.get(position).getPrix()+"");
        image.setImageResource(fruits.get(position).getImage());
        id.setText(fruits.get(position).getId()+"");
        return convertView;
    }
}
