package com;

public class AtmWithDraw {

	private final int MINIMUM_HUNDREDS = 6;
	private final int MINIMUM_FIVE_HUNDREDS = 3;

	public void draw(int amount) {

		if (amount % 100 != 0) {
			throw new IllegalArgumentException("invalid amount");
		}

		int t = amount / 1000;
		int h, f;
		int remaining = amount - t * 1000;

		f = remaining / 500;

		remaining = remaining - f * 500;

		h = remaining / 100;

		// settling five hundreds
		int fiveNeeded = MINIMUM_FIVE_HUNDREDS - f;
		if (fiveNeeded % 2 != 0) {
			++fiveNeeded;
		}

		if (t >= (fiveNeeded / 2)) {
			t -= fiveNeeded / 2;
		} else {
			fiveNeeded = t * 2;
			t = 0;
		}
		f += fiveNeeded;

		if (f > MINIMUM_FIVE_HUNDREDS) {
			h += 5;
			f -= 1;
		} else {
			if (f > 0) {
				int hundredNeeded = MINIMUM_HUNDREDS - h;
				if (hundredNeeded <= 5 || f == 1) {
					h += 5;
					f -= 1;
				} else {
					h += 10;
					f -= 2;
				}
			}

		}

		System.out.println("100 , 500, 1000 " + h + " " + f + " " + t);
	}

	public static void main(String args[]) {
		AtmWithDraw object = new AtmWithDraw();
//		object.draw(100);
//		object.draw(1000);
//		object.draw(500);
		object.draw(22200);

	}
}
