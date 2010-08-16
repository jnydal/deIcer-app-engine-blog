package no.jorundnydal.deicer.gae.editor;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import java.util.logging.Logger;

import java.beans.PropertyEditorSupport;

import no.jorundnydal.deicer.entity.User;

/**
 * Created by IntelliJ IDEA.
 *
 * @author shane
 * @since Jul 1, 2009 9:19:33 PM
 */
public class GoogleDatastoreKeyEditor extends PropertyEditorSupport {

  private static final Logger log = Logger.getLogger(GoogleDatastoreKeyEditor.class.getName());

  @SuppressWarnings("unchecked")
private Class subclass;
  
  public GoogleDatastoreKeyEditor() {

	  super();
	  
	  setSubclass(User.class);
	  
  }
  
  @Override
  public void setAsText(String text) {
    if (text == null || text.length() == 0) {
      setValue(null);
    } else {
      Key key = null;
      try {
    	key = KeyFactory.createKey(getSubclass().getSimpleName(), text);
        //key = KeyFactory.stringToKey(text);
      } catch (Exception e) {
    	  log.warning("Cannot parse key: " + text + e.getMessage());
      }
      setValue(key);
    }
  }

  @Override
  public String getAsText() {
    Key value = (Key) getValue();
    return (value != null ? KeyFactory.keyToString(value) : "");
  }

public void setSubclass(Class subclass) {
	this.subclass = subclass;
}

public Class getSubclass() {
	return subclass;
}
}
