import java.util.List;
import java.util.ArrayList;

public class InMemoryTimesheet {

		
		private List<TimesheetEntry> database;
		private List<TimesheetEntry> activeEntries = new ArrayList<>();
		private List<TimesheetEntry> projectEntries = new ArrayList<>();
		

		public InMemoryTimesheet() {
			this.database = new ArrayList<>();
		}
		
		public void add(String project, String task) {
			
			if(project.indexOf(" ")>-1)
				System.out.println("--note: spaces are not allowed and will be removed");
			
			TimesheetEntry newEntry = new TimesheetEntry(project.replace(" ", ""), task);
			database.add(newEntry);
			
		}
		public void delete(int id) {
		
			TimesheetEntry removeThis = findId(id);
			
			if(removeThis != null) {
				database.remove(removeThis);
				System.out.println("--removed entry " + removeThis.getId());
			}
		}
		public void stop(int id) {
			
			TimesheetEntry updateThis = findId(id);

			if(updateThis != null) {
				updateThis.updateEndTime();
				database.set(getIndex(id), updateThis);
			}
		}
		
		
		public List<TimesheetEntry> list(boolean activeOnly, String name) {

			projectEntries = new ArrayList<>();
			
			for(TimesheetEntry entry:database) {
				if(entry.getProjectName().indexOf(name) > -1) {
					projectEntries.add(entry);
				}
			}
			
			if(name.equals("-a") || name.isEmpty())
				projectEntries = database;

			if(activeOnly) {
				
				activeEntries = new ArrayList<>();
			
				for(TimesheetEntry entry:projectEntries) {
					if(entry.getEndTime() == null)
						activeEntries.add(entry);
				}
					
				return this.activeEntries;
			}
			else {
				return this.projectEntries;
			}
		
		}
		
		public TimesheetEntry findId(int id) {
			
			for(TimesheetEntry entry:database) {
				if(entry.getId()==id) {
					return entry;
				}
			}
			System.out.println("--error: no entry with id "+ id);
			return null;
		}

		public int getIndex(int id) {
			int counter = 0;
			for(TimesheetEntry entry:database) {
				
				if(entry.getId()==id) {
					return counter;
				}
				counter++;
			}
			
			return -1;
		}
		

}

