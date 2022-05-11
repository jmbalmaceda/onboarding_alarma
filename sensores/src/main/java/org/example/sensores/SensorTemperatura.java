package org.example.sensores;

import org.alarma.common.Central;
import org.alarma.common.Sensor;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class SensorTemperatura extends Sensor {

	private Central central;

	private String id;

	public SensorTemperatura(String id, Central central) {
		this.id = id;
		this.central = central;
	}

	@Override
	public void run() {

		while (true) {
			Double value = Math.random();
			LocalDateTime now = LocalDateTime.now();
			EventoTemperatura e = new EventoTemperatura(this.id, now, value);

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
