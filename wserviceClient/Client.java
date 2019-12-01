package ws.timetable;
import org.apache.axis2.*;
import ws.timetable.*;
import java.util.*;
import java.time.*;

public class Client{
	enum Locations{
		inClass,
		other
	};
	enum Entity{
		teacher,
		student
	};
	
	public static void main(String[] args) throws Exception {
		
		System.out.print(String.format("\n%50s\n", "We have No access to GPS, Please provide location us yourself!"));
		//get Conntext (entity & location)
		Entity ent = getEntity();
		Locations loc = getLocation();
		
		//get and parse data from soap server (activity)
		TimeTableServiceStub.Map1[] list = getTimeTableFromServer();
		List<List> days = axis2TypeToJavaList(list);
		
		//get time
		Date dateInput = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dateInput);
		int hour = dateInput.toInstant().atZone(ZoneId.systemDefault()).getHour();
		int day = c.get(Calendar.DAY_OF_WEEK);
		
		//do service
		Client.printTable(days);
		
		//trigger sensor
		sensor(ent, loc, days, day, hour);
	}
	
	static void printTable(List<List> week){
		String daysName[] = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		
		System.out.print(String.format("\n\n%50s\n","Context-Aware Time Table"));
		
		System.out.print(String.format("\n%-15s","Day"));
		for(int i = 0; i < week.get(0).size(); i++){
			List<TimeTableServiceStub.Entry1> a = (List<TimeTableServiceStub.Entry1>) week.get(0);
			int x = a.get(i).getKey();
			System.out.print(String.format("|%15s",( x + ((x < 12)? " AM":" PM")) ));
		}
		
		
		for(int i = 0; i < week.size(); i++){
			System.out.print(String.format("\n%-15s", daysName[i]));
			List day = week.get(i);
			for(int j = 0; j < day.size(); j++){
				TimeTableServiceStub.Entry1 aClass = (TimeTableServiceStub.Entry1) day.get(j);
				System.out.print(String.format("|%-15s", aClass.getValue()));
			}
		}
		System.out.println();
	}
	
	static Locations getLocation(){
		System.out.print("Enter Your Location\n" + 
					"Press 1, if you are in class, " + 
					"Press 2, if you are elsewhere : " );
		int choice = (new Scanner(System.in).nextInt());
		switch(choice){
			case 1: return Locations.inClass;
			case 2: return Locations.other;
		}
		return null;
	}
	
	static Entity getEntity(){
		System.out.print("Who you Are?\n" + 
					"Press 1, if you are Student, " + 
					"Press 2, if you are Teacher :" );
		int choice = (new Scanner(System.in).nextInt());
		switch(choice){
			case 1: return Entity.student;
			case 2: return Entity.teacher;
		}
		return null;
	}
	
	static TimeTableServiceStub.Map1[] getTimeTableFromServer() throws Exception {
		TimeTableServiceStub stub = new TimeTableServiceStub();

		TimeTableServiceStub.GetTimeTable request = new TimeTableServiceStub.GetTimeTable();

		TimeTableServiceStub.GetTimeTableResponse response = stub.getTimeTable(request);
		
		return response.get_return();
	}
	
	static List<List> axis2TypeToJavaList(TimeTableServiceStub.Map1[] list){
		List days = new ArrayList<List>();
		for(int i = 0; i < list.length; i++)
			days.add(org.apache.axis2.databinding.utils.ConverterUtil.toList(list[i].getEntry()));
		return days;
	}
	
	static void sensor(Entity e, Locations l, List<List> activity, int day, int time){
		List<TimeTableServiceStub.Entry1> Classess;
		String className = "";
		if(day >= Calendar.MONDAY && day <= Calendar.FRIDAY){
			day--;
			Classess = (List<TimeTableServiceStub.Entry1>) activity.get(day-1);
			//check is there is a class at this time
			for(int i = 0; i < Classess.size(); i++){
				int classTime = Classess.get(i).getKey();
				if(classTime == time){
					className = Classess.get(i).getValue();
					break;
				}
			}
		}
		switch(e){
			case teacher:{
				switch(l){
					case inClass:{
						if(className.equals("") != true)
							System.out.println("\nNOTIFICATION: Sir! you are in class! and this is time of " + 
											className + " class, please foucs!");
						else
							System.out.println("\nNOTIFICATION: Dear Teacher what are you doing in class there is no lecture, chill out!.");
					}
					break;
					case other:{
						if(className.equals("") != true)
							System.out.println("\nNOTIFICATION: Sir! Please proceed to Class now" + 
											" this is time of " + className + " class.");
					}
					break;
				}
			}
			break;
			case student:{
				switch(l){
					case inClass:{
						if(className.equals("") != true)
							System.out.println("\nNOTIFICATION: you should focus on " + 
											className + " class which you are sitting.");
						else
							System.out.println("\nNOTIFICATION: Hey what are you doing in class there is no lecture, chill out!.");
					}
					break;
					case other:{
						if(className.equals("") != true)
							System.out.println("\nNOTIFICATION: Hey! you should be in Class now" + 
											" this is time of " + className + " class.");
					}
					break;
				}				
			}
			break;
		}
	}
}  
