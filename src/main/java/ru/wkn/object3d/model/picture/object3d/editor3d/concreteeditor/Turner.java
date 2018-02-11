package ru.wkn.object3d.model.picture.object3d.editor3d.concreteeditor;

import ru.wkn.object3d.model.picture.object3d.editor3d.Editor;
import ru.wkn.object3d.model.picture.object3d.editor3d.vector.Vector;
import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;
import ru.wkn.object3d.model.picture.object3d.object3dunit.VoxelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.PixelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.ColorImpl;

public class Turner implements Editor {

    private Voxel[][] voxelsFor2D;
    private Voxel[][][] voxels;
    private Vector vector;

    public Turner(Voxel[][] voxelsFor2D, Voxel[][][] voxels, Vector vector) {
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
        double degree = Math.PI / 180;

        double x0, y0 = y, z0 = z;

        if (vector.getXCoefficient() != 0) {
            y = y0 * Math.cos(vector.getXCoefficient() * degree) - z0 * Math.sin(vector.getXCoefficient() * degree);
            z = y0 * Math.sin(vector.getXCoefficient() * degree) + z0 * Math.cos(vector.getXCoefficient() * degree);
        }

        x0 = x;
        z0 = z;

        if (vector.getYCoefficient() != 0) {
            x = x0 * Math.cos(vector.getYCoefficient() * degree) + z0 * Math.sin(vector.getYCoefficient() * degree);
            z = -x0 * Math.sin(vector.getYCoefficient() * degree) + z0 * Math.cos(vector.getYCoefficient() * degree);
        }

        x0 = x;
        y0 = y;

        if (vector.getZCoefficient() != 0) {
            x = x0 * Math.cos(vector.getZCoefficient() * degree) - y0 * Math.sin(vector.getZCoefficient() * degree);
            y = x0 * Math.sin(vector.getZCoefficient() * degree) + y0 * Math.cos(vector.getZCoefficient() * degree);
        }
        return new VoxelImpl(new PixelImpl((int) x, (int) y, new ColorImpl(0, 0, 0)), (int) z);
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
