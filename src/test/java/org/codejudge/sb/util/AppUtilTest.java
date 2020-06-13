package org.codejudge.sb.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUtilTest {

	@Test
	public void testFindDistance() {
		Double srcLatitude = Double.valueOf(53.32055555555556);
		Double srcLongitude = Double.valueOf(-1.7297222222222221);
		Double destLatitude = Double.valueOf(53.31861111111111);
		Double destLongitude = Double.valueOf(-1.6997222222222223);
		Double d = Double.valueOf(4);
		assertEquals(1, d.compareTo(AppUtil.findDistance(srcLatitude, srcLongitude, destLatitude, destLongitude)));
	}

}
