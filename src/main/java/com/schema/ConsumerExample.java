package com.schema;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class ConsumerExample {

    public static void main(String[] args) {


        Properties prop = new Properties();
        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"10.151.32.238:9092");
        prop.put(ConsumerConfig.GROUP_ID_CONFIG,"nice20");
        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        prop.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,"http://10.151.32.238:8081");

        prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        prop.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG,"true");

        KafkaConsumer<String ,Payment> consumer = new KafkaConsumer<String, Payment>(prop);

        consumer.subscribe(Arrays.asList("yogesh4"));

        try {
               while (true){

                   System.out.println("response:-");
                   ConsumerRecords<String,Payment> records = consumer.poll(1000);

                   for (ConsumerRecord<String,Payment> record : records)
                   {

                       System.out.println("Key : "+record.key()
                                       /*+  "  Id : "+record.value().getId()*/
                                      /* +  "  location : "+record.value().getAmount()*/
                       );

                   }

               }

        }catch(Exception e){
          e.printStackTrace();
        }
        finally {
            System.out.println("Inside finally");
            consumer.close();
        }


    }
}
