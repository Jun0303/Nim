import java.util.Random;
import java.util.Scanner;

public class StoneGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

    	// 初期の石の数
    	//ランダムに仕様変更
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
            stones = playerTurn(stones, scanner);

            // 勝敗判定
            if (isGameOver(stones, "あなた")) {
                break;
            }

            // コンピュータのターン
            stones = computerTurn(stones, random);

            // 勝敗判定
            if (isGameOver(stones, "コンピュータ")) {
                break;
            }
        }
    }

    // プレイヤーのターンを処理するメソッド
    public static int playerTurn(int stones, Scanner scanner) {
        System.out.print("取る石の数 (1~3) を入力してください: ");
        int playerMove = scanner.nextInt();

        while (playerMove < 1 || playerMove > 3 || playerMove > stones) {
            System.out.print("無効な入力です。再度1~3の範囲で入力してください: ");
            playerMove = scanner.nextInt();
        }

        stones -= playerMove;
        System.out.println("あなたは " + playerMove + " 個の石を取りました。残りの石: " + stones);
        return stones;
    }

    // コンピュータのターンを処理するメソッド
    public static int computerTurn(int stones, Random random) {
        int computerMove = Math.min(random.nextInt(3) + 1, stones);
        stones -= computerMove;
        System.out.println("コンピュータは " + computerMove + " 個の石を取りました。残りの石: " + stones);
        return stones;
    }

    // 勝敗判定を行うメソッド
    public static boolean isGameOver(int stones, String playerName) {
        if (stones == 0) {
            System.out.println(playerName + "の負けです！");
            return true;
        }
        return false;
    }
}