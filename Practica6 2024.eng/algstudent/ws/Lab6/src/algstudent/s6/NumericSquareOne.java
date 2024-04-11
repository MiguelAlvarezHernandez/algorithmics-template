package algstudent.s6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NumericSquareOne {

    private static String[][] board;
    private static String[][] boardVertical;

    private static int size;
    
    static boolean solutionFound = false;

    public static void main(String[] args) {
        try {
            readBoardFromFile("src/algstudent/s6/test00.txt"); // Change the filename accordingly
            solve(board, size);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
       // printBoard();
    }

//    private static void printBoard() {
//    	for (int i = 0; i < board.length; i++) {
//    		for (int j = 0; j < board[i].length; j++) {
//    			System.out.println(board[i][j] + " ");
//    		}
//    	}
//		
//	}

	private static void readBoardFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        size = Integer.parseInt(reader.readLine()) * 2 + 1;
        board = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                board[i][j] = line[j];
            }
        }

        reader.close();
    }
	
	public static void solve(String[][] board, int size) {
        backtrack(board, size, 0, 0);
        if (!solutionFound) {
            System.out.println("No solution found.");
        }
    }

    public static void backtrack(String[][] board, int size, int row, int col) {
        if (solutionFound) {
            return;
        }

        if (row == size) {
        	if (checkSolutions(board, size)) {
                printBoard(board, size);
                solutionFound = true;
            }
            return;
        }

        if (col == size) {
            backtrack(board, size, row + 1, 0);
            return;
        }

        if (board[row][col] != null && board[row][col].equals("?") ) {
            for (int num = 1; num <= 9; num++) {
            	String aux = String.valueOf(num);
                board[row][col] = aux;
                backtrack(board, size, row, col + 1);
                board[row][col] = "?";
            }
        } else {
            backtrack(board, size, row, col + 1);
        }
    }
    
    public static boolean checkSolutions(String[][] board, int size) {
        for (int i = 0; i < board.length -1; i+=2) {
            int resultRow = Integer.parseInt(board[i][board[i].length - 1]);
            int sumRow = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].equals("+")) {
                        sumRow += Integer.parseInt(board[i][j + 1]);
                        j++;
                    } else if (board[i][j].equals("-")) {
                        sumRow -= Integer.parseInt(board[i][j + 1]);
                        j++;
                    } else if (board[i][j].equals("*")) {
                        sumRow *= Integer.parseInt(board[i][j + 1]);
                        j++;
                    } else if (board[i][j].equals("/")) {
                        sumRow /= Integer.parseInt(board[i][j + 1]);
                        j++;
                    } else if (board[i][j].equals("=")) {
                    	break;
                    } else {
                        sumRow += Integer.parseInt(board[i][j]);
                    }
                }
            }
            if (sumRow != resultRow) {
                return false;
            }
            
        }
        
        for (int j = 0; j < size; j++) {
            int result = Integer.parseInt(board[board[j].length - 1][j]);
            int sum = 0;
            for (int i = 0; i < size; i++) {
            	if( i != 0 && i%2 == 0 && j >= (size-1)/2 -1) {
            		break;
            	}
                if (board[i][j] != null) {
                    if (board[i][j].equals("+")) {
                    	if (j != 0) {
                    		sum += Integer.parseInt(board[i+1][j * 2 ]);
                    		
                    	}else {
                    		sum += Integer.parseInt(board[i+1][j]);
                    	}
                    	
                        i++;
                    } else if (board[i][j].equals("-")) {
                    	if (j != 0) {
                    		sum -= Integer.parseInt(board[i+1][j * 2 ]);
                    	}else {
                    		sum -= Integer.parseInt(board[i+1][j]);
                    	}
                    	
                        i++;
                    } else if (board[i][j].equals("*")) {
                    	if (j != 0) {
                    		sum *= Integer.parseInt(board[i+1][j * 2 ]);
                    	}else {
                    		sum /= Integer.parseInt(board[i+1][j]);
                    	}
                    	
                        i++;
                    } else if (board[i][j].equals("/")) {
                    	if (j != 0) {
                    		sum /= Integer.parseInt(board[i+1][j * 2 ]);
                    	}else {
                    		sum /= Integer.parseInt(board[i+1][j]);
                    	}
                        i++;
                    } else if (board[i][j].equals("=")) {
                    	break;
                    } else {
                    	if (j != 0) {
                    		sum += Integer.parseInt(board[i][j*2]);
                    	}
                    	else {
                    		sum += Integer.parseInt(board[i][j]);
                    	}
                    }
                }
            }
//            for(i = 0; i < n - 2; i++)
//            	if i%2 != 0:
            		
            if (sum != result) {
                return false;
            }
        }
        return true;
    }
    
    public static void verticalizeBoard() {
    	boardVertical = new String[size][size];
    	 for (int i = 0; i < board.length ; i++) {
    		 if (i%2 == 0) {
    			 boardVertical[i] = board[i];
    		 }else {
	             for (int j = 0; j < board[i].length/2; j++) {
	            	 boardVertical[i][2*j] = board[i][j];
	            	 
	             }
    		 }
    }
    }
    

    public static void printBoard(String[][] board, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
