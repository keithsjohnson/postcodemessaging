package uk.co.cdl.keithj.postcodemessaging.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.co.cdl.keithj.postcodemessaging.infrastructure.SNSProvider;

@RestController
public class SendNotificationMessageAction {

	@Autowired
	private SNSProvider snsProvider;

	@RequestMapping(value = "/notification")
	public @ResponseBody String send(String message) {

		snsProvider.send(message);

		return "OK";
	}

}
