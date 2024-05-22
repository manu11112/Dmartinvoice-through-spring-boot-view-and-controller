package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class Mycontroller {

   static double discount;

	@RequestMapping("/invoice")
	public String invoice() {
		
		return "invoice";
	}
    
	@RequestMapping("/result")
	public String result(@RequestParam int cid, @RequestParam String cname, @RequestParam long phone,@RequestParam  String pname, @RequestParam double price, @RequestParam int quantity, ModelMap model) {
		model.put("key1",cid);
		model.put("key2", cname);
		model.put("key3", phone );
		model.put("key4", pname);
		model.put("key5", price);
		model.put("key6", quantity);
		
		double total;
		total=(price*quantity);
		model.put("totalkey", total);
		if(total<=5000) {
			discount=(total*0.1);
		}
		if(total<=10000) {
			discount=(total*0.15);
		}
		
		else {
			discount=(total*0.2);
		}
		
		model.put("discount", discount);
		double invoice=(double) (total-discount);
		 model.put("invoicekey", invoice);
		 
		 
		
		return "result";
	}
}
