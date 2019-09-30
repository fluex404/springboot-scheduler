package com.fluex404.springbootscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class SpringbootSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSchedulerApplication.class, args);
	}

	//https://docs.oracle.com/cd/E12058_01/doc/doc.1014/e12030/cron_expressions.htm
	@Scheduled(cron = "40 19 7 * * ?")
	public void conJobSch() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Java cron job expression::"+strDate);
	}

	/*
	Fixed Rate scheduler is used to execute the tasks at the specific time. It does not wait for the
	completion of previous task. The values should be in milliseconds. The sample code is shown here -
	 */
	@Scheduled(fixedRate = 1000)
	public void fixedRateSch(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);

		System.out.println("Fixed Rate scheduler:: "+strDate);
	}

	/*jadi nunggu 3 detik dulu baru jalan setiap detiknya*/
	/*Fixed Delay scheduler is used to execute the tasks at a specific time. It should wait for the previous task completion.
	The values should be in milliseconds. A sample code is shown here*/
	@Scheduled(fixedRate = 1000, initialDelay = 3000)
	public void fixedDelaySch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);

		System.out.println("Fixed Delay scheduler:: "+strDate);
	}
}
