package aaa1;

import java.util.Scanner;

public class Minesweeper  {
	private static Main main_M;
	private static Main_middle main_middle;
	private static Main_hard main_hard;
	
    static boolean finish = false;
    static int turn=0;

    public Minesweeper(){
        main_M = new Main();
        main_middle = new Main_middle();
        main_hard = new Main_hard();
        startGame(main_M);
        startGame(main_middle);
        startGame(main_hard);
        
    }

    public static void main(String[] args) {
      
     
      System.out.print("난이도를 입력하세요 (1~3): ");
      Scanner sc = new Scanner(System.in);
      int Value = sc.nextInt();
      
     
      if(Value == 1) {
    	 System.out.println(Value + "난이도(하)");
    	 new Minesweeper();
    	 startGame(main_M);
    	
    	 return;
     }else if(Value == 2){  
    	 System.out.println(Value + "난이도(중)");
    	  new Minesweeper();
    	 startGame(main_middle);
    	
    	 return;
     } else if(Value == 3){
    	 System.out.println(Value + "난이도(상)");
    	 new Minesweeper();
    	 startGame(main_hard); 
    	 
    	  return;
     }
    }
    
    

    public static void startGame(Main main_M){
    	do{
        	
       
            		turn++;
                    System.out.println("Turn "+turn);
                    
                    main_M.showMain();                //Shows the grid till the game is won or lost
                    finish = main_M.readAndsetPosition();//reads the input and checks if there is mine or not

                    if(!finish){
                        main_M.revealNeighbours();//opens surronding 8 neighbohors
                        finish = main_M.win();
                    }  
    	}while(!finish);

                    if(main_M.win()){
                        System.out.println("Congratulations, you Won the game in  " + turn + " turns :)");
                        main_M.revealMines();
                    } else {
                        System.out.println("ooh you step over the Mine, :(");
                        main_M.revealMines();
                        System.exit(999);
                    }
    	}
    	
        public static void startGame(Main_middle main_middle) {
        	do{
            		turn++;
                    System.out.println("Turn "+turn);
                    
                    main_middle.showMain();                //Shows the grid till the game is won or lost
                    finish = main_middle.readAndsetPosition();//reads the input and checks if there is mine or not

                    if(!finish){
                    	main_middle.revealNeighbours();//opens surronding 8 neighbohors
                        finish = main_middle.win();
                    } 
        	}while(!finish);

                    if(main_middle.win()){
                        System.out.println("Congratulations, you Won the game in  "+turn+" turns :)");
                        main_middle.revealMines();
                    } else {
                        System.out.println("ooh you step over the Mine, :(");
                        main_middle.revealMines();
                        System.exit(999);
                    }
        }
        public static void startGame(Main_hard main_hard) {   		
        	do {
            		turn++;
                    System.out.println("Turn "+turn);
                    
                    main_hard.showMain();                //Shows the grid till the game is won or lost
                    finish = main_hard.readAndsetPosition();//reads the input and checks if there is mine or not

                    if(!finish){
                    	main_hard.revealNeighbours();//opens surronding 8 neighbohors
                        finish = main_hard.win();
                    }
        	}
            	 while(!finish);

                 if(main_hard.win()){
                     System.out.println("Congratulations, you Won the game in  "+turn+" turns :)");
                     main_hard.revealMines();
                 } else {
                     System.out.println("ooh you step over the Mine, :(");
                     main_hard.revealMines();
                 }
            	
        }
        
 
}
