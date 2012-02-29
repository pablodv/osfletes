package com.licitaciones;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.licitaciones.exception.InvalidTransactionException;

public class MainClass {
  public static void main(String args[]) throws IOException {
    
	String[] workflows = {"workflow-anuncio","workflow-oferta","workflow-contrato"};
    new ClassPathXmlApplicationContext("workflow.xml");
    
    for(String workflowName:workflows){
	    Workflow wf = WorkflowLicitacionFactoryImpl.getWorkflow(workflowName);
	    System.out.println("-----------------------------"+workflowName+"----------------------------");
	    for(Estado estado: wf.getEstados()){
	    	System.out.println("estado: "+ estado.getName()+"("+estado.getIdentityVector()+"): " );
	    	System.out.println("Transactions:");
	    	for(Transaction transaction: wf.getEstadoTransactions(estado)){
	    		try {
					Estado nuevoEstado = wf.emuleAction(estado.getName(), transaction.getName());
					System.out.println(estado.getName()+ "---["+ transaction.getName() + "]--->" + nuevoEstado.getName());
				} catch (InvalidTransactionException e) {
					System.out.println(transaction.getName()+ " No soportada");
				}
	    	}
	    	
	    	System.out.println("---------------------------------------------------------");
	    	
	    }
    }
        
  }
}
      
