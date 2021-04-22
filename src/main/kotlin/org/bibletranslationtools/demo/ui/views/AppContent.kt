package org.bibletranslationtools.demo.ui.views

import javafx.application.Platform
import javafx.beans.property.SimpleObjectProperty
import javafx.geometry.Side
import javafx.util.Duration
import org.controlsfx.control.HiddenSidesPane
import tornadofx.*
import kotlin.reflect.KClass

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

    private val openDrawer = SimpleObjectProperty<KClass<UIComponent>>()
    private val duration = 100.0

    override val root = HiddenSidesPane().apply {
        // we cannot do content<Workspace>() because HiddenSidesPane comes
        // from controlsfx, and thus extension methods necessary do not exist
        // in tornadofx like they do with borderpane.
        content = workspace.root
        triggerDistance = 0.0

        animationDuration = Duration.millis(duration)
        animationDelay = Duration.ZERO

        subscribe<DrawerEvent<UIComponent>> {
            pinnedSide = Side.LEFT
            hide()

            if (openDrawer.value != it.type) {
                Thread {
                    Thread.sleep(duration.toLong())
                    Platform.runLater {
                        left = find(it.type).root
                        openDrawer.set(it.type)
                        show(Side.LEFT)
                    }
                }.start()
            } else {
                openDrawer.set(null)
            }
        }
    }
}
