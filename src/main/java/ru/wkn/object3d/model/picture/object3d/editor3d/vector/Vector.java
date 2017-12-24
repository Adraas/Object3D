package ru.wkn.object3d.model.picture.object3d.editor3d.vector;

public class Vector {

    private double xCoefficient;
    private double yCoefficient;
    private double zCoefficient;

    public Vector(double xCoefficient, double yCoefficient, double zCoefficient) {
        this.xCoefficient = xCoefficient;
        this.yCoefficient = yCoefficient;
        this.zCoefficient = zCoefficient;
    }

    public double getXCoefficient() {
        return xCoefficient;
    }

    public double getYCoefficient() {
        return yCoefficient;
    }

    public double getZCoefficient() {
        return zCoefficient;
    }
}
