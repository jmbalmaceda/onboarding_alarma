package com.onboarding.alarmaapp;

import com.onboarding.central.AlarmaMultiple;
import com.onboarding.central.AlarmaTemperatura;
import com.onboarding.central.CentralImpl;
import org.alarma.common.Central;
import org.alarma.common.Sensor;
import org.example.sensores.SensorApertura;
import org.example.sensores.SensorTemperatura;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

@SpringBootApplication
public class AlarmaAppApplication {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ConfigurableApplicationContext context = SpringApplication.run(AlarmaAppApplication.class, args);
        Central central = context.getBean(Central.class);
        AlarmaTemperatura alarmaTemperatura = (AlarmaTemperatura) Class.forName(context.getEnvironment().getProperty("alarm.type")).getConstructors()[0].newInstance();
        Double temperature = Double.parseDouble(context.getEnvironment().getProperty("alarm.temperature","40"));
        alarmaTemperatura.setValue(temperature);

        AlarmaMultiple alarmaMultiple = (AlarmaMultiple) Class.forName(context.getEnvironment().getProperty("alarm.multiple.type")).getConstructors()[0].newInstance();
        alarmaMultiple.setValue(temperature);
        central.addAlarma(alarmaTemperatura);
        central.addAlarma(alarmaMultiple);
        Sensor sensor = context.getBean(Sensor.class);
        sensor.setSensorName("Sensor 1");
        Sensor sensorTemperatura = context.getBean(SensorTemperatura.class);
        sensorTemperatura.setSensorName("Temperatura 1");
        Sensor sensorApertura = (Sensor) context.getBean("getSensorApertura");
        sensorApertura.setSensorName("Apertura 1");
        sensorApertura.start();
        sensorTemperatura.start();
        Sensor sensorApertura2 = (Sensor) context.getBean("getSensorApertura");
        sensorApertura2.setSensorName("Apertura 2");
        sensorApertura2.start();
    }

    @Bean
    public Central getCentral() {
        return new CentralImpl();
    }

    @Bean
    @Scope("prototype")
    @Primary
    public SensorTemperatura getSensorTemperatura(Central central) {
        String id = UUID.randomUUID().toString();
        return new SensorTemperatura(id, central);
    }

    @Bean
    @Scope("prototype")
    public SensorApertura getSensorApertura(Central central) {
        String id = UUID.randomUUID().toString();
        return new SensorApertura(id, central);
    }

    @Bean
    @Scope("prototype")
    public AlarmaTemperatura getAlarmaTemperatura() {
        return new AlarmaTemperatura();
    }

}
