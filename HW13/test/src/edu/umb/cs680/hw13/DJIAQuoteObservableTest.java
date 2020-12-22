package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DJIAQuoteObservableTest {

	@Test
	void verifyDijaQuote() {
		PieChartObserver PieChartObserver = new PieChartObserver();
		TableObserver TableObserver = new TableObserver();
		ThreeDObserver THREEDObserver = new ThreeDObserver();

		DJIAQuoteObservable djiaObserver = new DJIAQuoteObservable();
		djiaObserver.addObserver(PieChartObserver);
		djiaObserver.addObserver(TableObserver);
		djiaObserver.addObserver(THREEDObserver);

		djiaObserver.changeQuote(35);
		djiaObserver.changeQuote(50);
	}
}
