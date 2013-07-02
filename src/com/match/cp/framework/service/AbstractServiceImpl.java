package com.match.cp.framework.service;

import java.util.List;

import com.match.cp.framework.dao.Dao;
import com.match.cp.framework.model.Model;

public class AbstractServiceImpl<M extends Model, QM extends M, D extends Dao<M, QM>>
		implements Service<M, QM> {

	// 子类传上来
	protected D dao;

	public boolean create(M model) {
		return dao.create(model);
	}

	public boolean delete(long id) {
		return dao.delete(id);
	}

	public List<M> getAll() {
		return dao.getAll();
	}

	public List<M> getAll(int firstRecord, int maxRecords) {
		return dao.getAll(firstRecord, maxRecords);
	}

	public int getAllCount() {
		return dao.getAllCount();
	}

	public List<M> getByCondition(QM qm, int firstRecord, int maxRecords) {
		return dao.getByCondition(qm, firstRecord, maxRecords);
	}

	public List<M> getByCondition(QM qm) {
		return dao.getByCondition(qm);
	}

	public int getByConditionCount(QM qm) {
		return dao.getByConditionCount(qm);
	}

	public M getSingle(long id) {
		return dao.getSingle(id);
	}

	public boolean update(M model) {
		return dao.update(model);
	}

	public void setDao(D dao) {
		this.dao = dao;
	}
}
