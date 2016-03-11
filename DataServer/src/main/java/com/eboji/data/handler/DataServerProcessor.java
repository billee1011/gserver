package com.eboji.data.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eboji.data.pojo.GameTable;
import com.eboji.data.service.DataService;
import com.eboji.model.message.BaseMsg;
import com.eboji.model.message.dt.DtInsGGTableMsg;
import com.eboji.model.message.dt.DtInsGGTableRsMsg;

@Component("dataProcessor")
public class DataServerProcessor {
	@Autowired
	private DataService dataService;
	
	public void process(BaseMsg msg, String remoteAddress) {
		DtInsGGTableMsg insMsg = (DtInsGGTableMsg)msg;
		GameTable gt = new GameTable();
		if(insMsg.getPosition() == 1) {
			gt.setEuid(Integer.parseInt(insMsg.getUid()));
		} else if(insMsg.getPosition() == 2) {
			gt.setSuid(Integer.parseInt(insMsg.getUid()));
		} else if(insMsg.getPosition() == 3) {
			gt.setWuid(Integer.parseInt(insMsg.getUid()));
		} else if(insMsg.getPosition() == 4) {
			gt.setNuid(Integer.parseInt(insMsg.getUid()));
		}
		int deskId = dataService.insGGTable(gt);
		
		DtInsGGTableRsMsg ret = new DtInsGGTableRsMsg();
		ret.setDeskId(deskId);
		
		DataServerClientMap.get(remoteAddress).writeAndFlush(ret);
	}
}
