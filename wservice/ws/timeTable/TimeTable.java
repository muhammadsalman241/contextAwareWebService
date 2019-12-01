package ws.timeTable;
import java.util.*;

public class TimeTable{
	List<Map<Integer, String>> timeTable;
	void init(){
		timeTable = new ArrayList<Map<Integer, String>>();
		timeTable.add(monday());
		timeTable.add(tuesday());
		timeTable.add(wednesday());
		timeTable.add(thursday());
		timeTable.add(friday());
	}
	
	/**
	* This is Service Method.
	*/
	public List<Map<Integer, String>> getTimeTable(){
			init();
			return timeTable;
	}
	
	Map<Integer, String> monday(){
		Map<Integer, String> day = new HashMap<>();
		day.put(8, "");
		day.put(9, "Pro. Practice");
		day.put(10, "Parvasive C.");
		day.put(11, "Parvasive C.");
		day.put(12, "");
		day.put(13, "");
		return day;
	}
	Map<Integer, String> tuesday(){
		Map<Integer, String> day = new HashMap<>();
		day.put(8, "");
		day.put(9, "Pro. Practice");
		day.put(10, "Parvasive C.");
		day.put(11, "");
		day.put(12, "");
		day.put(13, "");
		return day;
	}
	Map<Integer, String> wednesday(){
		Map<Integer, String> day = new HashMap<>();
		day.put(8, "Parvasive.C Lab");
		day.put(9, "Parvasive.C Lab");
		day.put(10, "");
		day.put(11, "Pro. Practice");
		day.put(12, "");
		day.put(13, "");
		return day;
	}
	Map<Integer, String> thursday(){
		Map<Integer, String> day = new HashMap<>();
		day.put(8, "");
		day.put(9, "");
		day.put(10, "");
		day.put(11, "");
		day.put(12, "");
		day.put(13, "");
		return day;
	}
	Map<Integer, String> friday(){
		Map<Integer, String> day = new HashMap<>();
		day.put(8, "");
		day.put(9, "");
		day.put(10, "");
		day.put(11, "");
		day.put(12, "");
		day.put(13, "");
		return day;
	}
}