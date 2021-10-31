package com.example.itjbootcampbestpractices.shoppingcard

class USTaxService: TaxService() {
    override fun getTaxForRegion(region: String): Double {
        when (region) {
            WEST -> return 0.10
            SOUTH -> return 0.20
            NORTH -> return 0.30
            EAST -> return 0.10
        }
        return 0.0
    }

}