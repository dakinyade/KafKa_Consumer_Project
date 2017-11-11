package com.project.core.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerGen {
	
	public static void main(String[] args) throws Exception{

        String topicName = "UserSTream";
        String groupName = "UserSTreamGroup";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093");///connect to Kafka server
        props.put("group.id", groupName);// specifying a group name while API takes cares of the group, group cordinator e.t.c
        props.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer"); // deserialize the from the producer
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("enable.auto.commit", "false");

        KafkaConsumer<Integer, String> consumer = null;

        try {
            consumer = new KafkaConsumer<>(props);
            consumer.subscribe(Arrays.asList(topicName));

            while (true){
                ConsumerRecords<Integer, String> records = consumer.poll(100);
               
                consumer.commitAsync();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            consumer.commitSync();
            consumer.close();
        }
    }
	

}
