package org.bibletranslationtools.demo.ui.views

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import tornadofx.*

/**
 *                               AppBar
 *
 * The AppBar is a persistent view in the Application that provides globally
 * accessible (context free) features. In our example, we have two buttons that
 * open a page in the App Drawer. These buttons will fire a tornadofx DrawerEvent
 * with an enum for the page to open in the drawer.
 */
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
                fire(DrawerEvent<DrawerPage1>())
            }
        }

        button("2") {
            prefWidth = 40.0
            prefHeight = 40.0

            style {
                backgroundColor += Color.GREEN
            }
            action {
                fire(DrawerEvent<DrawerPage2>())
            }
        }

        style {
            backgroundColor += Paint.valueOf("#000055")
        }
    }
}
