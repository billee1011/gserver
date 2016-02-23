package com.eboji.center.util;

import com.eboji.center.bootstrap.Daemon;
import com.eboji.center.transfer.tcp.RegClientTransfer;
import com.eboji.center.transfer.tcp.connection.AgentRegClientConnection;
import com.eboji.center.transfer.tcp.connection.RegClientConnection;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.RegisterMsg;

public class RegisterServiceUtil {
	public static void registerService() {
		String services = ConfigUtil.getProps("services");
		String[] servicesArr = services.split("\\|");
		for(String service : servicesArr) {
			String[] components = service.split(Constant.STR_COLON);
			int serviceId = Integer.parseInt(components[0]);
			String host = components[1];
			int port = Integer.parseInt(components[2]);
			
			String serviceaddress = host + Constant.STR_COLON + port;
			if(Constant.SRV_AGENT == serviceId) {
				AgentRegClientConnection client = new AgentRegClientConnection(port, host);
				RegClientTransfer.getServiceMap().put(serviceaddress, serviceId);
				RegClientTransfer.getSocketChannelMap().put(serviceaddress, client.getSocketChannel());
			} else {
				RegClientConnection client = new RegClientConnection(port, host);
				RegClientTransfer.getServiceMap().put(serviceaddress, serviceId);
				RegClientTransfer.getSocketChannelMap().put(serviceaddress, client.getSocketChannel());
			}
		}
		
		RegisterMsg regMsg = new RegisterMsg();
		regMsg.setPort(Daemon.getInstance().getPort());
		
		RegClientTransfer.write(regMsg);
	}
}
