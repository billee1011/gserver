package com.eboji.game.server.transfer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eboji.commons.msg.BaseMsg;
import com.eboji.commons.msg.CreateRoomResMsg;
import com.eboji.commons.msg.JoinRoomResMsg;
import com.eboji.commons.msg.PingMsg;
import com.eboji.commons.msg.RegisterResMsg;
import com.eboji.commons.type.MsgType;
import com.eboji.game.bootstrap.Daemon;
import com.eboji.game.server.GameServerCfgMap;
import com.eboji.game.server.GameServerClientMap;
import com.eboji.game.vo.GameRoomVO;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

public class TransferHandler extends SimpleChannelInboundHandler<BaseMsg> {
	private static final Logger logger = LoggerFactory.getLogger(TransferHandler.class);
	
	//利用写空闲发送心跳检测消息
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		if(evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent)evt;
			switch (e.state()) {
			default:
				PingMsg pingMsg = new PingMsg();
				pingMsg.setType(String.valueOf(e.state()));
				pingMsg.setCport(Daemon.getInstance().getPort());
				ctx.writeAndFlush(pingMsg);
				break;
			}
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("remote address: " + ctx.channel().remoteAddress() + " connect success!");
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, BaseMsg msg)
			throws Exception {
		MsgType msgType = msg.getT();
		switch (msgType) {
		case PING:
		case CONNRES:
			break;
		case REGRES:		//中心注册响应
			RegisterResMsg regResMsg = (RegisterResMsg)msg;
			Map<String, Set<String>> sets = regResMsg.getServiceMap();
			TransferProcessor.parse(sets);
			logger.info("注册中心广播服务创建连接成功!");
			break;
			
		default:
			processTransfer(msg);
			break;
		}
		
		ReferenceCountUtil.release(msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		//删除相应的连接
		String remote = ctx.channel().remoteAddress().toString();
		String remoteAddress = remote.substring(1);
		TransferProcessor.remove(remoteAddress);
		logger.error("remote address: " + ctx.channel().remoteAddress() + ", " + cause.getMessage());
	}
	
	protected void processTransfer(BaseMsg msg) {
		if(msg instanceof CreateRoomResMsg) {
			if(msg.getRoomNo() != 0) {
				Map<String, String> uMap = new HashMap<String, String>();
				uMap.put(msg.getUid(), msg.getRas());
				
				GameRoomVO vo = new GameRoomVO();
				vo.setGid(msg.getGid());
				vo.setRoomNo(msg.getRoomNo());
				vo.setuMap(uMap);
				
				GameServerCfgMap.getRoomMap().put(msg.getRoomNo(), vo);
			}
		} else if(msg instanceof JoinRoomResMsg) {
			JoinRoomResMsg res = (JoinRoomResMsg)msg;
			if(res.getStatus() != null && res.getStatus() == 1) {
				GameServerCfgMap.getRoomMap().get(msg.getRoomNo()).getuMap()
					.put(res.getUid(), res.getRas());
			}
		}
		
		if(msg.getRas() != null && !msg.getRas().equals("")) {
			GameServerClientMap.get(msg.getRas()).writeAndFlush(msg);
		}
	}
}
