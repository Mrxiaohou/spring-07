package J1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class J1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʽ jdbc��MySQL��//����IP���˿ں�/���ݿ���;
		String url="jdbc:mysql://192.168.119.222:3306/db1";
		String user="root";
		String password="123456";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		;
		
		try {
			//ѡ��Ҫ���������ݿ�����--�������������䣩
			Class.forName("com.mysql.jdbc.Driver");
			//�������� ����IP �˿ں� �û��� ����//ѡ��Ҫ���������ݿ�
			con = DriverManager.getConnection(url, user, password);
			
			//��������ڣ�дsql��䣩
			 pstmt = con.prepareStatement("select * from student");
			//����sql��䲢�鿴���  �������ɾ���򷵻���Ӱ������� ����ǲ�ѯ���ص��ǲ�ѯ���
			//�������ɾ�� �����executeUpdate ����int����Ӱ��������������ѯ �����executeQuery
			//����Resultset��������ϣ�
			 rs=pstmt.executeQuery();
			//�鿴�����
			 while(rs.next()) {
				 System.out.println(rs.getInt("id")+" "+rs.getString("name"));
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
				rs.close();
				if(pstmt!=null)
				pstmt.close();
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
