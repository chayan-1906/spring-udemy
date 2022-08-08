package com.pdas.springdemoannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: Inside default constructor");
	}

	// define my init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("> TennisCoach: inside of doMyStartUpStuff");
	}

	// define my destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("> TennisCoach: inside of doMyCleanUpStuff");
	}

	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService theFortuneService) {
	 * System.out.println(">> TennisCoach: Inside doSomeCrazyStuff() method");
	 * fortuneService = theFortuneService; }
	 */

	// define a setter method
	/*
	 * @Autowired public void setFortuneService(FortuneService theFortuneService) {
	 * System.out.println(">> TennisCoach: Inside setFortuneService() method");
	 * fortuneService = theFortuneService; }
	 */

	/*
	 * @Autowired public TennisCoach(FortuneService theFortuneService) {
	 * fortuneService = theFortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
