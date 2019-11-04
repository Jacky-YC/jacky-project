package com.fastone.test.event;

import org.assertj.core.util.Sets;

import java.util.Set;

public class ApplicationContext {

	Set<JackyEventListener> listeners;

	public ApplicationContext(){
		this.listeners = Sets.newHashSet();
	}


	public void addApplicationListener(JackyEventListener listener){
		this.listeners.add(listener);
	}

	public void publishEvent(JackyEvent event){
		for (JackyEventListener listener : listeners) {
			listener.onApplicationEvent(event);
		}
	}

}
