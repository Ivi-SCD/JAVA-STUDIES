package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	
	private List <Comment> comentarios = new ArrayList<>();
	
	public Post() {
	}
	
	public Post(Date moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}
	
	public Date getMoment() {
		return moment;
	}
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
	public List<Comment> getCometarios() {
		return comentarios;
	}

	public void addComment(Comment comentary) {
		comentarios.add(comentary);
	}
	
	public void removeComment(Comment comentary) {
		comentarios.remove(comentary);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title + "\n");
		sb.append(likes);
		sb.append(" Likes - ");
		sb.append(formato.format(moment) + "\n");
		sb.append(content + "\n");
		sb.append("Comments:\n");
		for(Comment c : comentarios) {
			sb.append(c.getComment() + "\n");
		}
		return sb.toString();
	}
}