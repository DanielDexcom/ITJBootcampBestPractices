package com.example.itjbootcampbestpractices.utils

import android.content.Context
import java.io.InputStream

open class RawFileReader(val context: Context) : ProjectFilesReader(context) {
    override fun readFileWithId(rawId: Int): InputStream {
        return context.resources.openRawResource(rawId)
    }
}