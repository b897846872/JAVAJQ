package com.demo.grabRedPacket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.grabRedPacket.mapper.RedPacketMapper;
import com.demo.grabRedPacket.model.RedPacket;

@Service
public class RedPacketServiceImpl implements RedPacketService {
	
	@Autowired
	private RedPacketMapper redPacketMapper;
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public RedPacket getRedPacket(Long id) {
		return redPacketMapper.getRedPacket(id);
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int devcreaseRedPacket(Long id) {
		return redPacketMapper.devcreaseRedPacket(id);
	}

}
