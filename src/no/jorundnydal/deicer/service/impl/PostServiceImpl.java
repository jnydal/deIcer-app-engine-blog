package no.jorundnydal.deicer.service.impl;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;

import no.jorundnydal.deicer.PMF;
import no.jorundnydal.deicer.dao.PostDAO;
import no.jorundnydal.deicer.entity.BlogPost;
import no.jorundnydal.deicer.service.PostService;



/*
 * post manager implementation
 * 
 * handles post related buisness logic
 * 
 */
public class PostServiceImpl implements PostService{
	
	private	PostDAO postDAO;
	
	final Long numberOfPostsPrView;
	
	public PostServiceImpl() {
		
		numberOfPostsPrView = new Long(10);
		
	}
	
	public PostDAO getPostDAO() {
		return postDAO;
	}

	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
	
	public List<BlogPost> getAllPosts() {
		
		List<BlogPost> result = postDAO.findAll();
		
		return result;
	}
	
	public List<BlogPost> getPosts(Long range) {
		
		return postDAO.findPosts(getRangeString(range));
		
	}
	
	public BlogPost storePost(BlogPost newpost) {

		BlogPost post = new BlogPost();
		post.setId(newpost.getId());
		post.setDate(new Date());		
		post.setTitle(newpost.getTitle());
		post.setContent(newpost.getContent());
		post.setUser(newpost.getUser());
		
		return postDAO.saveObject(post);
		
	}

	private String getRangeString(Long range) {
		
		Long first = numberOfPostsPrView * range;
		Long last = (numberOfPostsPrView * range) + numberOfPostsPrView;
					
		return first.toString()+","+last.toString();
		
	}
	
	@Override
	public boolean isOlderPosts(Long page) {
		
		Long totalPostNumber = postDAO.count();
		
		return (((page * numberOfPostsPrView) + numberOfPostsPrView) < totalPostNumber) ? true : false; 
		
	}

	@Override
	public boolean isNewerPosts(Long page) {
		
		return (page>0) ? true : false;

	}

	@Override
	public void deletePost(Long id) {

		postDAO.deleteObject(id);
		
	}
	
}