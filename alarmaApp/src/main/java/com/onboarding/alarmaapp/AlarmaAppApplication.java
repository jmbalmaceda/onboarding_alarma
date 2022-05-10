package com.onboarding.alarmaapp;

import com.onboarding.central.CentralImpl;
import main.Sensor;
import org.alarma.common.Central;
import org.example.sensores.SensorTemperatura;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlarmaAppApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(AlarmaAppApplication.class, args);
        Central central = new CentralImpl();
        SensorTemperatura sensorTemperatura = new SensorTemperatura("1",central);
        sensorTemperatura.iniciar();
    }

}
