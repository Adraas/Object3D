package ru.wkn.object3d.model.picture;

import ru.wkn.object3d.model.picture.canvas.Canvas;
import ru.wkn.object3d.model.picture.object3d.editor3d.Editor;
import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;

import java.io.Serializable;

public interface Picture extends Serializable {

    void redraw(Canvas canvas);

    Voxel[][] getVoxelsFor2D();

    void setVoxelsFor2D(Voxel[][] voxelsFor2D);

    void edit(Editor editor);
}