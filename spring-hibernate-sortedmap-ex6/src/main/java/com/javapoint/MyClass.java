package com.javapoint;

import java.util.Comparator;

public class MyClass implements Comparator <String>{

	@Override
	public int compare(String o1, String o2) {

		final int beforeInt = -1;
		final int afterInt = 1;
		final  boolean beforeBoolean = false;
		final  boolean afterBoolean = true;
		
		if (o1 == null) {
			return afterInt;
		}
		else if (o2 == null){
			return beforeInt;
		}
		else  if (o1.compareToIgnoreCase(o2) < 0) {
			return afterInt;
		}
		else  if (o1.compareToIgnoreCase(o2) > 0) {
			return beforeInt;
		}
		else  if (o1.compareToIgnoreCase(o2) == 0) {
			return afterInt;
		}
		
		//should not return here;
		return beforeInt;
	}
}
