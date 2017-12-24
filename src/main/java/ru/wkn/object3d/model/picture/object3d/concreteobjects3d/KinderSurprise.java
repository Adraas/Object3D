package ru.wkn.object3d.model.picture.object3d.concreteobjects3d;

import ru.wkn.object3d.model.picture.object3d.Object3D;
import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;
import ru.wkn.object3d.model.picture.object3d.object3dunit.VoxelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.PixelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.ColorImpl;

public class KinderSurprise implements Object3D {

    private Voxel[][][] voxels;
    private Voxel[][] voxelsFor2D;
    private int radius;

    public KinderSurprise(Voxel[][][] voxels, int radius) {
        this.voxels = voxels;
        this.radius = radius;
    }

    @Override
    public Voxel[][][] getVoxels() {
        return this.voxels;
    }

    @Override
    public Voxel[][][] get3D() {
        build();
        return this.voxels;
    }

    private void build() {
        for (int i = 0; i < this.voxels.length; i++) {
            for (int j = 0; j < this.voxels[0].length; j++) {
                for (int k = 0; k < this.voxels[0][0].length; k++) {
                    double a = i * 12 * Math.PI / 180;
                    double b = j * 12 * Math.PI / 180;
                    double x = this.radius * Math.sin(a) * Math.cos(b);
                    double y = this.radius * Math.sin(a) * Math.sin(b);
                    double z;
                    if (this.radius * Math.cos(a) > 0)
                        z = this.radius * Math.cos(a) + this.radius;
                    else
                        z = this.radius * Math.cos(a);
                    this.voxels[i][j][k] = new VoxelImpl(new PixelImpl((int) x, (int) y, new ColorImpl(0, 0, 0)), (int) z);
                }
            }
        }
    }

    @Override
    public Voxel[][] get2D() {
        draw();
        return this.voxelsFor2D;
    }

    private void draw() {
        this.voxelsFor2D = new VoxelImpl[this.voxels.length][this.voxels[0].length];
        for (int i = 0; i < this.voxelsFor2D.length; i++) {
            for (int j = 0; j < this.voxelsFor2D[0].length; j++) {
                double a = i * 12 * Math.PI / 180;
                double b = j * 12 * Math.PI / 180;
                double x = this.radius * Math.sin(a) * Math.cos(b);
                double y = this.radius * Math.sin(a) * Math.sin(b);
                double z;
                if (this.radius * Math.cos(a) > 0)
                    z = this.radius * Math.cos(a) + this.radius;
                else
                    z = this.radius * Math.cos(a);
                this.voxelsFor2D[i][j] = new VoxelImpl(new PixelImpl((int) x, (int) y, new ColorImpl(0, 0, 0)), (int) z);
            }
        }
    }
}
