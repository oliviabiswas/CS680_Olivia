package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State {

	private DrawerClosedNotPlaying() {
	}

	private static DrawerClosedNotPlaying instance = null;

	public static DrawerClosedNotPlaying getInstance() {
		if (instance == null)
			instance = new DrawerClosedNotPlaying();
		return instance;
	}

	public void openCloseButtonPushed() {
		player.open();
		player.changeState(DrawerOpen.getInstance());
	}

	public void playButtonPushed() {
		player.play();
		player.changeState(DrawerClosedPlaying.getInstance());
	}

	public void stopButtonPushed() {
		System.out.println("DVD Stopped.....");
	}
}
