package com.automationpractice.demos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import driver.Driver;

/**
 * 26,01,2021
 * ArrayList vs Set
 * @author Aziz Tokhirov
 *
 */
public class CollectionDemos extends Driver {

	public static void main(String[] args) {
		
		ArrayList<String> arrL = new ArrayList<String>();
		arrL.add("Dell");
		arrL.add("MacBook");
		
//		System.out.println(arrL.get(0));
//		
//		for(int i=0; i<arrL.size(); i++) {
//			System.out.println(arrL.get(i));
//		}
		
		for(String com : arrL) {
			System.out.println(com);
		}
		
		Set<String> set = new HashSet<String>();
		set.add("MSI");
		set.add("HP");
		
//		System.out.println(set.get);
		
		for(String se : set) {
			System.out.println(se);
		}
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		set.forEach(comp -> {
			System.out.println(comp);
		});
		
		}
	}	 

