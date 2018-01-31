package com.xhruba08.view

import com.xhruba08.controller.DecryptController
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import tornadofx.*

class DecryptView : View("My View") {
    val decryptController : DecryptController by inject()
    val message = SimpleStringProperty()
    val smartDecrypt = SimpleBooleanProperty()

    override val root = vbox {
        form {
            fieldset("Decrypt", labelPosition = Orientation.VERTICAL) {
                textfield(message)
                checkbox("Smart decrypt", smartDecrypt) {
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
                        action {
                            decryptController.decrypt(message.value ?: "", smartDecrypt.value)
                        }
                    }
                }
            }
        }
        label(decryptController.resultProperty) {
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
