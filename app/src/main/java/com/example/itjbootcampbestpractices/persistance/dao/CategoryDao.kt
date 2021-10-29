package com.example.itjbootcampbestpractices.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.itjbootcampbestpractices.persistance.entities.Category

@Dao
interface CategoryDao {
    @Insert
    fun insertCategory(category: Category)
}