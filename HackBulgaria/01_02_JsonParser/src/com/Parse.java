package com;

import com.listify.Listify;

public class Parse {
	
	public static String jsonStringify(String[] fileLines) {
		
		String res="";
		boolean first = true;
		boolean second = true;
		
		for (int i=0;i<fileLines.length;i++) {
			
			if ((fileLines[i].trim().indexOf('[')==0)) {
				if (first) {
					first=false;
					res+="{\n";
				}else {
					res+="\n";
					res+="  },\n";
				}
				
				second = true;
				String[] mains=fileLines[i].split("\\[|\\]");
				
				res+="  \""+mains[1]+"\": {\n";
			}
			
			if ((fileLines[i].trim()=="")||(fileLines[i].trim().indexOf(';')==0)) {
				continue;
			}
			
			if (fileLines[i].trim().indexOf('=')>-1) {
				String[] seconds=fileLines[i].split("=");
				if (second) {
					second=false;
					res+="    \""+seconds[0].trim()+"\": \""+seconds[1].trim()+"\"";
				}else {
					res+=",\n";
					res+="    \""+seconds[0].trim()+"\": \""+seconds[1].trim()+"\"";
				}
				
			}
		}
		if (!first) {
			res+="\n";
			res+="  }\n";
			res+="}\n";
		}
		return res;
	}

	public static void main(String[] args) {
		String path= Parse.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"iniFile.ini";
		String[] fileLines = Listify.readToArray(path.substring(1));
		System.out.println(jsonStringify(fileLines));
	}
}
