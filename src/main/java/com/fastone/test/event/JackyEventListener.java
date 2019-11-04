package com.fastone.test.event;

import java.util.EventListener;

public interface JackyEventListener extends EventListener {


	void onApplicationEvent(JackyEvent event);


}
