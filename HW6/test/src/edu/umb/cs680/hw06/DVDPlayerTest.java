package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DVDPlayerTest {


	@Test
	public void DVDPlayingWhenClosedButtonPushedInDrawerClosed() {
		DVDPlayer p = DVDPlayer.getInstance();
		p.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), p.getCurrentState());
	}

        @Test
	public void StopWhenStopButtonPushedWhilePlayingInDrawerClosed() {
		DVDPlayer p = DVDPlayer.getInstance();
		p.playButtonPushed();
		p.stopButtonPushed();
		assertEquals(DrawerClosedNotPlaying.getInstance(), p.getCurrentState());
	}

	@Test
	public void OpenCloseButtonPushedWhilePlayingInDrawerOpen() {
		DVDPlayer p = DVDPlayer.getInstance();
		p.playButtonPushed();
		p.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(), p.getCurrentState());
	}

}
