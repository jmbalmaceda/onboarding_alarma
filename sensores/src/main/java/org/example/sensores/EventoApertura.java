package org.example.sensores;

import org.alarma.common.Evento;

import java.time.LocalDateTime;

public class EventoApertura extends Evento {

	public EventoApertura(String id, LocalDateTime time, Boolean data) {
		super(id, time, data);
	}

}
