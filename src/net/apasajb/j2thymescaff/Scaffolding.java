package net.apasajb.j2thymescaff;

import jakarta.persistence.Entity;


public class Scaffolding {
	
	public Boolean isValidJpaEntity(Entity myClass) {
		
		boolean isClassValidEntity = false;
		
		//isEntity = myClass.getClass().isAnnotationPresent(jakarta.persistence.Entity.class);
		
		return isClassValidEntity;
	}
}
