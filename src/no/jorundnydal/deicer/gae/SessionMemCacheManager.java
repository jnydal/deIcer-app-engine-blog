package no.jorundnydal.deicer.gae;

import java.util.Collections;
import java.util.logging.Logger;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheFactory;
import net.sf.jsr107cache.CacheManager;





/*
* SessionMemCacheManager singleton
*
* GAE/J related class
*
* Alternative to default sun servlet session implemention
*
*/
public final class SessionMemCacheManager {

	private static CacheFactory cacheFactory;
	private static Cache cache;
	public static final Logger log = Logger.getLogger(SessionMemCacheManager.class.getName());
	
	public static Cache getCache() {
		if (cache==null){
			try {
				cacheFactory = CacheManager.getInstance().getCacheFactory();
				return cacheFactory.createCache(Collections.emptyMap());
			} catch (CacheException e) {
				e.printStackTrace();
				return null;
			}
		}else {
			return cache;
		}
	}
	
}