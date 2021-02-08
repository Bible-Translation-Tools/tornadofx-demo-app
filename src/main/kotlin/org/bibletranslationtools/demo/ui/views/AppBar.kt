package org.bibletranslationtools.demo.ui.views

import javafx.scene.paint.Paint
import tornadofx.*

class AppBar : View() {
    override val root = region {
        prefWidth = 50.0

        style {
            backgroundColor += Paint.valueOf("#000055")
        }
    }
}
