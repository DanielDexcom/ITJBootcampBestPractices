package com.example.itjbootcampbestpractices.persistance.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Category(
    @PrimaryKey val id: String,
    val name: String
)