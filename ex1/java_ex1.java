import java.util.List;

/**
 * The java_ex1 class.
 * This is the main class of the program.
 *
 */
public class java_ex1 {

	/**
	 * The main function.
	 * This function runs the program.
	 */
	public static void main(String[] args) {

		FileManager fileManager = new FileManager();
		List<String> list = fileManager.readFromFile("input.txt");
		Parser<Character> parser = new Parser<Character>(list);
		Searchable<Character> graph = parser.parseSearchable();
		Searcher<Character> searcher = parser.parseSearcher();
		String string = searcher.search(graph);
		fileManager.writeToFile("output.txt", string);
	}

}
