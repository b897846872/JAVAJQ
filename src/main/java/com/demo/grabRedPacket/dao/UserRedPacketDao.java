package com.demo.grabRedPacket.dao;

import com.demo.grabRedPacket.model.UserRedPacket;

public interface UserRedPacketDao {
	/**
	 * 插入抢红包信息
	 * @param userRedPacket
	 * @return
	 */
	public int grapRedPacket(UserRedPacket userRedPacket);
}
