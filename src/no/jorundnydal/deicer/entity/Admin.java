package no.jorundnydal.deicer.entity;

import java.util.List;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import no.jorundnydal.deicer.entity.User;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Admin extends User {

	@Persistent
	private boolean isBandMember;

	@Persistent(mappedBy = "user")
    private List<Key> posts;
	
	public void setBandMember(boolean isBandMember) {
		this.isBandMember = isBandMember;
	}

	public boolean isBandMember() {
		return isBandMember;
	}

	public void setPosts(List<Key> posts) {
		this.posts = posts;
	}

	public List<Key> getPosts() {
		return posts;
	}
	
}