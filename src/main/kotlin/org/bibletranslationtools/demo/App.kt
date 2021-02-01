package org.bibletranslationtools.demo

import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.layout.Priority
import javafx.scene.paint.Paint
import javafx.stage.Stage
import javafx.stage.StageStyle
import tornadofx.*
import kotlin.concurrent.thread

fun main() {
    launch<DemoApp>()
}

class DemoApp : App(RootView::class) {
    init {

    }

    override fun start(stage: Stage) {
        super.start(stage)
        stage.isMaximized = true
        find<SplashScreen>().openModal(StageStyle.UNDECORATED)
    }

    override fun shouldShowPrimaryStage(): Boolean {
        return false
    }
}

class RootView : View() {

    val appBar = find(AppBar::class)

    override val root = stackpane {
        hbox {
            add(appBar)
            add(
                workspace.root.apply {
                   // hgrow = Priority.ALWAYS
                }
            )
        }

        style {
            backgroundColor += Paint.valueOf("#FF0000")
        }
    }

    override fun onDock() {
        workspace.dock<HomePage>()
    }
}

class AppBar : View() {
    override val root = region {
        prefWidth = 50.0

        style {
            backgroundColor += Paint.valueOf("#000055")
        }
    }
}

class Page2 : View() {
    override val root = region {
        style {
            backgroundColor += Paint.valueOf("555500")
        }
    }
}

class HomePage : View() {
    override val root = region {

        button("Dock a new View") {
            action {
                val page2 = find(Page2::class)
                workspace.dock(page2)
            }
        }

        style {
            backgroundColor += Paint.valueOf("#005500")
        }
    }
}

class SplashScreen : View() {
    override val root = stackpane {
        setPrefSize(300.0, 100.0)
        label("Loading...")
    }

    override fun onDock() {
        thread {
            Thread.sleep(2000)
            runLater {
                close()
                primaryStage.show()
            }
        }
    }
}
