package Global;

//import Login.*;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/

import java.awt.Frame;
import java.sql.*;
import javax.swing.*;
import javax.swing.text.StyledEditorKit.BoldAction;

public class ConnectSql {

	private Data d;


		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		private Statement Connect() {

			try {
				Class.forName("org.sqlite.JDBC");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Open DB");

			try {
				connection = DriverManager.getConnection("jdbc:sqlite:newSql.db");
				statement = connection.createStatement();
				statement.setQueryTimeout(30);

				return connection.createStatement();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

		}
		/*
		 * public boolean connect() { // TODO Auto-generated method stub return false; }
		 */
		/*
		 * public boolean connect() { d=new Data(); try { Statement stmt = Connect(); rs
		 * = stmt.executeQuery("SELECT ID, Password FROM Employee");
		 * 
		 * while (rs.next()) { if ((rs.getInt("ID") == d.getID()) &&
		 * (d.getPass().equals(rs.getString("Password")))) {
		 * 
		 * rs.close(); stmt.close(); return true; } }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * return false; }
		 */

		/*
		 * public boolean Exit() { d=new Data(); try {
		 * 
		 * Statement stmt = Connect(); System.out.println( "INSERT INTO Time VALUES (" +
		 * d.getID() + "," + d.getDate() + "," + d.getTime() + ",2)");
		 * 
		 * rs = stmt.executeQuery("SELECT * FROM Time"); while (rs.next()) if
		 * ((rs.getInt("ID") == d.getID()) && (rs.getString("Date").equals(d.getDate()))
		 * && (rs.getString("HourTime").equals(d.getTime())) &&
		 * rs.getInt("MovementType") == 2) return false;
		 * 
		 * stmt.executeUpdate( "INSERT INTO Time VALUES (" + d.getID() + "," +
		 * d.getDate() + "," + d.getTime() + ",2)");
		 * 
		 * stmt.close(); return true; } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } System.out.println("X"); return false; }
		 * 
		 * public boolean Enter() { try {
		 * 
		 * Statement stmt = Connect(); System.out.println( "INSERT INTO Time VALUES (" +
		 * d.getID() + "," + d.getDate() + "," + d.getTime() + ",1)"); rs =
		 * stmt.executeQuery("SELECT * FROM Time"); while (rs.next()) if
		 * ((rs.getInt("ID") == d.getID()) && (rs.getString("Date").equals(d.getDate()))
		 * && (rs.getString("HourTime").equals(d.getTime())) &&
		 * rs.getInt("MovementType") == 1) return false; stmt.executeUpdate(
		 * "INSERT INTO Time VALUES (" + d.getID() + "," + d.getDate() + "," +
		 * d.getTime() + ",1)");
		 * 
		 * stmt.close(); return true; } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } System.out.println("X"); return false; }
		 */
	
	public int connect() { // 1- false , 2 - no Active , 0 - true
		// TODO Auto-generated method stub
		d = new Data();
		try {
			Statement stmt = Connect();
		//	rs = stmt.executeQuery("SELECT  FROM Employee");
			//while (rs.next()) 
				//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" ");
			rs = stmt.executeQuery("SELECT ID, Password  FROM Employee");
			while (rs.next()) {
				System.out.println((rs.getInt("ID") == d.getID()) && (d.getPass().equals(rs.getString("Password"))));
				System.out.println((rs.getInt("ID") +"=="+ d.getID()) +"&&"+ (d.getPass()+" "+(rs.getString("Password"))));
				if ((rs.getInt("ID") == d.getID()) && (d.getPass().equals(rs.getString("Password")))) {
					//System.out.println(rs.getInt("IsActive"));
					/*if(rs.getInt("IsActive") == 0) {
						rs.close();
						stmt.close();
						return 2;
					//}*/

					rs.close();
					stmt.close();
					return 0;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;
	}
	

}
