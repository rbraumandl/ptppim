package de.braumandl.ptppim.presentation.model.groups

import de.braumandl.ptppim.presentation.NodeGenerator
import de.braumandl.ptppim.presentation.model.LabelPresentationModel
import javafx.scene.Node
import javafx.scene.layout.VBox

class VerticalBox(private val spacing : Double) : NodeGenerator {
    /**
     * Example of a lazy property realized by a delegated property.
     * Here lazy is the function which generates the lazy property
     * with the help of an initializer.
     */
    val children : MutableList<NodeGenerator> by lazy { mutableListOf() }

    override fun generateNode(): Node {
        val fxVbox = VBox(spacing)
        // for the VBox Java class we do not have to use the getter
        // for accessing the children property but Kotlin offers us the same
        // syntax by using the property name as it is also used in Kotlin itself.
        children.forEach { fxVbox.children.add(it.generateNode()) }
        return fxVbox
    }

    fun label(labelText: String, init: LabelPresentationModel.() -> Unit): LabelPresentationModel {
        val label = LabelPresentationModel(labelText)
        label.init()
        children.add(label)
        return label
    }
}