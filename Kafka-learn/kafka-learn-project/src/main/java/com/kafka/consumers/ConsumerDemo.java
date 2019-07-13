package com.kafka.consumers;

import static org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


public class ConsumerDemo {
	public static void main(String[] args) {
		Properties configs = new Properties();
		configs.setProperty(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.setProperty(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		configs.setProperty(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		configs.setProperty(GROUP_ID_CONFIG, "my-second-group");
		configs.setProperty(AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configs);
		
		consumer.subscribe(Arrays.asList("myTopic1"));
		
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
			for(ConsumerRecord<String,String> record : records) {
				System.out.println(record.value());
			}
		}
		
	}
}
