package ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit;

import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.Color;

public class PixelImpl implements Pixel {

    private double x;
    private double y;
    private Color color;

    public PixelImpl(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public Color getColor() {
        return color;
    }
}