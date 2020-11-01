package edu.umb.cs680.hw06;

public class DrawerOpen implements State {
	private DrawerOpen() {
	}

	private static DrawerOpen instance = null;

	public static DrawerOpen getInstance() {
		if (instance == null)
			instance = new DrawerOpen();
		return instance;
	}

	public void openCloseButtonPushed() {
		player.close();
		player.changeState(DrawerClosedNotPlaying.getInstance());
	}

	public void playButtonPushed() {
		player.close();
		player.changeState(DrawerClosedPlaying.getInstance());
	}

	public void stopButtonPushed() {
		System.out.println("DVD Stopped.....");
	}

}
