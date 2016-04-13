package com.eboji.data.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eboji.data.service.DataService;
import com.eboji.data.util.ConfigUtil;
import com.eboji.model.message.LoginMsg;
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
import com.eboji.persist.pojo.GgRoomExample;
import com.eboji.persist.pojo.GgRoomPlayer;
import com.eboji.persist.pojo.GuLogin;
import com.eboji.persist.pojo.GuUser;
import com.eboji.persist.pojo.GuUserExample;

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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String remark = sdf.format(new Date(start));
		while(true) {
			try {
				int roomNo = RandomUtil.getRandomRoomNo(10000, 99999);
				room = new GgRoom();
				room.setGameid(gameId);
				room.setGametype(gameType);
				room.setGameprice(gamePrice);
				room.setRoomno(roomNo);
				room.setRound(1);
				room.setPlayers(1);
				room.setRemark(remark);
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
		roomPlayer.setUid(uId);
		roomPlayer.setCreatetime(new Date(System.currentTimeMillis()));
		roomPlayer.setPosition(1);
		ggRoomPlayerMapper.insertSelective(roomPlayer);
		
		return room;
	}

	@Override
	public void addLogin(int uId, String ip) {
		GuLogin login = new GuLogin();
		login.setUid(uId);
		login.setIp(ip);
		guLoginMapper.insertSelective(login);
	}

	@Override
	@Transactional
	public GuUser login(LoginMsg msg) {
		GuUserExample example = new GuUserExample();
		example.createCriteria().andUsernameEqualTo(msg.getUsername());
		List<GuUser> users = guUserMapper.selectByExample(example);
		GuUser user = null;
		if(users != null && users.size() > 0) {
			user = users.get(0);
		} else {
			user = new GuUser();
			user.setUsername(msg.getUsername());
			user.setNickname(msg.getNickname());
			user.setIconurl(msg.getIconurl());
			guUserMapper.insertSelective(user);
		}
		
		addLogin(user.getId(), msg.getIp());
		
		return user;
	}

	@Override
	@Transactional
	public GgRoomPlayer joinRoom(int gameId, int roomNo, int uId) {
		GgRoomPlayer ret = null;
		GgRoomExample example = new GgRoomExample();
		example.createCriteria()
			.andRoomnoEqualTo(roomNo)
			.andStatusEqualTo(1)
			.andGameidEqualTo(gameId);
			
		List<GgRoom> rooms = ggRoomMapper.selectLockByExample(example);
		if(rooms != null && rooms.size() > 0) {
			GgRoom room = rooms.get(0);
			String counts = ConfigUtil.getProps(gameId + "_counts") == null 
					? "0" :ConfigUtil.getProps(gameId + "_counts");
			if(room.getPlayers() < Integer.parseInt(counts)) {
				GgRoom record = new GgRoom();
				record.setPlayers(room.getPlayers() + 1);
				record.setId(room.getId());
				ggRoomMapper.updateByPrimaryKeySelective(record);
				
				GgRoomPlayer player = new GgRoomPlayer();
				player.setCreatetime(new Date(System.currentTimeMillis()));
				player.setRoomid(room.getId());
				player.setUid(uId);
				player.setPosition(room.getPlayers() + 1);
				ggRoomPlayerMapper.insertSelective(player);
				ret = player;
			} else {
				//满员
				ret = new GgRoomPlayer();
				ret.setId(-1);
			}
		}
		
		return ret;
	}
}
