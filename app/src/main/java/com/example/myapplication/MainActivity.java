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
                fruits.add(new Fruits(13, "Fig", "https://images.unsplash.com/photo-1608141996069-206d06fc584b?q=80&w=1891&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 37\n" + "Protein: 0g\n" + "Carbs: 10g\n" + "Sugar: 8.0g\n" + "Fiber: 1.45g\n" + "Sodium: 0.5mg"));
                fruits.add(new Fruits(14, "Raspberry", "https://images.unsplash.com/photo-1577003833619-76bbd7f82948?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8fHw%3D", "Calories: 64\n" + "Water: 105.0g\n" + "Protein: 1.5g\n" + "Carbs: 9.3g\n" + "Sugar: 5.4g\n" + "Fiber: 8.0g\n" + "Calcium: 30.8mg\n" + "Magnesium: 27.1mg\n" + "Iron: 0.8mg"));
                fruits.add(new Fruits(15, "Guava", "https://images.unsplash.com/photo-1600659090872-74ca5ca1023a?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 37\n" + "Water: g\n" + "Protein: 0g\n" + "Carbs: 8g\n" + "Sugar: 5.0g\n" + "Fat: 0.5g\n" + "Fiber: 3g\n" + "Sodium: 1mg"));
                fruits.add(new Fruits(16, "Papaya", "https://images.unsplash.com/photo-1552427085-45d07c9e950d?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8fHw%3D", "Calories: 43\n" + "Water: 88.1g\n" + "Protein: 0.47g\n" + "Carbs: 10.8g\n" + "Sugar: 7.82g\n" + "Fiber: 1.7g\n" + "Fat: 0.26g"));
                fruits.add(new Fruits(17, "Pineapple", "https://images.unsplash.com/photo-1550828520-4cb496926fc9?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8cGluZWFwcGxlfGVufDB8fDB8fHww", "Calories: 50\n" + "Water: 88.1g\n" + "Protein: 0.47g\n" + "Carbs: 13g\n" + "Sugar: 10g\n" + "Fiber: 1.4g\n" + "Fat: 0.1g\n" + "Potassium: 109mg\n"+ "Sodium: 1mg"));


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
