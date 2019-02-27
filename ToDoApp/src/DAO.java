import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO extends Controller {

	int NEXTID = 1; // FIXME
	static Scanner sc = new Scanner(System.in);

	Controller database = new Controller();

	public void connect() {

		Connection conn = null;
		try {
			String url = "jdbc:sqlite:database.db";
			conn = DriverManager.getConnection(url);

			createTable(conn);
			add(conn);
			list(conn);
			delete(conn);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

	public static void createTable(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS todoitems "
				+ "(id INT, description VARCHAR(50), status VARCHAR(25), due_date DATE DEFAULT NULL); ";

		stmt.execute(sql);
		stmt.close();
	}

	public void deleteTable(Connection conn) throws SQLException {
		System.out.println("Deleting the table ");

		Statement stmt = conn.createStatement();
		stmt.execute("DROP TABLE todoitems; ");
		stmt.close();
	}

	public void add(Connection conn) throws SQLException {

		String description = promptString("add a new todo item");
		PreparedStatement stmt = conn.prepareStatement("insert into todoitems values (?,?,?,?);");

		stmt.setInt(1, NEXTID++);
		stmt.setString(2, description);
		stmt.setString(3, "Pending");
		stmt.setString(4, null);
		stmt.executeUpdate();
		stmt.close();

	}

	public void list(Connection conn) throws SQLException {

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from todoitems where status = 'Pending'");

		while (rs.next()) {

			int id = rs.getInt("id"); // rs.getInt(1);
			String description = rs.getString("description"); // rs.getString();

			this.database.add(description);
			System.out.println(id + " " + description);
		}
		rs.close();
		stmt.close();

	}

	public void update(Connection conn) throws SQLException {
		// TODO: include overdue

		int id = database.promptInt("Enter the id to delete: ");
		String nameInput = "Completed";

		PreparedStatement stmt = conn.prepareStatement("update todoitems set status = ? where id = ?;");
		stmt.setString(1, nameInput);
		stmt.setInt(2, id);
		stmt.executeUpdate();
		stmt.close();

	}

	public void delete(Connection conn) throws SQLException {

		int id = database.promptInt("Enter the id to delete: ");
		PreparedStatement stmt = conn.prepareStatement("delete from todoitems where id = ? ");

		stmt.setInt(1, id);
		stmt.executeUpdate();
		stmt.close();

	}

}