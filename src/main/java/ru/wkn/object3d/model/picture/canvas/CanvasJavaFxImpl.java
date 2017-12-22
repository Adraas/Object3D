package ru.wkn.object3d.model.picture.canvas;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
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
                Color.color(
                        pixel.getColor().getRed(),
                        pixel.getColor().getGreen(),
                        pixel.getColor().getBlue()
                )
        );
    }

    @Override
    public void drawGray(Pixel pixel) {
        graphicsContext.getPixelWriter().setColor(
                pixel.getX(),
                pixel.getY(),
                Color.gray(pixel.getColor().getGray())
        );
    }

    @Override
    public void clearScene() {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}