package com.azure.webapp;

import java.util.HashMap;
import java.util.Map;

public class challenge3 {
	
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Map<String, Object> u = new HashMap<>();

		Map<String, Object> a = new HashMap<>();
		Map<String, Object> b = new HashMap<>();
		b.put("c", "d");
		a.put("b", b);
		u.put("a", a);
		
		System.out.println(u);

		//Map<String, Object> object2 = Map.of("x", Map.of("y", Map.of("z", "a")));

		String key1 = "a/b/c";
		
		
		
		
		 String[] keys = key1.split("/");
	        Object value = u;
	        for (String k : keys) {
	            value = ((Map<String, Object>) value).get(k);
	        }		
	        
	        System.out.println(value);
	
	}

	
	
}
