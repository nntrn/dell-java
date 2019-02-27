import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;


// TODO DELETE THIS LATER?
public interface ToDoDAO {

	Integer id = 0;
	String description = "";
	String status = "Pending";
	LocalDate dueDate = null;
	
	default Integer getId() {
		return id;
	}

	default String getDesc() {
		return description;
	}

	default String getStatus() {
		return status;
	}

	default LocalDate getDueDate() {
		return dueDate;
	}
	
	default String getDueDateStr() {
		return getDueDate().toString();
	}
	
	void setCompleteTask();
	public void setOverdueTask();
	public void setPendingTask();
	
	void delete(Connection conn, Scanner sc) throws SQLException;
	void add(Connection conn, Scanner sc) throws SQLException;
	
}