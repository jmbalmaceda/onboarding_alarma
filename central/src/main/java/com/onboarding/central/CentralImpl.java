package com.onboarding.central;

import org.alarma.common.Central;
import org.alarma.common.Evento;

public class CentralImpl implements Central {


    @Override
    public void sendEvent(Evento evento) {
        System.out.println("Evento id = " + evento.getId() + ", data = " + evento.getData());
    }
}
