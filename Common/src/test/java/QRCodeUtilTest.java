import org.junit.Test;
import util.QRCodeUtil;

import java.io.IOException;

/**
 * @author Administrator
 * @date 2018/8/9 0009
 */
public class QRCodeUtilTest {

	@Test
	public void pructuerTest(){
		try {
			QRCodeUtil.createQRCode("https://qr.alipay.com/bax02023bizpwkzgix4s00e9","C://","9919");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
