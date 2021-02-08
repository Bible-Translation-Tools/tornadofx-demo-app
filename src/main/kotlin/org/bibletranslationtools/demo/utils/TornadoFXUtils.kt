package org.bibletranslationtools.demo.utils

import tornadofx.*

val App.rootView: UIComponent get() = find(primaryView)
val UIComponent.rootView: UIComponent get() = app.rootView
