import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {
	private double[][] dataSet2 = {{5,2,1},{7,3},{8,6,8,9}};
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	public void testGetRowTotal() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,1),.001);
	}
}
