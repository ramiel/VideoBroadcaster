package it.ramiel.red5;

import java.util.HashMap;

import org.red5.server.api.IConnection;

public class UserManager {
	
	private static UserManager userManager;
	public static final int BROADCASTER = 0;
	public static final int WATCHER = 1;
	private HashMap<String,User> connectedUsers;
	
	private UserManager(){
		connectedUsers = new HashMap<String, User>();
	}
	
	/**
	 * Fornisce uno UserManager. E' fornito in un contesto di singleton
	 * @return UserManager
	 */
	public static synchronized UserManager getUserManager(){
		if(userManager == null){
			userManager = new UserManager();
		}
		return userManager;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	private Broadcaster addBroadcaster(){		
		return new Broadcaster();
	}
	
	private Watcher addWatcher(){
		return new Watcher();
	}
	
	public User addUser(IConnection userConnection,String hash,int userType){
		switch(userType){
			case BROADCASTER:
				return addBroadcaster();
			case WATCHER:
				return addWatcher();
			default:
				VideoBroadcaster.log.info("Parametro TYPE del client errato,era {}",userType);
				userConnection.close();
				return null;
		}
		
	}

	/**
	 * @param connectedUsers the connectedUsers to set
	 */
	public void setConnectedUsers(HashMap<String,User> connectedUsers) {
		this.connectedUsers = connectedUsers;
	}

	/**
	 * @return the connectedUsers
	 */
	public HashMap<String,User> getConnectedUsers() {
		return connectedUsers;
	}

}
