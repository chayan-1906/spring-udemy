package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			// create object mapper
			ObjectMapper objectMapper = new ObjectMapper();
			
			// read json file and map/convert to Java POJO: data/sample-lite.json
			Student student = objectMapper.readValue(
					new File("data/sample-full.json"),
					Student.class);

			// print firstName and lastName
			System.out.println("First Name: " + student.getFirstName());
			System.out.println("Last Name: " + student.getLastName());

			// print address & city
			Address address = student.getAddress();
			System.out.println("Street: " + address.getStreet());
			System.out.println("City: " + address.getCity());
			
			// print languages
			for (String lang : student.getLanguages()) {
				System.out.print(lang + " ");
			}
			System.out.println();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
