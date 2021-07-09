package com.wf.consumerBT;

import akka.actor.typed.ActorSystem;
import com.wf.consumerBT.actor.GreeterMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerBtApplication {


	public static void main(String[] args) {

		SpringApplication.run(ConsumerBtApplication.class, args);
	}

}
