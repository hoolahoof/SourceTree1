package customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import customer.db.DBCon;
import customer.vo.Member;

public class MemberDao {

	public Member getMember(String id) throws Exception {
		
		String sql = "select id,pw,name,gender,birth,is_lunar,tel,email,hobby,regdate from member where id=?";
		Connection con = DBCon.getConnection();
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		
		Member m=new Member();
		if(rs.next()) {
			m.setId(rs.getString("id"));
			m.setPw(rs.getString("pw"));
			System.out.println("id "+m.getId());
		}
		return m;
	}
}
