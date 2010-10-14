package it.ramiel.red5;

public class WebSiteConnector {
		/**
		 * Fornisce autenticazione per il client
		 * @param hash
		 * @return true if authentication goes right,false otherwise
		 */
		public static boolean checkAuthentication(String hash){
			//TODO STUB
			return true;
		}
		
		public static User getUserInfo(String hash){
			return new User();
		}
}
