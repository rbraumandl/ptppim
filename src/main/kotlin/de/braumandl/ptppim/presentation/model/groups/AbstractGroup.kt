package de.braumandl.ptppim.presentation.model.groups

import de.braumandl.ptppim.presentation.NodeGenerator
import de.braumandl.ptppim.presentation.model.LabelPresentationModel
import de.braumandl.ptppim.presentation.model.PresentationConstructionNode

abstract class AbstractGroup {

    abstract fun addNodeGenerator(node : NodeGenerator)

    fun label(labelText: String, init: LabelPresentationModel.() -> Unit): PresentationConstructionNode {
        val label = LabelPresentationModel(labelText)
        label.init()
        addNodeGenerator(label)
        return PresentationConstructionNode(this, label)
    }

}