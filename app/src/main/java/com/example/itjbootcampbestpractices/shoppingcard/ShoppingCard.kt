package com.example.itjbootcampbestpractices.shoppingcard

import com.example.itjbootcampbestpractices.persistance.entities.ProductWithCategory

/*
* 1 - User should be able to add elements to shopping card
* 2- Shopping card should provide the total price of all products
* 3- If no products in shopping card then price is 0
* 4- If price is greater than $100 then no shipping cost shall be applied
* 5- If price is lower than $100 then each product shipping cost is applied
* 6- Tax is applied based on region
* 7- Supported regions are (West, Midwest, Northeast, Southwest, Southeast)
* 8- Region taxes [West = .11, Midwest = .09, Northeast = .11, Southwest = 0.08, Southeast = 0.09]
* 9- If the user has more than $200 in products we provide a coupon of $5
* */
class ShoppingCard(val taxService: TaxService) {

    val MAX_TOTAL_COST_FOR_NO_SHIPPPING = 100
    var products: List<ProductWithCategory>? = null
    // This should be a seperate class that provides the Region something like - RegionProvider
    var region: String = ""

    fun getTotalPrice(): Double {
        if (products.isNullOrEmpty()) {
            return 0.0
        }
        var totalPrice = 0.0
        var shippingPrice = 0.0
        products?.forEach {
            totalPrice += it.product.price
            shippingPrice += it.product.shipping
        }

        if (shouldApplyShipping(totalPrice)) {
            totalPrice += shippingPrice
        }

        totalPrice += totalPrice * taxService.getTaxForRegion(region)

        return  totalPrice
    }

    private fun shouldApplyShipping(totalPrice: Double): Boolean {
        return totalPrice < MAX_TOTAL_COST_FOR_NO_SHIPPPING
    }
}