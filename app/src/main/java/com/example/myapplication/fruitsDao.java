package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface fruitsDao {

    @Query("SELECT * FROM fruits")
    List<Fruits> getAllFruits();

//    @Query("INSERT OR REPLACE INTO fruits (fruit_name,image_url,description) VALUES (:name,:imageUrl ,:description)")
//    void insertFruit(String name, String imageUrl, String description);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllFruit(List<Fruits> fruits);

}
