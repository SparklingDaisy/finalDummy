package joa.db;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;

public class JoaDB {
	
	static DataSource ds;
	
	static{ //메모리에 바로 올려주는 스테틱 블록
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws Exception{
		return ds.getConnection();
	}
}
