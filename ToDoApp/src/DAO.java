import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {

	Connection conn = null;
	String formatHeader = "\n%3S %-9S %-12S %-25S";

	public DAO() {
		connect();
	}

	public void connect() {
		try {
			String url = "jdbc:sqlite:database.db";
			conn = DriverManager.getConnection(url);
			createTable();
			checkForOverdueTasks();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createTable() throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS todoitems "
				+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "description VARCHAR(50), " 
				+ "status VARCHAR(25), " 
				+ "due_date DATE DEFAULT NULL); ";
		stmt.execute(sql);
		stmt.close();
	}

	public void deleteTable() throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.execute("DROP TABLE todoitems; ");
		stmt.close();
		System.out.println("[table deleted]\n");
	}
	
	public void drop() throws SQLException {
		deleteTable();
		createTable();
	}

	public void add(String desc, LocalDate date) throws SQLException {
		String status = (date != null && date.isBefore(LocalDate.now())) ? 
						"Overdue" : "Pending";
		PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO todoitems "
				+ "(description, status, due_date) "
				+ "VALUES(?, ?, ?);");
		stmt.setString(1, desc);
		stmt.setString(2, status);
		stmt.setString(3, (date != null) ? date.toString() : null);
		close(stmt,"[added]");
	}

	public void printTableHeader() {
		System.out.format(formatHeader, "ID", "STATUS", "DUE DATE", "DESCRIPTION");
		System.out.format(formatHeader, dashes(2), dashes(8), dashes(10), dashes(25));
	}

	public void list(String status) throws SQLException {
		printTableHeader();
		Statement stmt = conn.createStatement();
		String sql = (status.equals("all")) ? 
				"select * from todoitems " 
				: "select * from todoitems where lower(status) = '" + status + "' ";
		sql += "order by status desc, due_date, id";
		ResultSet rs = stmt.executeQuery(sql);
		
		int size = 0;
		while (rs.next()) {
			size = rs.getRow();
			System.out.format(formatHeader, 
					rs.getInt("id"), 
					rs.getString("status"), 
					rs.getString("due_date"), 
					rs.getString("description"));
		}
		System.out.format("\n " + dashes(51)+ "\n%51s", size+" row(s)");
		rs.close();
		stmt.close();
	}
	
	public void delete(int id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("delete from todoitems where id = ? ");
		stmt.setInt(1, id);
		close(stmt,"[deleted]");
	}
	
	public void update(int id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(
				"update todoitems set status = 'Completed' "
				+ "where id = ?;");
		stmt.setInt(1, id);
		close(stmt,"[completed]");
	}
	
	/*
	 * check pending items that need to be updated
	 */
	public void checkForOverdueTasks() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(
				"update todoitems set status = 'Overdue' "
				+ "where due_date  < date('now') "
				+ "and status='Pending';");
		close(stmt,"");
	}
	
	/* 
	 * execute + close sql statement
	 * and print method description
	 */
	public void close(PreparedStatement stmt, String str) throws SQLException {
		stmt.executeUpdate();
		stmt.close();
		System.out.println(str);
	}
	
	private static String dashes(int length) {
		return String.format("%" + length + "c", ' ').replace(' ', '-');
	}

}