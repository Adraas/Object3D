package ru.wkn.object3d.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class Controller implements Initializable {

    @FXML
    private Canvas fxCanvas;
    private GraphicsContext graphicsContext;
    private FileChooser fileChooser;

    public Controller() {
        this.fileChooser = new FileChooser();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        graphicsContext = fxCanvas.getGraphicsContext2D();
    }

    @FXML
    public void onActionSave(ActionEvent actionEvent) {
        //
    }

    @FXML
    public void onActionExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void writeMessage(String name, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void onActionTask(ActionEvent actionEvent) {
        StringJoiner message = new StringJoiner("\n");
        message.add("13 вариант");
        message.add("Реализовать вывод на экран трехмерной поверхности.");
        message.add("Применить два аффинных преобразования над объектом.");
        message.add("Объект: киндер-сюрприз.");
        message.add("   x = R sin(α) cos(β),");
        message.add("   y = R sin(α) sin(β),");
        message.add("   Если  R cos(α) > 0, то z = R cos(α) + R,");
        message.add("   иначе, z = R cos(α)");
        writeMessage("Задание", message.toString());
    }

    @FXML
    public void onActionAuthor(ActionEvent actionEvent) {
        StringJoiner message = new StringJoiner("\n");
        message.add("Пикалов Артем Сергеевич");
        message.add("группа: 6202-090301D");
        writeMessage("Об авторе", message.toString());
    }
}
