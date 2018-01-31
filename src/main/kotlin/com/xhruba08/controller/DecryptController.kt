package com.xhruba08.controller

import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import org.jsoup.Jsoup

class DecryptController : Controller() {
    val resultProperty = SimpleStringProperty()
    var result : String by resultProperty

    fun decrypt(message : String, smartDecrypt : Boolean) {
        var possibilities : MutableList<String> = mutableListOf()

        (0 until AlphabetController.alphabet.length).mapTo(possibilities) { index ->
            message.filter { AlphabetController.alphabet.contains(it) }
                    .map { c -> (AlphabetController.alphabet.indexOfFirst { it == c } + index) % AlphabetController.alphabet.length }
                    .map { AlphabetController.alphabet[it] }
                    .joinToString("")
        }
        if(smartDecrypt) {
            possibilities = smartDecrypt(possibilities)
        }
        result = possibilities.joinToString("\n")
    }

    private fun smartDecrypt(possibilities: MutableList<String>) : MutableList<String> {
        return possibilities.sortedBy { -getNumberOfOccurences(it.split(" ")) }.toMutableList()
    }

    private fun getNumberOfOccurences(words : List<String>) : Long {
        return words
                .filter { it != "" }
                .map { word ->
                    Jsoup.connect("https://www.google.cz/search?q=" + word).get()
                            .select("div#resultStats")
                            .text()
                            .substringAfter(": ")
                            .substringBefore(" (")
                            .filter { !it.isWhitespace() }
                            .filter { it.isDefined() }
                            .filter { !it.equals(" ") }
                }
                .sumByLong { it.toLongOrNull() ?: 0L }
    }

    public inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
        var sum: Long = 0L
        for (element in this) {
            sum += selector(element)
        }
        return sum
    }


}
