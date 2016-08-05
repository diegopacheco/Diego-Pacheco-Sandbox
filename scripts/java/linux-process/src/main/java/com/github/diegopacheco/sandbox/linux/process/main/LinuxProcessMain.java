package com.github.diegopacheco.sandbox.linux.process.main;

import java.io.File;
import java.util.List;

import com.google.common.collect.Lists;

public class LinuxProcessMain {
	public static void main(String[] args) throws Exception {
		
		List<String> command = Lists.newArrayList();
		command.add("sudo lsof -p `ps -ef | grep redis | awk '{print $2}' ORS=' ' | awk '{print $1}'` | wc -l");
		
		ProcessBuilder process = new ProcessBuilder(command);
		process.directory(new File("/"));
		process.redirectErrorStream(true);
	    
		Process stopper = process.start();
		int code = stopper.exitValue();
        if (code == 0) {
        	System.out.println(stopper.getOutputStream());
        }else {
        	System.out.println("Error: " + code);
        }
	}
}
