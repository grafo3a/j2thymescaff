package net.apasajb.j2thymescaff;

import java.lang.reflect.Field;

import org.tinylog.Logger;


public class J2thymescaffLauncher {
	
	public static void main(String[] args) {
		Logger.info("Debut du demarrage de l'outil J2thymescaff.");
		
		getListeAttributs();
	}
	
	
	// This private constructor prevents instantiation
	private J2thymescaffLauncher() {
		throw new IllegalStateException("Error. This utility class cannot be instantiated.");
	}
	
	public static void getListeAttributs() {
		//String userDir = System.getProperty("user.dir");
		//System.out.println("\n ==== pwd: " + userDir + "/");
		
		Class<?> entityClass = Compte.class;
		Field[] fields = entityClass.getDeclaredFields();
		String attribut = "";
		
		Logger.info("");
		
		for (Field field : fields) {
			// Optional: Skip fields annotated with @Transient
			if (field.isAnnotationPresent(jakarta.persistence.Transient.class)) {
				continue;
			}
			
			attribut = "*Field name: " + field.getName() + " | Type: " + field.getType().getSimpleName();
			Logger.info(attribut);
		}
	}
}
