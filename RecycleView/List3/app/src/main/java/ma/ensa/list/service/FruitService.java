package ma.ensa.list.service;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.list.beans.Fruit;
import ma.ensa.list.dao.IDao;

public class FruitService implements IDao<Fruit> {

    private List<Fruit> fruits;

    public FruitService() {
        this.fruits = new ArrayList<>();
    }

    @Override
    public boolean create(Fruit o) {
        Log.d("Create : ", o.toString());
        return fruits.add(o);
    }

    @Override
    public Fruit findById(int id) {
        Log.d("FindById : ", id+"");
        for(Fruit f : fruits)
            if(f.getId() == id)
                return f;
        return null;
    }

    @Override
    public List<Fruit> findAll() {
        Log.d("findAll : ", fruits.size()+"");
        return fruits;
    }

    @Override
    public boolean delete(Fruit o) {
        Log.d("Delete : ", o.toString());
        return fruits.remove(o);
    }

    @Override
    public boolean update(Fruit o) {
        Fruit f = findById(o.getId());
        f.setNom(o.getNom());
        f.setPrix(o.getPrix());
        f.setImage(o.getImage());
        return false;
    }
}
