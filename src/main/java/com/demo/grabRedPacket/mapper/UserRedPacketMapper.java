package com.demo.grabRedPacket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.demo.grabRedPacket.model.UserRedPacket;

import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserRedPacketMapper extends BaseMapper<UserRedPacket>{
	/**
	 * 插入抢红包信息
	 * @param userRedPacket
	 * @return
	 */
	public int grapRedPacket(UserRedPacket userRedPacket);
}
