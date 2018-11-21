
import java.util.Random;
import java.util.Scanner;


public class Main {
    private int[][] mines;
    private char[][] Board;
    private int row, column;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
	private int a;
	private int b;
    public void setAB(int a, int b) {
    	this.a = a;
    	this.b = b;
    	
    }/*
    public Main(){
      mines = new int[10][10];
      Board = new char[10][10];
      initializeMines();          //초기화된 판
      placeMines();                //지뢰를 무작위 위치로 채움
      NominesOfSurroundingNeighbours(); //주변에 지뢰가 있는지 숫자로 표현해줌
      startBoard();                      //게임시작
}
*/
    public void Main(int a, int b){
      mines = new int[a][b];
      Board = new char[a][b];
      initializeMines(a, b);          //초기화된 판
      placeMines(a, b);                //지뢰를 무작위 위치로 채움
      NominesOfSurroundingNeighbours(a, b); //주변에 지뢰가 있는지 숫자로 표현해줌
      startBoard();                      //게임시작
}
    public void SelectLev(int Value) {
    	switch(Value) {
    	case 1:
    		Main(10, 10);
    		break;
    	case 2:
    		Main(50, 50);
    		break;
    	case 3:
    		Main(100, 100);
    		break;
    	}
    }
    public boolean win(int a, int b) {
    	int count = 0;
    	for(int line = 1; line < (a-1); line++)
    		for(int column = 1; column < (b-1); column++)
    			if(Board[line][column] == '#')
    				count++;
    	if(count == a)
    		return true;
    	else
    		return false;
    }
    
    public void revealNeighbours() {
    	for(int i = -1; i<2; i++)
    		for(int j = -1; j<2; j++)
    			if(mines[row + i][column + j] != -1)
    				Board[row + i][column + j] = Character.forDigit(mines[row + i][column + j], a);
    }
    
    public int getPosition(int Line, int Column) {
    	return mines[Line][Column];
    }
    
    public boolean readAndsetPosition(int a, int b) {
    	do {
    		System.out.print("\nrow: ");
    		row = sc.nextInt();
    		System.out.print("column: ");
    		column = sc.nextInt();
    		
    	if( (Board[row][column] != '-') && ((row < (a-1) && row > 0) && (column < (b-1) && column > 0)))
    		System.out.println("이미 입력한 좌표입니다.");
    	
    	if( row < 1 || row > a || column < 1 || column > b)
    		System.out.println("1~" + (a-1) + " 사이 숫자를 입력하세요.");
    	
    	}while((row < 1 || row > (a-2) || column < 1 || column > (b-2)) || (Board[row][column] != '-'));
    	
    	if(getPosition(row, column) == -1 )
    		return true;
    	else
    		return false;
		
	}
	
	public void showMain(int a, int b) {
		System.out.println("\n		Lines");
		for(int Line = (a-2); Line > 0; Line--) {
			System.out.print("		" + Line + " ");
			
			for(int Column = 1; Column < (b-2); Column++) {
				System.out.print("	" + Board[Line][Column]);
			}
			
			System.out.println();
		}
		System.out.print("\n  		   ");
		for(int x = 1; x < (a-1); x++) {
		System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("			Columns");
		}
	}
	
	public void NominesOfSurroundingNeighbours(int a, int b) {
		for(int line = 1; line < (a-1); line++)
			for(int column = 1; column < (b-1); column++) {
			
				for(int i = -1; i <=1; i++)
					for(int j = -1; j <= 1; j++)
						if(mines[line][column] != -1)
							if(mines[line+i][column+j] == -1)
								mines[line][column]++;
			}
	}
	
	public void revealMines(int a, int b) {
		for(int i = 1; i < (a-1); i++)
			for(int j = 1; j < (b-1); j++)
				if(mines[i][j] == -1)
					Board[i][j] = '#';
		
		showMain(a, b);
	}
	
	public void startBoard() {
		for(int i = 1; i < mines.length; i++)
			for(int j = 1; j < mines.length; j++)
				Board[i][j] = '-';
	}
	
	public void initializeMines(int a, int b) {
		for(int i = 0; i < mines.length; i++)
			for(int j = 0; j < mines.length; j++)
				mines[i][j] = 0;
	}
	
	public void placeMines(int a, int b) {
		boolean raffled;
		int Line, Column;
		for(int i = 0; i < a; i++) {
			do{
				Line = random.nextInt(a-2) + 1;
				Column = random.nextInt(b-2) + 1;
				
				if(mines[Line][Column] == -1)
					raffled = true;
				else
					raffled = false;
			}while(raffled);
			
			mines[Line][Column] = -1;
		}
	}
}
