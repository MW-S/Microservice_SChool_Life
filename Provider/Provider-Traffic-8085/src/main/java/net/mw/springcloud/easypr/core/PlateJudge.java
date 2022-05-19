package net.mw.springcloud.easypr.core;

import static org.bytedeco.javacpp.opencv_core.CV_32FC1;
import static org.bytedeco.javacpp.opencv_imgproc.resize;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;

import cn.hutool.core.io.FileUtil;
import net.mw.springcloud.ProviderTrafficApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_core.Size;
import org.bytedeco.javacpp.opencv_ml.CvSVM;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Created by fanwenjie
 * @author lin.yao
 *
 */
public class PlateJudge {
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(PlateJudge.class);

    public PlateJudge() {
        loadModel();
    }

    public void loadModel() {
        loadModel(path);
    }

    public void loadModel(String s)  {
        String path = null;
        ClassPathResource classPathResource = new ClassPathResource(s);
        URL url = ProviderTrafficApplication.class.getResource("");
        String protocol = url.getProtocol();
        try {
            //判断是否在JAR包环境下
            if("jar".equals(protocol)){
                //JAR包环境下设置为同级目录下的config为父目录
                path = FileUtil.file(".", "config/" + s).getCanonicalPath();
                logger.error(path);
            }else{
                //开发环境下
                File svmFile = null;
                svmFile = classPathResource.getFile();
                path =  svmFile.getAbsolutePath();
                logger.info(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String path = System.getProperty("user.dir");
//        System.out.println(path);
//        String outpath = path + "/config/";
        svm.clear();
        svm.load( path, "svm");
    }
    
    /**
     * 对单幅图像进行SVM判断
     * 
     * @param inMat
     * @return
     */
    public int plateJudge(final Mat inMat) {
        Mat features = this.features.getHistogramFeatures(inMat);
        
        // 通过直方图均衡化后的彩色图进行预测
        Mat p = features.reshape(1, 1);
        p.convertTo(p, CV_32FC1);
        float ret = svm.predict(features);
       
        return (int) ret;
    }

    /**
     * 对多幅图像进行SVM判断
     * 
     * @param inVec
     * @param resultVec
     * @return
     */
    public int plateJudge(Vector<Mat> inVec, Vector<Mat> resultVec) {

        for (int j = 0; j < inVec.size(); j++) {
            Mat inMat = inVec.get(j);

            if (1 == plateJudge(inMat)) {
                resultVec.add(inMat);
            } else { // 再取中间部分判断一次
                int w = inMat.cols();
                int h = inMat.rows();

                Mat tmpDes = inMat.clone();
                Mat tmpMat = new Mat(inMat, new Rect((int) (w * 0.05), (int) (h * 0.1), (int) (w * 0.9),
                        (int) (h * 0.8)));
                resize(tmpMat, tmpDes, new Size(inMat.size()));

                if (plateJudge(tmpDes) == 1) {
                    resultVec.add(inMat);
                }
            }
        }

        return 0;
    }

    public void setModelPath(String path) {
        this.path = path;
    }

    public final String getModelPath() {
        return path;
    }

    private CvSVM svm = new CvSVM();

    /**
     * EasyPR的getFeatures回调函数, 用于从车牌的image生成svm的训练特征features
     */
    private SVMCallback features = new Features();

    /**
     * 模型存储路径
     */
    private String path =  "model/svm.xml";
//    private String path = getClass().getResource("/") + "res/model/svm.xml";
}
