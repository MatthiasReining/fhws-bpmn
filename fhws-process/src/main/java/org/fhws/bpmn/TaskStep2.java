package org.fhws.bpmn;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
@RequestScoped
public class TaskStep2 implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("step 2");
		
		System.out.println("variable 'op': " + execution.getVariable("op"));
		
	}

}
