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
                fruits.add(new Fruits(7, "Avacado", "https://images.unsplash.com/photo-1601039641847-7857b994d704?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Calories: 160\n" + "Fat: 14.7g\n" + "Sodium: 7mg\n" + "Carbs: 8.5g\n" + "Fiber: 6.7g\n" + "Sugars: 0.7g\n" + "Protein: 2g\n" + "Magnesium: 29mg\n" + "Potassium: 485mg\n" + "Vitamin C: 10mg"));
                fruits.add(new Fruits(8, "Kiwi", "https://images.unsplash.com/photo-1601751911467-f0514d34f3ef?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE5fHx8ZW58MHx8fHx8", "Calories: 90\n" + "Protein: 1g\n" + "Fat: 1g\n" + "Carbs: 21g\n" + "Fiber: 5g\n" + "Sugar: 15g" + "Vitamin C: 56mg" + "Vitamin C: 56mg" + "Potassium: 148mg"));
                fruits.add(new Fruits(9, "Plum", "https://images.unsplash.com/photo-1465120846441-761b22f43328?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDR8fHxlbnwwfHx8fHw%3D", "Calories: 76\n" + "Protein: 1g\n" + "Fat: Less than 1g\n" + "Carbohydrates: 18g\n" + "Fiber: 2g\n" + "Sugar: 16g"));
                fruits.add(new Fruits(10, "Raspberry", "https://images.unsplash.com/photo-1577003833619-76bbd7f82948?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8fHw%3D", "Calories: 64\n" + "Water: 105.0g\n" + "Protein: 1.5g\n" + "Carbs: 9.3g\n" + "Sugar: 5.4g\n" + "Fiber: 8.0g\n" + "Calcium: 30.8mg\n" + "Magnesium: 27.1mg\n" + "Iron: 0.8mg"));
                fruits.add(new Fruits(10, "Raspberry", "https://images.unsplash.com/photo-1577003833619-76bbd7f82948?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8fHw%3D", "Calories: 64\n" + "Water: 105.0g\n" + "Protein: 1.5g\n" + "Carbs: 9.3g\n" + "Sugar: 5.4g\n" + "Fiber: 8.0g\n" + "Calcium: 30.8mg\n" + "Magnesium: 27.1mg\n" + "Iron: 0.8mg"));
                fruits.add(new Fruits(10, "Raspberry", "https://images.unsplash.com/photo-1577003833619-76bbd7f82948?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8fHw%3D", "Calories: 64\n" + "Water: 105.0g\n" + "Protein: 1.5g\n" + "Carbs: 9.3g\n" + "Sugar: 5.4g\n" + "Fiber: 8.0g\n" + "Calcium: 30.8mg\n" + "Magnesium: 27.1mg\n" + "Iron: 0.8mg"));

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
