package elinver;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

final public class PriceUpdateQueue {
	private static final int MAX_PRICE_UPDATES = 100;
	private final Set<PriceUpdate> PRICE_UPDATE_BUFFER = new LinkedHashSet<>(MAX_PRICE_UPDATES);
	private static final PriceUpdateQueue queue = new PriceUpdateQueue();

	private PriceUpdateQueue() {

	}

	public static PriceUpdateQueue getInstance() {
		return queue;
	}

	/**
	 * If there is an existing price update for stock removes it and adds given the
	 * price update.
	 * <p>
	 * If queue size is more than MAX_PRICE_UPDATES, it removes the oldest price
	 * update in the queue.
	 * </p>
	 * 
	 * 
	 * @param priceUpdate
	 */
	public void add(PriceUpdate priceUpdate) {
		if (PRICE_UPDATE_BUFFER.contains(priceUpdate)) {
			PRICE_UPDATE_BUFFER.remove(priceUpdate);
		} else if (PRICE_UPDATE_BUFFER.size() > MAX_PRICE_UPDATES) {
			removeOldestElement();
		}
		PRICE_UPDATE_BUFFER.add(priceUpdate);
	}

	private void removeOldestElement() {
		if (!PRICE_UPDATE_BUFFER.isEmpty()) {
			PRICE_UPDATE_BUFFER.remove(PRICE_UPDATE_BUFFER.iterator().next());
		}
	}

	public void removeAll() {
		PRICE_UPDATE_BUFFER.clear();
	}

	public List<PriceUpdate> getAllUpdates() {
		return new ArrayList<>(PRICE_UPDATE_BUFFER);
	}

}
