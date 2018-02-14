package ru.wkn.object3d.model.picture.object3d.editor3d.concreteeditor;

import ru.wkn.object3d.model.picture.object3d.editor3d.Editor;
import ru.wkn.object3d.model.picture.object3d.editor3d.vector.Vector;
import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;
import ru.wkn.object3d.model.picture.object3d.object3dunit.VoxelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.PixelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.ColorImpl;

public class ScaleEditor implements Editor {

    private Voxel[][] voxelsFor2D;
    private Voxel[][][] voxels;
    private Vector vector;

    public ScaleEditor(Voxel[][] voxelsFor2D, Voxel[][][] voxels, Vector vector) {
        this.voxelsFor2D = voxelsFor2D;
        this.voxels = voxels;
        this.vector = vector;
    }

    @Override
    public void edit() {
        for (int i = 0; i < voxelsFor2D.length; i++) {
            for (int j = 0; j < voxelsFor2D[0].length; j++) {
                voxelsFor2D[i][j] = newVoxel(voxelsFor2D[i][j]);
            }
        }
    }

    private Voxel newVoxel(Voxel voxel) {
        double x = voxel.getPixel().getX();
        double y = voxel.getPixel().getY();
        double z = voxel.getZ();
        if ((vector.getXCoefficient() != 0) && (vector.getYCoefficient() != 0) && (vector.getZCoefficient() != 0)) {
            x = x * vector.getXCoefficient();
            y = y * vector.getYCoefficient();
            z = z * vector.getZCoefficient();
        }
        return new VoxelImpl(new PixelImpl(x, y, new ColorImpl(0, 0, 0)), z);
    }

    @Override
    public Voxel[][] getObject2D() {
        return voxelsFor2D;
    }

    @Override
    public Voxel[][][] getObject3D() {
        return voxels;
    }
}