package com.eboji.game.util;

import java.util.HashSet;
import java.util.Set;

import com.eboji.game.bootstrap.Daemon;
import com.eboji.game.server.transfer.tcp.ServerClientTransfer;
import com.eboji.game.server.transfer.tcp.connection.ServerClientConnection;
import com.eboji.model.constant.Constant;
import com.eboji.model.message.RegisterMsg;

public class RegisterCenterServerUtil {
	public static void registerService() {
		String services = ConfigUtil.getProps("centerserver");
		String[] servicesArr = services.split("\\|");
		for(String service : servicesArr) {
			String[] components = service.split(Constant.STR_COLON);
			String host = components[0];
			int port = Integer.parseInt(components[1]);
			
			String serviceaddress = host + Constant.STR_COLON + port;
			ServerClientConnection client = new ServerClientConnection(port, host);
			ServerClientTransfer.getSocketChannelMap().put(serviceaddress, client.getSocketChannel());
			Set<String> sets = ServerClientTransfer.getServiceMap().get(Constant.SRV_CENTER);
			if(sets == null) {
				sets = new HashSet<String>();
			}
			
			sets.add(serviceaddress);
			ServerClientTransfer.getServiceMap().put(Constant.SRV_CENTER, sets);
		}
		
		RegisterMsg regMsg = new RegisterMsg();
		regMsg.setPort(Daemon.getInstance().getPort());
		regMsg.setCport(regMsg.getPort());
		regMsg.setServerId(Constant.SRV_LOGIN);
		
		ServerClientTransfer.write(regMsg);
	}
}
