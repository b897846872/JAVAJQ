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
	 * 获取红包信息,使用for update加锁
	 * @param id
	 * @return
	 */
	public RedPacket getRedPacketForUpdate(Long id);
	/**
	 * 扣减抢红包数
	 * @param id
	 * @return
	 */
	public int devcreaseRedPacket(Long id);
	
	public int devcreaseRedPacketForVersion(RedPacket redPacket);

}
