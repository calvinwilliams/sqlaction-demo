// This file generated by sqlaction v0.2.9.0
// WARN : DON'T MODIFY THIS FILE

package xyz.calvinwilliams.sqlaction;

import java.math.*;
import java.util.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlactionDemoSAO {

	int				id ; // 编号 // PRIMARY KEY
	String			name ; // 名字
	String			address ; // 地址

	int				_count_ ; // defining for 'SELECT COUNT(*)'

	// SELECT * FROM sqlaction_demo
	public static int SELECT_ALL_FROM_sqlaction_demo( Connection conn, List<SqlactionDemoSAU> sqlactionDemoListForSelectOutput ) throws Exception {
		Statement stmt = conn.createStatement() ;
		ResultSet rs = stmt.executeQuery( "SELECT * FROM sqlaction_demo" ) ;
		while( rs.next() ) {
			SqlactionDemoSAU sqlactionDemo = new SqlactionDemoSAU() ;
			sqlactionDemo.id = rs.getInt( 1 ) ;
			sqlactionDemo.name = rs.getString( 2 ) ;
			sqlactionDemo.address = rs.getString( 3 ) ;
			sqlactionDemoListForSelectOutput.add(sqlactionDemo) ;
		}
		rs.close();
		stmt.close();
		return sqlactionDemoListForSelectOutput.size();
	}

	// SELECT * FROM sqlaction_demo WHERE name=?
	public static int SELECT_ALL_FROM_sqlaction_demo_WHERE_name_E_( Connection conn, List<SqlactionDemoSAU> sqlactionDemoListForSelectOutput, String _1_SqlactionDemoSAU_name ) throws Exception {
		PreparedStatement prestmt = conn.prepareStatement( "SELECT * FROM sqlaction_demo WHERE name=?" ) ;
		prestmt.setString( 1, _1_SqlactionDemoSAU_name );
		ResultSet rs = prestmt.executeQuery() ;
		while( rs.next() ) {
			SqlactionDemoSAU sqlactionDemo = new SqlactionDemoSAU() ;
			sqlactionDemo.id = rs.getInt( 1 ) ;
			sqlactionDemo.name = rs.getString( 2 ) ;
			sqlactionDemo.address = rs.getString( 3 ) ;
			sqlactionDemoListForSelectOutput.add(sqlactionDemo) ;
		}
		rs.close();
		prestmt.close();
		return sqlactionDemoListForSelectOutput.size();
	}

	// INSERT INTO sqlaction_demo
	public static int INSERT_INTO_sqlaction_demo( Connection conn, SqlactionDemoSAU sqlactionDemo ) throws Exception {
		PreparedStatement prestmt ;
		Statement stmt ;
		ResultSet rs ;
		prestmt = conn.prepareStatement( "INSERT INTO sqlaction_demo (name,address) VALUES (?,?)" ) ;
		prestmt.setString( 1, sqlactionDemo.name );
		prestmt.setString( 2, sqlactionDemo.address );
		int count = prestmt.executeUpdate() ;
		prestmt.close();
		return count;
	}

	// UPDATE sqlaction_demo SET address=? WHERE name=?
	public static int UPDATE_sqlaction_demo_SET_address_E_WHERE_name_E_( Connection conn, String _1_address_ForSetInput, String _1_name_ForWhereInput ) throws Exception {
		PreparedStatement prestmt = conn.prepareStatement( "UPDATE sqlaction_demo SET address=? WHERE name=?" ) ;
		prestmt.setString( 1, _1_address_ForSetInput );
		prestmt.setString( 2, _1_name_ForWhereInput );
		int count = prestmt.executeUpdate() ;
		prestmt.close();
		return count;
	}

	// DELETE FROM sqlaction_demo WHERE name=?
	public static int DELETE_FROM_sqlaction_demo_WHERE_name_E_( Connection conn, String _1_name ) throws Exception {
		PreparedStatement prestmt = conn.prepareStatement( "DELETE FROM sqlaction_demo WHERE name=?" ) ;
		prestmt.setString( 1, _1_name );
		int count = prestmt.executeUpdate() ;
		prestmt.close();
		return count;
	}

}
