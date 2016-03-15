package com.sun.dao.impl;

import java.util.List;

import org.junit.Test;

import com.sun.dao.GoodsDao;
import com.sun.domain.Goods;
import com.sun.domain.GoodsResult;

public class GoodsDaoImplTest {

	GoodsDao goodsDao = new GoodsDaoImpl();
	@Test
	public void testSave() {
		Goods good = new Goods("paper",3.20);
		goodsDao.save(good);
	}

	@Test
	public void testUpdate() {
		Goods good = goodsDao.getById(6);
		good.setPrice(10.00);
		goodsDao.update(good);
	}

	@Test
	public void testDelete() {
		goodsDao.delete(6);
	}

	@Test
	public void testGetById() {
		Goods good = goodsDao.getById(6);
		System.out.println(good);
	}

	@Test
	public void testFindAll() {
		List<Goods> list = goodsDao.findAll();
		for(Goods good:list){
			System.out.println(good);
		}
	}

	@Test
	public void testFindAllPerPage() {
		GoodsResult goodResult = goodsDao.findAllPerPage(3,3);
		for(Goods good:goodResult.getList()){
			System.out.println(good);
		};
	}

}
