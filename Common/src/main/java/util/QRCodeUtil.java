package util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Hashtable;

/**
 * @author Administrator
 * @date 2018/8/9 0009
 */

public class QRCodeUtil {


	/**
	 * 创建二维码
	 * @param url
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String createQRCode(String url,String fileDirectory,String fileName) throws IOException {
		int width = 500;
		int height = 500;
		String format = "png";
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);

			File fileDir = new File(fileDirectory);
			Path file = new File(fileDirectory,fileName+".png").toPath();//在D盘生成二维码图片
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
			ByteArrayOutputStream os = new ByteArrayOutputStream();//新建流。
			ImageIO.write(image, format, os);//利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
			byte b[] = os.toByteArray();//从流中获取数据数组。
			String str = new BASE64Encoder().encode(b);
			os.close();
			return str;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//DeleteFileUtil.delete(fileDirectory);
		}
		return "NULL";
	}


}
