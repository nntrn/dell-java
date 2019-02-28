import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {

	Connection conn = null;

	public DAO() {
		connect();
	}

	public void connect() {
		try {
			String url = "jdbc:sqlite:database.db";
			conn = DriverManager.getConnection(url);
			createTable();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				deleteTable(); // TODO delete this later maybe
			} catch (SQLException e1) {
			} // silent catch
		}
	}

	public void createTable() throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS todoitems "
				+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, description VARCHAR(50), status VARCHAR(25), due_date DATE DEFAULT NULL); ";

		stmt.execute(sql);
		stmt.close();
	}

	public void deleteTable() throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.execute("DROP TABLE todoitems; ");
		stmt.close();

		System.out.println("[table deleted]");
	}

	public void add(String desc, LocalDate date) throws SQLException {

		String status = "Pending";
		if (date != null && date.isBefore(LocalDate.now()))
			status = "Overdue";

		PreparedStatement stmt = conn
				.prepareStatement("INSERT INTO todoitems (description, status, due_date) VALUES(?, ?, ?);");

		stmt.setString(1, desc);
		stmt.setString(2, status);
		stmt.setString(3, (date != null) ? date.toString() : null);
		stmt.executeUpdate();
		stmt.close();

		System.out.println("--added");
	}

	public void list(String status) throws SQLException {
		// TODO: RETURN TODO ITEMS BY STATUS

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from todoitems where status = 'Pending'");

		while (rs.next()) {

			int id = rs.getInt("id"); // rs.getInt(1);
			String description = rs.getString("description"); // rs.getString();

			// this.database.add(description);
			System.out.println(id + " " + description);
		}
		rs.close();
		stmt.close();

	}

	public void update(int id) throws SQLException {
		// TODO: include overdue

		PreparedStatement stmt = conn.prepareStatement("update todoitems set status = 'Completed' where id = ?;");

		stmt.setInt(1, id);
		stmt.executeUpdate();
		stmt.close();
		System.out.println("--updated");
	}

	public void delete(int id) throws SQLException {

		PreparedStatement stmt = conn.prepareStatement("delete from todoitems where id = ? ");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		stmt.close();

		System.out.println("--deleted");
	}

	public int i(String s) {
		return Integer.parseInt(s);
	}

}