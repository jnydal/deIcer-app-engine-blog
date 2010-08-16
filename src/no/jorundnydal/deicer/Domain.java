package no.jorundnydal.deicer;

/*
 * 
 * Immutable class Domain
 * 
 */
public final class Domain
{

	private final String adminPassword;
	private final String serverSalt;
	private boolean pageDataChanges;
	
	public String getAdminPassword() {
		return adminPassword;
	}

	public String getServerSalt() {
		return serverSalt;
	}

	public Domain(String adminPassword, String serverSalt) {
	   this.adminPassword = adminPassword;
	   this.serverSalt = serverSalt;
	   this.setPageDataChanges(false);
	}

	public void setPageDataChanges(boolean pageDataChanges) {
		this.pageDataChanges = pageDataChanges;
	}

	public boolean isPageDataChanges() {
		return pageDataChanges;
	}
	
} 

