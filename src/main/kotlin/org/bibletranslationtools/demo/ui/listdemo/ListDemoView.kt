package org.bibletranslationtools.demo.ui.listdemo

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.control.ScrollPane
import javafx.scene.control.SelectionMode
import javafx.scene.control.skin.ListViewSkin
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.layout.Region
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import tornadofx.*
import tornadofx.FX.Companion.stylesheets

class ListDemoView : View() {

    override val root: ScrollPane

    val demoItems = observableListOf<DemoListItemModel>()
    lateinit var listView: ListView<DemoListItemModel>

    var toggle = false

    init {
        val list = arrayListOf<DemoListItemModel>()
        for (i in 0..1_000_000) {
            list.add(DemoListItemModel(i))
        }
        demoItems.setAll(demoItems)

        root = scrollpane {
            vbox {

                hbox {
                    prefHeight = 200.0
                    style {
                        backgroundColor += Color.BLUE
                    }
                    button("select all") {
                        action {
                            toggle = !toggle
                            listView.items.forEach { it.selected = toggle }
                            listView.refresh()
                        }
                    }
                    button("get values") {
                        action {
                            listView.items.forEach {
                                println("${it.number} - ${it.selected}")
                            }
                            print("\n\n\n")
                        }
                    }
                }
                listView = listview {


                    prefHeight = 800.0
                    prefWidth = 900.0

                    setCellFactory { DemoListItemCell() }
                    items.setAll(list)
                }
                listView.refresh()
            }
        }
    }
}

data class DemoListItemModel(
    val number: Int,
    var selected: Boolean = false
)

class DemoListItemCell : ListCell<DemoListItemModel>() {

    val view = DemoListItem()

    override fun updateItem(item: DemoListItemModel?, empty: Boolean) {
        super.updateItem(item, empty)
        if (empty) {
            this.graphic = null
        } else {
            view.modelProperty.set(null)
            view.modelProperty.set(item)
            this.graphic = view
        }
    }
}

class DemoListItem : HBox() {

    val modelProperty = SimpleObjectProperty<DemoListItemModel>()

    init {

        with(this) {
            prefWidth = 500.0
            prefHeight = 50.0
            add(
                checkbox {
                    modelProperty.onChange {
                        it?.let {
                            selectedProperty().set(it.selected)
                        }
                    }
                    selectedProperty().onChange {
                        modelProperty.value.selected = it
                    }
                }
            )
            add(label {
                modelProperty.onChange {
                    println(it?.number.toString())
                    it?.let {
                        textProperty().set(it.number.toString())
                    }
                }
            })

            style {
                backgroundColor += Paint.valueOf("00FF0030")
            }
        }
    }
}

/**
items: list< state of items in listview>

ListViewItem: View of list view state (shows the state to the user, presents interaction between user and underlying state)

ListViewCell: Controller between listview and list items; needs to update the view with the state of the item


items:
[0][1][2][3][][][][][][][][][][][][][][][][][]... lots of items (unique)

listView [ // only 4 items can be shown at a time
^
| [list item 1]
| [list item 2]
| [list item 3]
| [list item 4]
v
]

list cell 0 needs to show list model index 0
list cell 1 needs to show list model index 1
list cell 2 needs to show list model index 2
list cell 3 needs to show list model index 3

list cells: stores list of list item views
[][][][]

Scroll to list item 5:
listView [ // only 4 items can be shown at a time
^
| [list item 2]
| [list item 3]
| [list item 4]
| [list item 5]
v
]

list cell 0 needs to show list model index 1
list cell 1 needs to show list model index 2
list cell 2 needs to show list model index 3
list cell 3 needs to show list model index 4
 */
