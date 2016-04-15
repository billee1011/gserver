package com.eboji.data.handler.task;

import com.eboji.data.handler.DataServerClientMap;
import com.eboji.data.service.DataService;
import com.eboji.model.message.LoginMsg;
import com.eboji.model.message.LoginResMsg;
import com.eboji.persist.pojo.GuUser;

public class LoginTask extends BaseTask {
	private LoginMsg msg;
	
	public LoginTask(String remoteAddress, LoginMsg msg, 
			DataService dataService) {
		super(remoteAddress, dataService);
		this.remoteAddress = remoteAddress;
		this.msg = msg;
	}
	
	@Override
	public Boolean call() throws Exception {
		Object ret = null;
		GuUser user = login((LoginMsg)msg);
		LoginResMsg res = new LoginResMsg();
		res.setCid(msg.getCid());
		res.setGid(msg.getGid());
		res.setRas(msg.getRas());
		if(user != null) {
			res.setStatus("OK");
			res.setUid(String.valueOf(user.getId()));
			res.setUsername(user.getUsername());
		} else {
			res.setStatus("FAIL");
		}
		
		ret = res;
		if(ret != null)
			DataServerClientMap.get(remoteAddress).writeAndFlush(ret);
		return true;
	}
	
	protected GuUser login(LoginMsg msg) {
		GuUser user = dataService.login(msg);
		return user;
	}
}
