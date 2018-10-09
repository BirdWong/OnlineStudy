package util;

import entity.Result;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Administrator
 * @date 2018/8/10 0010
 */
public class AlipayUtil {


	private String file_server_url = "http://jijiking.51vip.biz:45570/";

	AlipayTemlete alipayTemlete = new AlipayTemlete();

	public String execute(String shopId, String name, String money, String description) throws IOException {

		Result result = alipayTemlete.test_trade_precreate(shopId, name, money, description);
		String massage = result.getMassage();
		System.out.println(massage);
		massage = massage.replace("\\", "");

		massage = massage.replace("\"","");
		String filename = "" + System.currentTimeMillis()   + (long) (Math.random() * 10000000L);

		FastDFSClient client = null;
		try {
			client = new FastDFSClient("classpath:config/fdfs_client.conf");
			QRCodeUtil.createQRCode(massage,"C:\\Users\\Administrator\\Desktop\\",filename);
			File file = new File("C:\\Users\\Administrator\\Desktop\\"+filename+".png");
			FileInputStream fileInputStream = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = fileInputStream.read(b)) != -1){
				bos.write(b,0,n);
			}
			fileInputStream.close();;
			bos.close();;
			byte[] buffer = bos.toByteArray();
			String[] information = client.uploadFile(buffer,"png");
			String fileId = information[0] + "/" +information[1];
			//图片完整地址
			String url = file_server_url + fileId;
			return  url;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  null;
	}



	public boolean test_trade_query(String No){
		return  alipayTemlete.test_trade_query(No);
	}
}
