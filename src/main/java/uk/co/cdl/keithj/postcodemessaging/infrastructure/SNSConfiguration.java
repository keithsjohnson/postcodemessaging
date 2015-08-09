package uk.co.cdl.keithj.postcodemessaging.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.core.env.ResourceIdResolver;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Region;
import com.amazonaws.services.sns.AmazonSNS;

@Configuration
public class SNSConfiguration {

	@Autowired
	private Region region;

	@Bean
	public NotificationMessagingTemplate notificationMessagingTemplate(AmazonSNS amazonSNS,
			ResourceIdResolver resourceIdResolver) {
		amazonSNS.setRegion(region);

		amazonSNS.listTopics().getTopics().stream().forEach(System.out::println);

		return new NotificationMessagingTemplate(amazonSNS, resourceIdResolver);
	}
}
