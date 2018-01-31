package com.xhruba08.view

import tornadofx.*

class MainView : View("Smart Caesar") {
    override val root = vbox {
        minWidth = 200.0
        minHeight = 300.0
        add(EncryptView::class)
        add(DecryptView::class)
    }
}