package com.onboarding.alarmaapp;

import com.onboarding.central.CentralImpl;
import org.alarma.common.Central;
import org.alarma.common.Sensor;
import org.example.sensores.SensorTemperatura;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@SpringBootApplication
public class AlarmaAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AlarmaAppApplication.class, args);
        Central central = context.getBean(Central.class);
        Sensor sensorTemperatura = context.getBean(Sensor.class);
        sensorTemperatura.start();

        Sensor sensorTemperatura2 = context.getBean(Sensor.class);
        sensorTemperatura2.start();
    }

    @Bean
    public Central getCentral() {
        return new CentralImpl();
    }

    @Bean
    @Scope("prototype")
    public Sensor getSensor(Central central) {
        String id = UUID.randomUUID().toString();
        return new SensorTemperatura(id, central);
    }

}
