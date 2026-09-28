package es.ieslazarocardenas.di.actividad1;

import javafx.application.Application; // Permito crear una aplicación con JavaFX
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * Gestor de tareas con JavaFX
 * ¿Qué elementos gráficos voy a utilizar?
 * TextField, ComboBox, ListView, Button, Label
 * Vbox y HBox para orientación vertical y horizontal
 * 
 * Eventos (setOnAction) para hacer algo cuando el usuario pulse un botón.
 * Listeners...
 * 
 * ¿Cuál es el flujo de una aplicación en JavaFX?
 * 
 * main() -> launch() -> JavaFX inicia su entorno -> start (Stage stage) -> se
 * construye la interfaz -> stage.show()
 * 
 * App
 */

public class App extends Application {

    @Override
    /**
     * (non-Javadoc)
     * Este método se llama automáticamente por parte de JavaFX cuando se inicia el
     * contexto de JavaFX
     * Este método contendrá todos los componentes gráficos
     * 
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    public void start(Stage primaryStage) throws Exception {

        // Añadimos una etiqueta que va a ser el título de la ventana. Modificamos su
        // estilo con CSS
        Label titulo = new Label("Gestor de Tareas");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        TextField campoTarea = new TextField(); // Para introducir la desc de la tarea
        campoTarea.setPromptText("Escribe una tarea"); // setPromptText es un método que aparece mientras el campo está
                                                       // vacío
        HBox.setHgrow(campoTarea, Priority.ALWAYS); // Indico que el campo puede crecer horizontalmente dentro del HBox

    }

    public static void main(String[] args) {

    }

}