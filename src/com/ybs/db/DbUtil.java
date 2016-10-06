package com.ybs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
		private static String datebase = "study";
		private static final String URL ="jdbc:mysql://127.0.0.1:3306/"+datebase+
											"?useUnicode=true&characterEncoding=gbk";
		private static final String user = "root";
		private static final String password="root"; 
		private static Connection conn;
		
		static{
			try {
//				1.加载驱动程序
				Class.forName("com.mysql.jdbc.Driver");
//				2.获得数据库连接
				conn = DriverManager.getConnection(URL, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static Connection getConnection() {
				return conn;
			}
}

