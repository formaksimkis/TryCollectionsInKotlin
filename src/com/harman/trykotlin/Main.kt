package com.harman.trykotlin

import com.harman.trykotlin.helper.Direction
import com.harman.trykotlin.helper.FileReaderService
import com.harman.trykotlin.service.TextStatisticAnalyzer


fun main() {
    val file = FileReaderService()
    val text: String? = file.readFromFileToString("sample-text.txt")
    val textAnalyzer = TextStatisticAnalyzer(text!!)
    println(textAnalyzer.countNumberOfWords())
    println(textAnalyzer.countNumberOfUniqWords())
    println(textAnalyzer.countSumLenghtOfWords())
    println(textAnalyzer.getUniqWords())
    println("---------------------------------------------------------------")
    println(textAnalyzer.mapOfWordsRepetitions())
    println("---------------------------------------------------------------")
    println(textAnalyzer.sortWordsByLength(Direction.ASC))
    println("---------------------------------------------------------------")
    println(textAnalyzer.sortWordsByLength(Direction.DESC))
}