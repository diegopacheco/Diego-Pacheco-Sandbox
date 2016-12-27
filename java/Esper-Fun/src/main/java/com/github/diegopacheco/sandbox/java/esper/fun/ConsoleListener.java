package com.github.diegopacheco.sandbox.java.esper.fun;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class ConsoleListener implements UpdateListener {
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        EventBean event = newEvents[0];
        System.out.println("Event Status:" + event.get("status") + " - timestamp: " + event.get("timestamp"));
    }
}