package org.bibletranslationtools.demo.ui.views

import javafx.scene.paint.Color
import tornadofx.*

class AppDrawer(): View() {
    override val root = region {
        add<DrawerPage1>()
        subscribe<DrawerOpenEvent> {
            val content = when (it.page) {
                DrawerPage.DRAWER_PAGE_1 -> find<DrawerPage1>().root
                DrawerPage.DRAWER_PAGE_2 -> find<DrawerPage2>().root
            }
            content.setPrefSize(width, height)
            replaceChildren(content)
        }
    }
}

class DrawerPage1(): Fragment() {
    override val root = region {
        prefWidth = 400.0
        label("Drawer Page 1")
        style {
            backgroundColor += Color.WHITE
        }
    }
}

class DrawerPage2(): Fragment() {
    override val root = region {
        prefWidth = 300.0
        label("Drawer Page 2")
        style {
            backgroundColor += Color.WHITE
        }
    }
}
