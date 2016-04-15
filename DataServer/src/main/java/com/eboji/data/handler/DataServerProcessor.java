package com.eboji.data.handler;

import java.util.concurrent.Executors;

import com.eboji.data.handler.task.BaseTask;
import com.eboji.data.handler.task.CreateRoomTask;
import com.eboji.data.handler.task.JoinRoomTask;
import com.eboji.data.handler.task.LoginTask;
import com.eboji.data.service.DataService;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.LoginMsg;
import com.eboji.model.message.dt.DtCreGGRoomMsg;
import com.eboji.model.message.mj.MjJoinMsg;

public class DataServerProcessor {
	private DataService dataService;
	
	public DataServerProcessor(DataService dataService, int poolSize) {
		this.dataService = dataService;
		DataServerExecutors.setService(Executors.
				newFixedThreadPool(poolSize));
	}
	
	public void process(BaseMsg msg, String remoteAddress) {
		BaseTask task = null;
		if(msg instanceof DtCreGGRoomMsg) {
			task = new CreateRoomTask(remoteAddress, 
					(DtCreGGRoomMsg)msg, dataService);
		} else if(msg instanceof LoginMsg) {
			task = new LoginTask(remoteAddress, 
					(LoginMsg)msg, dataService);
		} else if(msg instanceof MjJoinMsg) {
			task = new JoinRoomTask(remoteAddress, 
					(MjJoinMsg)msg, dataService);
		}
		
		if(task != null) {
			DataServerExecutors.getService().submit(task);
		}
	}
}
