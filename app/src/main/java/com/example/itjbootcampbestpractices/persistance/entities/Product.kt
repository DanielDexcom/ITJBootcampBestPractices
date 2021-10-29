package com.example.itjbootcampbestpractices.persistance.entities

import androidx.room.*

@Entity
data class Product (
    @PrimaryKey val sku: Int,
    val name: String,
    val type: String,
    val price: Double,
    val upc: String,
    val shipping: Float,
    val description: String,
    val manufacturer: String,
    val model: String,
    val url: String,
    val image: String
)

@Entity(primaryKeys = ["sku", "id"])
data class ProductCategoryCrossReference(
    val id: String,
    val sku: Int
)

data class ProductWithCategory(
    @Embedded val product: Product,
    @Relation(
        parentColumn = "sku",
        entityColumn = "id",
        associateBy = Junction(ProductCategoryCrossReference::class)
    )
    val category: List<Category>
)