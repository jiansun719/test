package com.sun.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.dao.GoodsDao;
import com.sun.domain.Goods;
import com.sun.domain.GoodsResult;
import com.sun.hibernate.HibernateUtil;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public void save(Goods good) {
		Session session = new HibernateUtil().getSession();
		Transaction tr = null;
		try{
			tr = session.beginTransaction();
			session.save(good);
			tr.commit();
		}catch(RuntimeException e){
			tr.rollback();
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public void update(Goods good) {
		Session session = new HibernateUtil().getSession();
		Transaction tr = null;
		try{
			tr = session.beginTransaction();
			session.update(good);
			tr.commit();
		}catch(RuntimeException e){
			tr.rollback();
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public void delete(int id) {
		Session session = new HibernateUtil().getSession();
		Transaction tr = null;
		try{
			tr = session.beginTransaction();
			Object good = session.get(Goods.class, id);
			session.delete(good);
			tr.commit();
		}catch(RuntimeException e){
			tr.rollback();
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public Goods getById(int id) {
		Session session = new HibernateUtil().getSession();
		Transaction tr = null;
		try{
			tr = session.beginTransaction();
			Goods good = (Goods) session.get(Goods.class, id);
			tr.commit();
			return good;
		}catch(RuntimeException e){
			tr.rollback();
			throw e;
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findAll() {
		Session session = new HibernateUtil().getSession();
		Transaction tr = null;
		try{
			tr = session.beginTransaction();
			List<Goods> list = session.createQuery("from Goods").list();
			tr.commit();
			return list;
		}catch(RuntimeException e){
			tr.rollback();
			throw e;
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public GoodsResult findAllPerPage(int firstResult,int maxResult) {
		Session session = new HibernateUtil().getSession();
		Transaction tr = null;
		try{
			tr = session.beginTransaction();
			List<Goods> list = session.createQuery("from Goods")
				   .setFirstResult(firstResult)
				   .setMaxResults(maxResult)
				   .list();
			tr.commit();
			GoodsResult goodsResult = new GoodsResult();
			goodsResult.setList(list);
			Long size = (Long) session.createQuery(
					"SELECT COUNT(*)from Goods")
					.uniqueResult();
			goodsResult.setSize(size.intValue());
			return goodsResult;
		}catch(RuntimeException e){
			tr.rollback();
			throw e;
		}finally {
			session.close();
		}
	}

}
