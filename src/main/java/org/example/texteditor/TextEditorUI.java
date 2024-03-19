package org.example.texteditor;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TextEditorUI {

    private TextArea textArea;

    public  void setupUI (Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 400);

        textArea = new TextArea();
        root.setCenter(textArea);

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");

        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, new SeparatorMenuItem(), exitMenuItem);

        Menu edit = new Menu("Edit");
        MenuItem undoMenuItem = new MenuItem("Undo");
        MenuItem redoMenuItem = new MenuItem("Redo");

        edit.getItems().addAll(undoMenuItem, redoMenuItem);

        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(edit);
        root.setTop(menuBar);

        FileManager fileManager = new FileManager(textArea);
        newMenuItem.setOnAction(e -> fileManager.newFile());
        openMenuItem.setOnAction(e -> fileManager.openFile(primaryStage));
        saveMenuItem.setOnAction(e -> fileManager.saveFile(primaryStage));
        exitMenuItem.setOnAction(e -> System.exit(0));

        primaryStage.setScene(scene);

    }
}
