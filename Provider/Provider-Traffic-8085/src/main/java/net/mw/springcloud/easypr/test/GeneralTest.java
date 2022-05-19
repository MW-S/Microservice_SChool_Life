package net.mw.springcloud.easypr.test;

import static org.bytedeco.javacpp.opencv_highgui.imread;

import java.io.File;
import java.util.Vector;

import org.bytedeco.javacpp.opencv_core.Mat;
import net.mw.springcloud.easypr.core.CharsRecognise;
import net.mw.springcloud.easypr.core.PlateDetect;
import org.junit.Test;

public class GeneralTest {
	  
    @Test
    public void testPlateRecognise() {
    	System.out.println(System.getProperty("java.library.path"));
 
    
    	//File generalPath=new File("res/image/test_image");
    	File generalPath=new File("res/image/general_test");
        //String imgPath = "res/image/test_image/test.jpg";
        // String imgPath = "res/image/test_image/plate_recognize.jpg";
    	File[] files=generalPath.listFiles(); 
    	 System.out.println("files："+files.length);
    	for (int j = 0; j< files.length; j++) {
    		 System.out.println("j："+j);
    		try{
    			File file = files[j];
			    System.out.println("当前文件名称："+file.getPath());
				Mat src = imread(file.getPath());
		        PlateDetect plateDetect = new PlateDetect();
		        plateDetect.setPDLifemode(true);
		        Vector<Mat> matVector = new Vector<Mat>();
		        
		        if (0 == plateDetect.plateDetect(src, matVector)) {
		            CharsRecognise cr = new CharsRecognise();
		            
		            for (int i = 0; i < matVector.size(); ++i) {
		                String result = cr.charsRecognise(matVector.get(i));
		                System.out.println("Chars Recognised: " + result);
		                break;
		            }
		        }
    		}catch (Throwable e){
    			System.out.println(e.getMessage());
    		}
		}
      
    }
}
