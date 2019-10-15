package com.noah.demo.tools;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.font.FontDesignMetrics;

/**
 * 图片处理工具 小心内存泄露,及图片内容中文字乱码
 * 
 * @author leyan
 *
 */
@SuppressWarnings("restriction")
@Slf4j
public class WxImageTool {
    protected static Logger logger = LoggerFactory.getLogger(WxImageTool.class);
    
    /**
     * @throws IOException 
     * 
    * @Title: byte2BufferedImage
    * @author: wang_rui
    * @Description: byte 转 BufferedImage
    * @param @param b
    * @param @return
    * @return BufferedImage
    * @throws
     */
    public static BufferedImage byte2BufferedImage(byte[] b) throws IOException{
    	ByteArrayInputStream in = new ByteArrayInputStream(b); 
    	BufferedImage image = ImageIO.read(in);
    	return image;
    }

    
    /**
    * 转换BufferedImage 数据为byte数组
    * 
    * @param image
    * Image对象
    * @param format
    * image格式字符串.如"gif","png"
    * @return byte数组
    */
    public static byte[] imageToBytes(BufferedImage bImage, String format) {
    	ByteArrayOutputStream out = new ByteArrayOutputStream();
	    try {
	    	
	    	BufferedImage bufferedImage = new BufferedImage(bImage.getWidth(), bImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);  
	    	bufferedImage.getGraphics().drawImage(bImage, 0, 0, null);  	
	    
	    
	    	ImageIO.write(bufferedImage, format, out);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return out.toByteArray();
    }
    
    /**
     * 
    * @Title: saveImageUsingJPGWithQuality
    * @author: wang_rui
    * @Description: 无损生成jpg
    * @param @param image
    * @param @param filePath
    * @param @param quality
    * @param @throws Exception
    * @return void
    * @throws
     */
    public static void saveImageUsingJPGWithQuality(BufferedImage image,  
            String filePath,String fileName, float quality) throws Exception {  
  
    	File dir=new File(filePath);  
        if(!dir.exists() && !dir.isDirectory()){//判断文件目录是否存在    
            dir.mkdirs();    
        }  
    	
        BufferedImage newBufferedImage = new BufferedImage(image.getWidth(),  
                image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);  
        newBufferedImage.getGraphics().drawImage(image, 0, 0, null);  
  
        Iterator<ImageWriter> iter = ImageIO  
                .getImageWritersByFormatName("jpeg");  
  
        ImageWriter imageWriter = iter.next();  
        ImageWriteParam iwp = imageWriter.getDefaultWriteParam();  
  
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);  
        iwp.setCompressionQuality(quality);  
  
        File file = new File(filePath + fileName);  
        FileImageOutputStream fileImageOutput = new FileImageOutputStream(file);  
        
        try {
			imageWriter.setOutput(fileImageOutput);  
			IIOImage iio_image = new IIOImage(newBufferedImage, null, null);  
			imageWriter.write(null, iio_image, iwp);
		} catch (Exception e) {
            System.out.println(e.getMessage());  
            e.printStackTrace();   
		}finally{
	        imageWriter.dispose();
	        fileImageOutput.close();
		}

    } 
    
    
   /**
    * 
   * @Title: getQrPostersZQ
   * @author: wang_rui
   * @Description: 获取桌签的流
   * @param @param bytes
   * @param @param no
   * @param @param stationName
   * @param @return
   * @param @throws IOException
   * @return BufferedImage
   * @throws
    */
    public static BufferedImage getQrPostersZQ(byte[] bytes , String no,String stationName) throws IOException{
    	//海报模版
    	BufferedImage bgBuffer = ImageIO.read(getModFile("/posters/postersZQ.jpg"));
    	
    	//小程序的菊花码
    	BufferedImage qrCodeBuffer = byte2BufferedImage(bytes);
    	
    	//把海报和菊花码合并
    	BufferedImage mergeBuffer = synthesisPicAtXy(bgBuffer, qrCodeBuffer, 189, 434);
    	
    	
    	//字体配置
		int fontSize = 75;
    	Color c = new Color(255,112,38);
		Font font = new Font("微软雅黑",Font.PLAIN, fontSize);
		
		//添加固定标语
		FontMetrics fm = FontDesignMetrics.getMetrics(font);
		mergeBuffer = WxImageTool.addTxtAtXy(mergeBuffer, "武汉市\"双评议\"参评单位", (1301 - fm.stringWidth("武汉市\"双评议\"参评单位"))/2, 1400, font, c);
		
		//合并站名
		stationName = no + stationName;
		
		if(1301 - fm.stringWidth(stationName) < 0){
			//文字长度与海报的对比，如果文字太长，则缩小字体
			while(1301 - fm.stringWidth(stationName) < 0){
				font = new Font("微软雅黑",Font.PLAIN, fontSize);
				fm = FontDesignMetrics.getMetrics(font);
				fontSize -- ;
			}
		}
		
		//计算左边要空多少
		int leftLen = (1301 - fm.stringWidth(stationName))/2;
		
		//添加站名
		mergeBuffer = WxImageTool.addTxtAtXy(mergeBuffer, stationName, leftLen, 1500, font, c);

    	return mergeBuffer;

    }
    
    
    /**
     * 
    * @Title: getQrPostersHB
    * @author: wang_rui
    * @Description: 获取海报的流
    * @param @param bytes
    * @param @param no
    * @param @param stationName
    * @param @return
    * @param @throws IOException
    * @return BufferedImage
    * @throws
     */
     public static BufferedImage getQrPostersHB(byte[] bytes , String no,String stationName) throws IOException{
     	//海报模版
     	BufferedImage bgBuffer = ImageIO.read(getModFile("/posters/postersHB.jpg"));
     	
     	//小程序的菊花码
     	BufferedImage qrCodeBuffer = byte2BufferedImage(bytes);
     	
     	qrCodeBuffer = resizeByWidth(qrCodeBuffer, 1500);

     	
     	//把海报和菊花码合并
     	BufferedImage mergeBuffer = synthesisPicAtXy(bgBuffer, qrCodeBuffer, 0, 0);
     	
     	//字体配置
 		int fontSize = 110;
     	Color c = new Color(235,94,58);
 		Font font = new Font("微软雅黑",Font.PLAIN, fontSize);
 		
 		//添加固定标语
 		FontMetrics fm = FontDesignMetrics.getMetrics(font);
 		mergeBuffer = WxImageTool.addTxtAtXy(mergeBuffer, "武汉市\"双评议\"参评单位", (1500 - fm.stringWidth("武汉市\"双评议\"参评单位"))/2, 1650, font, c);
 		
 		//合并站名
 		stationName = no + stationName;
 		if(1500 - fm.stringWidth(stationName) < 0){
 			//文字长度与海报的对比，如果文字太长，则缩小字体
 			while(1500 - fm.stringWidth(stationName) < 0){
 				font = new Font("微软雅黑",Font.PLAIN, fontSize);
 				fm = FontDesignMetrics.getMetrics(font);
 				fontSize -- ;
 			}
 		}
 		
 		//计算左边要空多少
 		int leftLen = (1500 - fm.stringWidth(stationName))/2;
 		
 		//添加站名
 		mergeBuffer = WxImageTool.addTxtAtXy(mergeBuffer, stationName, leftLen, 1850, font, c);

     	return mergeBuffer;

     }
    
    

