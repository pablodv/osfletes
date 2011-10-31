package com.licitaciones;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.licitaciones.exception.InvalidTransactionException;

public class MainClass {
  public static void main(String args[]) throws IOException {
    

    ApplicationContext context = new ClassPathXmlApplicationContext("workflow.xml");
    
    Workflow wf = WorkflowLicitacionFactoryImpl.getWorkflow("workflow-anuncio");
    
    
    for(Estado estado: wf.getEstados()){
    	System.out.println("estado: "+ estado.getName()+"("+estado.getIdentityVector()+"): " );
    	System.out.println("Transactions:");
    	for(Transaction transaction: wf.getEstadoTransactions(estado.getIdentityVector())){
    		System.out.println(transaction.getName() );
    	}
    	
    	System.out.println("---------------------------------------------------------");
    	
    }
    try {
		wf.executeAction(1, 2);
		System.out.println("MAL\n!");
	} catch (InvalidTransactionException e) {
		System.out.println("bien!\n");
	}
	
	 try {
		 	wf.executeAction(1,4);
		 	System.out.println("bien!\n");
		} catch (InvalidTransactionException e) {
			System.out.println("MAL\n!");
			
		}
	
	 wf.getEstadoTransactions(1);
    
  }
}
      
