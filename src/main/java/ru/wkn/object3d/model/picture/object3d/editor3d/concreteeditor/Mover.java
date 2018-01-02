package ru.wkn.object3d.model.picture.object3d.editor3d.concreteeditor;

import ru.wkn.object3d.model.picture.object3d.editor3d.Editor;
import ru.wkn.object3d.model.picture.object3d.editor3d.vector.Vector;
import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;
import ru.wkn.object3d.model.picture.object3d.object3dunit.VoxelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.PixelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.ColorImpl;

public class Mover implements Editor {

    private Voxel[][] voxelsFor2D;
    private Voxel[][][] voxels;
    private Vector vector;

    public Mover(Voxel[][] voxelsFor2D, Voxel[][][] voxels, Vector vector) {
        this.voxelsFor2D = voxelsFor2D;
        this.voxels = voxels;
        this.vector = vector;
    }

    @Override
    public void edit() {
        for (int i = 0; i < this.voxelsFor2D.length; i++) {
            for (int j = 0; j < this.voxelsFor2D[0].length; j++) {
                this.voxelsFor2D[i][j] = newVoxel(this.voxelsFor2D[i][j]);
            }
        }
    }

    private Voxel newVoxel(Voxel voxel) {
        double x = voxel.getPixel().getX();
        double y = voxel.getPixel().getY();
        double z = voxel.getZ();
        x = x + this.vector.getXCoefficient();
        y = y + this.vector.getYCoefficient();
        z = z + this.vector.getZCoefficient();
        return new VoxelImpl(new PixelImpl((int) x, (int) y, new ColorImpl(0, 0, 0)), (int) z);
    }

    @Override
    public Voxel[][] getObject2D() {
        return this.voxelsFor2D;
    }

    @Override
    public Voxel[][][] getObject3D() {
        return this.voxels;
    }
}
