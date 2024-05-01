package algstudent.s7;

import java.util.ArrayList;
import java.util.UUID;

import algstudent.s7.pyramid.utils.BranchAndBound;
import algstudent.s7.pyramid.utils.Node;


/**
 * To solve a reduced version of the Pyramid Puzzle
 * Instructions at http://www2.stetson.edu/~efriedma/puzzle/pyramid/
 */
public class NumericSquareBaB extends BranchAndBound {	
	/**
	 * Constructor for Pyramid Puzzle objects
	 * @param board Representation of the board for playing the puzzle
	 */
    public NumericSquareBaB(SquareBoard board) {
    	rootNode = board; //we create the puzzle to start playing
    }
}
/***************************************************/


/***************************************************/
class SquareBoard extends Node {
	private String[][] board; //board for playing
	private int row; //current row of this board
	private int column; //current column of this board
	private static int n; //size of the side of the board to save the pyramid

	static boolean[][] isModifiable;
	
	private static final int INVALID_DIVISION = Integer.MAX_VALUE;

	/**
	 * Constructor for Pyramid puzzle objects (root node)
	 * @param n Size of the board
	 */
	public SquareBoard(int n) { //Generates an empty board
		SquareBoard.n = n;	 	
		board = new String[n][n];
		row = 0;
		column = 0;
		isModifiable = new boolean[n][n];
	}
	
	/**
	 * Inserts the values of a line from the pyramid 
	 * It is call once per every row of the pyramid to initialize all the values
	 * @param values Values of a row of the pyramid
	 * @param row Number of the current row
	 */
	public void insertValues(String[] values, int row) {
		
		if(!isNumber(values[0])) {
			int k = 0;
			for(int j = 0; j<values.length; j++) {
				board[row][k] = values[j];
				k+=2;
			}		
		}
		else {
			for(int i = 0; i<values.length; i++) {
				board[row][i] = values[i];
				if(board[row][i].equals("?")) {
					isModifiable[row][i] = true;
				}
			}
		}
	}
	
	public void insertLastRow(String[] values) {
		int k = 0;
		for(int j = 0; j<values.length; j++) {
			board[board.length-1][k] = values[j];
			k+=2;
		}	
	}
		
	private boolean isNumber(String board2) {
		if(board2.length() > 1) return Character.isDigit(board2.charAt(1)) || board2.charAt(0) == '?';
		return Character.isDigit(board2.charAt(0)) || board2.charAt(0) == '?';
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
	
	
	private boolean checkColumn(int i) {
		if(board[0][i] == null || board[0][i].equals("?")) return false;
		int result = Integer.valueOf(board[0][i]);
		
		for(int j = 1; j<board.length-2; j+=2) {
			if(board[j+1][i] == null ||board[j+1][i].equals("?") || board[j][i] == null || board[j][i].equals("?")) return false;
			result = operate(result,board[j][i],board[j+1][i]);
			if(result == INVALID_DIVISION)
				return false;
		}
		if(result == Integer.valueOf(board[board.length-1][i])) return true;
		else
			return false;
	}

	
	private boolean checkRow(int i) {
		if(board[i][0] == null || board[i][0].equals("?")) return false;
		int result = Integer.valueOf(board[i][0]);
		for(int j = 1; j<board.length-2; j+=2) {
			if(board[i][j+1] == null || board[i][j+1].equals("?")) return false;
			result = operate(result,board[i][j],board[i][j+1]);
			if(result == INVALID_DIVISION)
				return false;
		}
		if(result == Integer.valueOf(board[i][board.length-1])) return true;
		else
			return false;
	}
	
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i<board.length-1; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(board[i][j] != null) {
					if(isNumber(board[i][0]))
						sb.append(board[i][j] + "\t");
					else
						sb.append(board[i][j] + "\t\t");
					
				}
			}
			sb.append("\n");
		}
		int lastRow = board.length-1;
		for(int j = 0; j<board[lastRow].length; j++) {
			if(board[lastRow][j] != null) {
				sb.append(board[lastRow][j] + "\t\t");
			}
		}
		sb.append("\n");
		return sb.toString();
    }

    /**
     * Counts the number of blanks that are not yet filled
     */
    //@Override
    public void calculateHeuristicValue() {
    	int counter = 0;
    	if(prune()) {
    		heuristicValue = Integer.MAX_VALUE;
    	}
    	else {
    		for(int i = 0; i<n-2; i++) {
    			for(int j = 0; j<n-2; j++) {
    				if(board[i][j] != null && board[i][j].equals("?")) counter++; //Count the ? in the board
    			}
    		}
    		heuristicValue = counter;
    	}
    }
    
    /*public void calculateHeuristicValue(int previousHeuristicValue) {
    	int counter = 0;
    	if(prune()) {
    		heuristicValue = Integer.MAX_VALUE;
    	}
    	else {
    		heuristicValue = previousHeuristicValue - 1;
    	}
    }*/
    
	/**
	 * Checks if we should prune when the conditions are not longer met
	 * @return True if we should prune. False otherwise
	 */
	private boolean prune() {
		if(column == n-3) {
			if(!checkRow(row)) return true;
		}
		if(row == n-3) {
			if(!checkColumn(column)) return true;
		}
		return false;
	}
	
	@Override
	public boolean isSolution() {
		return heuristicValue == 0;
	}
    
	/**
	 * To get the children of the current node. They 
     * point to their parent through the parentID
	 */
	@Override
	public ArrayList<Node> expand() {
		ArrayList<Node> result = new ArrayList<Node>();
		String[][] newBoard;
		SquareBoard temp;
		
		while(board[row][column] != null  && row<board.length-2 && column<board.length-2) { //!isNumber(board[row][column])/*
			
			if(board[row][column].equals("?")) {
				for(int k = 0; k<10; k++) {
					newBoard = copyBoard(row, column, k);
					temp = new SquareBoard(newBoard, depth+1, this.getID(), row, column);
					result.add(temp);
				}
				//isModifiable[row][column] = false;
				break;
			}
			else {
				if(column < n-3 ) {
					if(row == n-3 && !checkColumn(column)) break;
					column+=2;
				}
				else {
					if(column == n-3 && !checkRow(row)) break;
					row+=2;
					column = 0;
				}
			}
		}
		
		return result;
	}
	
	/*Makes a copy of the actual board but putting a k in [row][column]*/
	private String[][] copyBoard(int row, int column, int k) {
		String[][] newBoard = new String[n][n];
		
		for (int i=0; i<n; i++) 
			for (int j=0; j<n; j++)
				newBoard[i][j] = board[i][j];				      
		
		newBoard[row][column] = Integer.toString(k);	
		return newBoard;
	}
	
	/**
	 * Constructor for Pyramid puzzle objects (children of the root node)
	 * @param newBoard
	 * @param depth
	 * @param parentID
	 */
    public SquareBoard(String[][] newBoard, int depth, UUID parentID, int row, int column/*, int parentHeuristic*/) {
    	this.board = newBoard;
    	this.depth = depth;
    	this.parentID = parentID;
    	this.row = row;
    	this.column = column;
    	calculateHeuristicValue();
    	//calculateHeuristicValue(parentHeuristic);
    }

    
    
} 


