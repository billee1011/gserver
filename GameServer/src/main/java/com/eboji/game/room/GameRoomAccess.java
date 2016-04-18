package com.eboji.game.room;

import com.eboji.commons.util.memcached.MemCacheClient;
import com.eboji.model.message.BaseMsg;

/**
 * 游戏房间操作相关的接口类
 * @author zhoucl
 */
public interface GameRoomAccess {
	/**
	 * 创建房间
	 */
	public void createRoomFunc(MemCacheClient client, BaseMsg obj);
	
	/**
	 * 加入房间
	 */
	public void joinRoonFunc(MemCacheClient client, BaseMsg obj);
	
	/**
	 * 进入直播房间
	 */
	public void joinLiveRoomFunc();
	
	/**
	 * 解散房间
	 */
	public void dismissRoomFunc();
}
