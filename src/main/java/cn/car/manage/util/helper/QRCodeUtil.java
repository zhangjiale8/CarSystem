package cn.car.manage.util.helper;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码生成工具类
 * 
 * @author xzy
 */
public class QRCodeUtil {

	/**
	 * 二维码宽
	 */
	private static int QRCode_width = 125;
	/**
	 * 二维码高
	 */
	private static int QRCode_height = 125;
	/**
	 * logo宽
	 */
	private static int IMAGE_WIDTH;
	/**
	 * logo高
	 */
	private static int IMAGE_HEIGHT;
	private static int IMAGE_HALF_WIDTH;
	private static final int FRAME_WIDTH = 2;
	/**
	 * 是否显示LOGO（手动修改）
	 */
	private static final boolean IsSHOW = true;
	private static MultiFormatWriter mutiWriter = new MultiFormatWriter();
	/**
	 * LOGO图片路径配置文件
	 */
	private static String qrcodeFileName = "qrcodeUrl.properties";
	private static Properties pro = new Properties();

	/**
	 * 
	 * @param content 二维码中的信息
	 * @param width 二维码宽
	 * @param heigh 二维码高
	 * @param srcImagePath logo路径
	 * @param outQRCode
	 */
	public static void encode(String content, int width, int height, String srcImagePath, OutputStream outQRCode) {
		try {
			QRCode_width = width;
			QRCode_height = height;
			IMAGE_WIDTH = QRCode_width/5;
			IMAGE_HEIGHT = QRCode_height/5;
			IMAGE_HALF_WIDTH = IMAGE_WIDTH / 2;
			ImageIO.write(genBarcode(content, QRCode_width, QRCode_height, srcImagePath), "jpg", outQRCode);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriterException e) {
			e.printStackTrace();
		}catch(IllegalArgumentException e){
			System.err.println("没有找到LOGO图片文件。原因：qrcodeUrl.properties文件没有对应的键，或者值为空");
		}
	}

