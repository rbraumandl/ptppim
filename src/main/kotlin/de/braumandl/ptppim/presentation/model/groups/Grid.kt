package de.braumandl.ptppim.presentation.model.groups

import de.braumandl.ptppim.presentation.NodeGenerator
import de.braumandl.ptppim.presentation.model.PresentationConstructionNode
import javafx.scene.Node
import javafx.scene.layout.GridPane
import java.lang.IllegalArgumentException

open class Grid(val collisionCheck : Boolean = true) : AbstractGroup(), NodeGenerator {
    /**
     * The properties of a [CellPosition] object will be subject
     * to change, therefore they are declared "var".
     * Visibility is private since we only assert the passed values
     * being positive in this context.
     */
    protected data class CellPosition(var row:Int, var col:Int)

    /**
     * The members of [CellDimension] objects will not be changed since
     * objects are generated anew for different span values.
     * Visibility is private since we only assert the passed values
     * being positive in this context.
     */
    protected data class CellDimension(val rSpan:Int, val cSpan:Int)

    /**
     *
     */
    protected data class GridMember(val position:CellPosition, val dimension:CellDimension, val nodeGenerator: NodeGenerator) {
        val leftEdge : Int get() = position.col
        val rightEdge : Int get() = position.col + dimension.cSpan
        val upperEdge : Int get() = position.row
        val lowerEdge : Int get() = position.row + dimension.rSpan

        private fun intervalIntersection(leftFirst: Int, rightFirst: Int, leftSecond: Int, rightSecond: Int): Boolean{
            return (leftSecond in leftFirst until rightFirst)
                    || (leftFirst in leftSecond until rightSecond)
        }

        fun collides(oCell: GridMember): Boolean {
            val horizontalCollision = intervalIntersection(leftEdge,rightEdge,oCell.leftEdge, oCell.rightEdge)
            val verticalCollision = intervalIntersection(upperEdge, lowerEdge, oCell.upperEdge, oCell.lowerEdge)
            return horizontalCollision && verticalCollision
        }
    }

    /**
     * The dimensions the next inserted cell should have.
     */
    protected var currentCellDimension : CellDimension = CellDimension(1,1)

    /**
     * The position the next inserted cell should have
     */
    protected var currentCellPosition : CellPosition = CellPosition(0,0)

    /**
     * The map of all children of the grid where the key is the [NodeGenerator] object
     * and the value is the [GridMember] object with the grid-based layout constraints.
     */
    protected val nodeToGridMemberMap = HashMap<NodeGenerator, GridMember>()

    override fun generateNode(): Node {
        val grid = GridPane()
        for ((nodeGenerator: NodeGenerator, gridMember: GridMember) in nodeToGridMemberMap) {
            grid.add(nodeGenerator.generateNode(), gridMember.position.col, gridMember.position.row,
                gridMember.dimension.cSpan, gridMember.dimension.rSpan)
        }
        return grid
    }

    /**
     * The span function is used within the DSL to set the row and column span values for
     * the next nodes placed in the grid cell. Function calls to this function can
     * also be nested.
     */
    fun span(rSpan:Int = 1, cSpan:Int = 1, init: Grid.() -> PresentationConstructionNode) : PresentationConstructionNode {
        // check for valid parameters, throws an IllegalArgumentException if condition is false:
        require(rSpan > 0) {"The value of rSpan must be 1 or more!"}
        require(cSpan > 0) {"The value of cSpan must be 1 or more!"}

        // save old cell dimension to restore it at the end of the function
        val oldCellDimension = currentCellDimension
        currentCellDimension = CellDimension(rSpan, cSpan)
        val toReturn = this.init()
        currentCellDimension = oldCellDimension
        return toReturn
    }

    /**
     * We assume that when we are in a [span] call the line break should jump to
     * the line which is determined by adding the current row span value.
     */
    fun linebreak() {
        // we have to use the rSpan value from the [currentCellDimension] for
        // setting the new row position.
        with(currentCellPosition) {
            row += currentCellDimension.rSpan
            col = 0
        }
    }

    override fun addNodeGenerator(node: NodeGenerator) {
         val gridMember = GridMember(currentCellPosition.copy(),
            currentCellDimension,
            node)
        // check for collisions with already defined grid cells:
        if(collisionCheck){
            val collisionDetected = nodeToGridMemberMap.values.fold(false) { acc: Boolean, member: GridMember ->
                acc || gridMember.collides(member)
            }
            if(collisionDetected){
                throw IllegalArgumentException("Collision with grid member values ${gridMember}")
            }
        }
        nodeToGridMemberMap[node] = gridMember
        // set the current cell position which should be used in the next call,
        // we have to take the cell dimension cSpan into account:
        currentCellPosition.col = currentCellPosition.col + currentCellDimension.cSpan
    }
}

fun grid(collisionCheck: Boolean = false, init: Grid.() -> Unit) : Grid {
    val grid = Grid(collisionCheck)
    grid.init()
    return grid
}
