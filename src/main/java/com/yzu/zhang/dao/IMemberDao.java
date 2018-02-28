package com.yzu.zhang.dao;

import java.util.List;

import com.yzu.zhang.model.Member;

public interface IMemberDao {

	/**
     * 添加对象
     */
	public boolean add(final Member member);
	
	/**
     * 添加集合
     */
	public boolean add(final List<Member> list);
	
	/**
     * 修改对象 
     */
	public boolean update(final Member member);
	
	/**
     * 根据key获取对象
     */
	public Member get(final String keyId);
	
	/**
     * 删除对象 ,依赖key
     */
	public void delete(String key);
	
	/**
     * 删除集合 ,依赖key集合
     */
    public void delete(List<String> keys);
    	
}
