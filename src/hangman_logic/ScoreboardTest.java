package hangman_logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreboardTest {

	/*
	 * Test case for the default constructor of scoreboard and no users added
	 */
	@Test
	public void testCase1() {
		Scoreboard scoreboard = new Scoreboard();
		String[] myArr = null;
		assertEquals("Testing creation of scoreboard using default constructor: ", 0, scoreboard.getScoreboard().getLength());
		assertArrayEquals("Testing retrieving of usernames - no usernames: ", scoreboard.retrieveUserNames(), myArr);
		
	}// testCase1()
	
	
	/*
	 * Test case for the default construct of scoreboard and the default constructor of the user
	 */
	@Test
	public void testCase7() {
		Scoreboard scoreboard = new Scoreboard();
		User user1 =  new User();
		String[] myArr = {"unknown"};
		
		scoreboard.addUser(user1);
		
		assertEquals("Testing creation of scoreboard using default constructor: ", 1, scoreboard.getScoreboard().getLength());
		assertArrayEquals("Testing retrieving of usernames - 1 user, default constructor: ", scoreboard.retrieveUserNames(), myArr);
		assertEquals("Testing total games set properly by default constructor: ", scoreboard.getScoreboard().getElementAt(0).getTotalGames(), 0);
		assertEquals("Testing total games won set properly by default constructor: ", scoreboard.getScoreboard().getElementAt(0).getTotalWins(), 0);

	}
	
	
	/*
	 * Test case for the default constructor of scoreboard and the addition of one user and associated methods
	 */
	@Test
	public void testCase2() {
		Scoreboard scoreboard = new Scoreboard();
		User user = new User("Jane");
		String [] myArr = {"Jane"};
		scoreboard.addUser(user);
		
		
		assertEquals("Testing addition of one user - length: ", 1, scoreboard.getScoreboard().getLength());
		assertTrue("Testing addition of one user - user exists: ", scoreboard.checkForUser(user));
		assertEquals("Testing addition of one user - user found: ", user, scoreboard.findUser("Jane"));
		
		assertEquals("Testing addition of one user - toString()", scoreboard.toString(), "Jane\n");
		assertEquals("Testing addition of one user - user logic: toString()", scoreboard.getScoreboard().getElementAt(0).toString(), "Jane has played a total of 0 games and has won 0");
	
		assertArrayEquals("Testing retrieving of usernames - no usernames: ", scoreboard.retrieveUserNames(), myArr);
		
		assertEquals("Testing addition of one user - searching for user that doesn't exist: ", scoreboard.findUser("John"), null);

	}// testCase2()
	
	
	/*
	 * Test case multiple users added and associated methods
	 */
	@Test
	public void testCase3() {
		Scoreboard scoreboard = new Scoreboard();
		User user0 = new User("AAAA");
		User user1 = new User("Jane");
		User user2 = new User("John Smith");
		User user3 = new User("1234");
		User user4 = new User("Hangman!! Master@!");
		User user5 = new User("ZZTop");
		User user6 = new User("aaa");
		
		scoreboard.addUser(user0);
		scoreboard.addUser(user1);
		scoreboard.addUser(user2);
		scoreboard.addUser(user3);
		scoreboard.addUser(user4);
		scoreboard.addUser(user5);
		scoreboard.addUser(user6);
		
		String[] myArr = {"1234", "aaa", "AAAA", "Hangman!! Master@!", "Jane", "John Smith", "ZZTop"};
		
		assertEquals("Testing addition of multiple users - length: ", 7, scoreboard.getScoreboard().getLength());
		
		assertTrue("Testing addition of multiple users - user0 exists: ", scoreboard.checkForUser(user0));
		assertTrue("Testing addition of multiple users - user1 exists: ", scoreboard.checkForUser(user1));
		assertTrue("Testing addition of multiple users - user2 exists: ", scoreboard.checkForUser(user2));
		assertTrue("Testing addition of multiple users - user3 exists: ", scoreboard.checkForUser(user3));
		assertTrue("Testing addition of multiple users - user4 exists: ", scoreboard.checkForUser(user4));
		assertTrue("Testing addition of multiple users - user5 exists: ", scoreboard.checkForUser(user5));
		assertTrue("Testing addition of multiple users - user6 exists: ", scoreboard.checkForUser(user6));
		
		assertEquals("Testing addition of one user - user0 found: ", user0, scoreboard.findUser("AAAA"));
		assertEquals("Testing addition of one user - user1 found: ", user1, scoreboard.findUser("Jane"));
		assertEquals("Testing addition of one user - user2 found: ", user2, scoreboard.findUser("John Smith"));
		assertEquals("Testing addition of one user - user3 found: ", user3, scoreboard.findUser("1234"));
		assertEquals("Testing addition of one user - user4 found: ", user4, scoreboard.findUser("Hangman!! Master@!"));
		assertEquals("Testing addition of one user - user5 found: ", user5, scoreboard.findUser("ZZTop"));
		assertEquals("Testing addition of one user - user6 found: ", user6, scoreboard.findUser("aaa"));	
		
		assertEquals("Testing addition of multiple users - toString() in alphabetic order", scoreboard.toString(), "1234\n" + 
				"aaa\n" + 
				"AAAA\n" + 
				"Hangman!! Master@!\n" + 
				"Jane\n" + 
				"John Smith\n" + 
				"ZZTop\n");
		
		assertEquals("Testing addition of multiple users - user '1234' logic: toString()", scoreboard.getScoreboard().getElementAt(0).toString(), "1234 has played a total of 0 games and has won 0");
		assertEquals("Testing addition of multiple users - user 'aaa' logic: toString()", scoreboard.getScoreboard().getElementAt(1).toString(), "aaa has played a total of 0 games and has won 0");
		assertEquals("Testing addition of multiple users - user 'AAAA' logic: toString()", scoreboard.getScoreboard().getElementAt(2).toString(), "AAAA has played a total of 0 games and has won 0");
		assertEquals("Testing addition of multiple users - user 'Hangman!! Master@!' logic: toString()", scoreboard.getScoreboard().getElementAt(3).toString(), "Hangman!! Master@! has played a total of 0 games and has won 0");
		assertEquals("Testing addition of multiple users - user 'Jane' logic: toString()", scoreboard.getScoreboard().getElementAt(4).toString(), "Jane has played a total of 0 games and has won 0");
		assertEquals("Testing addition of multiple users - user 'John Smith' logic: toString()", scoreboard.getScoreboard().getElementAt(5).toString(), "John Smith has played a total of 0 games and has won 0");
		assertEquals("Testing addition of multiple users - user 'ZZTop' logic: toString()", scoreboard.getScoreboard().getElementAt(6).toString(), "ZZTop has played a total of 0 games and has won 0");

		assertArrayEquals("Testing addition of multiple users array: ", scoreboard.retrieveUserNames(), myArr);
		
		assertEquals("Testing addition of multiple users - searching for user that doesn't exist: ", scoreboard.findUser("Bob"), null);
	}// TestCase2
	
	/*
	 * Test case users setters and getters of games used
	 */
	@Test
	public void testCase9() {
Scoreboard scoreboard = new Scoreboard();
		
		User user1 = new User("Jane");
		user1.setTotalGames(4);
		user1.setTotalWins(2);
		user1.setUsername("John");
		
		User user2 = new User("ZZTop");
		user2.setTotalGames(2);
		
		scoreboard.addUser(user1);
		scoreboard.addUser(user2);
		
		assertEquals("Testing winning and losing setters and getters - user1: ", scoreboard.getScoreboard().getElementAt(0).getTotalGames(), 4);
		assertEquals("Testing winning and losing setters and getters - user1: ", scoreboard.getScoreboard().getElementAt(0).getTotalWins(), 2);
		assertEquals("Testing username setters and getters - user1: ", scoreboard.getScoreboard().getElementAt(0).getUsername(), "John");
		assertEquals("Testing winning and losing, user1 toString shows correct values: ", scoreboard.getScoreboard().getElementAt(0).toString(), "John has played a total of 4 games and has won 2");

		assertEquals("Testing winning and losing setters and getters - user2: ", scoreboard.getScoreboard().getElementAt(1).getTotalGames(), 2);
		assertEquals("Testing winning and losing setters and getters - user2: ", scoreboard.getScoreboard().getElementAt(1).getTotalWins(), 0);
		assertEquals("Testing winning and losing, user2 toString shows correct values: ", scoreboard.getScoreboard().getElementAt(1).toString(), "ZZTop has played a total of 2 games and has won 0");
	}
	
	
	/*
	 * Test case multiple users incrementers used
	 */
	@Test 
	public void testCase4() {
		Scoreboard scoreboard = new Scoreboard();
		
		User user1 = new User("Jane");
		user1.incrementTotalGames();
		user1.incrementTotalWins();
		user1.incrementTotalGames();
		
		User user2 = new User("ZZTop");
		user2.incrementTotalGames();
		user2.incrementTotalGames();
		user2.incrementTotalGames();
		
		scoreboard.addUser(user1);
		scoreboard.addUser(user2);
		
		assertEquals("Testing winning and losing setters and getters - user1: ", scoreboard.getScoreboard().getElementAt(0).getTotalGames(), 2);
		assertEquals("Testing winning and losing setters and getters - user1: ", scoreboard.getScoreboard().getElementAt(0).getTotalWins(), 1);
		assertEquals("Testing username setters and getters - user1: ", scoreboard.getScoreboard().getElementAt(0).getUsername(), "Jane");
		assertEquals("Testing winning and losing, user1 toString shows correct values: ", scoreboard.getScoreboard().getElementAt(0).toString(), "Jane has played a total of 2 games and has won 1");

		assertEquals("Testing winning and losing setters and getters - user2: ", scoreboard.getScoreboard().getElementAt(1).getTotalGames(), 3);
		assertEquals("Testing winning and losing setters and getters - user2: ", scoreboard.getScoreboard().getElementAt(1).getTotalWins(), 0);
		assertEquals("Testing winning and losing, user2 toString shows correct values: ", scoreboard.getScoreboard().getElementAt(1).toString(), "ZZTop has played a total of 3 games and has won 0");
	}// testCase4()
	
	
	
	/*
	 * Test case for next user with multiple users
	 */
	@Test 
	public void testCase5() {
		Scoreboard scoreboard = new Scoreboard();
		User user0 = new User("Ester");
		User user1 = new User("Jane");
		User user2 = new User("Shanequa");
		
		scoreboard.addUser(user0);
		scoreboard.addUser(user1);
		scoreboard.addUser(user2);
		
		
		assertEquals("Testing next user multiple users:", scoreboard.nextUser(), user0);
		assertEquals("Testing next user multiple users:", scoreboard.nextUser(), user1);
		assertEquals("Testing next user multiple users:", scoreboard.nextUser(), user2);
		assertEquals("Testing next user multiple users:", scoreboard.nextUser(), null);
		
		scoreboard.setCurrPlayer(0);
		assertEquals("Testing next user multiple users:", scoreboard.nextUser(), user0);
		
	}// testCase5()
	
	/*
	 * Test case for next user with one user added
	 */
	@Test
	public void testCase8() {
		Scoreboard scoreboard = new Scoreboard();
		User user1 = new User("Jane");
		
		scoreboard.addUser(user1);
		assertEquals("Testing next user one user added: ", scoreboard.nextUser(), user1);
		assertEquals("Testing next user one user added: ", scoreboard.nextUser(), null);
	}//testCase6()
	

	/*
	 * Test case for next user with no users added
	 */
	@Test
	public void testCase6() {
		Scoreboard scoreboard = new Scoreboard();
		assertEquals("Testing next user no users added: ", scoreboard.nextUser(), null);
	}//testCase6()
	

}// ScoreboardTest class
