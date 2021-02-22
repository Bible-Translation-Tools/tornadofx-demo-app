package org.bibletranslationtools.demo.domain

import javax.inject.Inject

interface SimpleDependency

class SimpleDependencyImpl @Inject constructor(): SimpleDependency {}
