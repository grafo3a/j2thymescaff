package net.apasajb.j2thymescaff;

import jakarta.persistence.Entity;

import java.lang.reflect.Field;

import org.tinylog.Logger;


public class Scaffolding {
	
	public Boolean isValidJpaEntity(Entity myClass) {
		
		boolean isClassValidEntity = false;
		String myClassName = myClass.name();
		
		Logger.info("\nDebut verif si la classe " + myClassName + " est une entit/e valide.");
		isClassValidEntity = myClass.getClass().isAnnotationPresent(jakarta.persistence.Entity.class);
		
		Logger.info("Fin verif de la classe " + myClassName + ".");
		
		return isClassValidEntity;
	}
	
	
	public void getListeAttributs() {
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
