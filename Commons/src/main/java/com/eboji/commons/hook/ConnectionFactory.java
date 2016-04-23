package com.eboji.commons.hook;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.eboji.commons.Constant;
import com.eboji.commons.msg.RegisterMsg;

import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

public class ConnectionFactory {
	/**
	 * 向中心服务进行服务注册
	 * @param centerServers
	 * @param handler
	 * @param cport
	 * @param socketChannelMap
	 * @param serverMap
	 * @param serverName
	 */
	public static void registerServiceToCenterServer(String centerServers, 
			SimpleChannelInboundHandler<?> handler, int cport, 
			Map<String, SocketChannel> socketChannelMap, 
			Map<String, Set<String>> serverMap, String serverName) throws Exception {
		String[] servicesArr = centerServers.split("\\|");
		for(String service : servicesArr) {
			String[] components = service.split(Constant.STR_COLON);
			String host = components[0];
			int port = Integer.parseInt(components[1]);
			
			ConnectionBuilder client = new ConnectionBuilder(port, host, handler);
			socketChannelMap.put(service, client.getSocketChannel());
			if(serverMap.get(Constant.SRV_CENTER) == null) {
				Set<String> servers = new HashSet<>();
				servers.add(service);
				serverMap.put(Constant.SRV_CENTER, servers);
			} else {
				serverMap.get(Constant.SRV_CENTER).add(service);
			}
			
			RegisterMsg regMsg = new RegisterMsg();
			regMsg.setCport(cport);
			regMsg.setServer(serverName);
			
			client.getSocketChannel().writeAndFlush(regMsg);
		}
	}
	
	public static void registerGameServiceToCenterServer(String centerServers, 
			SimpleChannelInboundHandler<?> handler, int cport, 
			Map<String, SocketChannel> socketChannelMap, 
			Map<String, Set<String>> serverMap, String serverName, String gameNames) {
		String[] servicesArr = centerServers.split("\\|");
		for(String service : servicesArr) {
			String[] components = service.split(Constant.STR_COLON);
			String host = components[0];
			int port = Integer.parseInt(components[1]);
			
			ConnectionBuilder client = new ConnectionBuilder(port, host, handler);
			socketChannelMap.put(service, client.getSocketChannel());
			if(serverMap.get(Constant.SRV_CENTER) == null) {
				Set<String> servers = new HashSet<>();
				servers.add(service);
				serverMap.put(Constant.SRV_CENTER, servers);
			} else {
				serverMap.get(Constant.SRV_CENTER).add(service);
			}
			
			if(gameNames != null && !"".equals(gameNames)) {
				RegisterMsg regMsg = new RegisterMsg();
				regMsg.setCport(cport);
				regMsg.setServer(serverName + Constant.STR_UNDERLINE + gameNames);
				client.getSocketChannel().writeAndFlush(regMsg);
			}
		}
	}
}
