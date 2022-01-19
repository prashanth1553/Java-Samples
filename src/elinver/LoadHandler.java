package elinver;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LoadHandler {

	private static final int MAX_PRICE_UPDATES = 100;
	private Consumer consumer;
	private static final ScheduledExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadScheduledExecutor();
	PriceUpdateQueue priceUpdateQueue = PriceUpdateQueue.getInstance();

	public LoadHandler(Consumer consumer) {
		this.consumer = consumer;
	}

	{
		// start the schedule
		EXECUTOR_SERVICE.scheduleAtFixedRate(() -> {
			consumer.send(new ArrayList<>(priceUpdateQueue.getAllUpdates()));
			priceUpdateQueue.removeAll();
		}, 1, 1, TimeUnit.SECONDS);
	}

	public void receive(PriceUpdate priceUpdate) {
		priceUpdateQueue.add(priceUpdate);
	}

}
