package com.candybytes.taco.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.candybytes.taco.vo.Food

/**
 * Interface for database access for Food related operations.
 */
@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsync(food: Food)

    @Query("SELECT * FROM food")
    suspend fun getAllAsync(): List<Food>

    @Query("SELECT * FROM food WHERE description LIKE :searchText")
    suspend fun getSearchResult(searchText: String): List<Food>
}
