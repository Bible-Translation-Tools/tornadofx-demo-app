package org.bibletranslationtools.demo.ui.views

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import tornadofx.*

class AppBar : View() {
    override val root = vbox {
        spacing = 5.0
        alignment = Pos.CENTER

        prefWidth = 50.0

        button("1") {
            prefWidth = 40.0
            prefHeight = 40.0

            style {
                backgroundColor += Color.RED
            }
            action {
                fire(DrawerOpenEvent(DrawerPage.DRAWER_PAGE_1))
            }
        }

        button("2") {
            prefWidth = 40.0
            prefHeight = 40.0

            style {
                backgroundColor += Color.GREEN
            }
            action {
                fire(DrawerOpenEvent(DrawerPage.DRAWER_PAGE_2))
            }
        }

        style {
            backgroundColor += Paint.valueOf("#000055")
        }
    }
}

enum class DrawerPage {
    DRAWER_PAGE_1,
    DRAWER_PAGE_2
}

class DrawerOpenEvent(val page: DrawerPage): FXEvent()
