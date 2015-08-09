package uk.co.cdl.keithj.postcodemessaging.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SQSProvider {

	private static final String POSTCODE_QUEUE = "postcodeQueue";

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	public void send(String message) {
		Message<String> messageObject = MessageBuilder.withPayload(message).build();
		System.out.println("SQS SENT: " + messageObject.toString());
		this.queueMessagingTemplate.send(POSTCODE_QUEUE, messageObject);
	}

	@MessageMapping(POSTCODE_QUEUE)
	public void queueListener(String message) {
		System.out.println("SQS RECEIVED: " + message);
	}
}
