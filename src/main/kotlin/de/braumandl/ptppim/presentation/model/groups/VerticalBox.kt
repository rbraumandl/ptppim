package de.braumandl.ptppim.presentation.model.groups

import de.braumandl.ptppim.presentation.NodeGenerator
import de.braumandl.ptppim.presentation.model.LabelPresentationModel
import javafx.scene.Node
import javafx.scene.layout.VBox

class VerticalBox(private val spacing : Double) : AbstractGroup(), NodeGenerator {

    override fun generateNode(): Node {
        val fxVbox = VBox(spacing)
        // for the VBox Java class we do not have to use the getter
        // for accessing the children property but Kotlin offers us the same
        // syntax by using the property name as it is also used in Kotlin itself.
        children.forEach { fxVbox.children.add(it.generateNode()) }
        return fxVbox
    }

}