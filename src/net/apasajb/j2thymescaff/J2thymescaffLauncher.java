package net.apasajb.j2thymescaff;

import org.tinylog.Logger;


public class J2thymescaffLauncher {
	
	public static void main(String[] args) {
		Logger.info("Debut du demarrage de l'outil J2thymescaff.");
	}
	
	
	// This private constructor prevents instantiation
	private J2thymescaffLauncher() {
		throw new IllegalStateException("Error. This utility class cannot be instantiated.");
	}
}
