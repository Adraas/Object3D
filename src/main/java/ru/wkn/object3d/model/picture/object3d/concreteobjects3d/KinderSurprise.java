package ru.wkn.object3d.model.picture.object3d.concreteobjects3d;

import ru.wkn.object3d.model.picture.object3d.Object3D;
import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;
import ru.wkn.object3d.model.picture.object3d.object3dunit.VoxelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.PixelImpl;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.ColorImpl;

public class KinderSurprise implements Object3D {

    private Voxel[][][] voxels;
    private Voxel[][] voxelsFor2D;
    private double radius;
    private double height;
    private double width;

    public KinderSurprise(double axisY, double axisX, double axisZ, double radius, double height, double width) {
        this.voxels = new VoxelImpl[(int)axisY][(int)axisX][(int)axisZ];
        this.voxelsFor2D = new VoxelImpl[(int)axisY][(int)axisX];
        this.radius = radius;
        this.height = height;
        this.width = width;
    }

    @Override
    public Voxel[][][] getVoxels() {
        return voxels;
    }

    @Override
    public Voxel[][][] get3D() {
        build();
        return voxels;
    }

    private void build() {
        for (int i = 0; i < voxels.length; i++) {
            for (int j = 0; j < voxels[0].length; j++) {
                for (int k = 0; k < voxels[0][0].length; k++) {
                    double a = i * 12 * Math.PI / 180;
                    double b = j * 12 * Math.PI / 180;
                    double x = radius * Math.sin(a) * Math.cos(b);
                    double y = radius * Math.sin(a) * Math.sin(b);
                    double z;
                    if (radius * Math.cos(a) > 0)
                        z = radius * Math.cos(a) + radius;
                    else
                        z = radius * Math.cos(a);
                    voxels[i][j][k] = new VoxelImpl(new PixelImpl((int) x, (int) y, new ColorImpl(0, 0, 0)), (int) z);
                }
            }
        }
    }

    @Override
    public Voxel[][] get2D() {
        draw();
        return voxelsFor2D;
    }

    private void draw() {
        for (int i = 0; i < voxelsFor2D.length; i++) {
            for (int j = 0; j < voxelsFor2D[0].length; j++) {
                double a = i * 12 * Math.PI / 180;
                double b = j * 12 * Math.PI / 180;
                double x = radius * Math.sin(a) * Math.cos(b);
                double y = radius * Math.sin(a) * Math.sin(b);
                double z;
                if (radius * Math.cos(a) > 0)
                    z = radius * Math.cos(a) + radius;
                else
                    z = radius * Math.cos(a);

                double x0, y0, z0;
                double degree = Math.PI / 180;
                x0 = x;
                y0 = y;
                z0 = z;
                double angleB = -45 * degree;
                double angleA = -45 * degree;
                x = x0 * Math.cos(angleA) + y0 * Math.sin(angleA);
                y = -x0 * Math.sin(angleA) * Math.cos(angleB) + y0 * Math.cos(angleA) * Math.cos(angleB) + z0 * Math.sin(angleB);
                z = x0 * Math.sin(angleA) * Math.sin(angleB) - y0 * Math.cos(angleA) * Math.sin(angleB) + z0 * Math.cos(angleB);

                voxelsFor2D[i][j] = new VoxelImpl(new PixelImpl((int) x, (int) y, new ColorImpl(0, 0, 0)), (int) z);
            }
        }
    }
}
