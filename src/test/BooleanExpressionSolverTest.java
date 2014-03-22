package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import net.jbouchard.bool.BooleanExpressionSolver;

import org.junit.Assert;
import org.junit.Test;



public class BooleanExpressionSolverTest {

	ByteArrayOutputStream systemOut = new ByteArrayOutputStream();
	
	@Test
	public void or_test() {
		BooleanExpressionSolver bes = new BooleanExpressionSolver();
		try {
			
			System.setOut(new PrintStream(systemOut));
			
			String[] argv={"-b","-e","A|B"};
			bes.main(argv);
			String result=systemOut.toString();
			
			Assert.assertEquals("A B  A|B \n0 0   0  \n0 1   1  \n1 0   1  \n1 1   1",result.trim());
			systemOut.close();
		}
		catch (Exception ex) {
			
			fail("Unexpected"+ex.getStackTrace());
		}
		//fail("Not yet implemented");
	}
	
	@Test
	public void and_test() {
		BooleanExpressionSolver bes = new BooleanExpressionSolver();
		try {
			
			System.setOut(new PrintStream(systemOut));
			
			String[] argv={"-b","-e","A&B"};
			bes.main(argv);
			String result=systemOut.toString();
			
			Assert.assertEquals("A B  A&B \n0 0   0  \n0 1   0  \n1 0   0  \n1 1   1",result.trim());
			systemOut.close();
		}
		catch (Exception ex) {
			
			fail("Unexpected"+ex.getStackTrace());
		}
		//fail("Not yet implemented");
	}


	@Test
	public void not_test() {
		BooleanExpressionSolver bes = new BooleanExpressionSolver();
		try {
			
			System.setOut(new PrintStream(systemOut));
			
			String[] argv={"-b","-e","~A"};
			bes.main(argv);
			String result=systemOut.toString();
			
			Assert.assertEquals("A  ~A \n0  1  \n1  0",result.trim());
			systemOut.close();
		}
		catch (Exception ex) {
			
			fail("Unexpected"+ex.getStackTrace());
		}
		//fail("Not yet implemented");
	}
	
	@Test
	public void equals_test() {
		BooleanExpressionSolver bes = new BooleanExpressionSolver();
		try {
			
			System.setOut(new PrintStream(systemOut));
			
			String[] argv={"-b","-e","A=B"};
			bes.main(argv);
			String result=systemOut.toString();
			
			Assert.assertEquals("A B  A=B \n0 0   1  \n0 1   0  \n1 0   0  \n1 1   1",result.trim());
			systemOut.close();
		}
		catch (Exception ex) {
			
			fail("Unexpected"+ex.getStackTrace());
		}
		//fail("Not yet implemented");
	}
	
	@Test
	public void xor_test() {
		BooleanExpressionSolver bes = new BooleanExpressionSolver();
		try {
			
			System.setOut(new PrintStream(systemOut));
			
			String[] argv={"-b","-e","A+B"};
			bes.main(argv);
			String result=systemOut.toString();
			
			Assert.assertEquals("A B  A+B \n0 0   0  \n0 1   1  \n1 0   1  \n1 1   0",result.trim());
			systemOut.close();
		}
		catch (Exception ex) {
			
			fail("Unexpected"+ex.getStackTrace());
		}
		//fail("Not yet implemented");
	}
	
	@Test
	public void test_less_than() {
		BooleanExpressionSolver bes = new BooleanExpressionSolver();
		try {
			
			System.setOut(new PrintStream(systemOut));
			
			String[] argv={"-b","-e","A>B"};
			bes.main(argv);
			String result=systemOut.toString();
			
			Assert.assertEquals("A B  A>B \n0 0   1  \n0 1   1  \n1 0   0  \n1 1   1",result.trim());
			systemOut.close();
		}
		catch (Exception ex) {
			
			fail("Unexpected"+ex.getStackTrace());
		}
	}
}
