package com.blog.model.po;

import java.io.Serializable;

public class TabCommentPo extends BasePo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String articleId;
	private String content;
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
