package no.jorundnydal.deicer.dao;

import java.util.List;

import no.jorundnydal.deicer.dao.GenericDao;
import no.jorundnydal.deicer.entity.Page;
import no.jorundnydal.deicer.entity.PageReference;



public interface PageDAO extends GenericDao<Page, Long> {
 
	public List<PageReference> getPageReferences();
 
}