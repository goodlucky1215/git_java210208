package book.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Exam_map {
	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		li.add("포도");	
		li.add("키위");	
		li.add("사과");	
		Map<String,List<String>> pr = new HashMap<>();
		pr.put("one",li);
		pr.put("two",li);

		System.out.println(pr.get("one"));
		for(String fru:li) System.out.println(fru);
		System.out.println("---------------------------");
		Object keys[] = null;
		keys=pr.keySet().toArray();
		for(Object keyy:keys) {
			System.out.println((String)keyy);
		}
		for(int i=0;i<keys.length;i++) {
			String keyy = (String) keys[i];
			System.out.println(keyy);
		}
		System.out.println("---------------------------");
		Object values[] = null;
		values = pr.values().toArray();
		String a= values[0].toString();
		System.out.println(a);
	}
}
