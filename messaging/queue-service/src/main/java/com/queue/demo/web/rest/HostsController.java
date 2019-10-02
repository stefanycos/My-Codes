package com.queue.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.queue.demo.client.HostsClient;
import com.queue.demo.client.domains.request.host.HostRequest;
import com.queue.demo.client.domains.response.host.HostsResponse;

@RestController
@RequestMapping("/vhosts")
public class HostsController {

	@Autowired
	private HostsClient hostsClient;

	@GetMapping
	public HostsResponse[] getHosts() {
		return hostsClient.getHosts();
	}

	@PutMapping("/{name}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "VHost created successfully!")
	public void create(@PathVariable("name") String name, @RequestBody HostRequest body) {
		hostsClient.create(name, body);
	}

	@DeleteMapping("/{name}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "VHost deleted successfully!")
	public void delete(@PathVariable("name") String name) {
		hostsClient.delete(name);
	}

}
