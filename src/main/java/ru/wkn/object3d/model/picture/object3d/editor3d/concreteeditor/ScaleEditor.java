package ru.wkn.object3d.model.picture.object3d.editor3d.concreteeditor;

import ru.wkn.object3d.model.picture.object3d.editor3d.Editor;
import ru.wkn.object3d.model.picture.object3d.editor3d.vector.Vector;
import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;
import ru.wkn.object3d.model.picture.object3d.object3dunit.VoxelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.PixelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.ColorImpl;

public class ScaleEditor implements Editor {

    private Voxel[][] voxels;
    private Vector vector;

    public ScaleEditor(Voxel[][] voxels, Vector vector) {
        this.voxels = voxels;
        this.vector = vector;
    }

    @Override
    public void edit() {
        for (int i = 0; i < this.voxels.length; i++) {
            for (int j = 0; j < this.voxels[0].length; j++) {
                this.voxels[i][j] = newVoxel(this.voxels[i][j]);
            }
        }
    }

    private Voxel newVoxel(Voxel voxel) {
        double x = voxel.getPixel().getX();
        double y = voxel.getPixel().getY();
        double z = voxel.getZ();
        x = x * this.vector.getXCoefficient();
        y = y * this.vector.getYCoefficient();
        z = z * this.vector.getZCoefficient();
        return new VoxelImpl(new PixelImpl((int) x, (int) y, new ColorImpl(0, 0, 0)), (int) z);
    }

    @Override
    public Voxel[][] getObject3D() {
        return this.voxels;
    }
}