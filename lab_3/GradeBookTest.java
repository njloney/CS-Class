import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	private GradeBook gradebook1;
    private GradeBook gradebook2;
	@Before
	public void setUp() {
        gradebook1 = new GradeBook(5);
        gradebook2 = new GradeBook(5);

        gradebook1.addScore(90);
        gradebook1.addScore(85);
        gradebook1.addScore(95);

        gradebook2.addScore(75);
        gradebook2.addScore(80);
        gradebook2.addScore(70);
    }

	@After
	public void tearDown() {
        gradebook1 = null;
        gradebook2 = null;
    }

	@Test
	public void testGradeBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddScore() {
        gradebook1.addScore(95);
        assertEquals("90 85 95", gradebook1.toString());
        assertEquals(3, gradebook1.getScoreSize());

        gradebook2.addScore(80);
        assertEquals("75 80 70", gradebook2.toString());
        assertEquals(4, gradebook2.getScoreSize());
    }

	@SuppressWarnings("deprecation")
	@Test
	public void testSum() {
        assertEquals(270, gradebook1.sum());
        assertEquals(225, gradebook2.sum());
    }

	@Test
	public void testMinimum() {
        assertEquals(85, gradebook1.minimum());
        assertEquals(70, gradebook2.minimum());
    }

	@Test
	public void testFinalScore() {
        assertEquals(185, gradebook1.finalScore());
        assertEquals(155, gradebook2.finalScore());
    }

	@Test
	public void testGetScoreSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
