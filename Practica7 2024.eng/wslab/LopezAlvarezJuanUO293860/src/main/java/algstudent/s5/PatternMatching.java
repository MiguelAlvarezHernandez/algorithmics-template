package algstudent.s5;

public class PatternMatching {
	String text;
	boolean [][] table;

	public PatternMatching(String text) {
		this.text = text;
	}

	public boolean checkPattern(String pattern) {
		table = new boolean [text.length()+1][pattern.length()+1];
		table[0][0] = true;
		for(int i = 1; i< table.length; i++) {
			for(int j = 1; j< table[i].length; j++) {
				if(text.charAt(i-1) == pattern.charAt(j-1)) {
					if(table[i-1][j-1]) table[i][j] = true;
				}
				else {
					if(pattern.charAt(j-1) == '*') 
					{
						if(table[i-1][j-1]) table[i][j] = true;
						if(table[i][j-1]) table[i][j] = true;
						if(table[i-1][j]) table[i][j] = true;
					}
					else if(pattern.charAt(j-1) == '?') {
						if(table[i][j-1]) table[i][j] = true;
						if(table[i-1][j-1]) table[i][j] = true;
					}
					else table[i][j] = false;
				}
			}
		}
		return table[table.length-1][table[0].length-1];
		
	}

	public void printsTable() {
		for(int i = 0; i< table.length; i++) {
			for(int j = 0; j< table[i].length; j++) {
				System.out.print(table[i][j] + " - ");
			}
			System.out.println();
		}
		
	}

}
