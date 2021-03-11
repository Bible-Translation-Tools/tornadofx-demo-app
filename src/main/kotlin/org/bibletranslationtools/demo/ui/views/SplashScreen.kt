package org.bibletranslationtools.demo.ui.views

import com.guigarage.responsive.ResponsiveHandler
import tornadofx.*
import kotlin.concurrent.thread

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
