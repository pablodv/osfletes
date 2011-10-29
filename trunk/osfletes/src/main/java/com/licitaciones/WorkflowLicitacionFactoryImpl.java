package com.licitaciones;

import java.util.Map;

public class WorkflowLicitacionFactoryImpl {

	private Map<String,Workflow> workflows; 
	private static WorkflowLicitacionFactoryImpl factory;
	
	
	
	private WorkflowLicitacionFactoryImpl() {
		
	}
	
	public static WorkflowLicitacionFactoryImpl  createFactory(){
		if(factory == null){
			factory = new WorkflowLicitacionFactoryImpl();
		}
		return factory;
	}

	public static Workflow getWorkflow(String name) {
		return factory.workflows.get(name);
	}

	public void setWorkflows(Map<String, Workflow> workflows) {
		this.workflows = workflows;
	}
	
	
	
	
	
	



	

}
