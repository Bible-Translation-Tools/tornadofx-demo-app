package org.bibletranslationtools.demo.controls.skins

import javafx.scene.control.SkinBase
import javafx.scene.layout.FlowPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import org.bibletranslationtools.demo.controls.ChapterCard
import tornadofx.button

class LargeScreenChapterCardSkin(chapterCard: ChapterCard): SkinBase<ChapterCard>(chapterCard) {
    init {
        children.clear()
        children.add(
            FlowPane().apply {
                prefWidth = 800.0
                prefHeight = 800.0

                button("Large Button") {
                    setPrefSize(200.0, 200.0)
                    setOnAction {
                        println(skinnable.stuffProperty().value)
                    }
                }
                button("Large Button") { setPrefSize(200.0, 200.0) }
                button("Large Button") { setPrefSize(200.0, 200.0) }
                button("Large Button") { setPrefSize(200.0, 200.0) }

                styleClass.setAll(skinnable.styleClass)
            }
        )
    }
}
