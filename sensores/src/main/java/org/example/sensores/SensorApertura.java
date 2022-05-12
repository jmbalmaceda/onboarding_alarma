package org.example.sensores;

import org.alarma.common.Central;
import org.alarma.common.Evento;
import org.alarma.common.Sensor;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class SensorApertura extends Sensor {

    private Central central;

    public SensorApertura(String id, Central central) {
        super.sensorId = id;
        this.central = central;
    }

    @Override
    public void run() {

        while (true) {
            Boolean value = (Math.random() < 0.5);
            LocalDateTime now = LocalDateTime.now();
            Evento e = new EventoApertura(this.getSensorId(), this.getSensorName(), now, value);

            this.central.sendEvent(e);

            // sleep
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
