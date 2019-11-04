package com.fastone.test.event;

import java.util.EventObject;

public class JackyEvent extends EventObject {

	/**
	 * Constructs a prototypical Event.
	 *
	 * @param source the object on which the Event initially occurred
	 * @throws IllegalArgumentException if source is null
	 */
	public JackyEvent(Object source) {
		super(source);
	}
}
