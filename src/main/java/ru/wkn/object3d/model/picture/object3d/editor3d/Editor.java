package ru.wkn.object3d.model.picture.object3d.editor3d;

import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;

public interface Editor {

    void edit();

    Voxel[][] getObject3D();
}
