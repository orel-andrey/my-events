package com.oreland.myevents;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EventService {

    private final Calendar calendar;

    public EventService(Calendar calendar) {
        this.calendar = calendar;
    }


    List<Event> getEvents() throws IOException {
        DateTime now = new DateTime(System.currentTimeMillis());

        Events events = calendar.events().list("primary")
                .setMaxResults(10)
                .setTimeMax(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();

        return events.getItems();
    }
}
