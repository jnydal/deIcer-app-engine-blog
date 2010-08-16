package no.jorundnydal.deicer.entity;

import java.io.Serializable;


public class DownloadableFile implements Serializable {
	
    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	private byte[] content;
    public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	private String filename;
    private String mimeType;

}