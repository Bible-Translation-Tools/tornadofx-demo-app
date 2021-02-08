package org.bibletranslationtools.demo.ui.views

import javafx.scene.paint.Paint
import tornadofx.*

class Page2 : View() {

    override val root = region {

        prefWidth = 200.0
        prefHeight = 200.0

        style {
            backgroundColor += Paint.valueOf("555500")
        }
    }
}
