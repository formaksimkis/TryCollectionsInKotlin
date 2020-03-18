package com.harman.trykotlin.helper

import java.util.Properties

interface IFileReaderService {
    fun readFromFileToString(filename: String): String?
}