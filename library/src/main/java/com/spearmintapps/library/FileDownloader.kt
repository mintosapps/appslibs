package com.spearmintapps.library

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

object FileDownloader {

    @Throws(IOException::class)
    private fun readFully(stream: InputStream?): ByteArray {
        val buffer = ByteArray(1024 * 1024)
        val baos = ByteArrayOutputStream()
        var bytesRead: Int
        while (stream!!.read(buffer).also { bytesRead = it } != -1) {
            baos.write(buffer, 0, bytesRead)
        }
        return baos.toByteArray()
    }

    @Throws(IOException::class)
    fun loadFile(sourcePath: String?): ByteArray {
        var inputStream: InputStream? = null
        return try {
            val url = URL(sourcePath)
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.connect()
            inputStream = urlConnection.inputStream
            readFully(inputStream)
        } finally {
            inputStream?.close()
        }
    }
}