# ptppim
A peer to peer personal information manager

#Development

Starting the application from the command line:
mvn javafx:run

Alternatively we can start the application without the help of the javafx plugin via the command line in the project directory:
java --module-path ${HOME}/.m2/repository/org/openjfx/javafx-controls/11.0.2:${HOME}/.m2/repository/org/openjfx/javafx-base/11.0.2:${HOME}/.m2/repository/org/openjfx/javafx-graphics/11.0.2:${HOME}/programme/kotlin/kotlinc/lib/kotlin-stdlib-jdk8.jar:${HOME}/programme/kotlin/kotlinc/lib/kotlin-stdlib-jdk7.jar:${HOME}/programme/kotlin/kotlinc/lib/kotlin-stdlib.jar:./target/classes -m de.braumandl.ptppim/de.braumandl.ptppim.App

In order to start the application from within IntelliJ Idea 
the VM options in the run configuration has to be augmented
to include the JavaFX modules, e.g. (in one line)


--module-path ${HOME}/.m2/repository/org/openjfx/javafx-controls/11.0.2:${HOME}/.m2/repository/org/openjfx/javafx-base/11.0.2:${HOME}/.m2/repository/org/openjfx/javafx-graphics/11.0.2:${HOME}/programme/kotlin/kotlinc/lib/kotlin-stdlib-jdk8.jar:${HOME}/programme/kotlin/kotlinc/lib/kotlin-stdlib-jdk7.jar:${HOME}/programme/kotlin/kotlinc/lib/kotlin-stdlib.jar:./target/classes

Here we get these modules from the local maven repository cache
and the kotlinc installation which uses a symbolic link to select
the right version of kotlinc.

To debug module problems you could for example do something like this:


java --module-path ${HOME}/.m2/repository/org/openjfx/javafx-controls/11.0.2:${HOME}/programme/kotlin/kotlinc/lib/kotlin-stdlib-jdk8.jar --list-modules