package org.bibletranslationtools.demo.ui.views

import javafx.scene.paint.Color
import tornadofx.*

/**
 *                            App Drawer
 *
 *  This shows an example of creating an app drawer with various pages.
 *  The Drawer is created as a View (Singleton) and is responsible for
 *  displaying the proper page in the drawer. We listen for our defined
 *  DrawerEvent which contains a DrawerPage enum. We implement the pages
 *  as Fragments, so we find the DrawerPage corresponding to the enum,
 *  and get its root node. Then, we replace the children of the AppDrawer
 *  with the new page.
 *
 *  Before replacing the children, we set the pref size so that the height
 *  and width of the incoming page will fill out the size allocated to the drawer.
 */
class AppDrawer(): View() {
    override val root = region {
        add<DrawerPage1>()
        subscribe<DrawerEvent> {
            val content = when (it.page) {
                DrawerPage.DRAWER_PAGE_1 -> find<DrawerPage1>().root
                DrawerPage.DRAWER_PAGE_2 -> find<DrawerPage2>().root
            }
            content.setPrefSize(width, height)
            replaceChildren(content)
        }
    }
}

enum class DrawerPage {
    DRAWER_PAGE_1,
    DRAWER_PAGE_2
}

class DrawerEvent(val page: DrawerPage): FXEvent()

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
