package com.stackroute.playlistapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Userplaylist {
	
	@Id
	String playlistid; // (priimary key)  (combine=href+email)
	String href;
	String songname;
	String albumid;
	String albumname;
	String artistname;
	String email;
	
	public Userplaylist() {}

	public String getPlaylistid() {
		return playlistid;
	}

	public void setPlaylistid(String playlistid) {
		this.playlistid = playlistid;
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
		return "Userplaylist [playlistid=" + playlistid + ", href=" + href + ", songname=" + songname + ", albumid="
				+ albumid + ", albumname=" + albumname + ", artistname=" + artistname + ", email=" + email + "]";
	}

}
