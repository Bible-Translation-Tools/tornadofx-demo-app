package org.bibletranslationtools.demo.ui.views

import javafx.geometry.Pos
import javafx.scene.paint.Paint
import javafx.stage.StageStyle
import org.bibletranslationtools.demo.ui.viewmodels.HomePageViewModel
import org.bibletranslationtools.demo.utils.rootView
import tornadofx.*

class HomePage : View() {

    val viewModel: HomePageViewModel by inject()

    override val root = vbox {

        alignment = Pos.CENTER

        button("Dock a new View") {
            action {
                workspace.dock<Page2>()
            }
        }

        label { textProperty().bind(viewModel.workDoneTextProperty) }
        button("Do work") { action { viewModel.doWork() } }

        label { textProperty().bind(viewModel.returnedTextProperty) }

        button("Launch a View For a Return Value") {
            action {
                (rootView as RootView).enableOverlayProperty.set(true)
                find<Page2>().openModal(
                    StageStyle.DECORATED,
                    resizable = true,
                    block = true
                ).apply {
                    this?.let { println("stage is not null") }
                    this?.setOnCloseRequest {
                        (rootView as RootView).enableOverlayProperty.set(false)
                    }
                }
            }
        }

        style {
            backgroundColor += Paint.valueOf("#005500")
        }
    }
}
