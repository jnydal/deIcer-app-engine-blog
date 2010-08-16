package no.jorundnydal.deicer.entity;

import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.InheritanceStrategy;

import no.jorundnydal.deicer.SHA1;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
public abstract class User {
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    protected Key id;
	
    @Persistent
	protected String password;
    
    public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Persistent
    private ContactInfo contactInfo;
    
    public boolean validate(String passwordhash, String challenge) throws DigestException, NoSuchAlgorithmException, UnsupportedEncodingException {
    	String hashtest = new SHA1(password,challenge).getHash();
    	System.out.println("test "+hashtest+" db password "+passwordhash);
    	if (hashtest.compareTo(passwordhash) == 0) {
    		return true;
    	}
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getPassword() {
		return password;
	}
    
}