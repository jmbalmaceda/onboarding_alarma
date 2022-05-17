package com.onboarding.central;

import org.alarma.common.Alarma;
import org.alarma.common.Central;
import org.alarma.common.Evento;

import java.util.ArrayList;
import java.util.List;

public class CentralImpl implements Central {

    private List<Alarma> alarmas = new ArrayList<Alarma>();

    @Override
    public void sendEvent(Evento evento) {
        System.out.println("Evento id = " + evento.getId() + ", name = " + evento.getName() + ", data = " + evento.getData());
        for (Alarma a: alarmas) {
            a.check(evento);
        }
    }

    @Override
    public void addAlarma(Alarma alarma) {
        this.alarmas.add(alarma);
    }
}
