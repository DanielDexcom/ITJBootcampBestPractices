package com.example.itjbootcampbestpractices.utils

import android.content.Context
import java.io.InputStream

abstract class ProjectFilesReader(context: Context) {
    abstract fun readFileWithId(int: Int): InputStream
}