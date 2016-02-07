package es.futurespace.karmapp.server;

import javax.annotation.PostConstruct;

import location.Manager;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EventManager implements EnvironmentAware {
	private Manager locationManager;
	
	private RelaxedPropertyResolver env;

	@Override
	public void setEnvironment(Environment arg0) {
		this.env = new RelaxedPropertyResolver(arg0, "env.");
	}
	
	@PostConstruct
	public void initialize() {
		this.locationManager = new Manager(env.getProperty("parkings.residentes"), 
				env.getProperty("parkings.publicos"), 
				env.getProperty("parkings.electricos"),
				env.getProperty("events"));
	}
	
	public Manager getLocationManager() {
		return locationManager;
	}
	
}
