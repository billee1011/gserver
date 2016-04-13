package com.eboji.data.service;

import com.eboji.model.message.LoginMsg;
import com.eboji.persist.pojo.GgRoom;
import com.eboji.persist.pojo.GgRoomPlayer;
import com.eboji.persist.pojo.GuUser;


public interface DataService {
	GgRoom createRoom(int gameId, int gameType, long gamePrice, int uId);
	
	GgRoomPlayer joinRoom(int gameId, int roomNo, int uId);
	
	GuUser login(LoginMsg msg);
	
	void addLogin(int uId, String ip);
}
