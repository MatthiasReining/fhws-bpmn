package org.fhws.bpmn;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
@RequestScoped
public class TaskMicro1 implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// call Microservice
		String message = null;
		try {
			message = ClientBuilder.newClient()
					.target("http://localhost:8090/ping")
					.request()
					.get(String.class);

		} catch (Exception e) {
			throw new BpmnError("PING_NOT_AVAILABLE");
		}

		System.out.println("message from micro1: " + message);

		execution.setVariable("op", message);

	}

}
