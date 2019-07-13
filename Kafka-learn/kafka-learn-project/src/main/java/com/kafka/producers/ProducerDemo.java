package com.kafka.producers;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerDemo {
	public static void main(String[] args) {
		// Set configuration properties
		String bootstrapServer = "localhost:9092";
		Properties props = new Properties();
		props.setProperty(BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.setProperty(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// Declare Kafka producer
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

		// Set producer record
		producer.send(new ProducerRecord<String, String>("myTopic1", "message again java"),new Callback() {
			public void onCompletion(RecordMetadata metadata, Exception e) {
				if (e != null) {
					e.printStackTrace();
				} else {
					System.out.println("(" + System.currentTimeMillis() + ")MAJThe offset of the record we just sent is: "
							+ metadata.offset());
				}

			}
		});

		ProducerRecord<String, String> record = new ProducerRecord<String, String>("myTopic1", "java message");
		producer.send(record, new Callback() {
			public void onCompletion(RecordMetadata metadata, Exception e) {
				if (e != null) {
					e.printStackTrace();
				} else {
					System.out.println("(" + System.currentTimeMillis() + ")JMThe offset of the record we just sent is: "
							+ metadata.offset());
				}

			}
		});
		
		System.out.println("("+System.currentTimeMillis()+") ---TimeStamp");
		producer.close();

	}
}
