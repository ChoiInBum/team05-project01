package db_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db_common.DBConnect;
import db_dto.NewStDTO;

public class NewStDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public NewStDAO() {
		con = DBConnect.getConnect();
	}
	
	public boolean login(String id) {
		String sql = "select * from students where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
			return false;
			
		} catch(SQLException e) {
			System.out.println("login sql문 오류");
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return false;
	}
	
	public NewStDTO search(String id) {
		NewStDTO dto = null;
		String sql ="select id, name, kor, eng, math, (kor+eng+math) as sum, round((kor+eng+math)/3, 2) as avg from students where id='"+id+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) { 
				dto = new NewStDTO(rs.getString("id"),
						rs.getString("name"),
						rs.getInt("kor"),
						rs.getInt("eng"),
						rs.getInt("math"),
						rs.getInt("sum"),
						rs.getDouble("avg")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public ArrayList<NewStDTO> getList(){
		ArrayList<NewStDTO> list = new ArrayList<>();
		String sql = "select id, name, kor, eng, math, (kor+eng+math) as sum, round((kor+eng+math)/3, 2) as avg from students";
		try {
			ps = con.prepareStatement( sql );
			rs = ps.executeQuery();
			while(rs.next()) {
				NewStDTO dto = new NewStDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setSum(rs.getInt("sum"));
				dto.setAvg(rs.getDouble("avg"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int insert(NewStDTO dto) {
		String sql = "insert into students values(?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getKor());
			ps.setInt(4, dto.getEng());
			ps.setInt(5, dto.getMath());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int modify(NewStDTO d1) {
		String sql = "update students set kor=?, eng=?, math=? where id=?";
		int result = 0;
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, d1.getKor());
			ps.setInt(2, d1.getEng());
			ps.setInt(3, d1.getMath());
			ps.setString(4, d1.getId());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int delete(String id) {
		int result = 0;
		String sql ="delete from students where id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
