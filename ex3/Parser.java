import java.util.ArrayList;
import java.util.List;

/**
 * The Parser class.
 * This class parses the input, and creates a link, a size and a list of nodes
 * according to it.
 *
 * @param <T>
 *            - generic.
 */
public class Parser {

	// members
	private String type;
	private String size;
	private List<String> points;

	// constructor
	public Parser(List<String> list) {
		this.type = list.get(0);
		this.size = list.get(1);
		this.points = list.subList(2, list.size());
	}
	
	/**
	 * The parseLink function.
	 * This function parses the input to a link.
	 * @return - type CalculatingFunction<Cluster<Node>>, the parsed link.
	 */
	public CalculatingFunction<Cluster<Node>> parseLink() {
		if (this.type.equals("single link")) {
			return new SingleLink(new CalcDistanceFunction());
		} else if (this.type.equals("average link")) {
			return new AverageLink(new CalcDistanceFunction());
		}
		
		return null;
	}
	
	/**
	 * The parseLink function.
	 * This function parses the input to a size.
	 * @return - type int, the parsed size.
	 */
	public int parseSize() {
		return Integer.parseInt(this.size);
	}
	
	/**
	 * The parseNodes function.
	 * This function parses the input to a list of nodes.
	 * @return - type List<Node>, the parsed list of nodes.
	 */
	public List<Node> parseNodes() {
		List<Node> nodes = new ArrayList<Node>();
		for (String point : this.points) {
			double x = Double.parseDouble(point.substring(0, point.indexOf(',')));
			double y = Double.parseDouble(point.substring(point.indexOf(',') + 1, point.length()));
			Node node = new Node(x, y);
			nodes.add(node);
		}
		
		return nodes;
	}
}
