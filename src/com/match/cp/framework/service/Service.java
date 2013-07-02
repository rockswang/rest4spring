package com.match.cp.framework.service;

import java.util.List;
import com.match.cp.framework.model.Model;

public interface Service <M extends Model,QM extends M>{
	public boolean create(M model);
	public boolean update(M model);
	public boolean delete(long id);
	
	public M getSingle(long id);
	
	public List<M> getAll(int firstRecord,int maxRecords);
	public List<M> getAll();
	public int getAllCount();
	
	public List<M> getByCondition(QM qm,int firstRecord,int maxRecords);
	public List<M> getByCondition(QM qm);
	public int getByConditionCount(QM qm);
}
