package com.example.itjbootcampbestpractices.persistance.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.itjbootcampbestpractices.persistance.dao.CategoryDao
import com.example.itjbootcampbestpractices.persistance.dao.ProductDao
import com.example.itjbootcampbestpractices.persistance.entities.Category
import com.example.itjbootcampbestpractices.persistance.entities.Product
import com.example.itjbootcampbestpractices.persistance.entities.ProductCategoryCrossReference

@Database(entities = [Product::class, Category::class, ProductCategoryCrossReference::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao
}