package com.licitaciones;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.licitaciones.exception.InvalidTransactionException;

public class MainClass {
  public static void main(String args[]) throws IOException {
    int n = 170; // 10101010

    ApplicationContext context = new ClassPathXmlApplicationContext("workflow.xml");
    
    Workflow wf = WorkflowLicitacionFactoryImpl.getWorkflow("workflow-anuncio");
    
  
    
    try {
		wf.executeAction(1, 16);
		System.out.println("MAL\n!");
	} catch (InvalidTransactionException e) {
		System.out.println("bien!\n");
	}
	
	 try {
		 	wf.executeAction(1,2);
		 	System.out.println("bien!\n");
		} catch (InvalidTransactionException e) {
			System.out.println("MAL\n!");
			
		}
	
	 wf.getEstadoTransactions(1);
    
  }
}
      
