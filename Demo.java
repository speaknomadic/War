package war;

public class Demo {

	public static void main(String[] args) {
		Game game = new Game(new String[] { "Pesho", "Gosho" });
		game.reset();
		System.out.println(game.getInfo());
		while (game.isOver() == false) {
			game.turn();
			System.out.println(game.getInfo());
		}
		game.printWin();
	}
}
