package org.bibletranslationtools.demo

import tornadofx.*

class NewApp {
    companion object {
        @JvmStatic fun main(args : Array<String>) {
            launch<DemoApp>()
        }
    }
}
