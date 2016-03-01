package com.eboji.game.logic.mj;

import com.eboji.model.message.BaseMsg;


public abstract class GameBaseLogic {
	//洗牌
	public abstract void randMj(Byte[] mj, Integer mjMaxCount, Integer randCount);
	
	//麻将排序
	public abstract void sortMj(Byte[] mjHand, int mjHandCount);
	
	//开始
	public abstract void start();
	
	public abstract void process(BaseMsg msg);
}
