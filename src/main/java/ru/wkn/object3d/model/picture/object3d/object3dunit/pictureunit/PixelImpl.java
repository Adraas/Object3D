package ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit;

import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.Color;

public class PixelImpl implements Pixel {

    private int x;
    private int y;
    private Color color;

    public PixelImpl(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Color getColor() {
        return color;
    }
}