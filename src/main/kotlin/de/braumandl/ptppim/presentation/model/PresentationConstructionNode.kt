package de.braumandl.ptppim.presentation.model

import de.braumandl.ptppim.presentation.NodeGenerator
import de.braumandl.ptppim.presentation.model.groups.AbstractGroup

/**
 * Data class for returning more than on object from a method. Using the predefined <code>Pair</code> class
 * in Kotlin would also be possible. But perhaps we want to extend this class later on.
 */
data class PresentationConstructionNode(val abstractGroup: AbstractGroup, val nodeGenerator: NodeGenerator)
