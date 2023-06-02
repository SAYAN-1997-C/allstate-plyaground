package com.stackroute.bookmarkapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Userbookmark {

	@Id
	String bookmarkid; //(priimary key)  (combine=href+email)
	
	String href;
	String songname;
	String albumname;
	String artistname;
	String albumid;
	String email;
	
	public Userbookmark() {}

	public Userbookmark(String bookmarkid, String href, String songname, String albumname, String artistname,
			String albumid, String email) {
		super();
		this.bookmarkid = bookmarkid;
		this.href = href;
		this.songname = songname;
		this.albumname = albumname;
		this.artistname = artistname;
		this.albumid = albumid;
		this.email = email;
	}

	public String getBookmarkid() {
		return bookmarkid;
	}

	public void setBookmarkid(String bookmarkid) {
		this.bookmarkid = bookmarkid;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	public String getAlbumid() {
		return albumid;
	}

	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Userbookmark [bookmarkid=" + bookmarkid + ", href=" + href + ", songname=" + songname + ", albumname="
				+ albumname + ", artistname=" + artistname + ", albumid=" + albumid + ", email=" + email + "]";
	}
	
	
}
