package com.aca.RyanBatesSound.model;

import java.time.LocalDateTime;

public class Movie {

	private Integer id;
	private String title;
	private Integer releaseYear;
	private Production production;
	private LocalDateTime updateDateTime;
	private LocalDateTime createDateTime;
	private String link;

	public String getTitle() {
		return title;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public Production getProduction() {
		return production;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public void setProduction(Production production) {
		this.production = production;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
//	public String toString() {
//		return "title: " + title;
//	}
}
