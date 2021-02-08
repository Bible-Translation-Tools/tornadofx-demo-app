package org.bibletranslationtools.demo.ui

import javafx.scene.paint.Paint
import javafx.stage.Stage
import javafx.stage.StageStyle
import org.bibletranslationtools.demo.di.DaggerDoWorkComponent
import org.bibletranslationtools.demo.ui.viewmodels.DoWorkUseCase
import org.bibletranslationtools.demo.ui.views.RootView
import org.bibletranslationtools.demo.ui.views.SplashScreen
import tornadofx.*
import kotlin.reflect.KClass


fun main() {
    launch<DemoApp>()
}

class DemoApp : App(RootView::class) {

    init {
        val doWorkComponent = DaggerDoWorkComponent.create()
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T {
                return when (type) {
                    DoWorkUseCase::class -> doWorkComponent.injectDoWork() as T
                    else -> null as T
                }
            }
        }
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
