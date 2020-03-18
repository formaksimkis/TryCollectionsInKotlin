package com.harman.trykotlin.service

import com.harman.trykotlin.helper.Direction

interface ITextStatisticsAnalyzer {
    fun countSumLenghtOfWords(): Int
    fun countNumberOfWords(): Int
    fun countNumberOfUniqWords(): Int
    fun getUniqWords(): List<String>
    fun mapOfWordsRepetitions(): Map<String, Int>
    fun sortWordsByLength(direction: Direction): List<String>
}