package com.example.itjbootcampbestpractices.persistance.database

import com.example.itjbootcampbestpractices.models.RawProduct
import com.example.itjbootcampbestpractices.utils.JsonReader
import com.example.itjbootcampbestpractices.utils.ModelToEntityMapper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DatabasePopulator(
    private val database: AppDatabase,
    private val reader: JsonReader<List<RawProduct>>) {

    fun populateProductsTable() {
        val products = reader.getObjectFromJson()
        products.forEach {
            val productWithCategories = ModelToEntityMapper.mapProductToProductWithCategory(it)
            GlobalScope.launch {
                database.productDao().insertProductWithCategory(productWithCategories)
            }
        }
    }
}