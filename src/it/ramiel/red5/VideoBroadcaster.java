package it.ramiel.red5;

import org.red5.logging.Red5LoggerFactory;
import org.red5.server.adapter.MultiThreadedApplicationAdapter;
import org.red5.server.api.IConnection;
import org.red5.server.api.IScope;
import org.slf4j.Logger;


public class VideoBroadcaster extends MultiThreadedApplicationAdapter {
	
	public static Logger log =Red5LoggerFactory.getLogger(VideoBroadcaster.class, "VideoBroadcaster");
	private UserManager userManager = UserManager.getUserManager();
	
	@Override
	public boolean appStart(IScope app) {
			log.info("VideoBroadcaster Started...");
			return super.appStart(app);
	}
	
	@Override
	public boolean appConnect(IConnection conn, Object[] params) {		
		if(super.appConnect(conn, params) && params != null && params.length > 1){
			log.info("Client Connected {}",conn.getRemoteAddress());
			int type = Integer.parseInt(params[0].toString());
			String hash = params[1].toString();
			if(WebSiteConnector.checkAuthentication(hash)){
					User connectedUser = userManager.addUser(conn, hash, type);
					if(connectedUser != null)
						return true;
					else
						return false;
			}else{
				conn.close();
				return false;
			}
		}else
			return false;
	}
}
