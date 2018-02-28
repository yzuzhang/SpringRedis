package com.yzu.zhang.model;

public class Member extends BaseModel{
    
	private static final long serialVersionUID = 4991351119941634714L;
	
	private String id;
    private String nickname;
    
    public Member(){
    	
    }
    
    public Member(String id, String nickname){
        this.setId(id);
        this.setNickname(nickname);
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
}