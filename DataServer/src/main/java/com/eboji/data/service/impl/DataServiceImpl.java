package com.eboji.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eboji.data.dao.BkAccountMapper;
import com.eboji.data.dao.BkConsumeMapper;
import com.eboji.data.dao.BkRechargeMapper;
import com.eboji.data.dao.GameHistMapper;
import com.eboji.data.dao.GameScoreMapper;
import com.eboji.data.dao.GameTableMapper;
import com.eboji.data.dao.WxUserMapper;
import com.eboji.data.pojo.GameTable;
import com.eboji.data.service.DataService;

@Service("dataService")
public class DataServiceImpl implements DataService {
	@Autowired
	private BkAccountMapper bkAccountMapper;
	
	@Autowired
	private BkConsumeMapper bkConsumeMapper;
	
	@Autowired
	private BkRechargeMapper bkRechargeMapper;
	
	@Autowired
	private GameHistMapper gameHistMapper;
	
	@Autowired
	private GameScoreMapper gameScoreMapper;
	
	@Autowired
	private GameTableMapper gameTableMapper;
	
	@Autowired
	private WxUserMapper wxUserMapper;

	@Override
	public int insGGTable(GameTable gt) {
		int row = gameTableMapper.insertSelective(gt);
		if(row > 0) {
			return gt.getId();
		} else {
			return 0;
		}
	}
}
