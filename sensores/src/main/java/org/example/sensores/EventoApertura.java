package org.example.sensores;

import org.alarma.common.Evento;
import org.alarma.common.SensorType;

import java.time.LocalDateTime;

public class EventoApertura extends Evento {

	public EventoApertura(String id, String name, LocalDateTime time, Boolean data) {
		super(id, name, SensorType.APERTURA,  time, data);
	}

}
