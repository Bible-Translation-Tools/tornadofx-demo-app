package org.bibletranslationtools.demo.ui

import com.guigarage.responsive.ResponsiveHandler
import javafx.stage.Stage
import javafx.stage.StageStyle
import org.bibletranslationtools.demo.di.DaggerAppDependencyGraphComponent
import org.bibletranslationtools.demo.ui.views.RootView
import org.bibletranslationtools.demo.ui.views.SplashScreen
import tornadofx.*


fun main() {
    launch<DemoApp>()
}

class DemoApp : App(RootView::class) {
    val doWorkComponent = DaggerAppDependencyGraphComponent.builder().build()

    override fun start(stage: Stage) {
        super.start(stage)
        ResponsiveHandler.addResponsiveToWindow(stage)
        stage.isMaximized = true
        stage.scene.window.setOnCloseRequest {
            println("here")
           // it.consume()
        }
        find<SplashScreen>().openModal(StageStyle.UNDECORATED)
    }

    override fun shouldShowPrimaryStage(): Boolean {
        return false
    }
}
