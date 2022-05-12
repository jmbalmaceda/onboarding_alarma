package org.alarma.common;

import java.time.LocalDateTime;

public abstract class Evento {

    String id;

    String name;

    LocalDateTime time;

    Object data;

    public Evento(String id, String name, LocalDateTime time, Object data) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.data = data;
    }

    public String getId() {
        return this.id;
    }

    public Object getData() {
        return this.data;
    }

    public String getName() {
        return this.name;
    }

}
