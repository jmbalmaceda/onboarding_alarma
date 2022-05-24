package com.onboarding.central;

import org.alarma.common.Alarma;
import org.alarma.common.Evento;
import org.alarma.common.SensorType;

import java.util.HashMap;
import java.util.Map;

public class AlarmaMultiple implements Alarma {

    private Double value;

    private Double temperature;

    Map<String, Boolean> eventos = new HashMap<String, Boolean>();

    @Override
    public void check(Evento evento) {
        if (SensorType.TEMPERATURA.equals(evento.getType()))
            temperature = (Double) evento.getData();
        if (SensorType.APERTURA.equals(evento.getType()))
            eventos.put(evento.getId(), (Boolean) evento.getData());

        if (!eventos.containsValue(true)&&temperature>value)
            System.out.println("Temperatura maxima y todo cerrado!!!");
    }

    public void setValue(Double val) {
        this.value = val;
    }

}
