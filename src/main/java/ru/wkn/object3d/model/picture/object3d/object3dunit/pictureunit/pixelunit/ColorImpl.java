package ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit;

public class ColorImpl implements Color {

    private double red;
    private double green;
    private double blue;
    private double gray;

    public ColorImpl(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public ColorImpl(double gray) {
        this.gray = gray;
    }

    @Override
    public double getRed() {
        return red;
    }

    @Override
    public double getGreen() {
        return green;
    }

    @Override
    public double getBlue() {
        return blue;
    }

    @Override
    public double getGray() {
        return gray;
    }
}