package no.jorundnydal.deicer.dao;

import java.util.List;

import no.jorundnydal.deicer.dao.GenericDao;
import no.jorundnydal.deicer.entity.BlogPost;



public interface PostDAO extends GenericDao<BlogPost, Long> {
 
	public List<BlogPost> findPosts(String range);
 
}