package main.java;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // == 1. DB 접속 정보 == //
        // jdbc:mysql://localhost:3306/jdbc_db
        // JDBC 프로토콜 : 사용하는 DBMS://서버주소:포트번호(MySQL 기본 3306)/DB 이름
        final String URL = "jdbc:mysql://localhost:3306/jdbc_db";
        String user = "root";
        String password = "root"; //? 본인의 비밀번호로 변경

        Connection conn = null; // DB 연결 객체
        Statement stmt = null; // DB 실행 객체
        PreparedStatement pstmt = null; // 동적 DB 실행 객체
        ResultSet rs = null; // DB 결과 객체

        try {
            // 1. 드라이버 로딩
            // : JDBC 드라이버 클래스를 메모리에 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. DB 연결
            // : 실제로 MySQL DB 접속 시도 (성공 시 Connection 객체를 반환)
            conn = DriverManager.getConnection(URL, user, password);
            System.out.println("DB 연결 성공");

            // === DB 전체 데이터 조회(READ) === //
//            String sql = "SELECT * FROM member";
//            stmt = conn.createStatement(); // Statement 사용
//            rs = stmt.executeQuery(sql); // SELECT 실행
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                System.out.println(id + " | " + name + " | " + email);
//            }

            // === DB 데이터 삽입(Create) === //
//            String sql = "INSERT INTO member (name, email) VALUES (?, ?)";
//            pstmt = conn.prepareStatement(sql); // PreparedStatement 사용
//
//            pstmt.setString(1, "문현준");
//            pstmt.setString(2, "oner123"); // alt + shift + 방향키 (한 줄 복사, 윈도우)
//
//            int result = pstmt.executeUpdate(); // INSERT 실행
//            System.out.println(result + "명 회원 추가됨");

            // === DB 데이터 수정(Update) === //
//            String sql = "UPDATE member SET email = ? WHERE id = ?";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, "keria.t1");
//            pstmt.setInt(2, 1);
//
//            int updated = pstmt.executeUpdate();
//            System.out.println(updated + "명 수정됨");

            // === DB 데이터 삭제(Delete) === //
            String sql = "DELETE FROM member WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1); // parameterIndex: 1부터 시작
            int deleted = pstmt.executeUpdate();
            System.out.println(deleted + "명 삭제됨");

        } catch (Exception e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
        }
        // 자바 7버전 이상 부터는 자동 자원 해제로 생략 가능
//        finally {
//            // 3. 연결 종료
//            // conn.close();
//            try {
//                if (conn != null && stmt != null && rs != null) {
//                    // DB Connection이 존재한다면 - 자원 누수를 막기 위해 자원 해제를 호출
//                    conn.close();
//                    stmt.close();
//                    rs.close();
//                    System.out.println("DB 연결 종료");
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
}