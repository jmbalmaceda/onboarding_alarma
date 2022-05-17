package org.alarma.common;

public interface Central {

    void sendEvent(Evento e);

    void addAlarma(Alarma a);

}
