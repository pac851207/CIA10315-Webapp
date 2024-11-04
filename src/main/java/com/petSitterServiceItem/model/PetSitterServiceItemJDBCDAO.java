package com.petSitterServiceItem.model;

import java.util.*;
import java.sql.*;


public class PetSitterServiceItemJDBCDAO implements PetSitterServiceItemDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cia103g3?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "702158";

	private static final String INSERT_STMT = 
		"INSERT INTO PetSitterServiceItem ( svcDescr, svcName) VALUES ( ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT * FROM PetSitterServiceItem order by svcId";
	private static final String GET_ONE_STMT = 
		"SELECT svcId, svcDescr, svcName FROM PetSitterServiceItem where svcId = ?";
	private static final String DELETE = 
		"DELETE FROM PetSitterServiceItem where svcId = ?";
	private static final String UPDATE = 
		"UPDATE PetSitterServiceItem set svcDescr=?, svcName=? where svcId = ?";

	@Override
	public void insert(PetSitterServiceItemVO petSitterServiceItemVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, petSitterServiceItemVO.getSvcDescr());
			pstmt.setString(2, petSitterServiceItemVO.getSvcName() );
			

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(PetSitterServiceItemVO petSitterServiceItemVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, petSitterServiceItemVO.getSvcDescr());
			pstmt.setString(2, petSitterServiceItemVO.getSvcName());
			pstmt.setInt(3, petSitterServiceItemVO.getSvcId());
			

			pstmt.executeUpdate();
			System.out.println("123");
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer svcId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, svcId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public PetSitterServiceItemVO findByPrimaryKey(Integer svcId) {

		PetSitterServiceItemVO petSitterServiceItemVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, svcId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// PetSitterServiceItemVO 也稱為 Domain objects
				petSitterServiceItemVO = new PetSitterServiceItemVO();
				petSitterServiceItemVO.setSvcId(rs.getInt("svcId"));
				petSitterServiceItemVO.setSvcDescr(rs.getString("svcDescr"));
				petSitterServiceItemVO.setSvcName(rs.getString("svcName"));
				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return petSitterServiceItemVO;
	}

	@Override
	public List<PetSitterServiceItemVO> getAll() {
		List<PetSitterServiceItemVO> list = new ArrayList<PetSitterServiceItemVO>();
		PetSitterServiceItemVO petSitterServiceItemVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// PetSitterServiceItemVO 也稱為 Domain objects
				petSitterServiceItemVO = new PetSitterServiceItemVO();
				petSitterServiceItemVO.setSvcId(rs.getInt("svcId"));
				petSitterServiceItemVO.setSvcDescr(rs.getString("svcDescr"));
				petSitterServiceItemVO.setSvcName(rs.getString("svcName"));
				
				list.add(petSitterServiceItemVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		PetSitterServiceItemJDBCDAO dao = new PetSitterServiceItemJDBCDAO();

		// 新增
		PetSitterServiceItemVO PetSitterServiceItemVO1 = new PetSitterServiceItemVO();
//		PetSitterServiceItemVO1.setEname("吳永志1");
		PetSitterServiceItemVO1.setSvcDescr("完美的後空翻");
		PetSitterServiceItemVO1.setSvcName("後空翻訓練");
//		PetSitterServiceItemVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		PetSitterServiceItemVO1.setSal(new Double(50000));
//		PetSitterServiceItemVO1.setComm(new Double(500));
		dao.insert(PetSitterServiceItemVO1);

		// 修改
		PetSitterServiceItemVO PetSitterServiceItemVO2 = new PetSitterServiceItemVO();
		PetSitterServiceItemVO2.setSvcId(1);
		PetSitterServiceItemVO2.setSvcDescr("敘述");
		PetSitterServiceItemVO2.setSvcName("服務名");
//		PetSitterServiceItemVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		PetSitterServiceItemVO2.setSal(new Double(20000));
//		PetSitterServiceItemVO2.setComm(new Double(200));
//		PetSitterServiceItemVO2.setDeptno(20);
		dao.update(PetSitterServiceItemVO2);

		// 刪除
		dao.delete(11);

		// 查詢
		PetSitterServiceItemVO PetSitterServiceItemVO3 = dao.findByPrimaryKey(7001);
		System.out.print(PetSitterServiceItemVO3.getSvcId() + ",");
		System.out.print(PetSitterServiceItemVO3.getSvcDescr() + ",");
		System.out.print(PetSitterServiceItemVO3.getSvcName() + ",");
//		System.out.print(PetSitterServiceItemVO3.getHiredate() + ",");
//		System.out.print(PetSitterServiceItemVO3.getSal() + ",");
//		System.out.print(PetSitterServiceItemVO3.getComm() + ",");
//		System.out.println(PetSitterServiceItemVO3.getDeptno());
		System.out.println("---------------------");

		// 查詢
		List<PetSitterServiceItemVO> list = dao.getAll();
		for (PetSitterServiceItemVO aEmp : list) {
			System.out.print(aEmp.getSvcId() + ",");
			System.out.print(aEmp.getSvcDescr() + ",");
			System.out.print(aEmp.getSvcName() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			System.out.print(aEmp.getDeptno());
			System.out.println();
		}
		test();
	}
	
	
	public static void test() {
		PetSitterServiceItemJDBCDAO petSitterServiceItemJDBCDAO = new PetSitterServiceItemJDBCDAO();
        List<PetSitterServiceItemVO> sEs =  petSitterServiceItemJDBCDAO.getAll();
        for(PetSitterServiceItemVO petSitterServiceItemVO : sEs) {
            System.out.println(petSitterServiceItemVO.toString());
        }
    }
	
}