package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Beans.Student;
import MD5Utils.MD5Tool;



public class JDBCUtils {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private static String url="jdbc:mysql://localhost:3306/thesis_verify?useSSL=false";
	private static String username="root";
	private static String password="happy@heart";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		String md5="1234567890";
//		String stuNum="152210708225";
//		changePassword(MD5Tool.GetMD5Code(md5),stuNum);
//		System.out.println("done!");
		
		
		
//		Student stu=queryStudent("152210708225");
//		System.out.println(stu.toString());
		
		//rs.close();
		
		//stmt.close();
		//conn.close();
	}
	/**
	 * @param e_mail 邮箱
	 * @param stuNum 学号
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 改邮箱
	 */
	private static void changeEmail(String e_mail, String stuNum)
			throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		
		String sql="update stuinfo set e_mail = ? where stuNum= ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, e_mail);
		ps.setString(2, stuNum);
		ps.executeUpdate();		
		ps.close();
		//stmt.close();
		conn.close();
	}
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 刷新密码，把所有密码抓换成MD5值
	 */
	private static void flushPassword() throws ClassNotFoundException,
			SQLException {
		Connection conn=getConnection();
		
		Student stu=null;
		Statement stmt=conn.createStatement();
		conn.setAutoCommit(false);
		String sql="select * from stuInfo";
		ResultSet rs=stmt.executeQuery(sql);
		int i=0;
		ArrayList<String> ls=new ArrayList<String>();
		while(rs.next()){
			String stuNum=rs.getString("stuNum");
			ls.add(stuNum);
		}
		rs.close();
		PreparedStatement  ps1 = conn.prepareStatement("update stuinfo set password = ? where stuNum= ? ");
		for (String string : ls) {
			String md5=MD5Tool.GetMD5Code(string);
			ps1.setString(1, md5);
			ps1.setString(2, string);
			ps1.executeUpdate();
			ps1.addBatch();
			System.out.println(string+ ":"+(++i)+" success!");
		}
		ps1.executeBatch();
		conn.commit();//事务
		ps1.close();
	}
	/**
	 * @param md5 转换成的md5值
	 * @param stuNum 学号
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void changePassword(String md5, String stuNum)
			throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		//Statement stmt=conn.createStatement();
		String sql="update stuinfo set password = ? where stuNum= ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, md5);
		ps.setString(2, stuNum);
		ps.executeUpdate();		
		ps.close();
		//stmt.close();
		conn.close();
	}

	/**
	 * @param stuNum
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Student queryStudent(String stuNum)
			throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql="select * from stuinfo where stuNum=?;";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, stuNum);
		//System.out.println(sql);
		ResultSet rs=stmt.executeQuery();
		Student stu=null;
		while(rs.next()){
			stu=new Student(rs.getString("classNo"), stuNum, rs.getString("province"), rs.getString("category"), rs.getString("type"), rs.getString("name"),rs.getString("password"), rs.getString("sex"), rs.getString("mayor"), rs.getString("academy"), rs.getString("e_mail"));
		}
		rs.close();
		stmt.close();
		conn.close();
		return stu;
	}

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = getConnection(url, username, password);
		return conn;
	}

	private static Connection getConnection(String url, String username,
			String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url, username, password);
		return conn;
	}
	

}
