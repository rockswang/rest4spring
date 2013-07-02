package com.match.cp.framework.dao;

import com.match.cp.framework.model.Model;

import java.util.List;

public interface Dao<M extends Model, QM extends M> {
	public boolean create(M model);

	public boolean update(M model);

	public boolean delete(long id);

	public List<M> getAll(int firstRecord, int maxRecords);

	public List<M> getAll();

	public int getAllCount();

	public List<M> getByCondition(QM qm, int firstRecord, int maxRecords);

	public List<M> getByCondition(QM qm);

	public int getByConditionCount(QM qm);

	public M getSingle(long id);
}
