package com.demo.grabRedPacket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.grabRedPacket.mapper.RedPacketMapper;
import com.demo.grabRedPacket.mapper.UserRedPacketMapper;
import com.demo.grabRedPacket.model.RedPacket;
import com.demo.grabRedPacket.model.UserRedPacket;

@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {
	
	@Autowired
	private RedPacketMapper redPacketMapper;
	@Autowired
	private UserRedPacketMapper userRedPacketMapper;
	
	// 失败
	private static final int FAILED = 0;
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int grapRedPacket(Long redPacketId, Long userId) {
		// 获取红包信息
		RedPacket redPacket = redPacketMapper.getRedPacket(redPacketId);
		if (redPacket.getStock() > 0) {
			redPacketMapper.devcreaseRedPacket(redPacketId);
			// 生成抢红包信息
			UserRedPacket userRedPacket = new UserRedPacket();
			userRedPacket.setRedPacketId(redPacketId);
			userRedPacket.setUserId(userId);
			userRedPacket.setAmount(redPacket.getUnitAmount());
			userRedPacket.setNote("抢红包" + redPacketId);
			// 插入抢红包信息
			int result = userRedPacketMapper.grapRedPacket(userRedPacket);
			return result;
		}
		
		return FAILED;
	}

}
