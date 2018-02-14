package ru.wkn.object3d.model.picture.object3d.object3dunit;

import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.Pixel;

public class VoxelImpl implements Voxel {

    private Pixel pixel;
    private double z;

    public VoxelImpl(Pixel pixel, double z) {
        this.pixel = pixel;
        this.z = z;
    }

    @Override
    public Pixel getPixel() {
        return pixel;
    }

    @Override
    public double getZ() {
        return z;
    }
}
