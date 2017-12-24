package ru.wkn.object3d.model.picture.canvas;

import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.Color;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.Pixel;

public interface Canvas {

    void draw(Pixel pixel);

    void drawLine(int x1, int y1, int x2, int y2, Color color);

    void clearScene();
}