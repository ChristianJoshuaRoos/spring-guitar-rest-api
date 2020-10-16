package com.guitar.handler;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.guitar.model.Manufacturer;

@Component
@RepositoryEventHandler(Manufacturer.class)
public class ManufacturerEventHandler {

	@HandleBeforeCreate
	public void handleBeforeCreate(Manufacturer m) {
		//Do a check to see if the name is a valid manufacturer.
		
		//Do any auditing.
		
		//Only allow new manufacturers to be created that are in the active state.
		if(!m.getActive()) {
			throw new IllegalArgumentException("New manufacturers must be active.");
		}
	}
}
