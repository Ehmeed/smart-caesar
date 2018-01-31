package com.xhruba08.controller

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class DecryptController : Controller() {
    val resultProperty = SimpleStringProperty()
    var result : String by resultProperty

    fun decrypt(message : String, smartDecrypt : Boolean) {
        val possibilities : MutableList<String> = mutableListOf()

        (0 until AlphabetController.alphabet.length).mapTo(possibilities) { index ->
            message.filter { AlphabetController.alphabet.contains(it) }
                    .map { c -> (AlphabetController.alphabet.indexOfFirst { it == c } + index) % AlphabetController.alphabet.length }
                    .map { AlphabetController.alphabet[it] }
                    .joinToString("")
        }
        if(smartDecrypt) {
            smartDecrypt(possibilities)
        }
        result = possibilities.joinToString("\n")
    }

    private fun smartDecrypt(possibilities: MutableList<String>) {

    }
}
