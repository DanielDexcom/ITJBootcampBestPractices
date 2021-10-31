package com.example.itjbootcampbestpractices.repositories

import com.example.itjbootcampbestpractices.persistance.database.DatabaseManager
import com.example.itjbootcampbestpractices.persistance.entities.ProductWithCategory
import kotlinx.coroutines.flow.Flow

class ProductsRepository {
    private val productDao = DatabaseManager.instance.database.productDao()

    suspend fun getProductsWithCategory(): Flow<List<ProductWithCategory>> {
        return productDao.getProductsWithCategory()
    }
}