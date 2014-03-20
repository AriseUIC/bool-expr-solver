package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import net.jbouchard.bool.BooleanExpressionSolver;

import org.junit.Assert;
import org.junit.Test;

public class ComputeExpression {

	ByteArrayOutputStream systemOut = new ByteArrayOutputStream();
	@Test
	public void expressions_test() {
		BooleanExpressionSolver bes = new BooleanExpressionSolver();
		try {
			
			System.setOut(new PrintStream(systemOut));
			
			String[] argv={"-b","-e","A&B|C"};
			bes.main(argv);
			String result=systemOut.toString();
			
			Assert.assertEquals("A B C  A&B  A&B|C \n0 0 0   0     0   \n0 0 1   0     1   \n0 1 0   0     0   \n0 1 1   0     1   \n1 0 0   0     0   \n1 0 1   0     1   \n1 1 0   1     1   \n1 1 1   1     1",result.trim());
			systemOut.close();
		}
		catch (Exception ex) {
			
			fail("Unexpected"+ex.getStackTrace());
		}
		//fail("Not yet implemented");
	}
	@Test
	public void expressions_with_brackets_test() {
		BooleanExpressionSolver bes = new BooleanExpressionSolver();
		try {
			
			System.setOut(new PrintStream(systemOut));
			
			String[] argv={"-b","-e","A&(B|C)"};
			bes.main(argv);
			String result=systemOut.toString();
			
			Assert.assertEquals("A B C  B|C  A&(B|C) \n0 0 0   0      0    \n0 0 1   1      0    \n0 1 0   1      0    \n0 1 1   1      0    \n1 0 0   0      0    \n1 0 1   1      1    \n1 1 0   1      1    \n1 1 1   1      1",result.trim());
			systemOut.close();
		}
		catch (Exception ex) {
			fail("Unexpected"+ex.getStackTrace());
		}
	}

}
