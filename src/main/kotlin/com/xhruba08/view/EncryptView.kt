package com.xhruba08.view

import com.xhruba08.controller.EncryptController
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import tornadofx.*

class EncryptView : View() {
    val encryptController : EncryptController by inject()
    val message = SimpleStringProperty()
    val shift = SimpleIntegerProperty()

    override val root = vbox {
        form {
            fieldset("Encrypt", labelPosition = Orientation.VERTICAL) {
                textfield(message)
                hbox {
                    paddingTop = 10
                    alignment = Pos.CENTER_LEFT
                    label("shift") {
                        style {
                            fontWeight = FontWeight.BOLD
                            paddingTop = 3
                            paddingRight = 3
                            alignment = Pos.CENTER_LEFT
                        }
                    }
                    textfield(shift) {
                        maxWidth = 30.0
                    }
                }
                vbox {
                    alignment = Pos.CENTER
                    paddingAll = 5
                    button("Encrypt!") {
                        style {
                            fontWeight = FontWeight.BOLD
                        }
                        action {
                            encryptController.encrypt(message.value ?: "", shift.value)
                        }
                    }
                }
            }
        }

        label(encryptController.resultProperty) {
            style {
                useMaxWidth = true
                textAlignment = TextAlignment.CENTER
                alignment = Pos.CENTER
                fontWeight = FontWeight.BOLD
            }
        }
    }
}
