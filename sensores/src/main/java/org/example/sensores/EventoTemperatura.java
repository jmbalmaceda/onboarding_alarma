package org.example.sensores;

import org.alarma.common.Evento;
import org.alarma.common.SensorType;

import java.time.LocalDateTime;

public class EventoTemperatura extends Evento {

	public EventoTemperatura(String id, String name, LocalDateTime time, Double data) {
		super(id, name, SensorType.TEMPERATURA, time, data);
	}

}
