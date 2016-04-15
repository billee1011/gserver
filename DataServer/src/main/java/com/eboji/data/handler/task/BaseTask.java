package com.eboji.data.handler.task;

import java.util.concurrent.Callable;

import com.eboji.data.service.DataService;

public class BaseTask implements Callable<Boolean> {
	protected String remoteAddress;
	protected DataService dataService;
	
	public BaseTask(String remoteAddress, DataService dataService) {
		this.remoteAddress = remoteAddress;
		this.dataService = dataService;
	}
	
	@Override
	public Boolean call() throws Exception {
		return null;
	}
}
