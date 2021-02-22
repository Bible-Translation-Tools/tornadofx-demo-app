package org.bibletranslationtools.demo.ui.views

import com.guigarage.responsive.DeviceTypeEvent
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import org.bibletranslationtools.demo.controls.ChapterCard
import org.tbee.javafx.scene.layout.MigPane
import tornadofx.*

class MediaQueryPage : View() {

    override val root = MigPane("wrap 3, align center, debug", "[nogrid][][nogrid]")

    val box1 = makeABox("#FF0000", 100.0, 100.0, 100.0, 100.0)
    val box2 = makeABox("#00FF00", 100.0, 100.0, 100.0, 100.0)
    val box3 = makeABox("#0000FF", 100.0, 100.0, 100.0, 100.0)
    val box4 = makeABox("#FFFF00", 100.0, 100.0, 300.0, 800.0)
    val box5 = makeABox("#aaaa00", 100.0, 100.0, 100.0, 500.0)
    val box6 = makeABox("#00aaaa", 100.0, 100.0, 100.0, 500.0)
    val box7 = makeABox("#aaaaaa", 100.0, 100.0, 100.0, 500.0)

    val chapterCard: ChapterCard

    init {
        with(root) {
//            add(box1)
//            add(box2)
//            add(box3)
//            add(box4, "span 3")
//            add(box5)
//            add(box6)
//            add(box7)

            chapterCard = ChapterCard()
            add(chapterCard)
            style {
                backgroundColor += Color.WHITE
            }
            layout()
            println(chapterCard.stuffProperty().value)
        }

    }

    fun makeABox(color: String, minW: Double, minH: Double, prefH: Double, prefW: Double): Pane {
        return Pane().apply {
            minWidth = minW
            minHeight = minH
            prefHeight = prefH
            prefWidth = prefW
            style {
                backgroundColor += Paint.valueOf(color)
            }
        }
    }
}

