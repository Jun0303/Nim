import java.util.Random;
import java.util.Scanner;

public abstract class NimPlayer{
	
	String playerName;
	int WinCnt;
	
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