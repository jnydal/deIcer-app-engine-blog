package no.jorundnydal.deicer.entity;

import java.io.Serializable;

public class LoginData implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
    
    private String password;
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
    
    public String toString() {
    	return username;
    }
    
}
