package com.eboji.data.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.model.common.MsgType;
import com.eboji.model.message.BaseMsg;

public class DataServerHandler extends SimpleChannelInboundHandler<BaseMsg> {
	private static final Logger logger = LoggerFactory.getLogger(DataServerHandler.class);
	
	protected MemCacheClient memCacheClient = null;
	
	protected DataServerProcessor dataProcessor = null;
	
	public DataServerHandler(MemCacheClient memCacheClient, DataServerProcessor dataProcessor) {
		this.memCacheClient = memCacheClient;
		this.dataProcessor = dataProcessor;
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		DataServerClientMap.remove((SocketChannel)ctx.channel());
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String clientId = ctx.channel().remoteAddress().toString();
		DataServerClientMap.put(clientId, (SocketChannel)ctx.channel());
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg)
			throws Exception {
		try {
			MsgType type = msg.getT();
			
			switch (type) {
			case CONN:
			case PING:
				break;

			case DT_INSGGTABLE:
				dataProcessor.process(msg, ctx.channel().remoteAddress().toString());
				break;
				
			case DT_INSGGTABLERS:
				break;
			default:
				break;
			}
			
		} catch (Exception e) {
			logger.error("request param is not json object, request msg is:\n" + msg);
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		logger.info("remote address: " + ctx.channel().remoteAddress() + ", " + cause.getMessage()); 
	}
}
