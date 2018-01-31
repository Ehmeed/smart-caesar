package com.xhruba08.controller


import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class EncryptController : Controller() {
    val resultProperty = SimpleStringProperty()
    var result : String by resultProperty

    fun encrypt(message : String, shift : Int) {
        result = message.filter { AlphabetController.alphabet.contains(it) }
                .map { c -> (AlphabetController.alphabet.indexOfFirst { it == c } + Math.abs(shift)) % AlphabetController.alphabet.length }
                .map { AlphabetController.alphabet[it] }
                .joinToString("")
    }
}
