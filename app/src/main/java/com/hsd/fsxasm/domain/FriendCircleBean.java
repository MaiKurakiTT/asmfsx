package com.hsd.fsxasm.domain;import java.util.Date;import java.util.List;import org.xutils.http.annotation.HttpResponse;import com.hsd.fsxasm.parser.FriendCircleParser;@HttpResponse(parser = FriendCircleParser.class)public class FriendCircleBean extends BaseBean {	private Integer friendsCircle_ID;	private String friendsCircle_icon;	private String friendsCircle_nickname;	private String friendsCircle_content;	private List<PictureBean> pictures ;	private Date friendsCircle_time;	private List<String> comments ;	private Integer user_ID;	private String likeUserIDString;	private Integer likeCount;	private boolean isLike;	public boolean isLike() {		return isLike;	}	public void setLike(boolean isLike) {		this.isLike = isLike;	}	// 朋友圈列表控制	private Integer friendsCircle_pageNow;// 页码	private Integer friendsCircle_pageSize;// 每页大小	public Integer getFriendsCircle_ID() {		return friendsCircle_ID;	}	public String getFriendsCircle_icon() {		return friendsCircle_icon;	}	public String getFriendsCircle_nickname() {		return friendsCircle_nickname;	}	public String getFriendsCircle_content() {		return friendsCircle_content;	}	public List<PictureBean> getPictures() {		return pictures;	}	public Date getFriendsCircle_time() {		return friendsCircle_time;	}	public List<String> getComments() {		return comments;	}	public Integer getUser_ID() {		return user_ID;	}	public String getLikeUserIDString() {		return likeUserIDString;	}	public Integer getLikeCount() {		return likeCount;	}	public Integer getFriendsCircle_pageNow() {		return friendsCircle_pageNow;	}	public Integer getFriendsCircle_pageSize() {		return friendsCircle_pageSize;	}	public void setFriendsCircle_ID(Integer friendsCircle_ID) {		this.friendsCircle_ID = friendsCircle_ID;	}	public void setFriendsCircle_icon(String friendsCircle_icon) {		this.friendsCircle_icon = friendsCircle_icon;	}	public void setFriendsCircle_nickname(String friendsCircle_nickname) {		this.friendsCircle_nickname = friendsCircle_nickname;	}	public void setFriendsCircle_content(String friendsCircle_content) {		this.friendsCircle_content = friendsCircle_content;	}	public void setPictures(List<PictureBean> pictures) {		this.pictures = pictures;	}	public void setFriendsCircle_time(Date friendsCircle_time) {		this.friendsCircle_time = friendsCircle_time;	}	public void setComments(List<String> comments) {		this.comments = comments;	}	public void setUser_ID(Integer user_ID) {		this.user_ID = user_ID;	}	public void setLikeUserIDString(String likeUserIDString) {		this.likeUserIDString = likeUserIDString;	}	public void setLikeCount(Integer likeCount) {		this.likeCount = likeCount;	}	public void setFriendsCircle_pageNow(Integer friendsCircle_pageNow) {		this.friendsCircle_pageNow = friendsCircle_pageNow;	}	public void setFriendsCircle_pageSize(Integer friendsCircle_pageSize) {		this.friendsCircle_pageSize = friendsCircle_pageSize;	}	}