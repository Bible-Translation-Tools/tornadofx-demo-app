package org.bibletranslationtools.demo.ui.views

import com.guigarage.responsive.ResponsiveHandler
import javafx.geometry.Pos
import javafx.scene.paint.Paint
import javafx.stage.StageStyle
import org.bibletranslationtools.demo.ui.listdemo.ListDemoView
import org.bibletranslationtools.demo.ui.viewmodels.HomePageViewModel
import org.bibletranslationtools.demo.utils.rootView
import tornadofx.*
import java.lang.Exception

class HomePage : View() {

    val viewModel: HomePageViewModel by inject()

    override val root = vbox {

        alignment = Pos.CENTER

        button("Grid View") {
            action {
                workspace.dock<GridPage>()
            }
        }
        button("Media Query View") {
            action {
                workspace.dock<MediaQueryPage>()
            }
        }
        button("Demo List View") {
            action {
                workspace.dock<ListDemoView>()
            }
        }

        style {
            backgroundColor += Paint.valueOf("#005500")
        }
    }
}
