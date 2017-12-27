package ru.wkn.object3d.model.picture.object3d.editor3d.concreteeditor;

import ru.wkn.object3d.model.picture.object3d.editor3d.Editor;
import ru.wkn.object3d.model.picture.object3d.editor3d.vector.Vector;
import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;
import ru.wkn.object3d.model.picture.object3d.object3dunit.VoxelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.PixelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.ColorImpl;

public class Turner implements Editor {

    private Voxel[][] voxels;
    private Vector vector;

    public Turner(Voxel[][] voxels, Vector vector) {
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
        double degree = Math.PI / 180;
        double x0, y0 = y, z0 = z;

        //rotation around the axis Ox
        if (this.vector.getXCoefficient() != 0) {
            y = y0 * Math.cos(this.vector.getXCoefficient() * degree) - z0 * Math.sin(this.vector.getXCoefficient() * degree);
            z = y0 * Math.sin(this.vector.getXCoefficient() * degree) + z0 * Math.cos(this.vector.getXCoefficient() * degree);
        }
        x0 = x;
        z0 = z;

        //rotation around the axis Oy
        if (this.vector.getYCoefficient() != 0) {
            x = x0 * Math.cos(this.vector.getYCoefficient() * degree) + z0 * Math.sin(this.vector.getYCoefficient() * degree);
            z = -x0 * Math.sin(this.vector.getYCoefficient() * degree) + z0 * Math.cos(this.vector.getYCoefficient() * degree);
        }
        x0 = x;
        y0 = y;

        //rotation around the axis Oz
        if (this.vector.getZCoefficient() != 0) {
            x = x0 * Math.cos(this.vector.getZCoefficient() * degree) - y0 * Math.sin(this.vector.getZCoefficient() * degree);
            y = x0 * Math.sin(this.vector.getZCoefficient() * degree) + y0 * Math.cos(this.vector.getZCoefficient() * degree);
        }
        return new VoxelImpl(new PixelImpl((int) x, (int) y, new ColorImpl(0, 0, 0)), (int) z);
    }

    @Override
    public Voxel[][] getObject3D() {
        return this.voxels;
    }
}
