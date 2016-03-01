package com.eboji.game.logic.mj.zzmj;

/**
 * 转转麻将类型结构
 * @author zhoucl
 */
public enum ZZMJBlockType {
	BLOCK_NULL,				//无
	BLOCK_SHUN,				//顺子
	BLOCK_PENG,				//碰子结构，三个相同
	BLOCK_KE,				//刻子结构，三个相同，非碰
	BLOCK_GANG,				//杠子结构
	BLOCK_AN_GANG			//暗杠结构
}
