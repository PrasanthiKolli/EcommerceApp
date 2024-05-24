package com.demo.camelmicroservicea.routes;

import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyFirstTimerRoute extends RouteBuilder {
	
	
	@Autowired
	private GetCurrentTimeBean currentTimeBean;
	@Autowired
	private SimpleLogProcessingComponent loggerComponent;
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("timer:first-timer")
	//	.log("${body}")
	//	.transform().constant("my message")
	//	.transform().constant(LocalDateTime.now())
	//	.bean("getCurrentTimeBean")
		.bean(currentTimeBean)
//		.log("${body}")
//		.bean(loggerComponent)
		.process(new SimpleLoggingProcessor())
		.log("${body}")
		.to("log:first-timer");
		
	}

}
@Component
class GetCurrentTimeBean {
	
	public String getCurrentTime() {
		return "Time now is : "+LocalDateTime.now();
	}
}
@Component
class SimpleLogProcessingComponent{
	private Logger LOGGER = LoggerFactory.getLogger(SimpleLogProcessingComponent.class);
	public void process(String message) {
		LOGGER.info("simpleLogProcessingComponent {}",message);
	}
}
@Component
class SimpleLoggingProcessor implements Processor {
	private Logger LOGGER = LoggerFactory.getLogger(SimpleLoggingProcessor.class);
	@Override
	public void process(Exchange exchange) throws Exception {
		
		LOGGER.info("SimpleLoggingProcessor {}",exchange.getMessage().getBody());
	}

}
