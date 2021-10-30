package com.example.itjbootcampbestpractices.utils

interface JsonReader<Type> {
    fun getObjectFromJson(): Type
}