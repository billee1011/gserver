package com.eboji.im.codec;

import com.alibaba.fastjson.JSON;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MsgEncoder extends MessageToByteEncoder<Object> {
	@Override
	protected void encode(ChannelHandlerContext ctx, Object obj, ByteBuf out)
			throws Exception {
		String sbody = JSON.toJSONString(obj);
		byte[] body = sbody.getBytes("UTF-8");
		int dataLength = body.length;
		out.writeInt(dataLength);
		out.writeBytes(body);
	}
}
