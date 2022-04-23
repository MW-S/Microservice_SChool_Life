package net.mw.springcloud.easy.pr.util;

import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_highgui.imread;
import static org.bytedeco.javacpp.opencv_highgui.imwrite;
import java.util.Vector;

import net.mw.springcloud.easy.pr.core.CharsRecognise;
import net.mw.springcloud.easy.pr.core.PlateDetect;
import org.bytedeco.javacpp.opencv_core.Mat;
import java.io.File;



/**
 * @author lin.yao
 *
 */
public class Util {

    /**
     * get all files under the directory path
     * 
     * @param path
     * @param files
     */
    public static void getFiles(final String path, Vector<String> files) {
        getFiles(new File(path), files);
    }

    /**
     * delete and create a new directory with the same name
     * 
     * @param dir
     */
    public static void recreateDir(final String dir) {
        new File(dir).delete();
        new File(dir).mkdir();
    }
    
    private static void getFiles(final File dir, Vector<String> files) {
        File[] filelist = dir.listFiles();
        for (File file : filelist) {
            if (file.isDirectory()) {
                getFiles(file, files);
            } else {
                files.add(file.getAbsolutePath());
            }
        }
    }

    public static String recognize(String image) {
        String res = null;
        org.bytedeco.javacpp.Loader t;
        System.out.println("Current: " + image);
        Mat src = imread(image);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<Mat>();
        int recoginzeResult=plateDetect.plateDetect(src, matVector);
        if (0 == recoginzeResult) {
            CharsRecognise cr = new CharsRecognise();
            for (int i = 0; i < matVector.size(); ++i) {
                String result = cr.charsRecognise(matVector.get(i));
                res = result;
                System.out.println("Chars Recognised: " + result);
            }
        }else{
            System.out.println(recoginzeResult);
        }
        return res;
    }
}
