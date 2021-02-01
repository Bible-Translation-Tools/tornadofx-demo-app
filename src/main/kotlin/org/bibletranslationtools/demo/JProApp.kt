package org.bibletranslationtools.demo

import com.jpro.webapi.JProApplication
import javafx.stage.Stage

class JProApp : JProApplication() {
    val app = DemoApp()

    override fun start(primaryStage: Stage) {
        app.start(primaryStage)
    }

    override fun stop() {
        app.stop()
        super.stop()
    }
}
