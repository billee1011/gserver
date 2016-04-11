package com.eboji.data.service;

import com.eboji.persist.pojo.GgRoom;


public interface DataService {
	GgRoom createRoom(int gameId, int gameType, long gamePrice, int uId);
	
	void addLogin(int uId, String ip);
}
