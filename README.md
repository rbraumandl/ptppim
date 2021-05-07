# ptppim
A peer to peer personal information manager

#Development

Starting the application from the command line:
mvn javafx:run

In order to start the application from within IntelliJ Idea 
the VM options in the run configuration has to be augmented
to include the JavaFX modules, e.g. (in one line)


--module-path
/home/reinhard/.m2/repository/org/openjfx/javafx-base/11.0.2:/home/reinhard/.m2/repository/org/openjfx/javafx-controls/11.0.2:/home/reinhard/.m2/repository/org/openjfx/javafx-graphics/11.0.2
--add-modules
javafx.controls

Here we get these modules from the local maven repository cache.