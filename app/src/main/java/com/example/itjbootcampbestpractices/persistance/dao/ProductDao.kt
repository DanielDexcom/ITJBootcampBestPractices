package com.example.itjbootcampbestpractices.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.itjbootcampbestpractices.persistance.entities.Product
import com.example.itjbootcampbestpractices.persistance.entities.ProductCategoryCrossReference
import com.example.itjbootcampbestpractices.persistance.entities.ProductWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ProductDao {
    @Insert
    public abstract fun insertProduct(product: Product)

    @Insert
    public abstract fun insertProductCategoryCrossReference(productCategoryCrossReference: ProductCategoryCrossReference)

    public fun insertProductWithCategory(productWithCategory: ProductWithCategory) {
        val categories = productWithCategory.category
        categories.forEach {
            val crossRef = ProductCategoryCrossReference(it.id, productWithCategory.product.sku)
            insertProductCategoryCrossReference(crossRef)
        }
        insertProduct(productWithCategory.product)
    }

    @Transaction
    @Query("SELECT * FROM Product")
    abstract fun getProductsWithCategory(): Flow<List<ProductWithCategory>>
}