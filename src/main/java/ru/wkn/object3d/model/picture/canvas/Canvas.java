package ru.wkn.object3d.model.picture.canvas;

import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.Color;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.Pixel;

public interface Canvas {

    void draw(Pixel pixel);

    void drawLine(double x1, double y1, double x2, double y2, Color color);

    void clearScene();
}