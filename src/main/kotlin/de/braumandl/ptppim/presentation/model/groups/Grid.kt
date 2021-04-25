package de.braumandl.ptppim.presentation.model.groups

import de.braumandl.ptppim.presentation.NodeGenerator
import de.braumandl.ptppim.presentation.model.PresentationConstructionNode
import javafx.scene.Node

class Grid : AbstractGroup(), NodeGenerator {



    override fun generateNode(): Node {
        TODO("Not yet implemented")
    }


}

/**
 * Infix and extension function for the class <code>PresentationConstructionNode</code>
 */
infix fun  PresentationConstructionNode.leftOf( right : PresentationConstructionNode) : PresentationConstructionNode {
    TODO("complete here")
    return right
}


fun grid(init: Grid.() -> Unit) : Grid {
    val grid = Grid()
    grid.init()
    return grid
}

fun test() {
    grid {
        label("Mein Text"){}
    }
}