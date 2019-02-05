package edu.up.cs371.epp.photofunpattern;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 *  class BrightFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to increase an image brightness by value of 100.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class BrightnessFilter extends PhotoFilter {

    private final int ADJUSTMENT = 100;

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It adds 100 to each RGB color component. The maxium value of each
    * component is limited to 255
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components has been increased
    */
    public int transformPixel(int inPixel0, int inPixel1, int inPixel2, int inPixel3, int inPixel4,
                              int inPixel5, int inPixel6, int inPixel7, int inPixel8) {

        int outPixel4_r = Color.red(inPixel0) * 1 + Color.red(inPixel1) * 1 + Color.red(inPixel2) * -1 + Color.red(inPixel3) * 1 + Color.red(inPixel4) * -2 +
                Color.red(inPixel5) * -1 + Color.red(inPixel6) * 1 + Color.red(inPixel7) * 1 + Color.red(inPixel8) * -1;
        int outPixel4_g = Color.green(inPixel0) * 1 + Color.green(inPixel1) * 1 + Color.green(inPixel2) * -1 + Color.green(inPixel3) * 1 + Color.green(inPixel4) * -2 +
                Color.green(inPixel5) * -1 + Color.green(inPixel6) * 1 + Color.green(inPixel7) * 1 + Color.green(inPixel8) * -1;
        int outPixel4_b = Color.blue(inPixel0) * 1 + Color.blue(inPixel1) * 1 + Color.blue(inPixel2) * -1 + Color.blue(inPixel3) * 1 + Color.blue(inPixel4) * -2 +
                Color.blue(inPixel5) * -1 + Color.blue(inPixel6) * 1 + Color.blue(inPixel7) * 1 + Color.blue(inPixel8) * -1;


        return Color.argb(Color.alpha(inPixel4), outPixel4_r, outPixel4_g, outPixel4_b);
    }

    public Bitmap apply(Bitmap inBmp) {
        int width = inBmp.getWidth();
        int height = inBmp.getHeight();

        Bitmap newBmp = Bitmap.createBitmap(width, height, inBmp.getConfig());

        for (int w = 1; w < width-1; w++) {
            for (int h = 1; h < height-1; h++) {
                int inPixel0, inPixel1, inPixel2, inPixel3, inPixel4, inPixel5, inPixel6,
                        inPixel7, inPixel8, outPixel;

                inPixel4 = inBmp.getPixel(w, h);

                if(w != 0 && h != 0) inPixel0 = inBmp.getPixel(w-1, h-1);
                else inPixel0 = 0;
                if(h != 0) inPixel1 = inBmp.getPixel(w, h-1);
                else inPixel1 = 0;
                if(w != width && h != 0) inPixel2 = inBmp.getPixel(w+1, h-1);
                else inPixel2 = 0;
                if(w != 0) inPixel3 = inBmp.getPixel(w-1, h);
                else inPixel3 = 0;

                if(w != width) inPixel5 = inBmp.getPixel(w+1, h);
                else inPixel5 = 0;
                if(w != 0 && h != height) inPixel6 = inBmp.getPixel(w-1, h+1);
                else inPixel6 = 0;
                if(w != 0 && h != height) inPixel7 = inBmp.getPixel(w, h+1);
                else inPixel7 = 0;
                if(w != width && h != height) inPixel8 = inBmp.getPixel(w+1, h+1);
                else inPixel8 = 0;
                outPixel = transformPixel(inPixel0, inPixel1, inPixel2, inPixel3,inPixel4,
                        inPixel5, inPixel6, inPixel7, inPixel8);
                newBmp.setPixel(w, h, outPixel);
            }
        }
        return newBmp;
    }
}
