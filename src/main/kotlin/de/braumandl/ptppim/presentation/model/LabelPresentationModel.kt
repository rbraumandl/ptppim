package de.braumandl.ptppim.presentation.model

import de.braumandl.ptppim.presentation.NodeGenerator
import javafx.scene.Node
import javafx.scene.control.Label

class LabelPresentationModel(private val labelText : String) : NodeGenerator{
    override fun generateNode(): Node {
        return Label(labelText)
    }

}