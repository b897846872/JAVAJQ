package com.demo.grabRedPacket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.demo.grabRedPacket.model.RedPacket;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface RedPacketMapper extends BaseMapper<RedPacket>{
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
