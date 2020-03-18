package com.harman.trykotlin.helper

class FileReaderService: IFileReaderService {

    override fun readFromFileToString(fileName: String): String? =
        ClassLoader.getSystemClassLoader().getResourceAsStream(fileName)?.bufferedReader().use { w -> w?.readText() }
}