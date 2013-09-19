package com.github.diegopacheco.scala.playground.spring.tets;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.diegopacheco.scala.playground.spring.SoccerTeam;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-test-beans.xml" })
public class SoccerTeamTestSpring {
	
	@Inject @Named("teams") 
	private ArrayList<SoccerTeam>  teams;
	
	@Test
	public void testSpringInjectionScalaBeanProperyList(){
		Assert.assertNotNull(teams);
		System.out.println(teams);
	}
	
}
