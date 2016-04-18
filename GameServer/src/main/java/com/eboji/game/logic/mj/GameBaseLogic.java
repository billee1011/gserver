package com.eboji.game.logic.mj;

import com.eboji.model.message.BaseMsg;


public abstract class GameBaseLogic {
	//游戏开始
	public abstract void start();
	
	//游戏过程处理
	public abstract void process(BaseMsg msg);
}
