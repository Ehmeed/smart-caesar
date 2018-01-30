package com.xhruba08.view

import com.xhruba08.app.Styles
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import tornadofx.*

class MainView : View("Smart Caesar") {
    override val root = vbox {
        minWidth = 200.0
        minHeight = 300.0
        form {
            fieldset("Encrypt", labelPosition = Orientation.VERTICAL) {
                textfield()
                hbox {
                    paddingTop = 10
                    alignment = Pos.CENTER_LEFT
                    label("shift") {
                        style {
                            fontWeight = FontWeight.BOLD
                            paddingTop = 3
                        }
                    }
                    textfield() {
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
            }
        }


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
                paddingBottom = 5
            }
        }
    }
}