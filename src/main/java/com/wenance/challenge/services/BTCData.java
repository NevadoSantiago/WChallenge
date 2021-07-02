package com.wenance.challenge.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wenance.challenge.models.BTCInfoRequest;

@Service
public class BTCData {

	private static List<BTCInfoRequest> info = new ArrayList<>();

	public static void addInfo(BTCInfoRequest inf) {
		info.add(inf);
	}
	public static List<BTCInfoRequest> getData() {
		return info;
	}
}
