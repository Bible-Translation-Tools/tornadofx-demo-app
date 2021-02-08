package org.bibletranslationtools.demo.ui.viewmodels

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class HomePageViewModel : ViewModel() {

    private val doWork: DoWorkUseCase by di()

    val returnedTextProperty = SimpleStringProperty("")
    val workDoneTextProperty = SimpleStringProperty("")

    fun doWork() {
        workDoneTextProperty.set(doWork.doWork())
    }
}
