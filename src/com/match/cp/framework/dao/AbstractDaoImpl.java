package com.match.cp.framework.dao;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.match.cp.framework.model.Model;

@SuppressWarnings( { "rawtypes"})
public class AbstractDaoImpl<M extends Model, QM extends M> extends
		JdbcDaoSupport implements Dao<M, QM> {

	private final Class<M> clazz;
	protected AbstractDaoImpl(Class<M> clazz){
		this.clazz = clazz;
	}
	//private Logger log = LoggerFactory.getLogger(getClass()); 
	
	@Override
	public boolean create(M model) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(getJdbcTemplate()).withTableName(getTableName());
		return insertActor.execute(new BeanPropertySqlParameterSource(model)) > 0;
	}

	@Override
	public boolean update(M model) {
		StringBuffer createSql = new StringBuffer("update " + getTableName() + " set ");
		Field[] fields = model.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			Class fieldType = field.getType();
			if (! (fieldName.equalsIgnoreCase("id")
					|| fieldType.equals(Collections.class)
					|| fieldType.equals(Map.class)
					|| fieldType.equals(List.class) 
					|| fieldType.equals(Set.class)) )
				createSql.append(fieldName + " = :" + fieldName + ",");
		}
		createSql.replace(createSql.lastIndexOf(","), createSql.length(), "");
		createSql.append(" WHERE id = :id");

		SqlParameterSource ps = new BeanPropertySqlParameterSource(model);

		return this.getJdbcTemplate().update(createSql.toString(), ps) > 0;
	}

	@Override
	public boolean delete(long id) {
		String deleteSql = "delete from "+getTableName()+" where id = ?";
		return this.getJdbcTemplate().update(deleteSql, id) > 0;
	}

	@Override
	public M getSingle(long id) {
		String getSingleSql = "select * from " + getTableName() + " where id=?";
		RowMapper<M> rowMapper = BeanPropertyRowMapper.newInstance(clazz); 
		return getJdbcTemplate().query(getSingleSql, rowMapper, id).get(0);
	}

	@Override
	public List<M> getAll(int firstRecord, int maxRecords) {
		return null;
	}

	@Override
	public List<M> getAll() {
		String getAllSql = "select * from " + getTableName();
		RowMapper<M> rowMapper = BeanPropertyRowMapper.newInstance(clazz); 
		return getJdbcTemplate().query(getAllSql, rowMapper);
	}

	@Override
	public int getAllCount() {
		String getAllCountSql = "select count(0) from " + getTableName();
		return getJdbcTemplate().queryForObject(getAllCountSql, int.class);
	}

	@Override
	public List<M> getByCondition(QM qm, int firstRecord, int maxRecords) {
		return null;
	}

	@Override
	public List<M> getByCondition(QM qm) {
		return null;
	}

	@Override
	public int getByConditionCount(QM qm) {
		return 0;
	}
	
	/**
	 * @param operate:执行的操作
	 * @return
	 */
	private String getTableName(){
		String simpleName = clazz.getClass().getSimpleName();
		return simpleName.replace("Model", "");
	}

}
