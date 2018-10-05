import java.util.List;

/**
 * The Parser class. This class parses the input, and creates a Searchable and a
 * Searcher according to it.
 *
 * @param <T>
 *            - generic.
 */
public class Parser<T> {

	// members
	private String type;
	private String size;
	private String board;

	// constructor
	public Parser(List<String> list) {
		this.type = list.get(0);
		this.size = list.get(1);
		this.board = list.get(2);
	}

	/**
	 * The parseSearchable function. This function creates a Searchable
	 * according to the given input.
	 * 
	 * @return - type Searchable, the created Searchable.
	 */
	public Searchable<T> parseSearchable() {
		Searchable<T> graph = new Graph<T>(Integer.parseInt(this.size), this.board);

		return graph;
	}

	/**
	 * The parseSearcher function. This function creates a Searcher according to
	 * the given input.
	 * 
	 * @return - type Searcher, the created Searcher.
	 * @return
	 */
	public Searcher<T> parseSearcher() {
		Searcher<T> searcher = null;
		if (type.equals("A*")) {
			searcher = new A_Str<T>();
		} else if (type.equals("IDS")) {
			searcher = new IDS<T>();
		}

		return searcher;
	}
}
