package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class GrayFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to convert the image to gray scale.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class SmoothingFilter extends PhotoFilter {

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It transforms a color pixel to gray by averaging its three RGB
    * components.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components is their averaged
    * value
    */
    public int transformPixel(int inPixel0, int inPixel1, int inPixel2, int inPixel3, int inPixel4, int inPixel5, int inPixel6, int inPixel7, int inPixel8) {
        int intensity0 = (Color.red(inPixel0) + Color.green(inPixel0) + Color.blue(inPixel0)) ;
        int intensity1 = (Color.red(inPixel1) + Color.green(inPixel1) + Color.blue(inPixel1));
        int intensity2 = (Color.red(inPixel2) + Color.green(inPixel2) + Color.blue(inPixel2));
        int intensity3 = (Color.red(inPixel3) + Color.green(inPixel3) + Color.blue(inPixel3));
        int intensity4 = (Color.red(inPixel4) + Color.green(inPixel4) + Color.blue(inPixel4)) / 5;
        int intensity5 = (Color.red(inPixel5) + Color.green(inPixel5) + Color.blue(inPixel5));
        int intensity6 = (Color.red(inPixel6) + Color.green(inPixel6) + Color.blue(inPixel6));
        int intensity7 = (Color.red(inPixel7) + Color.green(inPixel7) + Color.blue(inPixel7));
        int intensity8 = (Color.red(inPixel8) + Color.green(inPixel8) + Color.blue(inPixel8));
        int edgeIntensity1 = intensity1 + intensity3+ intensity5 + intensity7;
        edgeIntensity1 = edgeIntensity1 / 10;
        int digIntensity1 = intensity0 + intensity2+ intensity6 + intensity8;
        digIntensity1 = digIntensity1 / 10;
        int intensity = edgeIntensity1 + digIntensity1 + intensity4;
        intensity = intensity / 3;

        return Color.argb(Color.alpha(inPixel4), intensity,intensity,intensity);
    }

}
