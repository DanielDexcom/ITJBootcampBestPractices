package com.example.itjbootcampbestpractices.shoppingcard

abstract class TaxService {
    val WEST = "WEST"
    val SOUTH = "SOUTH"
    val NORTH = "NORTH"
    val EAST = "EAST"
    abstract fun getTaxForRegion(region: String): Double
}