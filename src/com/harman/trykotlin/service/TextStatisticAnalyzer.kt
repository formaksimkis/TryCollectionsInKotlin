package com.harman.trykotlin.service

import com.harman.trykotlin.helper.Direction
import java.util.*
import java.util.regex.Pattern
import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.collections.HashMap

class TextStatisticAnalyzer(text: String): ITextStatisticsAnalyzer {
    private val allWordsList: List<String>

    init {
        allWordsList = Pattern.compile("\\W+")
            .splitAsStream(text)
            .collect(Collectors.toList())

    }
    override fun countSumLenghtOfWords(): Int =
        allWordsList.stream().flatMapToInt {
                o -> IntStream.of(o.length)
        }.sum()

    override fun countNumberOfWords(): Int = allWordsList.size

    override fun countNumberOfUniqWords(): Int = getUniqWords().size

    override fun getUniqWords(): List<String> = allWordsList.stream().distinct().collect(Collectors.toList())

    override fun mapOfWordsRepetitions(): Map<String, Int> {
        val eachWordCountMap: MutableMap<String, Int> = HashMap()
        allWordsList.stream().forEach { o -> eachWordCountMap.put(o, eachWordCountMap.getOrDefault(o, 0) + 1) }
        return eachWordCountMap
    }

    override fun sortWordsByLength(direction: Direction): List<String> = if(direction.equals(Direction.ASC))
        allWordsList.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()) else
        allWordsList.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList())

}