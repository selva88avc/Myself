package com.stackroute.thirdpartyapp.model;

public class NewsData {
	String status;
	int totalnumber;
	Article[] articles;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalnumber() {
		return totalnumber;
	}
	public void setTotalnumber(int totalnumber) {
		this.totalnumber = totalnumber;
	}
	public Article[] getArticles() {
		return articles;
	}
	public void setArticles(Article[] articles) {
		this.articles = articles;
	}

}
