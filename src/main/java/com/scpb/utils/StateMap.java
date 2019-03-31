package com.scpb.utils;

import java.util.HashMap;

public class StateMap {
	public static String getState(int state){
		HashMap<Integer, String> stateMap = new HashMap<>();
		stateMap.put(0, "审核中");
		stateMap.put(1, "审核未通过");
		stateMap.put(2, "待签收");
		stateMap.put(3, "正常流转");
		stateMap.put(4, "正常结算");
		stateMap.put(5, "逾期未结算");
		stateMap.put(6, "死亡");
		return stateMap.get(state);
	}
}
