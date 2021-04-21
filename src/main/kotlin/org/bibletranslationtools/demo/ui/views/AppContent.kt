package org.bibletranslationtools.demo.ui.views

import javafx.beans.property.SimpleObjectProperty
import javafx.geometry.Side
import org.controlsfx.control.HiddenSidesPane
import tornadofx.*

/**
 *                              App Content
 *
 * This is the viewport into the part of the application that is not made up of
 * persistent UI (as in, this is the part that changes). For the most part, this
 * can be accomplished with just a Workspace, however we need to put it inside a
 * HiddenSidesPane to allow a drawer that comes in from the side of the Workbook
 * but not the side of the Window (since the AppBar is on the left).
 *
 * If the AppBar is not on the left, and a drawer is desired on the left, a
 * JFXDrawer would work and this is unnecessary.
 */
class AppContent: View() {

    val openDrawer = SimpleObjectProperty<Class<UIComponent>>()
    val drawer: AppDrawer by inject()

    override val root = HiddenSidesPane().apply {
        left = drawer.root
        // we cannot do content<Workspace>() because HiddenSidesPane comes
        // from controlsfx, and thus extension methods necessary do not exist
        // in tornadofx like they do with borderpane.
        content = workspace.root

        subscribe<DrawerEvent<UIComponent>> {
            // only hide if the drawer is open and the page wasn't changed
            pinnedSide = if (openDrawer.value == it.type) {
                openDrawer.set(null)
                hide()
                null
            } else {
                openDrawer.set(it.type)
                show(Side.LEFT)
                Side.LEFT
            }
        }
    }
}
