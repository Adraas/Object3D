package ru.wkn.object3d.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import ru.wkn.object3d.model.picture.Picture;
import ru.wkn.object3d.model.picture.PictureImpl;
import ru.wkn.object3d.model.picture.canvas.CanvasJavaFxImpl;
import ru.wkn.object3d.model.picture.object3d.concreteobjects3d.KinderSurprise;
import ru.wkn.object3d.model.picture.object3d.editor3d.Editor;
import ru.wkn.object3d.model.picture.object3d.editor3d.concreteeditor.Mover;
import ru.wkn.object3d.model.picture.object3d.editor3d.concreteeditor.ScaleEditor;
import ru.wkn.object3d.model.picture.object3d.editor3d.concreteeditor.Turner;
import ru.wkn.object3d.model.picture.object3d.editor3d.vector.Vector;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class Controller implements Initializable {

    @FXML
    private Canvas fxCanvas;
    @FXML
    private Slider sliderMoveByX;
    @FXML
    private Slider sliderMoveByY;
    @FXML
    private Slider sliderMoveByZ;
    @FXML
    private Slider sliderTurnByX;
    @FXML
    private Slider sliderTurnByY;
    @FXML
    private Slider sliderTurnByZ;
    @FXML
    private Slider sliderScale;
    private GraphicsContext graphicsContext;
    private FileChooser fileChooser;
    private Picture picture;
    private ru.wkn.object3d.model.picture.canvas.Canvas canvas;

    public Controller() {
        this.fileChooser = new FileChooser();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.graphicsContext = this.fxCanvas.getGraphicsContext2D();
        this.graphicsContext.translate(fxCanvas.getWidth() / 2, fxCanvas.getHeight() / 2);
        this.canvas = new CanvasJavaFxImpl(this.fxCanvas);
        this.picture = new PictureImpl(new KinderSurprise(31, 31, 31, 100));
        update(null);
    }

    private void update(Editor editor) {
        if (editor != null) {
            this.picture.edit(editor);
            this.picture.setVoxelsFor2D(editor.getObject3D());
        }
        this.picture.redraw(this.canvas);
    }

    @FXML
    private void onActionSave(ActionEvent actionEvent) {
        //
    }

    @FXML
    private void onActionExit(ActionEvent actionEvent) {
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
    private void onActionTask(ActionEvent actionEvent) {
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
    private void onActionAuthor(ActionEvent actionEvent) {
        StringJoiner message = new StringJoiner("\n");
        message.add("Пикалов Артем Сергеевич");
        message.add("группа: 6202-090301D");
        writeMessage("Об авторе", message.toString());
    }

    @FXML
    private void onDragDetectedMoveByX(MouseEvent dragEvent) {
        update(new Mover(picture.getVoxelsFor2D(), new Vector(this.sliderMoveByX.getValue(), 0, 0)));
    }

    @FXML
    private void onDragDetectedMoveByY(MouseEvent dragEvent) {
        update(new Mover(picture.getVoxelsFor2D(), new Vector(0, this.sliderMoveByY.getValue(), 0)));
    }

    @FXML
    private void onDragDetectedMoveByZ(MouseEvent dragEvent) {
        update(new Mover(picture.getVoxelsFor2D(), new Vector(0, 0, this.sliderMoveByZ.getValue())));
    }

    @FXML
    private void onDragDetectedTurnByX(MouseEvent dragEvent) {
        update(new Turner(picture.getVoxelsFor2D(), new Vector(this.sliderTurnByX.getValue(), 0, 0)));
    }

    @FXML
    private void onDragDetectedTurnByY(MouseEvent dragEvent) {
        update(new Turner(picture.getVoxelsFor2D(), new Vector(0, this.sliderTurnByY.getValue(), 0)));
    }

    @FXML
    private void onDragDetectedTurnByZ(MouseEvent dragEvent) {
        update(new Turner(picture.getVoxelsFor2D(), new Vector(0, 0, this.sliderTurnByZ.getValue())));
    }

    @FXML
    private void onDragDetectedScale(MouseEvent dragEvent) {
        update(new ScaleEditor(picture.getVoxelsFor2D(), new Vector(this.sliderScale.getValue(), this.sliderScale.getValue(), this.sliderScale.getValue())));
    }

    public void onClickedMoveByX(MouseEvent dragEvent) {
        update(new Mover(picture.getVoxelsFor2D(), new Vector(this.sliderMoveByX.getValue(), 0, 0)));
    }

    public void onClickedMoveByY(MouseEvent dragEvent) {
        update(new Mover(picture.getVoxelsFor2D(), new Vector(0, this.sliderMoveByY.getValue(), 0)));
    }

    public void onClickedMoveByZ(MouseEvent dragEvent) {
        update(new Mover(picture.getVoxelsFor2D(), new Vector(0, 0, this.sliderMoveByZ.getValue())));
    }

    public void onClickedTurnByX(MouseEvent dragEvent) {
        update(new Turner(picture.getVoxelsFor2D(), new Vector(this.sliderTurnByX.getValue(), 0, 0)));
    }

    public void onClickedTurnByY(MouseEvent dragEvent) {
        update(new Turner(picture.getVoxelsFor2D(), new Vector(0, this.sliderTurnByY.getValue(), 0)));
    }

    public void onClickedTurnByZ(MouseEvent dragEvent) {
        update(new Turner(picture.getVoxelsFor2D(), new Vector(0, 0, this.sliderTurnByZ.getValue())));
    }

    public void onClickedScale(MouseEvent dragEvent) {
        update(new ScaleEditor(picture.getVoxelsFor2D(), new Vector(this.sliderScale.getValue(), this.sliderScale.getValue(), this.sliderScale.getValue())));
    }

    public void onKeyPressedMoveByX(KeyEvent dragEvent) {
        update(new Mover(picture.getVoxelsFor2D(), new Vector(this.sliderMoveByX.getValue(), 0, 0)));
    }

    public void onKeyPressedMoveByY(KeyEvent dragEvent) {
        update(new Mover(picture.getVoxelsFor2D(), new Vector(0, this.sliderMoveByY.getValue(), 0)));
    }

    public void onKeyPressedMoveByZ(KeyEvent dragEvent) {
        update(new Mover(picture.getVoxelsFor2D(), new Vector(0, 0, this.sliderMoveByZ.getValue())));
    }

    public void onKeyPressedTurnByX(KeyEvent keyEvent) {
        update(new Turner(picture.getVoxelsFor2D(), new Vector(this.sliderTurnByX.getValue(), 0, 0)));
    }

    public void onKeyPressedTurnByY(KeyEvent dragEvent) {
        update(new Turner(picture.getVoxelsFor2D(), new Vector(0, this.sliderTurnByY.getValue(), 0)));
    }

    public void onKeyPressedTurnByZ(KeyEvent dragEvent) {
        update(new Turner(picture.getVoxelsFor2D(), new Vector(0, 0, this.sliderTurnByZ.getValue())));
    }

    public void onKeyPressedScale(KeyEvent keyEvent) {
        update(new ScaleEditor(picture.getVoxelsFor2D(), new Vector(this.sliderScale.getValue(), this.sliderScale.getValue(), this.sliderScale.getValue())));
    }
}
