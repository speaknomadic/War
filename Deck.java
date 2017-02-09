package war;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {

	private Object[] cards;
	private int drawnCards = 0;

	public Deck() {
		List<Card> list = new ArrayList<Card>();
		for (int i = 0; i < Card.RANKS.length; i++) {
			for (int j = 0; j < Card.SUITS.length; j++) {
				list.add(new Card(Card.RANKS[i], Card.SUITS[j], Card.STRENGTH[i]));
			}
		}
		cards = list.toArray();
	}

	public void printCards() {
		for (int i = 0; i < this.cards.length; i++) {
			if (this.cards[i] == null) {
				continue;
			}

			System.out.println(((Card) cards[i]).getInfo());
		}
	}

	public void shuffle() {
		Random r = new Random();
		for (int i = 0; i < cards.length; i++) {
			int idx = r.nextInt(cards.length);
			Object temp = cards[i];
			cards[i] = cards[idx];
			cards[idx] = temp;
		}
	}

	public Object[] getCards() {
		return cards;
	}

	public int getMaxCardsInDeck() {
		return cards.length;
	}

	public int getDrawnCards() {
		return drawnCards;
	}

	public Card drawCard() {
		Card card = (Card) cards[drawnCards];
		drawnCards++;
		return card;
	}

	@Override
	public String toString() {
		return "Deck [cards=" + Arrays.toString(cards) + ", drawnCards=" + drawnCards + "]";
	}
}
