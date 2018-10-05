import java.util.ArrayList;
import java.util.List;

/**
 * The ClusterClassifier class.
 * This class classify a list of clusters to a given number of clusters by a
 * given link.
 */
public class ClusterClassifier {

	// members
	private List<Cluster<Node>> clusters;
	private CalculatingFunction<Cluster<Node>> calculatingFunction;
	private List<Node> nodes;
	private int numberOfClusters;

	//constructor
	public ClusterClassifier(List<Node> nodes,
			CalculatingFunction<Cluster<Node>> calculatingFunction,
			int numberOfClusters) {
		this.nodes = nodes;
		this.clusters = new ArrayList<Cluster<Node>>();
		this.calculatingFunction = calculatingFunction;
		this.numberOfClusters = numberOfClusters;
		this.initialClusters();
	}

	/**
	 * The classifyClusters function.
	 * This function classifies the list of clusters to a given number of
	 * clusters by a given link.
	 */
	public void classifyClusters() {
		Cluster<Node> cluster1 = null, cluster2 = null;
		double minDistance = Double.POSITIVE_INFINITY, currentDistance;

		while (this.clusters.size() > this.numberOfClusters) {
			for (Cluster<Node> currentCluster : this.clusters) {
				for (Cluster<Node> neighborCluster : this.clusters) {
					currentDistance =
							this.calculatingFunction.calc(currentCluster,
									neighborCluster);
					if ((currentCluster != neighborCluster) &&
							(currentDistance < minDistance)) {
						minDistance = currentDistance;
						cluster1 = currentCluster;
						cluster2 = neighborCluster;
					}
				}
			}

			this.union(cluster1, cluster2);
			minDistance = Double.POSITIVE_INFINITY;
		}

	}

	/**
	 * The union function.
	 * This function unions the 2 given clusters, and updates the clusters
	 * member of the class.
	 * @param cluster1 - the first given cluster.
	 * @param cluster2 - the second given cluster.
	 */
	private void union(Cluster<Node> cluster1, Cluster<Node> cluster2) {
		int indexOfFirstCluster = cluster1.getClusterNumber() - 1;
		int indexOfSecondCluster = cluster2.getClusterNumber() - 1;

		List<Node> nodes = cluster2.getMembersList();

		for (Node node : nodes) {
			cluster1.addMember(node);
		}

		this.clusters.remove(indexOfFirstCluster);
		this.clusters.remove(indexOfSecondCluster - 1);
		this.clusters.add(indexOfFirstCluster, cluster1);

		for (int i = 0; i < this.clusters.size(); i++) {
			if (this.clusters.get(i).getClusterNumber() != i + 1) {
				this.clusters.get(i).setClusterNumber(i + 1);
			}
		}
	}

	/**
	 * The classifyListOfNodesToClustersNumbers function.
	 * This function classifies the given list of nodes to the clusters
	 * numbers.
	 * @param nodes - type List<Node>, the given list of nodes.
	 * @return - clustersNumbers, type List<Integer>, the clusters numbers.
	 */
	public List<Integer> classifyListOfNodesToClustersNumbers(
			List<Node> nodes) {
		List<Integer> clustersNumbers = new ArrayList<Integer>();

		for (Node node : nodes) {
			for (Cluster<Node> cluster : this.clusters) {
				if (cluster.contains(node)) {
					clustersNumbers.add(cluster.getClusterNumber());
					continue;
				}
			}
		}

		return clustersNumbers;
	}

	/**
	 * The initialClusters function.
	 * This function initializes the list of nodes to clusters.
	 */
	private void initialClusters() {
		int num = 1;
		for (Node node : this.nodes) {
			Cluster<Node> cluster = new Cluster<Node>(num);
			cluster.addMember(node);
			this.clusters.add(cluster);
			num++;
		}
	}

}
