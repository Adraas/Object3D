package ru.wkn.object3d.model.picture.canvas;

import javafx.scene.canvas.GraphicsContext;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.Color;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.Pixel;

public class CanvasJavaFxImpl implements Canvas {

    private javafx.scene.canvas.Canvas canvas;
    private GraphicsContext graphicsContext;

    public CanvasJavaFxImpl(javafx.scene.canvas.Canvas canvas) {
        this.canvas = canvas;
        graphicsContext = canvas.getGraphicsContext2D();
    }

    @Override
    public void draw(Pixel pixel) {
        graphicsContext.getPixelWriter().setColor(
                (int)pixel.getX(),
                (int)pixel.getY(),
                javafx.scene.paint.Color.color(
                        pixel.getColor().getRed(),
                        pixel.getColor().getGreen(),
                        pixel.getColor().getBlue()
                )
        );
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2, Color color) {
        graphicsContext.setFill(javafx.scene.paint.Color.color(color.getRed(), color.getGreen(), color.getBlue()));
        graphicsContext.strokeLine(x1, y1, x2, y2);
    }

    @Override
    public void clearScene() {
        graphicsContext.clearRect(- canvas.getWidth() / 2, - canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight());
    }
}