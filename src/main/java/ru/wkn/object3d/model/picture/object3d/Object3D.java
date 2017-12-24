package ru.wkn.object3d.model.picture.object3d;

import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;

public interface Object3D {

    Voxel[][][] getVoxels();

    Voxel[][] get2D();

    Voxel[][][] get3D();
}
