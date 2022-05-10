package org.example.sensores;

import main.Sensor;
import org.alarma.common.Central;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class SensorTemperatura extends Sensor {

	private Central central;

	private String id;

	public SensorTemperatura(String id, Central central) {
		this.id = id;
		this.central = central;
	}

	public void iniciar() throws InterruptedException {

		while (true) {
			Double value = Math.random();
			LocalDateTime now = LocalDateTime.now();
			EventoTemperatura e = new EventoTemperatura(this.id, now, value);

			this.central.sendEvent(e);

			// sleep
			TimeUnit.SECONDS.sleep(1);
		}
	}

}
