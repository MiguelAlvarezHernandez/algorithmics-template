package algstudent.test;

import java.io.BufferedReader;
import java.io.FileReader;

public class NumericSquareAll {
	private static final int INVALID_DIVISION = Integer.MAX_VALUE;
	int sizeOfBoard;
	String[][] board;
	boolean[][] isModifiable;
	int numberOfSlots;
	int numSolutions;

	int mainDiagonal;
	
	public static void main(String arg []) {
		NumericSquareAll n = new NumericSquareAll();
		n.readFromFile("src/main/java/algstudent/test/test04.txt");
		n.printBoard();
		n.backtracking(0,0);
	}
	
	void backtracking(int row, int column) {
		if(row > board.length-3) {
			if(allOperationsCorrect() && mainDiagonal()) {
				System.out.println("SOLUTION FOUND");
				numSolutions++;
				System.out.println("Solution number:" + numSolutions);
				printBoard();
			}
		}
		else {
			if (row<=board.length-3 && column<=board.length-3) {
				if (isModifiable[row][column]) {
					for (int n = 0; n <= 9; n++) {
						board[row][column] = Integer.toString(n);
						isModifiable[row][column] = false;
						if(column==board.length-3) {
							if(checkRow(row))
								backtracking(row+2, 0);
						}
						else if(row == board.length-3) {
							if(checkColumn(column))
								backtracking(row, column+2);
						}
						else
							backtracking(row, column+2);
						
						//board[row][column] = "?";
						isModifiable[row][column] = true;
					}
				}
				else {
					if(column==board.length-3 && checkRow(row))
						backtracking(row+2, 0);
					else
						backtracking(row, column+2);
				}	
			}
			return;
		}
	}
	
	private boolean mainDiagonal() {
		int sum = 0;
		for(int i=0; i<board.length-2;i+=2) {
			sum+= Integer.valueOf(board[i][i]);
		}
		return sum == mainDiagonal;
	}
	
	private boolean allOperationsCorrect() {
		return checkRowOperations() && checkColumnOperations();
	}

	private boolean checkColumnOperations() {
		for(int i = 0; i<board.length-2; i+=2) {
			if(!checkColumn(i)) return false;
		}
		return true;
	}
	
	private boolean checkColumn(int i) {
		if(board[0][i].equals("?")) return false;
		int result = Integer.valueOf(board[0][i]);
		
		for(int j = 1; j<board.length-2; j+=2) {
			if(board[j+1][i].equals("?") || board[j][i].equals("?")) return false;
			result = operate(result,board[j][i],board[j+1][i]);
			if(result == INVALID_DIVISION)
				return false;
		}
		if(result == Integer.valueOf(board[board.length-1][i])) return true;
		else
			return false;
	}

	private boolean checkRowOperations() {
		for(int i = 0; i<board.length-2; i+=2) {
			if(!checkRow(i)) return false;
		}
		return true;
	}
	
	private boolean checkRow(int i) {
		if(board[i][0].equals("?")) return false;
		int result = Integer.valueOf(board[i][0]);
		for(int j = 1; j<board.length-2; j+=2) {
			if(board[i][j+1].equals("?")) return false;
			result = operate(result,board[i][j],board[i][j+1]);
			if(result == INVALID_DIVISION)
				return false;
		}
		if(result == Integer.valueOf(board[i][board.length-1])) return true;
		else
			return false;
	}
	
	public static boolean checkRow(String[] a) {
		if(a[0].equals("?")) return false;
		int result = Integer.valueOf(a[0]);
		for(int j = 1; j<a.length-2; j+=2) {
			if(a[j+1].equals("?")) return false;
			result = operate(result,a[j],a[j+1]);
			if(result == INVALID_DIVISION)
				return false;
		}
		if(result == Integer.valueOf(a[a.length-1])) return true;
		else
			return false;
	}

	private static int operate(int result, String operation, String operand) {
		switch(operation) {
		case "+":
			result += Integer.valueOf(operand);
			break;
		case "-":
			result -= Integer.valueOf(operand);
			break;
		case "/":
			try {
				int modulus = result % Integer.valueOf(operand);
			} catch (ArithmeticException e) {
				result = INVALID_DIVISION;
				break;
			}
			if(result % Integer.valueOf(operand)== 0)
				result = result / Integer.valueOf(operand);
			else result = INVALID_DIVISION;
			break;
		case "*":
			result *= Integer.valueOf(operand);
			break;
		default:
			throw new RuntimeException("Internal error please contact the useless programer");
		}
		return result;
	}

	void printBoard() {
		for(int i = 0; i<board.length-1; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(board[i][j] != null) {
					if(isNumber(board[i][0]))
						System.out.print(board[i][j] + "\t");
					else
						System.out.print(board[i][j] + "\t\t");
					
				}
			}
			System.out.println();
		}
		int lastRow = board.length-1;
		for(int j = 0; j<board[lastRow].length; j++) {
			if(board[lastRow][j] != null) {
				System.out.print(board[lastRow][j] + "\t\t");
			}
		}
		System.out.println();
		System.out.println("----------------------------------");
		
	}
	
	
	
	private boolean isNumber(String board2) {
		if(board2.length() > 1) return Character.isDigit(board2.charAt(1)) || board2.charAt(0) == '?';
		return Character.isDigit(board2.charAt(0)) || board2.charAt(0) == '?';
	}
	
	void readFromFile(String fileName) {
		
		BufferedReader reader = null; 	
		try {
			reader = new BufferedReader(new FileReader(fileName));
			sizeOfBoard = Integer.valueOf(reader.readLine());
			mainDiagonal = Integer.valueOf(reader.readLine());
			numberOfSlots = sizeOfBoard*sizeOfBoard -1;
			board = new String[sizeOfBoard*2 +1][sizeOfBoard*2 +1];
			isModifiable = new boolean[sizeOfBoard*2 +1][sizeOfBoard*2 +1];
			String[] aux = new String[sizeOfBoard*2 +1];
			int i = 0;
			for(int k = 0; i<board.length -1 ; k++) { 
				aux = reader.readLine().split(" ");
				if(isNumber(aux[0])) {
					for(int j = 0; j<aux.length; j++) {
						board[i][j] = aux[j];
						if(board[i][j].equals("?")) {
							isModifiable[i][j] = true;
						}
					}
					i++;
				}
				else {
					int pos = 0;
					for(int j = 0; j<aux.length; j++) {
						board[i][pos] = aux[j];
						pos+=2;
					}
					i++;
				}
			}
			aux = reader.readLine().split(" ");
			int pos = 0;
			for(int p =0; p<aux.length; p++) {
				board[i][pos]=aux[p];
				pos+=2;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
	}
}
