package ru.wkn.object3d.model.picture.object3d.object3dunit;

import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.Pixel;

public class VoxelImpl implements Voxel {

    private Pixel pixel;
    private int z;

    public VoxelImpl(Pixel pixel, int z) {
        this.pixel = pixel;
        this.z = z;
    }

    @Override
    public Pixel getPixel() {
        return this.pixel;
    }

    @Override
    public int getZ() {
        return this.z;
    }
}
