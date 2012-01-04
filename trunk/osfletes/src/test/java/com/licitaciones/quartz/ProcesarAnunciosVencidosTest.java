package com.licitaciones.quartz;


import java.text.ParseException;
import java.util.Date;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.osfletes.quartz.ProcesarAnunciosVencidosJob;
public class ProcesarAnunciosVencidosTest {

	
	@Test
	public void procesarAnunciosVencidosTest(){
        // Grab the Scheduler instance from the Factory 
        Scheduler scheduler;
        //Logger log = (Logger) LoggerFactory.getLogger(ProcesarAnunciosVencidosTest.class);
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			// and start it off
			

	        // define the job and tie it to our HelloJob class
			/*
	        JobDetail job = newJob(ProcesarAnunciosVencidos.class)
	            .withIdentity("job_matias", "group1")
	            .build();
	        */
	        // Trigger the job to run now, and then repeat every 40 seconds
	        Trigger trigger=null;
			//Date ft = scheduler.scheduleJob(job, trigger);
	        /*
	        log.info(job.getKey() + " has been scheduled to run at: " + ft
	                + " and repeat based on expression: "
	                + ((CronTrigger) trigger).getCronExpression());
			*/
	        // Tell quartz to schedule the job using our trigger
			scheduler.start();
			
	        try {
	            // wait five minutes to show jobs
	            Thread.sleep(300L * 1000L);
	            // executing...
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }

			scheduler.shutdown();
			
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}
}
