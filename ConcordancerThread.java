import java.util.SortedMap;
import java.util.TreeMap;

/* Author: Chen Bi 
 * Concordancer Thread
 */
public class ConcordancerThread extends Thread {

	private StringBuilder document;
	private int beginIndex, endIndex;
	private TreeMap<String, IWord> wordMap;
	private int sentenceNum;
	
	public ConcordancerThread(TreeMap<String, IWord> wordMap, int beginIndex,	int endIndex, StringBuilder document) {
		this.sentenceNum=1;
		this.document = document;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		this.wordMap = wordMap;

	}

	/* (non-Javadoc)
	 * @see IThread#run()
	 */
	@Override
	public void run() {

		while (beginIndex < endIndex) {
			StringBuilder word = new StringBuilder();

			while (beginIndex <= endIndex) {

				char c = document.charAt(beginIndex);
				beginIndex++;
				if (Character.isWhitespace(c)) // end of a word
					break;

				else if (Character.isLetter(c)) 
					word.append(c);

				else if (c == '.' && beginIndex < endIndex) {

					// abbreviation like 'i.e.'
					if (Character.isLetter(document.charAt(beginIndex))
							|| document.charAt(beginIndex - 3) == '.') 
					{			
						word.append(c); // if the next character is a letter or there is a period 2 characters ahead
										// the current one, append the period. Otherwise, period is end of word, do nothing
					}
				}
				// begin of another sentence if c is upper case, and proceeded by period  2 spaces ahead
				if (beginIndex > 2 ){
					if (Character.isUpperCase(c) && document.charAt(beginIndex - 3) == '.' || document.charAt(beginIndex - 3) == '?') {
						sentenceNum++;
					}
				}
			}
			
			

			String s = word.toString().toLowerCase();
			if (s.isEmpty())
				continue; // in case beginIndex points to a whitespace

			IWord w = new Word(s);
			if (wordMap.containsKey(s)) {
				w = wordMap.get(s);
			}
			w.incrementFrequency(); // increment frequency of this word
			w.addSentenceNum(sentenceNum); // add sentence number
			wordMap.put(s, w); // put word in word map
		}

	}

}
