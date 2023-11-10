package com.ltp.workbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkbookApplication {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		System.out.println("Why isn't this restarting?");
		SpringApplication.run(WorkbookApplication.class, args);
	}
}
