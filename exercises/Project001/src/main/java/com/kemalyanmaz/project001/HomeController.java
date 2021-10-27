package com.kemalyanmaz.project001;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalyanmaz.project001.dtos.Kisiler;
import com.kemalyanmaz.project001.models.Kisi;

@RestController
@RequestMapping(path="/users")
public class HomeController {

	
	@RequestMapping
	public Kisiler get() {
		List<Kisi> kisilerList = Arrays.asList(
				new Kisi("Kemal","Yanmaz",BigDecimal.valueOf(1000)),
				new Kisi("Ulaş","Yanmaz",BigDecimal.valueOf(6000))	
		);
		
		Kisiler kisiler = new Kisiler();
		kisiler.setKisiler(kisilerList);
		BigDecimal para=BigDecimal.valueOf(0);
		
		for(Kisi kisi : kisilerList) {
			para.add(kisi.getBudget());
		}

		kisiler.setToplamPara(para);
		return kisiler;
	}
}
