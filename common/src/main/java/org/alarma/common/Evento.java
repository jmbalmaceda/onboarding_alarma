package org.alarma.common;

import java.time.LocalDateTime;

public abstract class Evento {

    String id;

    String name;

    SensorType type;

    LocalDateTime time;

    Object data;

    public Evento(String id, String name, SensorType type, LocalDateTime time, Object data) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public SensorType getType() { 
        return this.type; 
    }

}
