package br.com.springboot.events.demo.event.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.springboot.events.demo.controller.WebhookSender;
import br.com.springboot.events.demo.event.ChangeStatusEvent;

@Component
public class ChangeStatusEventListener implements ApplicationListener<ChangeStatusEvent> {

	@Autowired
	private WebhookSender sender;

	@Override
	public void onApplicationEvent(ChangeStatusEvent event) {
		sender.sendNotification(event.getOrder());
	}

}
