import java.util.List;

/**
 * The java_ex3 class. This is the main class of the program.
 */
public class java_ex3 {

	/**
	 * The main function. This function runs the program.
	 */
	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		List<String> parameters = fileManager.readFromFile("input.txt");
		Parser parser = new Parser(parameters);
		CalculatingFunction<Cluster<Node>> calculatingFunction =
				parser.parseLink();

		int numberOfClusters = parser.parseSize();
		List<Node> nodes = parser.parseNodes();

		ClusterClassifier classifier = new ClusterClassifier(nodes,
				calculatingFunction, numberOfClusters);
		classifier.classifyClusters();
		List<Integer> clustersNumbers =
				classifier.classifyListOfNodesToClustersNumbers(nodes);

		fileManager.writeToFile("output.txt", clustersNumbers);
	}

}
