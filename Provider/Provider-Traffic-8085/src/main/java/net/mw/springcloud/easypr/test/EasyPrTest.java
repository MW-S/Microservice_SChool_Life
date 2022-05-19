package net.mw.springcloud.easypr.test;


import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_highgui.imread;
import static org.bytedeco.javacpp.opencv_highgui.imwrite;
import static net.mw.springcloud.easypr.core.CoreFunc.getPlateType;
import static net.mw.springcloud.easypr.core.CoreFunc.projectedHistogram;
import static net.mw.springcloud.easypr.core.CoreFunc.showImage;

import java.util.Vector;

import org.bytedeco.javacpp.opencv_core.Mat;
import net.mw.springcloud.easypr.core.CharsIdentify;
import net.mw.springcloud.easypr.core.CharsRecognise;
import net.mw.springcloud.easypr.core.CoreFunc;
import net.mw.springcloud.easypr.core.PlateDetect;
import net.mw.springcloud.easypr.core.PlateLocate;
import org.junit.Test;

/**
 * @author lin.yao
 * 
 */
public class EasyPrTest {
    
    @Test
    public void testPlateRecognise() {
//    	System.out.println(System.getProperty("java.library.path"));
//    	String imgPath = "res/image/test_image/Y44748.jpg";
//        String imgPath = "res/image/test_image/chars_recognise_suEUK722.jpg";
//    	String imgPath = "res/image/baidu_image/test";
//    	String imgPath = "D:\\PlateDetect\\test\\F0188.jpg";
//    	recognize(imgPath);
/*    	for(int i=1;i<=19;i++) {
    		recognize(imgPath + i + ".jpg");
    	}*/
    	
//        String path = "D:\\PlateDetect\\test\\";
//        String[] imgs = {"9X612.jpg", "AFD9150.jpg", "KC375R.jpg", "KY835.jpg"};
//        for(String imagePath: imgs) {
//        	 recognize(path + imagePath);
//        }
    	String imgPath = "D:\\PlateDetect\\test\\Q8999.jpg";
    	recognize(imgPath);
    }

    /**
     *  识别车牌
     * 2022年5月14日
     * String
     */
    public String recognize(String image) {
    	String res = null;
//    	org.bytedeco.javacpp.Loader t;
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
    /**
     * 车牌位置定位
     * 2022年5月14日
     * void
     */
    @Test
    public void testPlateDetect() {
        String imgPath = "D:\\PlateDetect\\test\\DD6666.jpg";

        Mat src = imread(imgPath);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            for (int i = 0; i < matVector.size(); ++i) {
                showImage("Plate Detected", matVector.get(i));
            }
        }
    }

    /**
     * 车牌位置定位
     * 2022年5月14日
     * void
     */
    @Test
    public void testPlateLocate() {
        String imgPath =  "D:\\PlateDetect\\test\\9X612_cut.jpg";

        Mat src = imread(imgPath);

        PlateLocate plate = new PlateLocate();
        plate.setDebug(true);
        plate.setLifemode(true);

        Vector<Mat> resultVec = plate.plateLocate(src);

        int num = resultVec.size();
        for (int j = 0; j < num; j++) {
             showImage("Plate Located " + j, resultVec.get(j));
        }

        return;
    }

    /**
     * 车牌字符识别
     * 2022年5月14日
     * void
     */
    @Test
    public void testCharsRecognise() {
        String imgPath = "D:\\PlateDetect\\temp\\result_.png";
//        String imgPath = "D:\\PlateDetect\\test\\D12345.jpg";
        //String imgPath = "res/image/test_image/Y44748.jpg";
        Mat src = imread(imgPath);
        CharsRecognise cr = new CharsRecognise();
        cr.setCRDebug(true);
        for(int i = 0; i<10; i++) {
        	String result = cr.charsRecognise(src);
        	System.out.println(i);
            System.out.println("\tChars Recognised: " + result);
        }
    }

    @Test
    public void testColorDetect() {
        String imgPath = "res/image/test_image/core_func_yellow.jpg";

        Mat src = imread(imgPath);

        CoreFunc.Color color = getPlateType(src, true);
        System.out.println("Color Deteted: " + color);
    }

    @Test
    public void testProjectedHistogram() {
        String imgPath = "res/image/test_image/chars_identify_E.jpg";

        Mat src = imread(imgPath);
        projectedHistogram(src, CoreFunc.Direction.HORIZONTAL);
    }

    @Test
    public void testCharsIdentify() {
        String imgPath = "res/image/test_image/chars_identify_E.jpg";

        Mat src = imread(imgPath);
        CharsIdentify charsIdentify = new CharsIdentify();
        String result = charsIdentify.charsIdentify(src, false, true);
        System.out.println(result);
    }

    /**
     * 测试检测绿牌颜色
     */
    @Test
    public void testGreenColorReco() {
        String imgPath = "D:\\PlateDetect\\test\\D12345.jpg";
        Mat src = imread(imgPath);

        // 判断绿色车牌
        Mat src_hsv = new Mat();
        cvtColor(src, src_hsv, CV_BGR2HSV);
        src_hsv = CoreFunc.colorMatch(src, CoreFunc.Color.GREEN, true);
        System.err.println(CoreFunc.plateColorJudge(src, CoreFunc.Color.GREEN, true));
        String str = "d:/PlateDetect/src_hsv.png";
        imwrite(str, src_hsv);
    }

    @Test
    public void testGreenPlate() {
        String imgPath = "D:\\PlateDetect\\test\\Q8999.jpg";
//    	String imgPath = "res/image/baidu_image/test1.jpg";
        Mat src = imread(imgPath);

        // 车牌检测对象
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        plateDetect.setPDDebug(true); // 将过程的图块保存到盘符

        Vector<Mat> matVector = new Vector<Mat>();

        System.err.println(plateDetect.plateDetect(src, matVector));
        System.err.println(matVector.size());

        for (int i = 0; i < matVector.size(); ++i) { // 遍历车牌图块Mat，进行识别
            Mat img = matVector.get(i);

            String str = "d:/PlateDetect/temp/result_"+ i +".png";
           imwrite(str, img);

        }

    }
}
