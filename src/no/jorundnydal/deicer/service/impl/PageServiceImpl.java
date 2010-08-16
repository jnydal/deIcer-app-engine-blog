package no.jorundnydal.deicer.service.impl;

import java.util.Date;
import java.util.List;

import no.jorundnydal.deicer.dao.PageDAO;
import no.jorundnydal.deicer.entity.Page;
import no.jorundnydal.deicer.entity.PageReference;
import no.jorundnydal.deicer.service.PageService;



/*
 * page manager implementation
 * 
 * handles page related buisness logic
 * 
 */
public class PageServiceImpl implements PageService {

	private PageDAO pageDAO;
	
	public Page getPage(Long id) {

		return pageDAO.findObjectById(id);
		
	}

	/*
	 * fetches page references: page id and title
	 * 
	 * (non-Javadoc)
	 * @see com.nifrostband.web.service.PageService#getPageHeaders()
	 */
	public List<PageReference> getPageReferences() {

		//WebApplicationContext applicationContext = Utils.getApplicationContext(arg0);
		//Nifrost nifrost = (Nifrost)applicationContext.getBean("nifrost");
		
		return pageDAO.getPageReferences();

	}
	
	public Page storePage(Page newpage) {

		Page page = new Page();
		page.setId(newpage.getId());
		page.setDate(new Date());		
		page.setTitle(newpage.getTitle());
		page.setContent(newpage.getContent());
		page.setUser(newpage.getUser());
		
		return pageDAO.saveObject(page);
		
	}

	public void setPageDAO(PageDAO pageDAO) {
		this.pageDAO = pageDAO;
	}

	public PageDAO getPageDAO() {
		return pageDAO;
	}

	@Override
	public void deletePage(Long id) {

		pageDAO.deleteObject(id);
	
	}
	
}