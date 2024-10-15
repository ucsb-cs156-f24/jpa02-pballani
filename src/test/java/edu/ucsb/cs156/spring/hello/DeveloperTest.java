package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Priyanka", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("pballani", Developer.getGithubId());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

   @Test 
   public void getTeam_retuens_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("f24-03", t.getName());
   }
    @Test 
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Bharat"),"Team should contain Bharat");
        assertTrue(t.getMembers().contains("Chris C"),"Team should contain Chris C");
        assertTrue(t.getMembers().contains("Chloe"),"Team should contain Chloe");
        assertTrue(t.getMembers().contains("Sameer"),"Team should contain Sameer");
        assertTrue(t.getMembers().contains("Eugene L"),"Team should contain Eugene L");
        assertTrue(t.getMembers().contains("Priyanka"),"Team should contain Priyanka");
    }
}
