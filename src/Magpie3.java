/**
 * A program to carry on conversations with a human user. This version:
 * <ul>
 * <li>
 * Uses advanced search for keywords</li>
 * </ul>
 * 
 * @author Laurie White
 * @version April 2012
 */
public class Magpie3 {
	/**
	 * Get a default greeting
	 * 
	 * @return a greeting
	 */
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement) {
		String response = "";
		if (statement.length() == 0) {
			response = "Say something, please.";
		} else if (findKeyword(statement, "no", 0) >= 0) {
			response = "Why so negative?";
		} else if (findKeyword(statement, "mother", 0) >= 0
				|| findKeyword(statement, "father", 0) >= 0
				|| findKeyword(statement, "sister", 0) >= 0
				|| findKeyword(statement, "brother", 0) >= 0) {
			response = "Tell me more about your family.";
		}  else if (findKeyword(statement, "cat", 0) >= 0 
		|| findKeyword(statement, "dog", 0) >=0) {
			response = "Tell me more about your pets";
		} else if (findKeyword(statement, "padjen", 0) >=0) {
			response = "He sounds like a grat person";
		} else if (statement.trim().length() < 1) {
			response = "Say something, please.";
		} else if(findKeyword(statement, "fortnite", 0) >= 0) {
			response = "OK Zoomer.";
		} else if (findKeyword(statement, "epic", 0) >= 0) {
			response = "Are you an EPIC Gamer?";
		} else if (findKeyword(statement, "rick", 0) >= 0) {
			response = "Rick and Morty, or... https://www.youtube.com/watch?v=oHg5SJYRHA0 ?";
		} else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Search for one word in phrase. The search is not case sensitive. This
	 * method will check that the given goal is not a substring of a longer
	 * string (so, for example, "I know" does not contain "no").
	 * 
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the search at
	 * @return the index of the first occurrence of goal in statement or -1 if
	 *         it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int position = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		int iteration = 0;
		while (position >= 0) {
			iteration++;
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (position > 0) {
				before = phrase.substring(position - 1, position);
			}
			if (position + goal.length() < phrase.length()) {
				after = phrase.substring(position + goal.length(),
						position + goal.length() + 1);
			}
			System.out.println(iteration + " " + position + " " + before + " " + after);
			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) // before
																				// is
																				// not
																				// a
																				// letter
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
				return position;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			position = phrase.indexOf(goal, position + 1);
			iteration++;
		}

		return -1;
	}

	/**
	 * Search for one word in phrase. The search is not case sensitive. This
	 * method will check that the given goal is not a substring of a longer
	 * string (so, for example, "I know" does not contain "no"). The search
	 * begins at the beginning of the string.
	 * 
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if
	 *         it's not found
	 */
	private int findKeyword(String statement, String goal) {
		return findKeyword(statement, goal, 0);
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * 
	 * @return a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			response = "Life never gave you lemons, they are a hybrid of citron and oranges, we made them ourselves.";
		} else if (whichResponse == 5) {
			response = "Are you sure?";
		}

		return response;
	}

}
