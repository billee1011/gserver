package com.eboji.data.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eboji.data.service.DataService;
import com.eboji.model.util.RandomUtil;
import com.eboji.persist.dao.GcOffDepositMapper;
import com.eboji.persist.dao.GcRatioCoinMapper;
import com.eboji.persist.dao.GcRatioTaxMapper;
import com.eboji.persist.dao.GfRankMapper;
import com.eboji.persist.dao.GfRewardMapper;
import com.eboji.persist.dao.GfScoreMapper;
import com.eboji.persist.dao.GgHistMapper;
import com.eboji.persist.dao.GgRoomMapper;
import com.eboji.persist.dao.GgRoomPlayerMapper;
import com.eboji.persist.dao.GuLoginMapper;
import com.eboji.persist.dao.GuUserMapper;
import com.eboji.persist.pojo.GgRoom;
import com.eboji.persist.pojo.GgRoomPlayer;
import com.eboji.persist.pojo.GuLogin;

@Service("dataService")
public class DataServiceImpl implements DataService {
	private static final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);
	
	@Autowired
	GcOffDepositMapper gcOffDepositMapper;
	
	@Autowired
	GcRatioCoinMapper gcRatioCoinMapper;
	
	@Autowired
	GcRatioTaxMapper gcRatioTaxMapper;
	
	@Autowired
	GfRankMapper gfRankMapper;
	
	@Autowired
	GfRewardMapper gfRewardMapper;
	
	@Autowired
	GfScoreMapper gfScoreMapper;
	
	@Autowired
	GgHistMapper ggHistMapper;
	
	@Autowired
	GgRoomMapper ggRoomMapper;
	
	@Autowired
	GgRoomPlayerMapper ggRoomPlayerMapper;
	
	@Autowired
	GuLoginMapper guLoginMapper;

	@Autowired
	GuUserMapper guUserMapper;
	
	@Override
	@Transactional
	public GgRoom createRoom(int gameId, int gameType, long gamePrice, int uId) {
		GgRoom room = null;
		int count = 1;
		int row = 0;
		long start = System.currentTimeMillis();
		while(true) {
			try {
				int roomNo = RandomUtil.getRandomRoomNo(10000, 99999);
				room = new GgRoom();
				room.setGameid(gameId);
				room.setGametype(gameType);
				room.setGameprice(gamePrice);
				room.setRoomno(roomNo);
				row = ggRoomMapper.insertSelective(room);
				if(row > 0) 
					break;
			} catch (Exception e) {
				count++;
				
				if(System.currentTimeMillis() - start >= 2000) {
					break;
				}
			}
		}
		
		logger.debug("生成房间号的次数:" + count);
		
		GgRoomPlayer roomPlayer = new GgRoomPlayer();
		roomPlayer.setRoomid(room.getId());
		roomPlayer.setEuid(uId);
		roomPlayer.setCreatetime(new Date(System.currentTimeMillis()));
		ggRoomPlayerMapper.insertSelective(roomPlayer);
		
		return room;
	}

	@Override
	@Transactional
	public void addLogin(int uId, String ip) {
		GuLogin login = new GuLogin();
		login.setUid(uId);
		login.setIp(ip);
		guLoginMapper.insertSelective(login);
	}
}
