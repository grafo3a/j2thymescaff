package net.apasajb.j2thymescaff;

import jakarta.persistence.Entity;
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
}
