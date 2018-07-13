package com.jason.boot.testOthers;

import org.junit.Test;

import com.jason.boot.common.utils.IdGen;
import com.jason.boot.common.utils.Md5Util;

public class TestOther {
	@Test
	public void test1(){
		for(int i = 0; i<3;i++){
			System.out.println(IdGen.createUUID());
		}
		System.out.println(Md5Util.encode("11111111"));
	}
}
