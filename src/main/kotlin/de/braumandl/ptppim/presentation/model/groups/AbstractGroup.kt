package de.braumandl.ptppim.presentation.model.groups

import de.braumandl.ptppim.presentation.NodeGenerator
import de.braumandl.ptppim.presentation.model.LabelPresentationModel
import de.braumandl.ptppim.presentation.model.PresentationConstructionNode

abstract class AbstractGroup {
    /**
     * Example of a lazy property realized by a delegated property.
     * Here lazy is the function which generates the lazy property
     * with the help of an initializer.
     */
    val children : MutableList<NodeGenerator> by lazy { mutableListOf() }

    fun label(labelText: String, init: LabelPresentationModel.() -> Unit): PresentationConstructionNode {
        val label = LabelPresentationModel(labelText)
        label.init()
        children.add(label)
        return PresentationConstructionNode(this, label)
    }

}