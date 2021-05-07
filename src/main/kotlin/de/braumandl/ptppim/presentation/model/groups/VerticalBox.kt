package de.braumandl.ptppim.presentation.model.groups

import de.braumandl.ptppim.SystemInfo
import de.braumandl.ptppim.presentation.NodeGenerator
import javafx.scene.Node
import javafx.scene.layout.VBox

class VerticalBox(private val spacing : Double) : AbstractGroup(), NodeGenerator {
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

    override fun addNodeGenerator(node: NodeGenerator) {
        children.add(node)
    }

}

fun verticalBox(init: VerticalBox.() -> Unit): VerticalBox {
    val vbox = VerticalBox(8.0)
    vbox.init()
    return vbox
}

fun testVbox() : Node {
    val javaVersion = SystemInfo.javaVersion()
    val javafxVersion = SystemInfo.javafxVersion()
    val vbox = verticalBox {
        label("Hello, Kotlin powered JavaFX $javafxVersion, running on Java $javaVersion."){}
    }.generateNode()
    return vbox
}