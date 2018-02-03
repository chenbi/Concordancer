import java.util.*;

/* Author: Chen Bi 
 * each object of Word represents a word in text document
 */
public class Word implements IWord {

	private String word;

	private int frequency;

	private List<Integer> sentenceNum;  //list storing sentence numbers of each word



	public Word(String s) {
		this.word = s;
		this.frequency = 0;
		this.sentenceNum = new LinkedList<Integer>();
	}

	/* (non-Javadoc)
	 * @see IWord#addSentenceNum(int)
	 */
	@Override
	public void addSentenceNum(int num) {
		this.sentenceNum.add(num);
	}
	
	
	/* (non-Javadoc)
	 * @see IWord#clearSentenceNum()
	 */
	@Override
	public void clearSentenceNum(){
		
		this.sentenceNum.clear();
		
	}

	/* (non-Javadoc)
	 * @see IWord#incrementFrequency()
	 */
	@Override
	public void incrementFrequency() {
		this.frequency++;
	}
	
	/* (non-Javadoc)
	 * @see IWord#addFrequency(int)
	 */
	@Override
	public void addFrequency(int num) {
		this.frequency=num+this.frequency;
	}
	

	/* (non-Javadoc)
	 * @see IWord#getWord()
	 */
	@Override
	public String getWord() {
		return this.word;
	}

	/* (non-Javadoc)
	 * @see IWord#getSentenceNum()
	 */
	@Override
	public List<Integer> getSentenceNum() {
		return this.sentenceNum;
	}

	/* (non-Javadoc)
	 * @see IWord#getFrequency()
	 */
	@Override
	public int getFrequency() {
		return this.frequency;
	}
}