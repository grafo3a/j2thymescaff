package net.apasajb.j2thymescaff;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;

import org.tinylog.Logger;

import jakarta.persistence.Entity;


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
		String userDir = System.getProperty("user.dir");
		Logger.info("\n ==== pwd: " + userDir + "/");
		
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
	
	
	public void ajouterTexteDansFichier(String textToAppend) {
		
		String filePath = "C:\\tmp\\ScaffExports\\journal.log";
		
		// Ensure the file exists, create if not
		
		boolean isFilePresent = false;
		Path path = Path.of(filePath);
		
		if (!Files.exists(path)) {
			Logger.info("The File does not exist. We'll create it.");
			
			try {
				Files.createFile(path);
				Logger.info("New file created: " + filePath);
				isFilePresent = true;
				
			} catch (Exception ex) {
				Logger.error("Error while writing to file: " + ex.getMessage());
			}
			
		} else {
			isFilePresent = true;
		}
		
		if (isFilePresent) {
			
			// Open FileWriter in append mode (=> true)
			try (FileWriter writer = new FileWriter(filePath, true)) {
				
				writer.write(textToAppend + "\n");
				Logger.info("Text appended successfully.");
				
			} catch (Exception ex) {
				Logger.error("Error while writing to file: " + ex.getMessage());
			}
		}
	}
}
