package org.alarma.common;

import java.time.LocalDateTime;

public abstract class Evento {

    String id;

    LocalDateTime time;

    Object data;

    public Evento(String id, LocalDateTime time, Object data) {
        this.id = id;
        this.time = time;
        this.data = data;
    }

    public Object getData() {
        return this.data;
    };

}
