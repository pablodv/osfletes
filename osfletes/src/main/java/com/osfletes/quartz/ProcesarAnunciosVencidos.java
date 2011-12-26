package com.osfletes.quartz;

import java.util.Date;
import java.util.logging.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.LoggerFactory;

public class ProcesarAnunciosVencidos implements Job{

    private static Logger _log = (Logger) LoggerFactory.getLogger(ProcesarAnunciosVencidos.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//System.out.println("procesando anuncios ....");
        // This job simply prints out its job name and the
        // date and time that it is running
        JobKey jobKey = context.getJobDetail().getKey();
        _log.info("SimpleJob says: " + jobKey + " executing at " + new Date());		
	}

}
