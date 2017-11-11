package com.project.core.gen;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class MyProducerCallback implements Callback {


	       public  void onCompletion(RecordMetadata recordMetadata, Exception e) {
	        if (e != null)
	            System.out.println("Producer failed with the exception: "+ e.getMessage());
	                else
	                        System.out.println("Producer Message Successfully sent");
	       }

	   }

