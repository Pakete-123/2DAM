package es.ies.gestortareas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Actividad 1 - GESTOR DE TAREAS CON JAVAFX
 * 
 * Conceptos principales: - Application, Stage, Scene - Vbox y Hbox - TextField,
 * ComboBox, ListView, Button y Label - Propiedades de componentes - Eventos con
 * setOnAction() - Listeners sobre propiedades - SelectionModel - Alert -
 * Validación y feedback
 * 
 * La aplicación hereda de Application, la clase base de JavaFX
 * 
 * El flujo de arranque de una aplicación JavaFx es: main() -> launch() ->
 * JavaFx inicia su entorno -> start(Stage stage) -> Se construye
 *
 */

public class App extends Application {

    // Atributos de la clase
    private ComboBox<String> comboPrioridad;
    private ListView<String> listaTareas;
    private Button botonCompletar;
    private Button botonEliminar;
    private Label mensaje;
    private Label estado;
    private TextField campoTarea;

    /**
     * (non-Javadoc) En el flujo de trabajo de JavaFX, se llama automáticamente
     * a este método start En este método construimos toda la interfaz
     * 
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage stage) throws Exception {
        // 1.- Creamos una etiqueta y se modifica su estilo via CSS
        Label titulo = new Label("Gestor de Tareas");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        // 2.- Creamos un TextField para introducir el texto de la tarea
        campoTarea = new TextField();
        // El método setPromptText es un método que muestra el texto cuando el TextField
        // está vacío
        campoTarea.setPromptText("Escribe una tarea: ");

        // 3.- Permitir que este TextField pueda crecer horizontalmente cuando se
        // redimensiona la ventana. Se aplica a campoTarea y se hace siempre.
        HBox.setHgrow(campoTarea, Priority.ALWAYS);

        // 4.- Creamos un desplegable con tres prioridades: baja, media y alta.
        // Queremos que se quede seleccionada la prioridad media.
        comboPrioridad = new ComboBox<>();
        comboPrioridad.getItems().addAll("Baja", "Media", "Alta");
        comboPrioridad.setValue("Media");

        // 5.- Añadimos un botón para añadir la tarea. Es el botón predeterminado de la
        // ventana
        Button botonAñadir = new Button("Añadir tarea");
        botonAñadir.setDefaultButton(true);

        // 6.- Creamos un contenedor horizontal para colocar los elementos.
        // 10 es el espaciado entre elementos
        HBox formulario = new HBox(10,
                new Label("Nueva tarea: "),
                campoTarea,
                new Label("Prioridad: "),
                comboPrioridad,
                botonAñadir);

        // 7.- Alineo los elementos hacia la izquierda y centrados verticalmente.
        formulario.setAlignment(Pos.CENTER_LEFT);

        // 8.- Creamos una lista donde se van a mostrar las tareas creadas.
        listaTareas = new ListView<>();

        // 9.- Ancho que va a tener el componente de la lista de tareas.
        listaTareas.setPrefHeight(280);

        // 10.- Añadimos una lista de botones.
        botonCompletar = new Button("Marcar como completada"); // Permitirá marcar como completada una tarea
        botonEliminar = new Button("Eliminar"); // Elimina una tarea
        Button botonLimpiar = new Button("Limpiar todas"); // Limpia todas las tareas

        // 11.- Defino un contenedor horizontal para poner todos los botones.
        HBox acciones = new HBox(10,
                botonCompletar,
                botonEliminar,
                botonLimpiar);

        // 12.- Lo alineo al centro-izquierda
        acciones.setAlignment(Pos.CENTER_LEFT);

        // 13.- Defino dos labels para mostrar información.
        mensaje = new Label();
        mensaje.setWrapText(true);

        estado = new Label();

        // 14.- Defino mi elemento raíz de la ventana donde voy a ir apilando
        // verticalmente cada uno de los elementos gráficos de la ventana.
        VBox raiz = new VBox(14,
                titulo,
                formulario,
                new Label("Lista de tareas"),
                listaTareas,
                acciones,
                mensaje,
                estado);

        // 15.- Añadimos 20 píxeles de margen general
        raiz.setPadding(new Insets(20));

        // 16.- Permitimos que la lista crezca verticalmente si crece la ventana
        VBox.setVgrow(listaTareas, Priority.ALWAYS);

        // 17.- Añadimos eventos a los botones con funciones Lambda.
        botonAñadir.setOnAction(e -> anadirTarea()); // Cuando se pulsa un botón se ejecuta el código del método
                                                     // anadirTarea();
        botonEliminar.setOnAction(e -> eliminarTarea());
        botonCompletar.setOnAction(e -> marcarCompletada());
        botonLimpiar.setOnAction(e -> limpiarTodas());

        // Necesito una escena para que se muestre la ventana y llamar al método
        // stage.show
        Scene scene = new Scene(raiz, 820, 500); // Defino el contenido: el contenido va a ser el elemento raíz
        stage.setTitle("Gestor de tareas en JavaFX"); // Le pongo título a la ventana
        stage.setScene(scene);
        stage.show();

    }

    /**
     * 
     */
    private void anadirTarea() {

        String txt = campoTarea.getText().trim();

        if (txt.isEmpty()) {
            mostrarMensaje("Introduce una tarea. No se permiten tareas vacías");
            return;
        }

        // Transformamos el texto de la tarea precediendo de la prioridad
        String prioridad = comboPrioridad.getValue();
        String tarea = String.format("[%s] %s", prioridad, txt);

        listaTareas.getItems().add(tarea); // Añadimos la tarea al ListView
        listaTareas.getSelectionModel().selectLast();
        listaTareas.scrollTo(listaTareas.getItems().size() - 1);

        campoTarea.clear(); // Limpiamos el TextField de la tarea
        comboPrioridad.setValue("Media"); // Volvemos a dejar la prioridad por defecto
        mostrarMensaje("Tarea Añadida"); // Mostramos un mensaje de success
        campoTarea.requestFocus(); // Devolvemos el foco al TextField

    }

    private void eliminarTarea() {
        String selected = listaTareas.getSelectionModel().getSelectedItem();
        int index = listaTareas.getSelectionModel().getSelectedIndex();

        if (index < 0) {
            mostrarMensaje("Selecciona una tarea para eliminarla.");
            return;
        }

        listaTareas.getItems().remove(index);
        mostrarMensaje("Tarea eliminada: " + selected);
    }

    private void marcarCompletada() {
        int index = listaTareas.getSelectionModel().getSelectedIndex();

        if (index < 0) {
            mostrarMensaje("Selecciona una tarea para completarla.");
            return;
        }

        String task = listaTareas.getItems().get(index);
        if (task.startsWith(" ✓ ")) {
            mostrarMensaje("Esa tarea ya está completada");
            return;
        }

        listaTareas.getItems().set(index, " ✓ " + task);
        mostrarMensaje("Tarea completada.");
    }

    private void limpiarTodas() {
        int index = listaTareas.getItems().size();
        listaTareas.getItems().removeIf(task -> task.startsWith(" ✓ "));
        int deleted = index - listaTareas.getItems().size();

        if (deleted == 0) {
            mostrarMensaje("No hay tareas completadas para limpiar.");
        } else {
            mostrarMensaje("Se han eliminado " + deleted + " tareas completadas.");
        }

    }

    /**
     * Método que muestra en el interfaz el texto pasado como parámetro.
     * 
     * @param str
     */
    private void mostrarMensaje(String str) {
        this.mensaje.setText(str);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        launch();

    }
}
