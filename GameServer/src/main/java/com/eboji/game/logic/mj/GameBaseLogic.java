package com.eboji.game.logic.mj;

import com.eboji.model.message.BaseMsg;


public abstract class GameBaseLogic {
	/**
	 * 游戏开始
	 */
	public abstract void start();
	
	/**
	 * 游戏过程处理<br />
	 * 依据不同游戏的实际处理逻辑，进行逻辑判断
	 * @param msg
	 */
	public abstract void process(BaseMsg msg);
}
