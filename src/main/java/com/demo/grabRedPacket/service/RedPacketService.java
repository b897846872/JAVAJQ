package com.demo.grabRedPacket.service;

import com.demo.grabRedPacket.model.RedPacket;

public interface RedPacketService {
	/**
	 * 获取红包信息
	 * @param id
	 * @return
	 */
	public RedPacket getRedPacket(Long id);
	/**
	 * 扣减抢红包数
	 * @param id
	 * @return
	 */
	public int devcreaseRedPacket(Long id);

}
