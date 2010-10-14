package it.ramiel.red5;

public class Watcher extends User {
	
	protected boolean isBroadcaster = false;
	private boolean isWatching;
	
	/**
	 * @param isWatching the isWatching to set
	 */
	public void setWatching(boolean isWatching) {
		this.isWatching = isWatching;
	}
	/**
	 * @return the isWatching
	 */
	public boolean isWatching() {
		return isWatching;
	}

}
