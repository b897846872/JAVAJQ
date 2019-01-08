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
		// 只有3次机会抢红包
		for (int i = 0; i < 3; i++) {
			// 获取红包信息
			RedPacket redPacket = redPacketMapper.getRedPacket(redPacketId);
			if (redPacket.getStock() > 0) {
				int update = redPacketMapper.devcreaseRedPacketForVersion(redPacket);
				// 如果没有数据更新，说明其他线程已经修改过数据，重新抢红包
				if (update == 0) {
					continue;
				}
				// 生成抢红包信息
				UserRedPacket userRedPacket = new UserRedPacket();
				userRedPacket.setRedPacketId(redPacketId);
				userRedPacket.setUserId(userId);
				userRedPacket.setAmount(redPacket.getUnitAmount());
				userRedPacket.setNote("抢红包" + redPacketId);
				// 插入抢红包信息
				int result = userRedPacketMapper.grapRedPacket(userRedPacket);
				return result;
			} else {
				// 一旦没有库存退出
				return FAILED;
			}
		}
		return FAILED;
		/*
		// 可以在100毫秒内无限次重新抢红包
		Long start = System.currentTimeMillis();
		while(true) {
			Long end = System.currentTimeMillis();
			if (end - start > 100) {
				return FAILED;
			}
			// 获取红包信息
			RedPacket redPacket = redPacketMapper.getRedPacket(redPacketId);
			// for update加锁
//			RedPacket redPacket = redPacketMapper.getRedPacketForUpdate(redPacketId);
			if (redPacket.getStock() > 0) {
//			redPacketMapper.devcreaseRedPacket(redPacketId);
				int update = redPacketMapper.devcreaseRedPacketForVersion(redPacket);
				// 如果没有数据更新，说明其他线程已经修改过数据，抢红包失败
				System.out.println(update+" Version="+redPacket.getVersion()+" redPacketId="+redPacketId);
				// 如果没有数据更新，说明其他线程已经修改过数据，重新抢红包
				if (update == 0) {
//					return FAILED;
					continue;
				}
				// 生成抢红包信息
				UserRedPacket userRedPacket = new UserRedPacket();
				userRedPacket.setRedPacketId(redPacketId);
				userRedPacket.setUserId(userId);
				userRedPacket.setAmount(redPacket.getUnitAmount());
				userRedPacket.setNote("抢红包" + redPacketId);
				// 插入抢红包信息
				int result = userRedPacketMapper.grapRedPacket(userRedPacket);
				return result;
			} else {
				// 一旦没有库存退出
				return FAILED;
			}
		}*/
	}

}
