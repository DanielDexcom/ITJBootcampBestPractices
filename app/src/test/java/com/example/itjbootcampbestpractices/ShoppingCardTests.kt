package com.example.itjbootcampbestpractices

import com.example.itjbootcampbestpractices.mocks.MockData
import com.example.itjbootcampbestpractices.shoppingcard.ShoppingCard
import com.example.itjbootcampbestpractices.shoppingcard.USTaxService
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ShoppingCardTests {
    lateinit var shoppingCard: ShoppingCard
    lateinit var usTaxService: USTaxService
    @Before
    fun setup() {
        usTaxService = USTaxService()
        shoppingCard = ShoppingCard(usTaxService)
    }

    @Test
    fun testCalculateTotalPriceReturnsZeroIfNoProducts() {
        assertEquals(0.0, shoppingCard.getTotalPrice(), 0.0)
    }

    @Test
    fun testCalculateTotalPrice() {
        shoppingCard.region = usTaxService.EAST
        shoppingCard.products = MockData().getsProductsWithCategory()
        assertEquals(1430.0, shoppingCard.getTotalPrice(), 0.0)
    }

    @Test
    fun testCalculateTotalPriceWithShippingInclude() {
        shoppingCard.region = usTaxService.SOUTH
        shoppingCard.products = MockData().getsProductsWithCategoryTotalPriceLessThanOneHoundred()
        assertEquals(104.4, shoppingCard.getTotalPrice(), 0.0)
    }

}