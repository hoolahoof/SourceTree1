package customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import customer.db.DBCon;
import customer.vo.Notice;

public class NoticeDao {
	
	public void write(Notice n) throws Exception {
		//insert 작업 
		String sql = "insert into notices values((select max(to_number(seq))+1 from notices),?,?,?,sysdate,0,?)";
		// seq가 1씩 증가해야해서 서브쿼리문으로 max값에서 +1된 값이 들어가도록한다.
		// DB연결 
		Connection con = DBCon.getConnection();
		// 실행 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, n.getTitle());
		pstmt.setString(2, n.getWriter());
		pstmt.setString(3, n.getContent());
		pstmt.setString(4, n.getFilesrc());
		pstmt.executeUpdate(); 
		
		pstmt.close();
		con.close(); 
	}
	
	public void update(Notice notice) throws Exception {
		String sql = "update notices set title=?,content=? where seq=?";
		// "update notices "+"set title=?,content=? where seq=?"; 이렇게도 가능 
		// DB연결 
		Connection con = DBCon.getConnection();
		// 실행 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, notice.getTitle());
		pstmt.setString(2, notice.getContent());
		pstmt.setString(3, notice.getSeq());
		pstmt.executeUpdate(); 
	}
	
	public void update2(String seq, String tit, String content) throws Exception {
		String sql = "update notices set title=?,content=? where seq=?";
		// "update notices "+"set title=?,content=? where seq=?"; 이렇게도 가능 
		// DB연결 
		Connection con = DBCon.getConnection();
		// 실행 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, tit);
		pstmt.setString(2, content);
		pstmt.setString(3, seq);
		pstmt.executeUpdate();  
	}
	
	public int delete(String seq) throws Exception {
		String sql = "delete from notices where seq="+seq;

		//DB연결
		Connection con = DBCon.getConnection();
		//실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		int del = pstmt.executeUpdate();
		
		return del;
	}
	
	public Notice getNotice(String seq, String hit) throws Exception {
		
		String sql = "select seq,title,writer,content,regdate,hit,filesrc from notices where seq="+seq;
//		update notices set hit=hit+1 where seq='1'
		int hnum = Integer.parseInt(hit);
		hitupdate(seq,hnum);
		
		// DB연결 
		Connection con = DBCon.getConnection();
		// 실행 
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		
		Notice n = new Notice();
		n.setSeq(rs.getString("seq"));
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));
		n.setFilesrc(rs.getString("filesrc"));
		
		rs.close();
		stmt.close();
		con.close();
		
		return n;
	}

	private void hitupdate(String seq, int hnum) throws Exception {
		System.out.println("hit up");
		
		/* DB연결 */
		Connection con = DBCon.getConnection();
		
		String sql = "update notices set hit=? where seq=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, hnum+1);
		pstmt.setString(2, seq);
		pstmt.executeUpdate();
	}

	public List<Notice> noticeSelAll(String field, String query) throws Exception {
		
		String sql = "select seq,title,writer,content,regdate,hit,filesrc from notices where "+field+" like ? order by to_number(seq) desc";
		
		/* DB연결 */
		Connection con = DBCon.getConnection();
		/* 실행 */
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%"+query+"%");
		ResultSet rs = pstmt.executeQuery();
		List<Notice> list = new ArrayList<Notice>();
		while(rs.next()) {
			Notice n = new Notice();
			n.setSeq(rs.getString("seq"));
			n.setTitle(rs.getString("title"));
			n.setWriter(rs.getString("writer"));
			n.setContent(rs.getString("content"));
			n.setRegdate(rs.getDate("regdate"));
			n.setHit(rs.getInt("hit"));
			n.setFilesrc(rs.getString("filesrc"));
			list.add(n);
		}
		return list;
	}
}
