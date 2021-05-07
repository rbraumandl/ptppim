package de.braumandl.ptppim

import de.braumandl.ptppim.presentation.model.groups.Grid
import de.braumandl.ptppim.presentation.model.groups.grid
import javafx.application.Application
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * JavaFX App
 */
class App : Application() {
    override fun start(stage: Stage) {
        val node = testGrid()
        val scene = Scene(node as Parent?, 640.0, 480.0)
        stage.scene = scene
        stage.show()
    }

    fun main() {
        launch()
    }

    fun testGrid() : Node {
        val gridModel: Grid = grid {
            span(2, 2){label("Mein Text") {}}
            linebreak()
            linebreak()
            label("Noch ein Text") {}
            linebreak()
            span(2, 2) {
                label("Mein 2. Text") {}
            }
        }
        return gridModel.generateNode();
    }
}