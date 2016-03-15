package com.sun.dao;

import java.util.List;

import com.sun.domain.Goods;
import com.sun.domain.GoodsResult;

public interface GoodsDao {

	public void save(Goods good);
	
	public void update(Goods good);
	
	public void delete(int id);
	
	public Goods getById(int id);
	
	public List<Goods> findAll();

	public GoodsResult findAllPerPage(int firstResult, int maxSize);


}
