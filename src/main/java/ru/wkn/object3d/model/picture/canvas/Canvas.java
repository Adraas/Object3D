package ru.wkn.object3d.model.picture.canvas;

import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.Pixel;

public interface Canvas {

    void draw(Pixel pixel);

    void drawGray(Pixel pixel);

    void clearScene();
}