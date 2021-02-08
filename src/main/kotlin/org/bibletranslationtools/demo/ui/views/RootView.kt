package org.bibletranslationtools.demo.ui.views

import javafx.beans.property.SimpleBooleanProperty
import javafx.scene.paint.Paint
import tornadofx.*

class RootView : View() {

    val enableOverlayProperty = SimpleBooleanProperty(false)

    override val root = stackpane {
        borderpane {
            left<AppBar>()
            center<Workspace>()
        }
        region {
            prefWidth = 1000.0
            prefHeight = 1000.0
            visibleProperty().bind(enableOverlayProperty)
            visibleProperty().onChange {
                println("should be visible")
            }
            style { backgroundColor += Paint.valueOf("000000aa") }
        }
        style {
            backgroundColor += Paint.valueOf("#FF0000")
        }
    }

    override fun onDock() {
        workspace.dock<HomePage>()
    }
}
