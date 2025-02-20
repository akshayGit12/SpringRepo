package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix="per.info")
@Component("pDetails")
@Data
public class PersonDetails {
	private String name;
	private String addrs;
	private Long mobileno;
	private Integer age;
	private Double salary;

}
