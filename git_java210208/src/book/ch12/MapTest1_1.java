package book.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest1_1 {
	void methodA() {//List
		List<String> li = new ArrayList<>();
		li.add("포도");	
		li.add("키위");	
		li.add("사과");
		for(String fru:li) System.out.println(fru);
	}
	void methodB() { //Map
		Map<String,Object> pr = new HashMap<>();
		pr.put("one","청포도");
		pr.put("two","키위");
		pr.put("three","apple");
		Object keys[] = null;
		Set set = pr.keySet();
		keys = set.toArray();
		for(int i=0;i<keys.length;i++) {
			String key = (String)keys[i];
			String val = String.valueOf(pr.get(key));
			System.out.println(key+", "+val);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
