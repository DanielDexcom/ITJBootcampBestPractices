package com.example.itjbootcampbestpractices.mocks

import com.example.itjbootcampbestpractices.persistance.entities.Category
import com.example.itjbootcampbestpractices.persistance.entities.Product
import com.example.itjbootcampbestpractices.persistance.entities.ProductWithCategory

class MockData {

    fun getsProductsWithCategoryTotalPriceLessThanOneHoundred(): List<ProductWithCategory> {
        val product1 = createProduct(
            1000,
            name = "Xbox One X",
            type = "Console",
            price = 60.0,
            shipping = 1.0f
        )
        val product2 = createProduct(
            2000,
            name = "PS5",
            type = "Console",
            price = 20.0,
            shipping = 1.0f
        )
        val product3 = createProduct(
            3000,
            name = "Switch",
            type = "Console",
            price = 5.0,
            shipping = 0.0f
        )

        val category = createCategory("123abc", "Console")
        val categoryList = arrayListOf(category)

        val productWithCategory1 = createProductWithCategory(product1, categoryList)
        val productWithCategory2 = createProductWithCategory(product2, categoryList)
        val productWithCategory3 = createProductWithCategory(product3, categoryList)

        return arrayListOf(productWithCategory1, productWithCategory2, productWithCategory3)
    }

    fun getsProductsWithCategory(): List<ProductWithCategory> {
        val product1 = createProduct(
            1000,
            name = "Xbox One X",
            type = "Console",
            price = 500.0,
            shipping = 1.0f
        )
        val product2 = createProduct(
            2000,
            name = "PS5",
            type = "Console",
            price = 600.0,
            shipping = 1.0f
        )
        val product3 = createProduct(
            3000,
            name = "Switch",
            type = "Console",
            price = 200.0,
            shipping = 0.0f
        )

        val category = createCategory("123abc", "Console")
        val categoryList = arrayListOf(category)

        val productWithCategory1 = createProductWithCategory(product1, categoryList)
        val productWithCategory2 = createProductWithCategory(product2, categoryList)
        val productWithCategory3 = createProductWithCategory(product3, categoryList)

       return arrayListOf(productWithCategory1, productWithCategory2, productWithCategory3)
    }

    fun createProductWithCategory(product: Product, category: List<Category>): ProductWithCategory {
        return ProductWithCategory(product, category)
    }

    fun createCategory(
        id: String,
        name: String
    ): Category {
        return Category(id, name)
    }

    fun createProduct(
        sku: Int = 0,
        name: String = "",
        type: String = "",
        price: Double = 0.0,
        upc: String = "",
        shipping: Float = 0.0f,
        description: String = "",
        manufacturer: String = "",
        model: String = "",
        url: String = "",
        image: String = ""
    ): Product {
        return Product(sku, name, type, price, upc, shipping, description, manufacturer, model, url, image)
    }
}