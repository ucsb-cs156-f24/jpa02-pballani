package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assert(team.getName().equals("test-team"));
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void testSameObject() {
        team = new Team("test-team");
        assertTrue(team.equals(team));
    }

    @Test
    public void testDifferentClass() {
        String notATeam = "Not a team";
        assertFalse(team.equals(notATeam));
    }

    @Test
    public void testSameNameAndMembers() {
        Team sameTeam = new Team("test-team");
        sameTeam.setMembers(team.getMembers());
        assertTrue(team.equals(sameTeam));
    }

    @Test
    public void testSameNameDifferentMembers() {
        Team otherMembers = new Team("test-team");
        otherMembers.addMember("Snoopy");
        assertFalse(team.equals(otherMembers));
    }

    @Test
    public void testDifferentNameSameMembers() {
        Team otherName = new Team("other-team");
        otherName.setMembers(team.getMembers());
        assertFalse(team.equals(otherName));
    }

    @Test
    public void testDifferentNameDifferentMembers() {
        Team otherNamesAndMembers = new Team("other-team");
        otherNamesAndMembers.addMember("Snoopy");
        assertFalse(team.equals(otherNamesAndMembers));
    }

    @Test
    public void testHashCodeSameContent() {
        Team team = new Team("test-team");
        Team otherTeam = new Team("test-team");
        ArrayList<String> members = new ArrayList<>();
        members.add("Snoopy");
        team.setMembers(members);
        otherTeam.setMembers(members);

        assertEquals(team.hashCode(), otherTeam.hashCode());
    }

    @Test
    public void testHashCodeSpecificValue() {
        Team t = new Team("test-team");
        int result = t.hashCode;
        int expected = result;
        assertEquals(result, expected);
    }
}