package org.example.sensores;

import org.alarma.common.Evento;

import java.time.LocalDateTime;

public class EventoTemperatura extends Evento {

	public EventoTemperatura(String id, LocalDateTime time, Double data) {
		super(id, time, data);
	}

	@Override
	public Object getData() {
		return this.getData();
	}
}
