package no.jorundnydal.deicer.gae.editor;

import com.google.appengine.api.datastore.Text;

import java.util.logging.Logger;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 *
 * @author shane
 * @since Jul 1, 2009 9:19:33 PM
 */
public class GoogleDatastoreTextEditor extends PropertyEditorSupport {

  private static final Logger log = Logger.getLogger(GoogleDatastoreKeyEditor.class.getName());

  @Override
  public void setAsText(String text) {
    if (text == null || text.length() == 0) {
      setValue(null);
    } else {
      Text object = null;
      try {
    	object = new Text(text);
      } catch (Exception e) {
    	  log.warning("Cannot create text object: " + text + e);
      }

      super.setValue(object);

    }
  }

  @Override
  public String getAsText() {
    Text object = (Text) super.getValue();
    try {
    	
    }catch (Exception e) {
    	System.out.println("unable to read text object"+e.getMessage());
	}
    return (object != null ? object.getValue() : "");
  }
}
