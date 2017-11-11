package com.project.core.gen;

import java.util.*;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.*;

public class ProducerGen {
	
	
	//This class Produces messages per user record
	public ProducerGen(int key, String[] value, List<String> v) {
		super();
		
		this.key = key;
		this.value = value;
		this.v = v;
	}

	String topicName = "UserSTream";
    int key ;
    String value[];
    List<String> v;
    ProducerRecord<Integer, String> record ;
	

	public void producerMth (){
	Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092,localhost:9093"); //creating the broker
    props.put("key.serializer","org.apache.kafka.common.serialization.IntegerSerializer"); //convert key to byte for the broker
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");//convert key to byte for the broker

    
    Producer<Integer , String> producer = new KafkaProducer <>(props);

    if (!v.isEmpty() && v.size() >1){
    	
    	for (int i = 0; i<v.size(); i++){
    		
    		 ProducerRecord<Integer, String> record = new ProducerRecord<>(topicName,key,v.get(i));
    		
    		
    	}
    	
    }else{
    	
		ProducerRecord<Integer, String> record = new ProducerRecord<>(topicName,key,v.get(0));
    }
    producer.send(record, new MyProducerCallback());
    System.out.println("AsynchronousProducer call completed");
    producer.close();

}
}