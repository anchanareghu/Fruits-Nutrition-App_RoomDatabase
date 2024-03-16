package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    RecyclerViewAdapter adapter;
    AppDatabase appDatabase;
    List<Fruits> fruits;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
        SearchView searchView = findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
        appDatabase = AppDatabase.getInstance(this);
        new Thread((new Runnable() {
            @Override
            public void run() {
                fruits = new ArrayList<>();
                fruits.add(new Fruits(1, "Apple", "https://images.unsplash.com/photo-1645519115635-b80cd66cde3a?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDEyfHx8ZW58MHx8fHx8", "Calories: 104\n" + "Protein: 0.52g\n" + "Dietary fiber: 4.8g\n" + "Calcium: 12mg\n" + "Iron: 0.24mg\n" + "Magnesium: 10mg\n"));
                fruits.add(new Fruits(2, "Banana", "https://plus.unsplash.com/premium_photo-1685946109192-b9b1867bf0c7?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 89\n" + "Water: 75%\n" + "Protein: 1.1g\n" + "Carbs: 22.8g\n" + "Sugar: 12.2g\n" + "Fiber: 2.6g\n" + "Fat: 0.3g"));
                fruits.add(new Fruits(3, "Orange", "https://images.unsplash.com/photo-1512578000375-660f001ef96d?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDEzfHx8ZW58MHx8fHx8", "Calories: 60 \n" + "Protein: 1g\n" + "Fiber: 3g\n" + "Sugar: 12g\n" + "Vitamin A: 14mg\n" + "Vitamin C: 70mg\n" + "No fat or sodium"));
                fruits.add(new Fruits(4, "Strawberry", "https://images.unsplash.com/photo-1527777309916-b59323b01809?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxjb2xsZWN0aW9uLXBhZ2V8OHw4NjU3MzkyfHxlbnwwfHx8fHw%3D", "Calories: 32\n" + "Water: 91%\n" + "Protein: 0.7 g\n" + "Carbs: 7.7 g\n" + "Sugar: 4.9 g\n" + "Fiber: 2 g\n" + "Fat: 0.3 g"));
                fruits.add(new Fruits(5, "Grapes", "https://images.unsplash.com/photo-1537640538966-79f369143f8f?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDJ8fHxlbnwwfHx8fHw%3D", "Calories: 104\n" + "Fat: <1g\n" + "Sodium: 3mg\n" + "Carbs: 27g\n" + "Fiber: 1.35g\n" + "Protein: 1.08g"));
                fruits.add(new Fruits(6, "Blueberry", "https://plus.unsplash.com/premium_photo-1674831509063-e68252300846?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxjb2xsZWN0aW9uLXBhZ2V8M3xZRTVHM1c0TUtSOHx8ZW58MHx8fHx8", "Calories: 57\n" + "Dietary fiber: 2.4g\n" + "Vitamin A: 54IU\n" + "Vitamin B6: 0.052mg\n" + "Vitamin C: 9.7mg\n" + "Vitamin K: 19.3μg"));
                fruits.add(new Fruits(7, "Avocado", "https://images.unsplash.com/photo-1601039641847-7857b994d704?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 160\n" + "Fat: 14.7g\n" + "Sodium: 7mg\n" + "Carbs: 8.5g\n" + "Fiber: 6.7g\n" + "Sugars: 0.7g\n" + "Protein: 2g\n" + "Magnesium: 29mg\n" + "Potassium: 485mg\n" + "Vitamin C: 10mg"));
                fruits.add(new Fruits(8, "Kiwi", "https://images.unsplash.com/photo-1601751911467-f0514d34f3ef?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE5fHx8ZW58MHx8fHx8", "Calories: 90\n" + "Protein: 1g\n" + "Fat: 1g\n" + "Carbs: 21g\n" + "Fiber: 5g\n" + "Sugar: 15g\n" + "Vitamin C: 56mg\n" + "Potassium: 148mg"));
                fruits.add(new Fruits(9, "Plum", "https://images.unsplash.com/photo-1465120846441-761b22f43328?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDR8fHxlbnwwfHx8fHw%3D", "Calories: 76\n" + "Protein: 1g\n" + "Fat: Less than 1g\n" + "Carbohydrates: 18g\n" + "Fiber: 2g\n" + "Sugar: 16g"));
                fruits.add(new Fruits(10, "Pomegranate", "https://images.unsplash.com/photo-1541344999736-83eca272f6fc?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDEzfHx8ZW58MHx8fHx8", "Calories: 72.\n" + "Protein: 2.35g\n" + "Fat: 1.6g\n" + "Carbohydrates: 26g\n" + "Fiber: 5.5g\n" + "Sugar: 20g"));
                fruits.add(new Fruits(11, "Dragon Fruit", "https://images.unsplash.com/photo-1585138774489-caf6e48633b5?q=80&w=2072&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 57\n" + "Protein: 0.36g\n" + "Carbs: 22g\n" + "Fiber: 5.0g\n" + "Calcium: 31mg\n" + "Magnesium: 68mg\n" + "Iron: 0.1mg"));
                fruits.add(new Fruits(12, "Mango", "https://images.unsplash.com/photo-1519096845289-95806ee03a1a?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bWFuZ28lMjBmcnVpdHxlbnwwfHwwfHx8MA%3D%3D", "Calories: 202\n" + "Water: g\n" + "Protein: 3g\n" + "Carbs: 50g\n" + "Sugar: 45g\n" + "Fiber: 5g"));
                fruits.add(new Fruits(13, "Fig", "https://cdn.pixabay.com/photo/2017/08/10/08/26/figs-2619978_1280.jpg", "Calories: 37\n" + "Protein: 0g\n" + "Carbs: 10g\n" + "Sugar: 8.0g\n" + "Fiber: 1.45g\n" + "Sodium: 0.5mg"));
                fruits.add(new Fruits(14, "Raspberry", "https://images.unsplash.com/photo-1577003833619-76bbd7f82948?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8fHw%3D", "Calories: 64\n" + "Water: 105.0g\n" + "Protein: 1.5g\n" + "Carbs: 9.3g\n" + "Sugar: 5.4g\n" + "Fiber: 8.0g\n" + "Calcium: 30.8mg\n" + "Magnesium: 27.1mg\n" + "Iron: 0.8mg"));
                fruits.add(new Fruits(15, "Guava", "https://images.unsplash.com/photo-1600659090872-74ca5ca1023a?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 37\n" + "Water: g\n" + "Protein: 0g\n" + "Carbs: 8g\n" + "Sugar: 5.0g\n" + "Fat: 0.5g\n" + "Fiber: 3g\n" + "Sodium: 1mg"));
                fruits.add(new Fruits(16, "Papaya", "https://cdn.pixabay.com/photo/2018/09/03/19/08/papaya-3652074_1280.jpg", "Calories: 43\n" + "Water: 88.1g\n" + "Protein: 0.47g\n" + "Carbs: 10.8g\n" + "Sugar: 7.82g\n" + "Fiber: 1.7g\n" + "Fat: 0.26g"));
                fruits.add(new Fruits(17, "Pineapple", "https://cdn.pixabay.com/photo/2015/02/14/18/10/pineapple-636562_1280.jpg", "Calories: 50\n" + "Water: 88.1g\n" + "Protein: 0.47g\n" + "Carbs: 13g\n" + "Sugar: 10g\n" + "Fiber: 1.4g\n" + "Fat: 0.1g\n" + "Potassium: 109mg\n" + "Sodium: 1mg"));
                fruits.add(new Fruits(18, "Cantaloupe", "https://cdn.pixabay.com/photo/2014/07/08/14/17/muskmelons-387466_1280.jpg", "Calories: 34\n" + "Protein: 0.8g\n" + "Carbs: 8g\n" + "Sugar: 8g\n" + "Fiber: 0.9g\n" + "Fat: 0.2g\n" + "Potassium: 267mg\n" + "Sodium: 16mg"));
                fruits.add(new Fruits(19, "Litchi", "https://cdn.pixabay.com/photo/2020/07/04/06/11/lychee-5368361_1280.jpg", "Calories: 66\n" + "Protein: 0.83g\n" + "Carbs: 16.5g\n" + "Sugar: 15.2g\n" + "Fiber: 1.3g\n" + "Fat: 0.44g\n" + "Vitamin C: 71.5mg"));
                fruits.add(new Fruits(20, "Mangosteen", "https://cdn.pixabay.com/photo/2015/06/16/12/00/mangosteen-811154_1280.jpg", "Calories: 143\n" + "Protein: 1g\n" + "Carbs: 35g\n" + "Fiber: 3.5g\n" + "Fat: 1g\n" + "Copper: 0.135mg\n" + "Manganese: 0.2mg\n" + "Folate: 61mcg"));
                fruits.add(new Fruits(21, "Blackberry", "https://cdn.pixabay.com/photo/2015/11/16/13/49/blackberries-1045728_1280.jpg", "Calories: 43\n" + "Protein: 1.4g\n" + "Carbs: 10g\n" + "Fiber: 5g\n" + "Fat: 0.5g\n" + "Sugar: 4.9g\n" + "Potassium: 162mg"));
                fruits.add(new Fruits(22, "Watermelon", "https://images.unsplash.com/photo-1622208489373-1fe93e2c6720?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 30\n" + "Protein: 0.6g\n" + "Carbs: 8g\n" + "Fiber: 0.4g\n" + "Fat: 0.2g\n" + "Sugar: 6g\n" + "Potassium: 112mg"));
                fruits.add(new Fruits(23, "Jackfruit", "https://images.unsplash.com/photo-1624711078028-19ed36a91f02?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 302\n" + "Protein: 2.74g\n" + "Carbs: 14.01g\n" + "Fiber: 3.62g\n" + "Fat: 0.15g\n" + "Sodium: 1.62mg"));
                fruits.add(new Fruits(24, "Peach", "https://images.unsplash.com/photo-1639588473831-dd9d014646ae?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 39\n" + "Water: 88.9g\n" + "Protein: 0.91g\n" + "Carbs: 9.54g\n" + "Fiber: 1.5g\n" + "Fat: 0.25g\n" + "Sugar: 8.39g\n" + "Calcium: 4mg"));
                fruits.add(new Fruits(25, "Apricot", "https://images.unsplash.com/photo-1627931754115-478ed65b4fef?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 348\n" + "Protein: 4.1g\n" + "Carbs: 58g\n" + "Sugar: 58g\n" + "Fiber: 9.9g\n" + "Fat: 0.6g\n" + "Sodium: <0.02mg\n" + "Iron: 5.18mg"));
                fruits.add(new Fruits(26, "Cranberry", "https://images.unsplash.com/photo-1641333839658-d0f584a3ddc7?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 46\n" + "Protein: 0.4g\n" + "Carbs: 12.2g\n" + "Sugar: 4g\n" + "Fiber: 4.6g\n" + "Fat: 0.1g"));
                fruits.add(new Fruits(27, "Lemon", "https://images.unsplash.com/photo-1587496679742-bad502958fbf?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDN8fHxlbnwwfHx8fHw%3D", "Calories: 29\n" + "Protein: 1.1g\n" + "Carbs: 9g\n" + "Sugar: 2.5g\n" + "Fiber: 2.8g\n" + "Fat: 0.3g"));
                fruits.add(new Fruits(28, "Custard Apple", "https://images.unsplash.com/photo-1650192578609-a6c304d34965?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 101\n" + "Protein: 0.83g\n" + "Carbs: 25.3g\n" + "Fiber: 2.5g\n" + "Fat: 0.7g\n" + "Vitamin C: 19.2mg"));
                fruits.add(new Fruits(29, "Mulberry", "https://img.freepik.com/free-photo/fresh-mulberrys-dark-surface_1150-42169.jpg?size=626&ext=jpg&ga=GA1.1.464864005.1703865873&semt=sph", "Calories: 329\n" + "Protein: 4.2g\n" + "Carbs: 36.9g\n" + "Sugar: 37.7g\n" + "Fiber: 5g\n" + "Fat: 1.5g\n" + "Sodium: 0.079g\n" + "Vitamin C: 33mg"));
                fruits.add(new Fruits(30, "Rambutan", "https://cdn.pixabay.com/photo/2019/07/26/09/18/rambutan-4364311_1280.jpg", "Calories: 73.1\n" + "Protein: 0.6g\n" + "Carbs: 16.8g\n" + "Sugar: 8.0g\n" + "Zinc: 0.5mg\n" + "Calcium: 8.6mg\n" + "Iron: 0/3mg"));

                appDatabase.fruitsDao().insertAllFruit(fruits);
                List<Fruits> fruitsFromDb = appDatabase.fruitsDao().getAllFruits();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setFruitList(fruitsFromDb);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        })).start();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(fruits);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void filter(String searchText) {
        List<Fruits> filteredList = new ArrayList<>();

        for (Fruits fruit : fruits) {
            if (fruit.getFruit_name().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(fruit);
            }
        }
        adapter.setFruitList(filteredList);
    }
}
