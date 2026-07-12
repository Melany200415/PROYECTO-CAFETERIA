module org.example.trabajo_cafeteria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.trabajo_cafeteria to javafx.fxml;
    exports org.example.trabajo_cafeteria;

    opens org.example.trabajo_cafeteria.controlador to javafx.fxml;
    exports org.example.trabajo_cafeteria.controlador;
}