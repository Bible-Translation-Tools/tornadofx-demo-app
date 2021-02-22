package org.bibletranslationtools.demo.domain

import java.util.*
import javax.inject.Inject

class DoWorkUseCase @Inject constructor(dependency: SimpleDependency) {
    val random = Math.random()
    fun doWork(): String = "did work! $random"
}
