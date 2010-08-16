package no.jorundnydal.deicer.service;

import java.util.List;

import no.jorundnydal.deicer.entity.BlogPost;



public interface PostService {

	public List<BlogPost> getAllPosts();
	
	public List<BlogPost> getPosts(Long range);
	
	public boolean isOlderPosts(Long page);
	
	public boolean isNewerPosts(Long page);
	
	public BlogPost storePost(BlogPost post);

	public void deletePost(Long id);
	
}
