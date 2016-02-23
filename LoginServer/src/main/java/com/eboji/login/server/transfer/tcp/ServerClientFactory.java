package com.eboji.login.server.transfer.tcp;

import java.util.HashSet;
import java.util.Set;

import com.eboji.login.server.transfer.tcp.connection.ServerClientConnection;
import com.eboji.model.constant.Constant;

public class ServerClientFactory {
	public static void initConnection(String host, int port, int serviceId) {
		ServerClientConnection client = new ServerClientConnection(port, host);
		Set<String> serviceSet = ServerClientTransfer.getServiceMap().get(serviceId);
		String serveraddress = host + Constant.STR_COLON + port;
		if(serviceSet != null) {
			serviceSet.add(serveraddress);
			ServerClientTransfer.getServiceMap().put(serviceId, serviceSet);
		} else {
			Set<String> set = new HashSet<String>();
			set.add(serveraddress);
			ServerClientTransfer.getServiceMap().put(serviceId, set);
		}
		ServerClientTransfer.getSocketChannelMap().put(serveraddress, client.getSocketChannel());
	}
}
