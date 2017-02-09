package war;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
	private Player players[] = {};
	private List piles[] = {};
	private Deck deck = new Deck();

	public Game(String names[]) {
		players = new Player[names.length];
		piles = new List[names.length];
		for (int i = 0; i < names.length; i++) {
			players[i] = new Player(names[i]);
			piles[i] = new ArrayList<Card>();
		}
	}

	private void deal() {
		Object cards[] = deck.getCards();
		Card hands[][] = new Card[players.length][deck.getMaxCardsInDeck() / players.length];
		for (int p = 0, c = 0; p < players.length; p++) {
			for (int h = 0; h < hands[p].length; h++, c++) {
				hands[p][h] = (Card) cards[c];
			}

			players[p].receive(hands[p]);
		}
	}

	public void reset() {
		deck.shuffle();
		deal();
	}

	public boolean isOver() {
		for (Player player : players) {
			if (player.getLeft() > 0) {
				return false;
			}
		}
		return true;
	}

	public void turn() {
		for (int p = 0; p < players.length; p++) {
			piles[p].add(players[p].play());
		}
		loop: do {
			if (((Card) piles[0].get(0)).equalTo((Card) piles[1].get(0))) {
				for (int p = 0; p < players.length; p++) {
					if (players[p].getLeft() <= 0) {
						break loop;
					}
					piles[p].add(0, players[p].play());
					piles[p].add(0, players[p].play());
					piles[p].add(0, players[p].play());
				}
			} else if (((Card) piles[0].get(0)).isSmallerThan((Card) piles[1].get(0))) {
				// System.err.println("Test point 5 ...");
				players[1].collect(piles[0].toArray());
				players[1].collect(piles[1].toArray());
				for (List pile : piles) {
					pile.clear();
				}
			} else if (((Card) piles[0].get(0)).isGreaterThan((Card) piles[1].get(0))) {
				// System.err.println("Test point 6 ...");
				players[0].collect(piles[0].toArray());
				players[0].collect(piles[1].toArray());
				for (List pile : piles) {
					pile.clear();
				}
			}
			// System.err.println("Test point 7 ...");
		} while (piles[0].size() > 0 || piles[1].size() > 0);
		// System.err.println("Test point 8 ...");
	}

	public String getInfo() {
		return toString();
	}

	@Override
	public String toString() {
		return "Game [players=" + Arrays.toString(players) + ", piles=" + Arrays.toString(piles) + ", deck=" + deck
				+ "]";
	}

	public void printWin() {

		if (players[0].getLeft() == 0 && players[1].getLeft() == 0) {
			if (players[0].getCollected().length > players[1].getCollected().length) {
				System.out.println(players[0].getName() + "  wins");
			} else {
				System.out.println(players[1].getName() + "  wins");
			}
		}
	}

}
