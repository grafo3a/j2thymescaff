package net.apasajb.j2thymescaff;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Contains test methods for Scaffolding.java.
 */
public class ScaffoldingTests {
	
	@Test
	void isValidJpaEntity_notValidJpaEntity_throwsException() {
		
		Scaffolding scaffolding = new Scaffolding();
		Compte compte = new Compte();
		
		assertTrue(scaffolding.isValidJpaEntity(compte));
	}
}
