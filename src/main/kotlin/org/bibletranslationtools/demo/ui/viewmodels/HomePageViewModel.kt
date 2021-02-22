package org.bibletranslationtools.demo.ui.viewmodels

import javafx.beans.property.SimpleStringProperty
import org.bibletranslationtools.demo.domain.DoWorkUseCase
import org.bibletranslationtools.demo.domain.Router
import tornadofx.*
import javax.inject.Inject
import javax.inject.Provider

class HomePageViewModel @Inject constructor() : ViewModel() {

    val router: Router by inject()

    @Inject lateinit var doWorkProvider: Provider<DoWorkUseCase>

    val returnedTextProperty = SimpleStringProperty("")
    val workDoneTextProperty = SimpleStringProperty("")

    fun doWork() {
        val doWork = doWorkProvider.get()
        workDoneTextProperty.set(doWork.doWork())
    }
}
