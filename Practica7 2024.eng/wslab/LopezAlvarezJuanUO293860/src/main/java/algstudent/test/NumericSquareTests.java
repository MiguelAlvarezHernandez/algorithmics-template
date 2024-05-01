package algstudent.test;


import org.junit.Test;

public class NumericSquareTests {
	
	@Test
	public void AllSolutionsTest00() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/test/test00.txt");
		System.out.println("----------BEGIN TEST00-----------");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
		System.out.println("----------END TEST-----------");
	}

	
	@Test
	public void AllSolutionsTest01() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/test/test01.txt");
		System.out.println("----------BEGIN TEST01-----------");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
		System.out.println("----------END TEST-----------");
	}
	
	
	@Test
	public void AllSolutionsTest02() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/test/test02.txt");
		System.out.println("----------BEGIN TEST02-----------");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
		System.out.println("----------END TEST-----------");
	}
	
	@Test
	public void AllSolutionsTest03() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/test/test03.txt");
		System.out.println("----------BEGIN TEST03-----------");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
		System.out.println("----------END TEST-----------");
	}
	
	@Test
	public void AllSolutionsTest04() {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/test/test04.txt");
		System.out.println("----------BEGIN TEST04-----------");
		System.out.println("INITIAL STATE OF THE BOARD");
		n.printBoard();
		long time1 = System.currentTimeMillis();
		n.backtracking(0,0);
		long time2 = System.currentTimeMillis();
		System.out.println("Time spent: " + (time2-time1) + "ms");
		System.out.println("----------END TEST-----------");
	}


}
