package com.jxau.ssm.pojo;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Main {


	public static void main(String[] args) {
		SqlSession sqlsession = null;
		try {
			Logger logger = Logger.getLogger(Main.class);
			sqlsession = SqlSessionFactoryUtils.openSqlSession();
			EmployeeMapper employeeMapper = sqlsession.getMapper(EmployeeMapper.class);
			Employee employee = employeeMapper.getEmployee(1L);
			logger.info(employee.getBirthday());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlsession != null){
				sqlsession.close();
			}
		}
	}
}
