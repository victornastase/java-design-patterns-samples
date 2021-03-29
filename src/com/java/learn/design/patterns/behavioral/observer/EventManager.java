package com.java.learn.design.patterns.behavioral.observer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Basic publisher
 */
public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager (String... operations) {
        for(String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener subject) {
        List<EventListener> users = listeners.get(eventType);
        users.add(subject);
    }

    public void unsubscribe(String eventType, EventListener subject) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(subject);
    }

    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for(EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
 }
