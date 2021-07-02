package com.wenance.challenge.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.wenance.challenge.commons.models.BTCInfoRequest;
import com.wenance.challenge.commons.models.BTCInfoResponse;

@Service
public class BTCService {
	
	
	public void getBTCData(int seconds) {
		Gson gson = new Gson();
		Timer t = new Timer();
		seconds*=1000;
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
				try {
			        URL url = new URL("https://cex.io/api/last_price/BTC/USD");
			        HttpURLConnection con;
					con = (HttpURLConnection) url.openConnection();
			        con.setRequestMethod("GET");
			        con.connect();
			        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			        BTCInfoRequest info = gson.fromJson(reader.readLine(), BTCInfoRequest.class);
			        Date now = new Date();			     
			        info.setDate(now);
			        System.out.println(now);
			        BTCData.addInfo(info);
			        
				} catch (IOException e) {
					e.printStackTrace();
				}

		    }
		}, 10, seconds);
	}

	public String getPriceByDate(Date time) {
		return getDataByDate(time).getLprice();
	}
	public BTCInfoResponse getInfoBTCBetweenDates(Date from, Date to) {
		List<BTCInfoRequest> results=getDataBetweenDates(from,to);
		double average = getAverageByBTCList(results);
		double percent = getPercentBetweenAverageAndMax(getMaxPrice(), average);
		return new BTCInfoResponse(average, percent);
	}
	
	////-------------------PRIVATE---------------------///////
	
	private List<BTCInfoRequest> getDataBetweenDates(Date from, Date to) {
		System.out.println("Promedio entre: " + from + " y " + to);	
			List<BTCInfoRequest> results =
					BTCData.getData().stream().filter(i->i.getDate().compareTo(from)>0 && i.getDate().compareTo(to)<0)
					.collect(Collectors.toList());
			return results;
	}
	private double getAverageByBTCList(List<BTCInfoRequest> list){
		double sum = 0;
		for(BTCInfoRequest info : list) sum+=Double.parseDouble(info.getLprice()); 
		return sum/list.size();			
	}
	private double getPercentBetweenAverageAndMax(double average, double max){
		double dif = max-average;
		
		return dif/max*100;
	}
	private double getMaxPrice() {
		List<BTCInfoRequest> list = BTCData.getData();
		double max = list.stream().mapToDouble(i->Double.parseDouble(i.getLprice())).max().orElseThrow(NoSuchElementException::new);
		return max;
	}
	private BTCInfoRequest getDataByDate(Date time) {
		//RETORNA LA INFO MAS CERCANA AL HORARIO INGRESADO REDONDEADO PARA ARRIBA
		BTCInfoRequest result = BTCData.getData().stream().filter(i->i.getDate().compareTo(time) >0).findAny().get();
	return result;
}
}
