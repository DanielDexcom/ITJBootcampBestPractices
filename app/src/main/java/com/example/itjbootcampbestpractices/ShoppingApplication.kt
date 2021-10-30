package com.example.itjbootcampbestpractices

import android.app.Application
import android.util.Log
import com.example.itjbootcampbestpractices.persistance.database.DatabaseManager
import com.example.itjbootcampbestpractices.persistance.database.DatabasePopulator
import com.example.itjbootcampbestpractices.repositories.ProductsRepository
import com.example.itjbootcampbestpractices.utils.ProductJsonReader
import com.example.itjbootcampbestpractices.utils.RawFileReader
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ShoppingApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // Intialize Database
        DatabaseManager.instance.initializeDb(applicationContext)
        // Read JSON
        val fileReader = RawFileReader(applicationContext)
        val productJsonReader = ProductJsonReader(fileReader)
        //Populate DB
        val databasePopulator = DatabasePopulator(DatabaseManager.instance.database, productJsonReader)
        val job = GlobalScope.launch {
            databasePopulator.populateProductsTable()
        }
        //Create repository
        val productsRepository = ProductsRepository()
        // Log records
        job.invokeOnCompletion {
            if (it == null) {
                GlobalScope.launch {
                    val products = productsRepository.getProductsWithCategory()
                    products.collect {
                        Log.d("Count Products", it.count().toString())
                    }
                }
            }
        }
    }
}