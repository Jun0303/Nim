import java.util.Random;
import java.util.Scanner;

public class Nim{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();
		
		/*
		NimPlayer human = new HumanPlayer();
		NimPlayer cpu = new ComputerPlayer();
		
		human.play(); //メソッド
		cpu.play();  //メソッド
		
		*/
		
		int stones = random.nextInt(19) + 15; // 15～33の乱数; 
	    System.out.println("=== 石取りゲーム ===");
		for(int i = 0; i < stones; i++){
			System.out.print("*");
		}
		
		
		System.out.println();
	    System.out.println("石の数: " + stones);
	    System.out.println("1ターンに1~3個の石を取ることができます。");
	    System.out.println("最後の石を取った方が負けです。");
		System.out.println();

		
	    while (stones > 0) {
	        // プレイヤーのターン
	        stones = NimPlayer.playerTurn(stones, scanner);

	        // 勝敗判定
	        if (NimPlayer.isGameOver(stones, "あなた")) {
	            break;
	        }

	        // コンピュータのターン
	        stones = NimPlayer.computerTurn(stones, random);

	        // 勝敗判定
	        if (NimPlayer.isGameOver(stones, "コンピュータ")) {
	            break;
	        }
	    }
		
	}
	
   
}