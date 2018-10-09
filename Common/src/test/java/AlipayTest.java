import org.junit.Test;
import util.AlipayUtil;

import java.io.IOException;

/**
 * @author Administrator
 * @date 2018/8/10 0010
 */
public class AlipayTest {

	@Test
	public void test(){
		AlipayUtil alipayUtil = new AlipayUtil();
		String shopId = "tradeprecreate" + System.currentTimeMillis()   + (long) (Math.random() * 10000000L);
		try {
			String execute = alipayUtil.execute(shopId, "学习平台", "1000", "测试");
			System.out.println(execute);
		} catch (IOException e) {
			System.out.println("失败");
			e.printStackTrace();

		}
	}

	@Test
	public void test2(){

	}
}
