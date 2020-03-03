package com.sdstc.pub.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtils extends org.apache.commons.lang3.StringUtils{
    public static List<String> parseString2ArrayList(String str,String regex){
    	if(str!=null) {
    		List<String> list = new ArrayList<String>(Arrays.asList(str.split(regex)));
    		return list;
    	}else {
    		return null;
    	}
    }
    
    public static Set<String> parseString2HashSet(String str,String regex){
    	if(str!=null) {
    		Set<String> set = new HashSet<String>(Arrays.asList(str.split(regex)));
    		return set;
    	}else {
    		return null;
    	}
    }
}
