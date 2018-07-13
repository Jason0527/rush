package com.jason.boot.specific.rush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.boot.common.base.ResponseResult;
import com.jason.boot.specific.rush.entity.RushStatEnum;
import com.jason.boot.specific.rush.service.RushService;
/**
 * 负责半价抢购的controller
 * @author jason
 */
@Controller
@RequestMapping("rush")
public class RushController {
	@Autowired
	private RushService rushService;
	@RequestMapping(value="{loginNo}/{heroName}",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult rushHero(@PathVariable("loginNo")String loginNo,@PathVariable("heroName")String heroName){
		RushStatEnum rushEnum = rushService.rush(loginNo, heroName);
		return new ResponseResult(rushEnum.getState(),rushEnum.getStateInfo());
	}
	@RequestMapping(value="page",method = RequestMethod.GET)
	public String rushPage(){
		return "rush";
	}
}
