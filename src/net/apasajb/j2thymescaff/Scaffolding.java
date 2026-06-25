package net.apasajb.j2thymescaff;


public class Scaffolding {
	
	public Boolean isValidJpaEntity(Object myClass) {
		
		boolean isEntity = false;
		
		//isEntity = myClass.getClass().isAnnotationPresent(jakarta.persistence.Entity.class);
		
		return isEntity;
	}
}
