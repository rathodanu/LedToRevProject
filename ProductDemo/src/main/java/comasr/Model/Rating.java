package comasr.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Rating {
	

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private int rating;

    private String comment;

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rating(String userId, int rating, String comment) {
		super();
		this.userId = userId;
		this.rating = rating;
		this.comment = comment;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Rating [userId=" + userId + ", rating=" + rating + ", comment=" + comment + "]";
	}
    
    

}
