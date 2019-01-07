package com.demo.grabRedPacket.service;


public interface UserRedPacketService {
	
	/**
	 * 保存抢红包信息
	 * @param redPacketId
	 * @param userUd
	 * @return
	 */
	public int grapRedPacket(Long redPacketId, Long userId);
}
