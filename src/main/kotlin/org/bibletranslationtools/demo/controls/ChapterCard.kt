package org.bibletranslationtools.demo.controls

import javafx.beans.property.StringProperty
import javafx.css.CssMetaData
import javafx.css.Styleable
import javafx.css.StyleableProperty
import javafx.css.StyleableStringProperty
import javafx.css.converter.StringConverter
import javafx.scene.AccessibleAttribute
import javafx.scene.control.Control
import javafx.scene.control.Skin
import org.bibletranslationtools.demo.controls.skins.LargeScreenChapterCardSkin
import java.util.*

class ChapterCard : Control() {
    private var stuff: StringProperty? = null

    fun stuffProperty(): StringProperty {
        if (stuff == null) {
            stuff = object : StyleableStringProperty("") {
                override fun getCssMetaData(): CssMetaData<out Styleable?, String> {
                    return StyleableProperties.STUFF
                }

                override fun invalidated() {
                    notifyAccessibleAttributeChanged(AccessibleAttribute.VALUE)
                }

                override fun getBean(): Any {
                    return this@ChapterCard
                }

                override fun getName(): String {
                    return "stuff"
                }
            }
        }
        return stuff!!
    }

    private object StyleableProperties {
        val STUFF: CssMetaData<ChapterCard, String> = object : CssMetaData<ChapterCard, String>(
            "-fx-stuff",
            StringConverter.getInstance()
        ) {
            override fun isSettable(n: ChapterCard): Boolean {
                return n.stuff == null || !n.stuff!!.isBound
            }

            override fun getStyleableProperty(n: ChapterCard): StyleableProperty<String?> {
                return n.stuffProperty() as StyleableProperty<String?>
            }
        }
        val STYLEABLES: List<CssMetaData<out Styleable?, *>>

        init {
            val styleables: ArrayList<CssMetaData<out Styleable?, *>> = ArrayList(Control.getClassCssMetaData())
            styleables.add(STUFF)
            STYLEABLES = Collections.unmodifiableList(styleables)
        }
    }

    override fun createDefaultSkin(): Skin<*> {
        println("what")
        return LargeScreenChapterCardSkin(this)
    }

    override fun getControlCssMetaData(): List<CssMetaData<out Styleable?, *>>? {
        return StyleableProperties.STYLEABLES
    }

    companion object {
        private const val DEFAULT_STYLE_CLASS = "chaptercard"
    }

    init {
        id = "chaptercard"
        styleClass.setAll(DEFAULT_STYLE_CLASS)
    }
}
