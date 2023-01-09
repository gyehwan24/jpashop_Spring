package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpashopApplication.class, args);

		//버전확인
//		String getVersion = org.springframework.core.SpringVersion.getVersion();
//		System.out.println("버전---------:"+getVersion);
	}

}
