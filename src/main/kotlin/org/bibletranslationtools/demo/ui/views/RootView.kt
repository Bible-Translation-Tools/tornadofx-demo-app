package org.bibletranslationtools.demo.ui.views

import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class RootView : View() {

    val enableOverlayProperty = SimpleBooleanProperty(false)

    init {
        importStylesheet(resources["/chapter-card.css"])
        importStylesheet(resources["/list-style.css"])
    }

    override val root = stackpane {
        borderpane {
            left<AppBar>()
            center<AppContent>()
        }
    }

    override fun onDock() {
        workspace.dock<HomePage>()
    }
}
