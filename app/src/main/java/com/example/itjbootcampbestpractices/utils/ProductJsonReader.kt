package com.example.itjbootcampbestpractices.utils

import com.example.itjbootcampbestpractices.R
import com.example.itjbootcampbestpractices.models.RawProduct
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ProductJsonReader(private val fileReader: ProjectFilesReader): JsonReader<List<RawProduct>> {
    override fun getObjectFromJson(): List<RawProduct> {
        val jsonStr = getJsonString()
        val product = Json.decodeFromString<List<RawProduct>>(jsonStr)
        return product
    }

    private fun getJsonString(): String {
        val inputStream = fileReader.readFileWithId(R.raw.products)
        return String(inputStream.readBytes())
    }
}