package org.bibletranslationtools.demo.controls.skins

import javafx.scene.control.Button
import javafx.scene.control.SkinBase
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import org.bibletranslationtools.demo.controls.ChapterCard
import tornadofx.add
import tornadofx.button

class SmallScreenChapterCardSkin(chapterCard: ChapterCard): SkinBase<ChapterCard>(chapterCard) {
    init {
        children.clear()
        children.add(
            VBox().apply {
                prefWidth = 300.0
                prefHeight = 300.0


                add(Button("Small Button"))
                add(Button("Small Button"))

                styleClass.setAll(skinnable.styleClass)
            }
        )
    }
}
