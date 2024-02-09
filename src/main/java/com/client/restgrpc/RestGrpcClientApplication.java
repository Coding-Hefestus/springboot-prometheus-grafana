package com.client.restgrpc;

import com.client.restgrpc.dto.EmailMessageRequestDto;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@RequestMapping
@RestController
@AllArgsConstructor
//@EnableAspectJAutoProxy
@SpringBootApplication
public class RestGrpcClientApplication {

	private final MyService myService;

	public static void main(String[] args) {
		SpringApplication.run(RestGrpcClientApplication.class, args);
	}
	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) {
		return new TimedAspect(registry);
	}

	@GetMapping("/sendEmails")
	public String sendEmails(){
		//send 10 emails concurrently
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 1; i <= 10; i++){
			executorService.execute(() -> {
				myService.sendEmail(new EmailMessageRequestDto());
			});
		}
		return "response 1";
	}

	@GetMapping("/testEndpoint")
	public String testEndpoint(){
		return "response from testEndpoint";
	}


}
