package uk.co.cdl.keithj.postcodemessaging.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationSubject;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.cloud.aws.messaging.endpoint.NotificationStatus;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationMessageMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/sns/receive")
public class SNSProvider {

	private static final String POSTCODE_TOPIC = "postcodeNotifications";

	@Autowired
	private NotificationMessagingTemplate notificationMessagingTemplate;

	public void send(String message) {
		System.out.println("SNS SENT: " + message);
		this.notificationMessagingTemplate.sendNotification(POSTCODE_TOPIC, message, "Subject");
	}

	@NotificationSubscriptionMapping
	public void confirmSubscription(NotificationStatus notificationStatus) {
		System.out.println("notificationStatus: " + notificationStatus.toString());
		notificationStatus.confirmSubscription();
	}

	@NotificationMessageMapping
	public void receiveNotification(@NotificationMessage String message, @NotificationSubject String subject) {
		System.out.println("Received SNS message {" + message + "} with subject {" + subject + "}");
	}
}
