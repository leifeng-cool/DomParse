package com.ybs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class DbDao {
	
	UUID uuid  =  UUID.randomUUID(); 
	private static String s = UUID.randomUUID().toString();
	
	public static void insert(String tableName,String parentID,String idvalue) throws SQLException {
		//获得数据库conn连接
		Connection conn = DbUtil.getConnection();
		//insert into tableName (Id, parentID, Name， enable) values
		//									(getUUid(), null, idvalue, true);
		String sql = "INSERT INTO "+tableName+"(Id, parentID, Name， enable) Values"
				+"(?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, s);
		ptmt.setString(2, parentID);
		ptmt.setString(3, idvalue);
		ptmt.setBoolean(4, true);
		Boolean rs = ptmt.execute();
		if (rs) {
			System.out.println("添加成功");
		}
	}
}
