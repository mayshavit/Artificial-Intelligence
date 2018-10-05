import java.util.List;

/**
 * The AverageLink class.
 * This class implements the CalculatingFunction interface.
 * This class has a calc function that calculates the average distance
 * between 2 given clusters - sum of the distances between each node member in
 * the first cluster to each node member in the second cluster / number of
 * nodes of the 2 clusters.
 */
public class AverageLink implements CalculatingFunction<Cluster<Node>> {

	//members
	private CalcDistanceFunction distanceFunction;

	//constructor
	public AverageLink(CalcDistanceFunction distanceFunction) {
		this.distanceFunction = distanceFunction;
	}

	@Override
	/**
	 * The calc function.
	 * This function calculates the average distance between 2 given
	 * clusters - sum of the distances between each node member in the first
	 * cluster to each node member in the second cluster / number of nodes
	 * of the 2 clusters.
	 * 
	 * @param cluster1,
	 *            type Cluster<Node>, the first given cluster.
	 * @param cluster2,
	 *            type Cluster<Node>, the second given cluster.
	 * @return - type double, the calculated distance.
	 */
	public double calc(Cluster<Node> cluster1, Cluster<Node> cluster2) {
		double sumOfDistances = 0, numOfNodes;

		List<Node> clusterList1 = cluster1.getMembersList();
		List<Node> clusterList2 = cluster2.getMembersList();

		numOfNodes = clusterList1.size() * clusterList2.size();

		for (Node node1 : clusterList1) {
			for (Node node2 : clusterList2) {
				sumOfDistances += this.distanceFunction.calc(node1, node2);
			}
		}

		return sumOfDistances / numOfNodes;
	}

}
