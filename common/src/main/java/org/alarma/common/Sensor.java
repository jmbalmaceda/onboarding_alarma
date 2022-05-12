package org.alarma.common;

public abstract class Sensor extends Thread {

	protected String sensorId;

	protected String sensorName;

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String id) {
		this.sensorId = id;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

}
