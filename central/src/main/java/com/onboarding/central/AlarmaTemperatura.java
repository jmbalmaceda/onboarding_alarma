package com.onboarding.central;

import org.alarma.common.Alarma;
import org.alarma.common.Evento;
import org.alarma.common.SensorType;

public class AlarmaTemperatura implements Alarma {

    private Double value;

    public AlarmaTemperatura() {
    }

    public void setValue(Double val) {
        this.value = val;
    }

    public void check(Evento e) {
        if (SensorType.TEMPERATURA.equals(e.getType()) && ((Double) e.getData() > value)) {
            System.out.println("Ring!!!");
        }
    }

}
