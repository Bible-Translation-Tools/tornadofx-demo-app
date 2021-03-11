package org.bibletranslationtools.demo.ui.views

import javafx.beans.property.SimpleObjectProperty
import javafx.geometry.Side
import javafx.scene.Parent
import org.controlsfx.control.HiddenSidesPane
import tornadofx.View

class AppContent(): View() {

    var openDrawer = SimpleObjectProperty<DrawerPage>()
    val drawer: AppDrawer by inject()

    override val root = HiddenSidesPane().apply {
        left = drawer.root
        content = workspace.root

        subscribe<DrawerOpenEvent> {
            if (openDrawer.value == it.page) {
                openDrawer.set(null)
                hide()
                pinnedSide = null
            } else {
                openDrawer.set(it.page)
                show(Side.LEFT)
                pinnedSide = Side.LEFT
            }
        }
    }

}
