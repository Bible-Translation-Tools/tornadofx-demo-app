package org.bibletranslationtools.demo.controls.skins

import javafx.scene.control.SkinBase
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import org.bibletranslationtools.demo.controls.ChapterCard
import tornadofx.button

class MediumScreenChapterCardSkin(chapterCard: ChapterCard): SkinBase<ChapterCard>(chapterCard) {

    init {
        children.clear()
        children.add(
            VBox().apply {
                prefWidth = 500.0
                prefHeight = 500.0
                button("Medium Button") {}
                button("Medium Button") {}
                button("Medium Button") {}
                styleClass.setAll(skinnable.styleClass)
            }
        )
    }
}
