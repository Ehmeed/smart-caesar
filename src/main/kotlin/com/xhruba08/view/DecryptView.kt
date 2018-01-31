package com.xhruba08.view

import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import tornadofx.*

class DecryptView : View("My View") {
    override val root = vbox {
        form {
            fieldset("Decrypt", labelPosition = Orientation.VERTICAL) {
                textfield()
                checkbox("Smart decrypt") {
                    style {
                        paddingAll = 5
                        fontWeight = FontWeight.BOLD
                    }
                }
                vbox {
                    alignment = Pos.CENTER
                    paddingAll = 5
                    button("Decrypt!") {
                        style {
                            fontWeight = FontWeight.BOLD
                        }
                    }
                }
            }
        }
        label("TODO") {
            style {
                useMaxWidth = true
                textAlignment = TextAlignment.CENTER
                alignment = Pos.CENTER
                fontWeight = FontWeight.BOLD
                paddingBottom = 8
            }
        }
    }
}
