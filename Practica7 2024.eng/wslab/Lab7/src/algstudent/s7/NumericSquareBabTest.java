package algstudent.s7;

import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;

/**
 * JUnit Test for Pyramid Puzzle
 */
public class NumericSquareBabTest {
	@Test
	public void test5() {
		long time1 = System.currentTimeMillis();
		boolean result = executeFromFile("src/algstudent/s7/test00.txt");
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
		assertEquals(true, result);
	}
	
	
	/**
	 * Reads the initial pyramid from a text file and creates an object to deal with the problem
	 * @param file File from which 
	 * @return True if we find a solution for the problem, false otherwise
	 */
	private boolean executeFromFile(String file) {
		boolean result = false;
		//input
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			
			//first line (HEIGHT OF THE PYRAMID)
			String size = br.readLine(); //height of the pyramid
			int n = Integer.parseInt(size); //n
			n = n*2 +1;
			
			SquareBoard board = new SquareBoard(n);
			
			//next lines
			for (int i=0; i<n-1; i++) {
				String[] values = br.readLine().split(" ");				
				board.insertValues(values, i);
			}	
			String[] values = br.readLine().split(" ");
			board.insertResultsRow(values);
			NumericSquareBaB puzzle = new NumericSquareBaB(board);	
			//System.out.println(board.toString());
			puzzle.branchAndBound(puzzle.getRootNode()); 		
			puzzle.printSolutionTrace();
			
			result = puzzle.getBestNode() != null ? true : false;
//			if (result == true) {
//				System.out.println("Number of nodes: " + board.getCounterNodes());
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return result;
	}
	
}
