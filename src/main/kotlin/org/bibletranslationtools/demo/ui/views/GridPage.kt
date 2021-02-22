package org.bibletranslationtools.demo.ui.views

import com.dukescript.layouts.flexbox.FlexboxLayout
import com.dukescript.layouts.jfxflexbox.FlexBoxPane
import com.guigarage.responsive.DeviceTypeEvent
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.geometry.Orientation
import javafx.geometry.VPos
import javafx.scene.Parent
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import org.tbee.javafx.scene.layout.MigPane
import tornadofx.*

class GridPage : View() {

    override val root = MigPane(
        "align center, debug, flowx",
        "align center, fill",
        "align center, fill",
    )

    val box1 = makeABox("#FF0000", 100.0, 100.0, 100.0, 100.0)
    val box2 = makeABox("#00FF00", 100.0, 100.0, 100.0, 100.0)
    val box3 = makeABox("#0000FF", 100.0, 100.0, 100.0, 100.0)
    val box4 = makeABox("#FFFF00", 100.0, 100.0, 300.0, 800.0)
    val box5 = makeABox("#aaaa00", 100.0, 100.0, 100.0, 200.0)
    val box6 = makeABox("#00aaaa", 100.0, 100.0, 100.0, 200.0)
    val box7 = makeABox("#aaaaaa", 100.0, 100.0, 100.0, 200.0)
    val box8 = makeABox("#aa00aa", 100.0, 100.0, 100.0, 200.0)

    init {

        with(root) {
            vbox {
                fitToParentSize()
                add(
                    FlexBoxPane().apply {
                        prefHeight = 500.0
                        prefWidth = 500.0
                        setFlexDirection(FlexboxLayout.FlexDirection.ROW)
                        setFlexWrap(FlexboxLayout.FlexWrap.WRAP)
                        setAlignContent(FlexboxLayout.AlignContent.SPACE_BETWEEN)
                        add(box1)
                        add(box2)
                        add(box3)

                        style {
                            backgroundColor += Color.AQUA
                        }
                    }
                )

                style {
                    backgroundColor += Color.GREEN
                }

            }
        }
    }
}


fun makeABox(color: String, minW: Double, minH: Double, prefH: Double, prefW: Double): Region {
    return Region().apply {
        hgrow = Priority.ALWAYS
        vgrow = Priority.ALWAYS

        minWidth = minW
        minHeight = minH

        prefHeight = prefH
        prefWidth = prefW

        maxHeight = prefH * 2
        maxWidth = prefW * 2

        style {
            backgroundColor += Paint.valueOf(color)
        }
    }
}


