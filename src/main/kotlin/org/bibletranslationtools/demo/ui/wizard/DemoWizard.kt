package org.bibletranslationtools.demo.ui.wizard

import tornadofx.*

class DemoWizard: Wizard() {
    init {
    }

    override fun onCancel() {
        workspace.backButton
    }
}
