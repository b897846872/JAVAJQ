package com.demo.grabRedPacket.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.grabRedPacket.service.UserRedPacketService;

@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {
	@Autowired
	private UserRedPacketService userRedPacketService;
	
	@PostMapping("/grapRedPacket")
	public Map<String, Object> grapRedPacket(@RequestParam(required = true) Long redPacketId, 
				@RequestParam(required = true) Long userId)  {
		// 抢红包
		int result = userRedPacketService.grapRedPacket(redPacketId, userId);
		Boolean flag = result > 0;
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("success", flag);
		retMap.put("message", flag ? "抢红包成功" : "抢红包失败");
		return retMap;
	}
}