	/**
	 * 
	 * @param content 二维码中的信息
	 * @param width 二维码宽
	 * @param height 二维码高
	 * @param srcImagePath logo路径
	 * @return
	 * @throws WriterException
	 * @throws IOException
	 */
	private static BufferedImage genBarcode(String content, int width, int height, String srcImagePath)
			throws WriterException, IOException {
		
		Map<EncodeHintType, Object> hint = new HashMap<EncodeHintType, Object>();
		hint.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 生成二维码
		BitMatrix matrix = mutiWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hint);
		// 二维矩阵转为一维像素数组
		int halfW = matrix.getWidth() / 2;
		int halfH = matrix.getHeight() / 2;
		int[] pixels = new int[width * height];
		if(IsSHOW){
			BufferedImage scaleImage = scale(srcImagePath, IMAGE_WIDTH, IMAGE_HEIGHT, true);
			if(scaleImage==null){
				return null;
			}
			int[][] srcPixels = new int[IMAGE_WIDTH][IMAGE_HEIGHT];
			for (int i = 0; i < scaleImage.getWidth(); i++) {
				for (int j = 0; j < scaleImage.getHeight(); j++) {
					srcPixels[i][j] = scaleImage.getRGB(i, j);
				}
			}
			for (int y = 0; y < matrix.getHeight(); y++) {
				for (int x = 0; x < matrix.getWidth(); x++) {
					// 左上角颜色,根据自己需要调整颜色范围和颜色
					/*if (x > 0 && x < 170 && y > 0 && y < 170) {
						Color color = new Color(231, 144, 56);
						int colorInt = color.getRGB();
						pixels[y * width + x] = matrix.get(x, y) ? colorInt : 16777215;
					}*/
					// 读取图片
					/*else*/ if (x > halfW - IMAGE_HALF_WIDTH && x < halfW + IMAGE_HALF_WIDTH && y > halfH - IMAGE_HALF_WIDTH
							&& y < halfH + IMAGE_HALF_WIDTH) {
						pixels[y * width + x] = srcPixels[x - halfW + IMAGE_HALF_WIDTH][y - halfH + IMAGE_HALF_WIDTH];
					} 
					//LOGO外边框
					else if ((x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH && x < halfW - IMAGE_HALF_WIDTH + FRAME_WIDTH
							&& y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH + IMAGE_HALF_WIDTH + FRAME_WIDTH)
							|| (x > halfW + IMAGE_HALF_WIDTH - FRAME_WIDTH && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
									&& y > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH + IMAGE_HALF_WIDTH + FRAME_WIDTH)
							|| (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
									&& y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH - IMAGE_HALF_WIDTH + FRAME_WIDTH)
							|| (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH && x < halfW + IMAGE_HALF_WIDTH + FRAME_WIDTH
									&& y > halfH + IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH + IMAGE_HALF_WIDTH + FRAME_WIDTH)) {
						pixels[y * width + x] = 0xfffffff;
						// 在图片四周形成边框
					} else {
						// 二维码颜色
						int num1 = (int) (50 - (50.0 - 13.0) / matrix.getHeight() * (y + 1));
						int num2 = (int) (165 - (165.0 - 72.0) / matrix.getHeight() * (y + 1));
						int num3 = (int) (162 - (162.0 - 107.0) / matrix.getHeight() * (y + 1));
						Color color = new Color(num1, num2, num3);
						int colorInt = color.getRGB();
						// 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
						pixels[y * width + x] = matrix.get(x, y) ? colorInt : 16777215;
						// 0x000000:0xffffff
					}
				}
			}
		}else{
			for (int y = 0; y < matrix.getHeight(); y++) {
				for (int x = 0; x < matrix.getWidth(); x++) {
					// 二维码颜色
					int num1 = (int) (50 - (50.0 - 13.0) / matrix.getHeight() * (y + 1));
					int num2 = (int) (165 - (165.0 - 72.0) / matrix.getHeight() * (y + 1));
					int num3 = (int) (162 - (162.0 - 107.0) / matrix.getHeight() * (y + 1));
					Color color = new Color(num1, num2, num3);
					int colorInt = color.getRGB();
					// 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
					pixels[y * width + x] = matrix.get(x, y) ? colorInt : 16777215;
					// 0x000000:0xffffff
				}
			}
		}
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image.getRaster().setDataElements(0, 0, width, height, pixels);
		return image;
	}

	/**
	 * 
	 * @param srcImageFile logo路径
	 * @param height logo高
	 * @param width logo宽
	 * @param hasFiller 
	 * @return
	 * @throws IOException
	 */
	private static BufferedImage scale(String srcImageFile, int height, int width, boolean hasFiller)
			throws IOException {
		double ratio = 0.0; // 缩放比例
			//调用配置文件，选择需要的LOGO
			InputStreamReader reader = new InputStreamReader(QRCodeUtil.class.getClassLoader().getResourceAsStream(qrcodeFileName), "UTF-8"); 
			pro.load(reader);
			String result = pro.getProperty("qrcodeLOGO.TestImage");
			if(result==null || result.trim().equals("")){
				return null;
			}
		//读取LOGO图片
		File file = new File(srcImageFile+"resource"+File.separator+"img"+File.separator+"QRCodeImage"+File.separator+result);
		BufferedImage srcImage = ImageIO.read(file);
		Image destImage = srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		// 计算比例
		if ((srcImage.getHeight() > height) || (srcImage.getWidth() > width)) {
			if (srcImage.getHeight() > srcImage.getWidth()) {
				ratio = (new Integer(height)).doubleValue() / srcImage.getHeight();
			} else {
				ratio = (new Integer(width)).doubleValue() / srcImage.getWidth();
			}
			AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
			destImage = op.filter(srcImage, null);
		}
		if (hasFiller) {
			// 补白
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphic = image.createGraphics();
			graphic.setColor(Color.white);
			graphic.fillRect(0, 0, width, height);
			if (width == destImage.getWidth(null))
				graphic.drawImage(destImage, 0, (height - destImage.getHeight(null)) / 2, destImage.getWidth(null),
						destImage.getHeight(null), Color.white, null);
			else
				graphic.drawImage(destImage, (width - destImage.getWidth(null)) / 2, 0, destImage.getWidth(null),
						destImage.getHeight(null), Color.white, null);
			graphic.dispose();
			destImage = image;
		}
		return (BufferedImage) destImage;
	}
}
