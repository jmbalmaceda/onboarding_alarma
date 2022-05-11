package com.onboarding.alarmaapp;

import com.onboarding.central.CentralImpl;
import org.alarma.common.Central;
import org.example.sensores.SensorTemperatura;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlarmaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlarmaAppApplication.class, args);
        Central central = new CentralImpl();
        SensorTemperatura sensorTemperatura = new SensorTemperatura("1",central);
        sensorTemperatura.start();

        SensorTemperatura sensorTemperatura2 = new SensorTemperatura("2",central);
        sensorTemperatura2.start();
    }

}
