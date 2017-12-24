package ru.wkn.object3d.model.picture;

import ru.wkn.object3d.model.picture.canvas.Canvas;
import ru.wkn.object3d.model.picture.object3d.Object3D;
import ru.wkn.object3d.model.picture.object3d.editor3d.Editor;
import ru.wkn.object3d.model.picture.object3d.object3dunit.Voxel;
import ru.wkn.object3d.model.picture.object3d.object3dunit.pictureunit.pixelunit.ColorImpl;

public class PictureImpl implements Picture {

    private Voxel[][][] voxels;
    private Voxel[][] voxelsFor2D;
    private Object3D object3D;

    public PictureImpl(Object3D object3D) {
        this.object3D = object3D;
    }

    @Override
    public void redraw(Canvas canvas) {
        if (this.voxelsFor2D == null) {
            this.voxelsFor2D = object3D.get2D();
        }
        canvas.clearScene();
        for (int i = 0; i < voxelsFor2D.length - 1; i++) {
            for (int j = 0; j < voxelsFor2D[0].length - 1; j++) {
                canvas.drawLine(
                        voxelsFor2D[i][j].getPixel().getX(),
                        voxelsFor2D[i][j].getPixel().getY(),
                        voxelsFor2D[i][j + 1].getPixel().getX(),
                        voxelsFor2D[i][j + 1].getPixel().getY(),
                        new ColorImpl(0, 0, 0)
                );
                canvas.drawLine(
                        voxelsFor2D[i][j + 1].getPixel().getX(),
                        voxelsFor2D[i][j + 1].getPixel().getY(),
                        voxelsFor2D[i + 1][j + 1].getPixel().getX(),
                        voxelsFor2D[i + 1][j + 1].getPixel().getY(),
                        new ColorImpl(0, 0, 0)
                );
                canvas.drawLine(
                        voxelsFor2D[i + 1][j + 1].getPixel().getX(),
                        voxelsFor2D[i + 1][j + 1].getPixel().getY(),
                        voxelsFor2D[i + 1][j].getPixel().getX(),
                        voxelsFor2D[i + 1][j].getPixel().getY(),
                        new ColorImpl(0, 0, 0)
                );
                canvas.drawLine(
                        voxelsFor2D[i + 1][j].getPixel().getX(),
                        voxelsFor2D[i + 1][j].getPixel().getY(),
                        voxelsFor2D[i][j].getPixel().getX(),
                        voxelsFor2D[i][j].getPixel().getY(),
                        new ColorImpl(0, 0, 0)
                );
            }
        }
    }

    @Override
    public void setVoxelsFor2D(Voxel[][] voxelsFor2D) {
        this.voxelsFor2D = voxelsFor2D;
    }

    @Override
    public Voxel[][] getVoxelsFor2D() {
        return this.voxelsFor2D;
    }

    @Override
    public void edit(Editor editor) {
        editor.edit();
    }
}
