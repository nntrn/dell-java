import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileBackTimesheet{

	private String fileName;
	private String updateTime; 
	private DateTimeFormatter timeFormatter;
	private DateTimeFormatter fileTimeFormatter;
	private List<String> activeEntries = new ArrayList<>();
	private List<String> projectEntries = new ArrayList<>();
	private List<ArrayList> db = new ArrayList<>();
	
	
	public FileBackTimesheet() {
		fileName = "timesheet.txt";
		timeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm");
		fileTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm");
		this.updateTime = LocalDateTime.now().format(fileTimeFormatter);
		
	}

	public String serialize(TimesheetEntry entry, String command) {
		
		StringBuffer buffer = new StringBuffer();
		
		String endTime = entry.getEndTime()==null? " ," : entry.getEndTime().format(timeFormatter);
		
		buffer.append(updateTime);
		buffer.append(" ");
		buffer.append(command);
		buffer.append("#\t");
		
		// add file details here
		
		/* very important that theres a space after the comma for splitting string
		 * into array later on 
		 * ex: 	"annie,spagon,,".split(",") is length = 2
		 * 		"annie, spagon, ,".split(",") is length = 3
		 */
		buffer.append(entry.getId());
		buffer.append(",");
		buffer.append(entry.getProjectName());
		buffer.append(",");
		buffer.append(entry.getStartTime().format(timeFormatter));
		buffer.append(",");
		buffer.append(endTime);
		//buffer.append(entry.getEndTime().format(timeFormatter));
		buffer.append("\n");
		
		return buffer.toString();
	}
	
	
	public void add(String project, String task) {
		TimesheetEntry newEntry = new TimesheetEntry(project, task);
		File file = new File(fileName);
				
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true) );
			String entryAsString = serialize(newEntry, "add");			
			writer.write(entryAsString);
			writer.close();
			
		}
		catch (Exception e){
			//silent catch
		}

	}
	
	public List<String> list()  {
		

		try {
			File file = new File(fileName);
			BufferedReader readTimesheet = new BufferedReader(new FileReader(file));
			
			
			String st;
			
			while ((st = readTimesheet.readLine()) != null) {
				String[] sysArr = st.split("#\t");
				String[] fileArr = sysArr[1].split(",");
				
				projectEntries = new ArrayList<>();
				for(String entry:fileArr) {
					projectEntries.add(entry);
				}
				System.out.println(projectEntries);
	
			}
			readTimesheet.close();
			
			return projectEntries;
			
		} catch (Exception e) {
		} // silent catch
		return null;
	}
	

	public void delete(int id) {

	}

	public void stop(int id) {
		// this is update
		
		

	}




}
