package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StockQuoteObservableTest {

	@Test
	void verifyDijaQuote() {
		PieChartObserver PieChartObserver = new PieChartObserver();
		TableObserver TableObserver = new TableObserver();
		ThreeDObserver THREEDObserver = new ThreeDObserver();

		StockQuoteObservable djiaObserver = new StockQuoteObservable();
		djiaObserver.addObserver(PieChartObserver);
		djiaObserver.addObserver(TableObserver);
		djiaObserver.addObserver(THREEDObserver);

		djiaObserver.changeQuote("MSFT",35);
		djiaObserver.changeQuote("AAPL",50);
	}
}

