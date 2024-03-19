module org.example.texteditor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.texteditor to javafx.fxml;
    exports org.example.texteditor;
}