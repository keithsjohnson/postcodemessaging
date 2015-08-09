package uk.co.cdl.keithj.postcodemessaging.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.co.cdl.keithj.postcodemessaging.infrastructure.SQSProvider;

@RestController
public class SendQueueMessageAction {

	@Autowired
	private SQSProvider sqsProvider;

	@RequestMapping(value = "/send")
	public @ResponseBody String send(String message) {

		sqsProvider.send(message);

		return "OK";
	}

}
