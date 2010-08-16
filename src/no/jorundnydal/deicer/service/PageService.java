package no.jorundnydal.deicer.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import no.jorundnydal.deicer.entity.Page;
import no.jorundnydal.deicer.entity.PageReference;


public interface PageService {

	public Page getPage(Long id);
	
	public Page storePage(Page page);
	
	public List<PageReference> getPageReferences();

	public void deletePage(Long id);
	
}
