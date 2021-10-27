package com.kemalyanmaz.project001.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.kemalyanmaz.project001.models.Kisi;

public class Kisiler {

	List<Kisi> kisiler;
	
	BigDecimal toplamPara;

	
	public Kisiler() {
		
	}
	
	public List<Kisi> getKisiler() {
		return kisiler;
	}

	public void setKisiler(List<Kisi> kisiler) {
		this.kisiler = kisiler;
	}

	public BigDecimal getToplamPara() {
		return toplamPara;
	}

	public void setToplamPara(BigDecimal toplamPara) {
		this.toplamPara = toplamPara;
	}
	
	
	
	
}
