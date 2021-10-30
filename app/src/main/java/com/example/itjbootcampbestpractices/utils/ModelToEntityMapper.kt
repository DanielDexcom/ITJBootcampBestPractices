package com.example.itjbootcampbestpractices.utils

import com.example.itjbootcampbestpractices.models.RawProduct
import com.example.itjbootcampbestpractices.persistance.entities.Category
import com.example.itjbootcampbestpractices.persistance.entities.Product
import com.example.itjbootcampbestpractices.persistance.entities.ProductWithCategory

class ModelToEntityMapper {
    companion object {
        fun mapProductToProductWithCategory(rawProduct: RawProduct): ProductWithCategory {
            val entityProduct = Product(
                rawProduct.sku,
                rawProduct.name,
                rawProduct.type,
                rawProduct.price,
                rawProduct.upc,
                rawProduct.shipping,
                rawProduct.description,
                rawProduct.manufacturer,
                rawProduct.model,
                rawProduct.url,
                rawProduct.image
            )

            val entityCategories = ArrayList<Category>()
            rawProduct.category.forEach {
                val entityCategory = Category(it.id, it.name)
                entityCategories.add(entityCategory)
            }
            return ProductWithCategory(entityProduct, entityCategories)
        }
    }
}