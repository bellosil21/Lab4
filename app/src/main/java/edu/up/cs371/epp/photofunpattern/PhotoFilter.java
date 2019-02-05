package edu.up.cs371.epp.photofunpattern;

import android.graphics.Bitmap;

/**
 *  class PhotoFilter is the abstract filter parent class. Its default behavior
 *  is the leave an image unchanged.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */
public abstract class PhotoFilter {

    /*
    * constrain This method does not permit an RGB color value to over or under
    * saturate. It maintains values between 0 and 255 inclusive.
    *
    * @param inPixel is an integer input color component value that may be out
    *                of range
    * @return a new color component in range
    */
    protected int constrain(int color) {
        if (color > 255)
            return 255;
        else if (color < 0)
            return 0;
        else
            return color;
    }

    /*
    * tranformPixel This is the default transform method. It leaves the pixel
    * unchanged. It implements a copy image function.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which unchanged color components
    */
    protected int transformPixel (int inPixel0, int inPixel1, int inPixel2, int inPixel3, int inPixel4, int inPixel5, int inPixel6, int inPixel7, int inPixel8){
        return inPixel0;
    }

    /*
    * apply This method visits every pixel in the input image. It applies a
    * transform to each pixel.
    *
    * @param inBmp is the original image
    * @return a new image in which each pixel has been transformed
    */
    public Bitmap apply(Bitmap inBmp) {
        int width = inBmp.getWidth();
        int height = inBmp.getHeight();

        Bitmap newBmp = Bitmap.createBitmap(width, height, inBmp.getConfig());
        //we set w and h = 1 in order to avoid bo
        for (int w = 1; w < width-1; w++) {
            for (int h = 1; h < height-1; h++) {
                int inPixel0 = inBmp.getPixel(w-1,h-1);
                int inPixel1 = inBmp.getPixel(w,h-1);
                int inPixel2 = inBmp.getPixel(w+1,h-1);
                int inPixel3 = inBmp.getPixel(w-1,h);
                int inPixel4 = inBmp.getPixel(w,h);
                int inPixel5 = inBmp.getPixel(w+1,h);
                int inPixel6 = inBmp.getPixel(w-1,h+1);
                int inPixel7 = inBmp.getPixel(w,h+1);
                int inPixel8 = inBmp.getPixel(w+1,h+1);

                int outPixel = transformPixel(inPixel0, inPixel1, inPixel2, inPixel3, inPixel4, inPixel5, inPixel6, inPixel7, inPixel8);
                newBmp.setPixel(w, h, outPixel);
            }
        }
        return newBmp;
    }
}
