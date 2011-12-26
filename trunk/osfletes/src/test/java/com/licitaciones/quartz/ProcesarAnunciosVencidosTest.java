package com.licitaciones.quartz;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.osfletes.quartz.ProcesarAnunciosVencidos;
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
	        JobDetail job = newJob(ProcesarAnunciosVencidos.class)
	            .withIdentity("job_matias", "group1")
	            .build();
	        
	        // Trigger the job to run now, and then repeat every 40 seconds
	        Trigger trigger=null;
			try {
				trigger = newTrigger()
				    .withIdentity("trigger1", "group1")
				    .withSchedule(cronSchedule("0/20 * * * * ?"))
				    .build();
				//scheduler.scheduleJob(job, trigger);			
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        
			
	        Date ft = scheduler.scheduleJob(job, trigger);
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
