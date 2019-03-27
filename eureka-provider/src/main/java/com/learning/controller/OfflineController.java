package com.learning.controller;

import com.netflix.discovery.DiscoveryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title null.java$
 * @ClassName OfflineController
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/18 16:05
 * @Version 1.0
 */
@RestController
public class OfflineController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "offline",method = RequestMethod.GET)
	public void offLine(){
		DiscoveryManager.getInstance().shutdownComponent();
	}

}