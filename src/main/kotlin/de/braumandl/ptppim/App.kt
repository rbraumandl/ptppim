package de.braumandl.ptppim

import de.braumandl.ptppim.presentation.model.groups.VerticalBox
import javafx.application.Application
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.stage.Stage

/**
 * JavaFX App
 */
class App : Application() {
    override fun start(stage: Stage) {
        val javaVersion = SystemInfo.javaVersion()
        val javafxVersion = SystemInfo.javafxVersion()
        val vbox = verticalBox {
            label("Hello, Kotlin powered JavaFX $javafxVersion, running on Java $javaVersion."){}
        }.generateNode()
        //val label = Label("Hello, JavaFX $javafxVersion, running on Java $javaVersion.")
        val scene = Scene(vbox as Parent?, 640.0, 480.0)
        stage.scene = scene
        stage.show()
    }

    fun main() {
        launch();
    }

    fun verticalBox(init: VerticalBox.() -> Unit): VerticalBox {
        val vbox = VerticalBox(8.0)
        vbox.init()
        return vbox;
    }
}