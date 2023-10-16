package ma;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.StarAdapter;
import ma.ensa.StarService;
import ma.ensa.list.R;
import ma.ensa.Star;


public class ListActivity extends AppCompatActivity {
    private List<Star> stars;
    private RecyclerView recyclerView;
    private StarAdapter starAdapter = null;

    private StarService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        stars = new ArrayList<>();
        service = StarService.getInstance();
        init();
        recyclerView = findViewById(R.id.recycle_view);
        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (starAdapter != null){
                    starAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });
        return true;
    }

    public void init() {
        service.create(new Star("Abdallah RAMADAN", "https://www.footballdatabase.eu/images/photos/players/a_343/343508.jpg", 3.5f));
        service.create(new Star("Zakaria ELHARCHI", "https://media.licdn.com/dms/image/D4E03AQF1Yaux5K2Rmg/profile-displayphoto-shrink_800_800/0/1684540330852?e=1702512000&v=beta&t=AHCO7IVNVjazrQJQBeTTe0lh2IzgCFIPFx5nTJP7B6A", 4));
        service.create(new Star("michelle rodriguez", "http://www.stars-photos.com/resize.php?id=1120", 5));
        service.create(new Star("george clooney", "http://www.stars-photos.com/resize.php?id=1193", 1));
        service.create(new Star("louise bouroin", "http://www.stars-photos.com/resize.php?id=1185", 5));
        service.create(new Star("louise bouroin", "http://www.stars-photos.com/resize.php?id=1184", 1));
    }
}