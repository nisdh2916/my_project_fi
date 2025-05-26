/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mokpo.myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAO 클래스는  
 * 
 * 
 * 
 * @author 신동하
 * @since  1.2
 */



public class MemberDAO {
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    /**
     * 
     * DB에 연결하는 역할을 합니다. 
     * ip : 1ocalhost 
     */
    public void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/mokpo";
            String user = "mokpo";
            String pwd = "mokpo1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    /**
     * MemberDTO는 ~~~~~
     * @param dto DB에 저장할 자료를 DTO형태로 가져옵니다. DTO는 id, passwd, name으로 구성되어 있음.
     * @return 아무것도 돌려주지 않음.
     */
    
    public boolean insert(MemberDTO dto) {
        connect();
        String sql = "INSERT INTO member (id, password, name) VALUES (?, ?, ?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPassword());
            pstmt.setString(3, dto.getName());
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            close();
        }
    }

    public MemberDTO search(String id, String pwd) {
        connect();
        String sql = "SELECT * FROM member WHERE id=? AND password=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new MemberDTO(rs.getString("id"), rs.getString("password"), rs.getString("name"));
            }
        } catch (SQLException e) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }
        return null;
    }

    private void close() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
