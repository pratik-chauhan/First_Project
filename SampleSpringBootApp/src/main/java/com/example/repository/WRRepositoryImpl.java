package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value="wrRepositoryImpl")
public class WRRepositoryImpl {
	
	@Autowired
	@Qualifier("wrJDBCTemplate")
	private JdbcTemplate wrJDBCTemplate;
	
	
	@Transactional("wrTransactionManager")
	public void testDBConnection() throws SQLException{
		Connection connection = wrJDBCTemplate.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT COUNT(1) as Cnt FROM postalcodes");
		rs.next();
		System.out.println(rs.getInt("Cnt"));
		connection.close();
	}
	
	@Transactional("wrTransactionManager")
	public void insertEmployee() throws Exception{
		
		wrJDBCTemplate.execute("insert into employee (name,create_date_time) values (?,?);",new PreparedStatementCallback<Boolean>(){

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, "emp2");
				ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				return ps.execute();
			}
			
		});
		
		throw new Exception("exception");
		
//		wrJDBCTemplate.queryForList("select count(1) from employee;");
		
	}
	

}
