package com.ai.slp.balance.constants;

public class FunAccountLogConstants {

	public static final String UPDATE_MASK = "1";
	//
	public static String str32Zero(){
		StringBuilder str = new StringBuilder();
		//
		for(int i=0;i<32;i++){
			str.append("0");
		}
		//
		return str.toString();
	}

}
