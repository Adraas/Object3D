package ru.wkn.object3d.model.picture.canvas;

import javafx.scene.canvas.GraphicsContext;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.Color;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.Pixel;

public class CanvasJavaFxImpl implements Canvas {

    private javafx.scene.canvas.Canvas canvas;
    private GraphicsContext graphicsContext;

    public CanvasJavaFxImpl(javafx.scene.canvas.Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
    }

    @Override
    public void draw(Pixel pixel) {
        graphicsContext.getPixelWriter().setColor(
                pixel.getX(),
                pixel.getY(),
                javafx.scene.paint.Color.color(
                        pixel.getColor().getRed(),
                        pixel.getColor().getGreen(),
                        pixel.getColor().getBlue()
                )
        );
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        this.graphicsContext.setFill(javafx.scene.paint.Color.color(color.getRed(), color.getGreen(), color.getBlue()));
        this.graphicsContext.strokeLine(x1, y1, x2, y2);
    }

    @Override
    public void clearScene() {
        this.graphicsContext.clearRect(- this.canvas.getWidth() / 2, - this.canvas.getHeight() / 2, this.canvas.getWidth(), this.canvas.getHeight());
    }
}