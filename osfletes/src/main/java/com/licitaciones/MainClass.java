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
    		try {
				Estado nuevoEstado = wf.emuleAction(estado.getIdentityVector(), transaction.getIdentityVector());
				System.out.println(estado.getName()+ "---["+ transaction.getName() + "]--->" + nuevoEstado.getName());
			} catch (InvalidTransactionException e) {
				System.out.println(transaction.getName()+ " No soportada");
			}
    	}
    	
    	System.out.println("---------------------------------------------------------");
    	
    }
    try {
    	System.out.println("-------------PRUEBAAAA  Transaccion Correcta--------------");
    	System.out.println("Estado: "+wf.getStateById(1).getName());
    	System.out.println("Accion: "+wf.getTransactionById(2).getName());
    	wf.emuleAction(wf.getStateById(1).getIdentityVector(), 2);
		System.out.println("Se permite\n!");
	} catch (InvalidTransactionException e) {
		System.out.println("Mal!\n");
	}
	
	 try {
		 	
		 System.out.println("-------------PRUEBAAAA  Transaccion Incorrecta--------------");
	    	System.out.println("Estado: "+wf.getStateById(1).getName());
	    	System.out.println("Accion: "+wf.getTransactionById(5).getName());
		 wf.emuleAction(1,5);
		 System.out.println("MAL\n!");
		} catch (InvalidTransactionException e) {
			System.out.println("No flaquito que estas haciendo esto no podes\n");
			
		}
	
	 wf.getEstadoTransactions(1);
    
  }
}
      
