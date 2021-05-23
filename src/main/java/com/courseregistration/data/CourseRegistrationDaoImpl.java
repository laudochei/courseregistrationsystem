/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.courseregistration.data;

import com.courseregistration.model.CourseRegistration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Me
 */



@Repository
public class CourseRegistrationDaoImpl implements CourseRegistrationDao{

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
        

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;      
	}
        
        
        DataSource dataSource;
        @Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
                
	}
        
        

        
        @Override
	public List<CourseRegistration> findAll() {
		String sql = "SELECT * FROM courseregistration";
		List<CourseRegistration> result = namedParameterJdbcTemplate.query(sql, new CourseRegistrationDaoImpl.CourseRegistrationMapper());
		return result;
	}
        
        
        
	@Override
	public CourseRegistration findID(Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
                String sql = "select * from courseregistration WHERE id=:id";
		CourseRegistration result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new CourseRegistrationMapper());
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
		}
		return result;
	}
        
        
        
        @Override
        public int RegIDExists(Integer id) {
            
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", id);
                   
            String sql = "SELECT count(*) FROM courseregistration WHERE id = :id";
            int count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
            return count;
        }
        
        
        
        @Override
	public void save(CourseRegistration courseregistration) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO CourseRegistration(id, matno, coursecode, term, academicsession) "
				+ "VALUES ( :id, :matno, :coursecode, :term, :academicsession)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(courseregistration), keyHolder, new String[]{"id"});
                courseregistration.setId(keyHolder.getKey().intValue());
	}
        
        
        @Override
	public void update(CourseRegistration courseregistration) {
            String sql = "UPDATE Courseregistration SET id=:id, matno=:matno, coursecode=:coursecode, term=:term, academicsession=:academicsession WHERE id=:id";
            namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(courseregistration));    
	}
        
        
        @Override
	public void delete(Integer id) {
		String sql = "DELETE FROM courseregistration WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
	}
        
        
               
        private SqlParameterSource getSqlParameterByModel(CourseRegistration courseregistration) {
            MapSqlParameterSource paramSource = new MapSqlParameterSource();
            paramSource.addValue("id", courseregistration.getId());
             paramSource.addValue("matno", courseregistration.getMatno());
            paramSource.addValue("coursecode", courseregistration.getCoursecode());
            paramSource.addValue("term", courseregistration.getTerm());
            paramSource.addValue("academicsession", courseregistration.getAcademicsession());
            return paramSource;
	}

       
	private static final class CourseRegistrationMapper implements RowMapper<CourseRegistration> {

            public CourseRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
                CourseRegistration courseregistration = new CourseRegistration();
                courseregistration.setId(rs.getInt("id"));
                courseregistration.setMatno(rs.getString("matno"));
                courseregistration.setCoursecode(rs.getString("coursecode"));
                courseregistration.setTerm(rs.getInt("term"));
                courseregistration.setAcademicsession(rs.getString("academicsession"));
                return courseregistration;
            }
	}   
}

