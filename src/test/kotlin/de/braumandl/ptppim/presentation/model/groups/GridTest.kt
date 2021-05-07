package de.braumandl.ptppim.presentation.model.groups

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


internal class GridTest {

    @Test
    fun generateNode() {
        assertThrows<IllegalArgumentException> {
            val gridNode: Grid = grid (collisionCheck = true) {
                span(2, 2){label("Mein Text") {}}
                linebreak()
                label("Noch ein Text") {}// collision
                linebreak()
                span(2, 2) {
                    label("Mein 2. Text") {}
                }
            }
        }
    }
}