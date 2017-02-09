package war;

class Card {

	static final int[] STRENGTH = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
	static final char[] RANKS = { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };
	static final char[] SUITS = { 'C', 'D', 'H', 'S' };

	private final char rank;
	private final char suit;
	private int strength;

	public Card(char rank, char suit, int strength) {
		this.rank = rank;
		this.suit = suit;
		this.strength = strength;

	}

	public char getRank() {
		return rank;
	}

	public char getSuit() {
		return suit;
	}

	public int getStrength() {
		return strength;
	}

	boolean isGreaterThan(Card c) {
		if (c == null) {
			throw new RuntimeException("Null pointer compare.");
		}
		return this.strength > c.strength;
	}

	boolean equalTo(Card c) {
		if (c == null) {
			throw new RuntimeException("Null pointer compare.");
		}
		return this.rank == c.rank;
	}

	boolean isSmallerThan(Card c) {
		if (c == null) {
			throw new RuntimeException("Null pointer compare.");
		}
		return this.strength < c.strength;
	}

	public String getInfo() {
		return this.rank + " of " + this.suit;
	}

	// @Override
	// public int compareTo(Card otherCard) {
	// if (otherCard == null) {
	// throw new RuntimeException("Null pointer compare.");
	// }
	//
	// if (this.isGreaterThan(otherCard)) {
	// return +1;
	// } else if (this.isSmallerThan(otherCard)) {
	// return -1;
	// } else if (this.equalTo(otherCard)) {
	// return 0;
	// }
	//
	// return 0;
	// }

	@Override
	public String toString() {
		return "" + rank + "" + suit;
	}
}
