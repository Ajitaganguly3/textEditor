package org.example.texteditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileManager {

    private TextArea textArea;

    public  FileManager (TextArea textArea) {
        this.textArea = textArea;
    }

    public void newFile() {
        textArea.clear();
    }

    public void openFile(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(primaryStage);

        if(file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textArea.setText(content.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public  void saveFile(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(primaryStage);
        if(file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
