package pactera;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pactera.backend.PacteraApplication;

/**
 * @author Holly.Y.Yin
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PacteraApplication.class)
@WebAppConfiguration
public class PacteraApplicationTest {
	

	@Before
	public void init() {
		System.out.println("开始测试-----------------");
	}

	@After
	public void after() {
		System.out.println("测试结束-----------------");
	}

	@Test
	public void contextLoads() {

	}

}
