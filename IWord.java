import java.util.List;

public interface IWord {

	public  void addSentenceNum(int num);

	public  void clearSentenceNum();

	public  void incrementFrequency();

	public  void addFrequency(int num);

	public  String getWord();

	public  List<Integer> getSentenceNum();

	public  int getFrequency();

}