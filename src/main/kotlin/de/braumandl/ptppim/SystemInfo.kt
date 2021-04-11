package de.braumandl.ptppim

object SystemInfo {
    fun javaVersion(): String {
        return System.getProperty("java.version")
    }

    fun javafxVersion(): String {
        return System.getProperty("javafx.version")
    }
}