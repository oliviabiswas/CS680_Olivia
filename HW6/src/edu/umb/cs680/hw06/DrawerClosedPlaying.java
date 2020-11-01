package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State {
	private DrawerClosedPlaying() {
	}

	private static DrawerClosedPlaying instance = null;

	public static DrawerClosedPlaying getInstance() {
		if (instance == null)
			instance = new DrawerClosedPlaying();
		return instance;
	}

	public void openCloseButtonPushed() {
		player.stop();
		player.open();
		player.changeState(DrawerOpen.getInstance());
	}

	public void playButtonPushed() {
		System.out.println("Playing DVD.....");
	}

	public void stopButtonPushed() {
		player.stop();
		player.changeState(DrawerClosedNotPlaying.getInstance());
	}
}