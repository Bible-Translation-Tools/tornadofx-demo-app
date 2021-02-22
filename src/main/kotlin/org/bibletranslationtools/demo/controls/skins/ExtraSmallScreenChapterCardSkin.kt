package org.bibletranslationtools.demo.controls.skins

import javafx.scene.control.Control
import javafx.scene.control.SkinBase
import javafx.scene.layout.Pane
import org.bibletranslationtools.demo.controls.ChapterCard
import tornadofx.button

class ExtraSmallScreenChapterCardSkin(chapterCard: ChapterCard): SkinBase<ChapterCard>(chapterCard) {
    init {
        children.clear()
        children.add(
            Pane().apply {
                prefWidth = 200.0
                prefHeight = 100.0

                button("Extra Small Button") {}
                styleClass.setAll(skinnable.styleClass)
            }
        )
    }
}
