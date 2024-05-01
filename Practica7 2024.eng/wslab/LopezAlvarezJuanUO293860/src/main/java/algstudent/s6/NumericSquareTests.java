package algstudent.s6;


import org.junit.Test;

public class NumericSquareTests {

	@Test
	public void OneSolutionTest00() {
		NumericSquareOne n = new NumericSquareOne();
		n.readFromFile("src/main/java/algstudent/s6/test00.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void AllSolutionsTest00() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/s6/test00.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void OneSolutionTest01() {
		NumericSquareOne n = new NumericSquareOne();
		n.readFromFile("src/main/java/algstudent/s6/test01.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void AllSolutionsTest01() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/s6/test01.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void OneSolutionTest02() {
		NumericSquareOne n = new NumericSquareOne();
		n.readFromFile("src/main/java/algstudent/s6/test02.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void AllSolutionsTest02() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/s6/test02.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void OneSolutionTest03() {
		NumericSquareOne n = new NumericSquareOne();
		n.readFromFile("src/main/java/algstudent/s6/test03.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void AllSolutionsTest03() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/s6/test03.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void OneSolutionTest04() {
		NumericSquareOne n = new NumericSquareOne();
		n.readFromFile("src/main/java/algstudent/s6/test04.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void AllSolutionsTest04() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/s6/test04.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void OneSolutionTest05() {
		NumericSquareOne n = new NumericSquareOne();
		n.readFromFile("src/main/java/algstudent/s6/test05.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void AllSolutionsTest05() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/s6/test05.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void OneSolutionTest06() {
		NumericSquareOne n = new NumericSquareOne();
		n.readFromFile("src/main/java/algstudent/s6/test06.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	@Test
	public void AllSolutionsTest06() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/s6/test06.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	@Test
	public void OneSolutionTest07() {
		NumericSquareOne n = new NumericSquareOne();
		n.readFromFile("src/main/java/algstudent/s6/test07.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}
	
	
	// NOT ADVISABLE TO EXECUTE, IT TAKEs 4 MINUTES TO GET 86 SOLUTIONS AND THEN TAKES FOREVER
	@Test
	public void AllSolutionsTest07() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/s6/test07.txt");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
	}

}
