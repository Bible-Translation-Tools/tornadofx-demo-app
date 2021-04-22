package org.bibletranslationtools.demo.ui.views

import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import org.kordamp.ikonli.javafx.FontIcon
import org.kordamp.ikonli.materialdesign.MaterialDesign
import tornadofx.*
import kotlin.reflect.KClass

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
inline fun <reified T: UIComponent> DrawerEvent() = DrawerEvent(T::class)
class DrawerEvent<T: UIComponent>(val type: KClass<T>): FXEvent()

class DrawerPage1: Fragment() {
    override val root = vbox {
        prefWidth = 400.0
        paddingAll = 10.0
        hbox {
            label("Drawer Page 1")
            region { hgrow = Priority.ALWAYS }
            button {
                graphic = FontIcon(MaterialDesign.MDI_CLOSE)
                action { collapse() }
            }
        }
        style {
            backgroundColor += Color.WHITE
        }
    }
    private fun collapse() {
        fire(DrawerEvent(this::class))
    }
}

class DrawerPage2: Fragment() {
    override val root = vbox {
        prefWidth = 400.0
        paddingAll = 10.0
        hbox {
            label("Drawer Page 2")
            region { hgrow = Priority.ALWAYS }
            button {
                graphic = FontIcon(MaterialDesign.MDI_CLOSE)
                action { collapse() }
            }
        }
        style {
            backgroundColor += Color.WHITE
        }
    }
    private fun collapse() {
        fire(DrawerEvent(this::class))
    }
}
