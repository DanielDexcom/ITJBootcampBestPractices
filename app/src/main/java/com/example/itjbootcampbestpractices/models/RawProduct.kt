package com.example.itjbootcampbestpractices.models

import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class RawProduct(
    val sku: Int,
    val name: String,
    val type: String,
    val price: Double,
    val upc: String,
    val category: List<Category>,
    val shipping: Float,
    val description: String,
    val manufacturer: String,
    val model: String,
    val url: String,
    val image: String
)

@Serializable
data class Category(
    val id: String,
    val name: String
)