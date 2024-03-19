package org.example.texteditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class TextEditorApp extends Application {

    //private TextArea textArea;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Editor Demo");

        TextEditorUI textEditorUI = new TextEditorUI();

        textEditorUI.setupUI(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}