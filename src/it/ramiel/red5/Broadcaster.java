package it.ramiel.red5;

public class Broadcaster extends User {
	
	protected boolean isBroadcaster = true;
	private boolean isStreaming;
	
	
	/**
	 * @param isStreaming the isStreaming to set
	 */
	public void setStreaming(boolean isStreaming) {
		this.isStreaming = isStreaming;
	}
	/**
	 * @return the isStreaming
	 */
	public boolean isStreaming() {
		return isStreaming;
	}

}
