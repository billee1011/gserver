package com.eboji.data.handler;

import java.util.concurrent.ExecutorService;

public class DataServerExecutors {
	public static ExecutorService service = null;

	public static ExecutorService getService() {
		return service;
	}

	public static void setService(ExecutorService service) {
		DataServerExecutors.service = service;
	}
	
}
