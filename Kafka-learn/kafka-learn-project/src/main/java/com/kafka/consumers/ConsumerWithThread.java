package com.kafka.consumers;

import static org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerWithThread {
	public static void main(String[] args) {
		String bootstrapServer = "localhost:9092";
		String groupId = "my-third-group";
		String offsetResetType = "earliest";
		Collection<String> topics = Arrays.asList("myTopic1");
		
		final CountDownLatch latch = new CountDownLatch(1);
		
		final ConsumerThread consumerThread = new ConsumerThread(bootstrapServer, groupId, offsetResetType, topics, latch);
		consumerThread.start();
		
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				System.out.println("ShutDown by exit has been invoked");
				consumerThread.shutDown();
				try {
					latch.await();
					System.out.println("ShutDown hook is done");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}));
		
		
		new Thread(new Runnable() {
			
			public void run() {
				try {
					System.out.println("new thread sleeping");
					Thread.sleep(10000);
					System.exit(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		
		System.out.println("Awaiting countdown------>");
		try {
			latch.await();
			System.out.println("MainApplication is done");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exiting MAIN application thread");
		}
		
	}
}

class ConsumerThread extends Thread {
	private CountDownLatch latch;
	private KafkaConsumer<String, String> consumer;

	public ConsumerThread(String bootstrapServer, String groupId, String offsetResetType, Collection<String> topics,
			CountDownLatch latch) {
		Properties configs = new Properties();
		configs.setProperty(BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		configs.setProperty(GROUP_ID_CONFIG, groupId);
		configs.setProperty(AUTO_OFFSET_RESET_CONFIG, offsetResetType);
		configs.setProperty(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		configs.setProperty(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		consumer = new KafkaConsumer<String, String>(configs);
		consumer.subscribe(topics);
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10));
				for (ConsumerRecord<String, String> record : records) {
					if(record.value()!=null && !record.value().isEmpty()) {
						System.out.println(String.format("Message received ---> %s", record.value()));
					}
				}
			}
		} catch (WakeupException e) {
			System.out.println("-----WakeUp call-----");
		} finally {
			consumer.close();
			System.out.println("---Latch counted down");
			latch.countDown();
			System.out.println("Exiting CONSUMER thread");
		}
	}

	public void shutDown() {
		System.out.println("-----calling shutdown consumer");
		consumer.wakeup();
	}
}
