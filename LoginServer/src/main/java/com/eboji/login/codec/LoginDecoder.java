package com.eboji.login.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eboji.model.common.MsgType;
import com.eboji.model.constant.Constant;

/**
 * LoginServer的自定义解码类
 * @author zhoucl 2016-02-21
 *
 */
public class LoginDecoder extends ByteToMessageDecoder {
	private final int HEAD_LENGTH = 4;
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		//这个HEAD_LENGTH是我们用于表示头长度的字节数。  由于上面我们传的是一个int类型的值，所以这里HEAD_LENGTH的值为4.
		if(in.readableBytes() < HEAD_LENGTH) {	
			return;
		}
		
		in.markReaderIndex();					//我们标记一下当前的readIndex的位置
		int dataLength = in.readInt();			//读取传送过来的消息的长度。ByteBuf 的readInt()方法会让他的readIndex增加4
		if(dataLength < 0) {					//我们读到的消息体长度为0，这是不应该出现的情况，这里出现这情况，关闭连接。
			ctx.close();
		}
		
		if(in.readableBytes() < dataLength) {	//读到的消息体长度如果小于我们传送过来的消息长度，则resetReaderIndex. 这个配合markReaderIndex使用的。把readIndex重置到mark的地方
			in.resetReaderIndex();
			return;
		}
		
		byte[] body = new byte[dataLength];		//这时候，我们读到的长度，满足我们的要求了，把传送过来的数据取出来
		in.readBytes(body);
		
		//将byte数据转化为我们需要的对象。序列化
		String sbody = new String(body, "UTF-8");
		JSONObject obj = JSON.parseObject(sbody);
		String clazzName = MsgType.valueOf(obj.getString(Constant.KEY_TYPE)).getClazz();
		Class<?> clazz = Class.forName(clazzName).newInstance().getClass();
		Object o = JSON.toJavaObject(obj, clazz);
		out.add(o);
		
	}

}