    /**
     * 获取图片背景
     * @return
     */
   private static InputStream getModFile(String filePath) {
		InputStream input = null;
		try {
			input = Class.forName(WxImageTool.class.getName()).getResourceAsStream(filePath);
			return input;
		} catch (Exception e) {
			log.error("！！！！！！！！！没有找到下载模板！！！！！！！！");
			e.printStackTrace();
		}
		return null;
	}

    /**
     * 获取指定字体指定内容的宽度
     * 
     * @param font
     * @param content
     * @return
     */
    public static int getWordWidth(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = 0;
        for (int i = 0; i < content.length(); i++) {
            width += metrics.charWidth(content.charAt(i));
        }
        return width;
    }

    /**
     * 获取指定字体指定内容的宽度
     * 
     * @param font
     * @param content
     * @return
     */
    public static int getWordWidthBody(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);

        return metrics.stringWidth(content);

    }

    /**
     * 按比例裁剪图片
     * 
     * @param src
     *            待处理的图片流
     * @param startX
     *            开始x坐标
     * @param startY
     *            开始y坐标
     * @param endX
     *            结束x坐标
     * @param endY
     *            结束y坐标
     * @return
     */
    public static BufferedImage crop(BufferedImage src, int startX, int startY, int endX, int endY) {
        int width = src.getWidth();
        int height = src.getHeight();
        if (startX <= -1) {
            startX = 0;
        }
        if (startY <= -1) {
            startY = 0;
        }
        if (endX <= -1) {
            endX = width - 1;
        }
        if (endY <= -1) {
            endY = height - 1;
        }
        BufferedImage result = new BufferedImage(endX, endY, src.getType());
        for (int y = startY; y < endY + startY; y++) {
            for (int x = startX; x < endX + startX; x++) {
                int rgb = src.getRGB(x, y);
                result.setRGB(x - startX, y - startY, rgb);
            }
        }
        return result;
    }

    /**
     * 对图片进行强制放大或缩小
     * 
     * @param originalImage
     *            原始图片
     * @return
     */
    public static BufferedImage zoomInImage(BufferedImage originalImage, int width, int height) {
        /* 新建一个空白画布 */
        BufferedImage image = new BufferedImage(width, height, originalImage.getType());
        // BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        /* 设置背景透明 */
        image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        // g2d.dispose();
        g2d = image.createGraphics();

        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return image;
    }

    /**
     * 实现图像的等比缩放(固定宽度)
     * 
     * @param source
     *            待处理的图片流
     * @param targetW
     *            宽度
     * @return
     */
    public static BufferedImage resizeByWidth(BufferedImage source, double targetW) {
        double targetH = 0;
        double width = source.getWidth();// 图片宽度
        double height = source.getHeight();// 图片高度
        targetH = targetW / width * height;

        return zoomInImage(source, (int) targetW, (int) targetH);

    }

    /**
     * 实现图像的等比缩放(固定高度)
     * 
     * @param source
     *            待处理的图片流
     * @param targetH
     *            高度
     * @return
     */
    public static BufferedImage resizeByHeight(BufferedImage source, double targetH) {
        double targetW;

        double width = source.getWidth();// 图片宽度
        double height = source.getHeight();// 图片高度
        targetW = targetH / height * width;

        return zoomInImage(source, (int) targetW, (int) targetH);
        // 图片宽高都太小时，强制放大图片
    }

    /***
     *
     * @param srcFilePath
     *            源图片文件路径
     * @param circularImgSavePath
     *            新生成的图片的保存路径，需要带有保存的文件名和后缀
     * @param targetSize
     *            文件的边长，单位：像素，最终得到的是一张正方形的图，所以要求targetSize<=源文件的最小边长
     * @param cornerRadius
     *            圆角半径，单位：像素。如果=targetSize那么得到的是圆形图
     * @return 文件的保存路径
     * @throws IOException
     */
    public static String roundImage(String srcImgPath, String destImgPath, int targetSize, int cornerRadius) {
        BufferedImage bufferedImage = null;
        BufferedImage circularBufferImage = null;
        try {
            bufferedImage = ImageIO.read(new File(srcImgPath));
            circularBufferImage = roundImage(bufferedImage, targetSize, cornerRadius);
            ImageIO.write(circularBufferImage, "png", new File(destImgPath));
            return destImgPath;
        } catch (Exception e) {
            logger.error("图片合成roundImage异常：" + e);
        } finally {
            if (bufferedImage != null) {
                bufferedImage.flush();
                bufferedImage = null;
            }
            if (circularBufferImage != null) {
                circularBufferImage.flush();
                circularBufferImage = null;
            }

        }

        return destImgPath;
    }

    /**
     * 将图片处理为圆角图片
     * 
     * @param image
     * @param targetSize
     *            直径
     * @param cornerRadius
     * @return
     */
    public static BufferedImage roundImage(BufferedImage image, int targetSize, int cornerRadius) {
        BufferedImage outputImage = new BufferedImage(targetSize, targetSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = outputImage.createGraphics();

        g2d.setComposite(AlphaComposite.Src);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.fill(new RoundRectangle2D.Float(0, 0, targetSize, targetSize, cornerRadius, cornerRadius));
        g2d.setComposite(AlphaComposite.SrcAtop);
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return outputImage;
    }

    /**
     * 将第二张图片放到第一张的指定位置
     * 
     * @param first
     * @param second
     * @param out
     * @param x
     * @param y
     */
    public static BufferedImage synthesisPicAtXy(BufferedImage imageFirst, BufferedImage imageSecond, int x, int y) {
        BufferedImage image = null;
        try {
            /* 读取第一张图片 宽高 */
            int width = imageFirst.getWidth();// 图片宽度
            int height = imageFirst.getHeight();// 图片高度

            /* 读取第二张图片 宽高 */
            int widthTwo = imageSecond.getWidth();// 图片宽度
            int heightTwo = imageSecond.getHeight();// 图片高度

            /* 计算总宽度 */
            int w = 0;
            if (x + widthTwo > width) {
                w = widthTwo + x;
            } else {
                w = width;
            }

            /* 计算总高度 */
            int h = 0;
            if (y + heightTwo > height) {
                h = heightTwo + y;
            } else {
                h = height;
            }

            /* 新建一个空白画布 */
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();

            g2d = image.createGraphics();
            g2d.drawImage(imageFirst, 0, 0, w, h, null);
            g2d.drawImage(imageSecond, x, y, widthTwo, heightTwo, null);

            return image;

        } catch (Exception e) {
            if (image != null) {
                image.flush();
                image = null;
            }
            logger.error("横向合成图片出错....", e);
        }
        return null;
    }

    /**
     * 将第二张图片放到第一张的指定位置
     * 
     * @param first
     * @param second
     * @param out
     * @param x
     * @param y
     */
    public static String synthesisPicAtXy(String first, String second, String out, int x, int y) {
        BufferedImage imageFirst = null;
        BufferedImage imageSecond = null;
        BufferedImage outBuffered = null;
        try {
            File fileOne = new File(first);
            imageFirst = ImageIO.read(fileOne);
            File fileTwo = new File(second);
            imageSecond = ImageIO.read(fileTwo);
            outBuffered = synthesisPicAtXy(imageFirst, imageSecond, x, y);
            File outFile = new File(out);
            ImageIO.write(outBuffered, "png", outFile);// 写图片
            return out;

        } catch (Exception e) {
            logger.error("横向合成图片出错....", e);
        } finally {
            if (imageFirst != null) {
                imageFirst.flush();
                imageFirst = null;
            }
            if (imageSecond != null) {
                imageSecond.flush();
                imageSecond = null;
            }
            if (outBuffered != null) {
                outBuffered.flush();
                outBuffered = null;
            }
        }
        return null;
    }

    /**
     * 将文字添加到图片指定的位置
     * 
     * @param src
     * @param out
     * @param x
     * @param y
     * @param center
     *            可选居中 默认false
     * @param f
     * @return
     */
    public static String addTxtAtXy(String src, String out, String txt, int x, int y, boolean center, Font font,
            Color color) {
        BufferedImage picBuffer = null;
        BufferedImage outBuffered = null;
        try {
            File fileOne = new File(src);
            picBuffer = ImageIO.read(fileOne);
            outBuffered = addTxtAtXy(picBuffer, txt, x, y, font, color);
            File outFile = new File(out);
            ImageIO.write(outBuffered, "png", outFile);// 写图片
            return out;

        } catch (Exception e) {
            logger.error("横向合成图片出错....", e);
            // e.printStackTrace(e);
        } finally {
            if (picBuffer != null) {
                picBuffer.flush();
                picBuffer = null;
            }
        }
        return null;
    }

    /**
     * 将文字txt添加到图片指定的位置(x,y)
     * 
     * @param src
     * @param txt
     * @param x
     * @param y
     * @param center
     *            可选水平居中 默认false
     * @param f
     * @return
     */
    public static BufferedImage addTxtAtXy(BufferedImage src, String txt, int x, int y, Font font, Color color) {
        BufferedImage outBuffer = null;
        try {

            /* 读取图片 宽高 */
            int width = src.getWidth();// 图片宽度
            int height = src.getHeight();// 图片高度

            /* 新建一个空白画布 */
            outBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = outBuffer.createGraphics();
            
            g2d = outBuffer.createGraphics();
            g2d.drawImage(src, 0, 0, width, height, null);

            g2d.setColor(color);
            g2d.setFont(font);

            // 10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
            g2d.drawString(txt, x, y);
            g2d.dispose();
            return outBuffer;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // e.printStackTrace(e);
            logger.error("合成图片 添加文字出错....", e);
        }
        return null;

    }
}
