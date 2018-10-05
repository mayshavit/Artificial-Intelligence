import java.util.ArrayList;
import java.util.List;

/**
 * The Cluster<T> class.
 * This class represents a cluster of objects (type T), by a List<T> member.
 *
 * @param <T> - generic.
 */
public class Cluster<T> {

	//members
	private List<T> membersList;
	private int clusterNumber;

	//constructor
	public Cluster(int clusterNumber) {
		this.membersList = new ArrayList<T>();
		this.clusterNumber = clusterNumber;
	}

	/**
	 * The addMember function.
	 * This function adds a member to the membersList.
	 * @param member - type T, the member to add to the membersList.
	 */
	public void addMember(T member) {
		this.membersList.add(member);
	}

	/**
	 * The getClusterNumber function.
	 * This function returns the clusterNumber member of the class.
	 * @return - clusterNumber, type int, the clusterNumber member of the
	 * class.
	 */
	public int getClusterNumber() {
		return this.clusterNumber;
	}

	/**
	 * The setClusterNumber function.
	 * This function sets the clusterNumber member of the class by the given
	 * number.
	 * @param clusterNumber - type int, the given number.
	 */
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}

	/**
	 * The getMembersList function.
	 * This function returns the membersList member of the class.
	 * @return - membersList, type List<T>, the membersList member of the
	 * class.
	 */
	public List<T> getMembersList() {
		return this.membersList;
	}

	/**
	 * The contains function.
	 * This function returns a boolean indicates if the given object is a
	 * member of the membersList of the class.
	 * @param object - type Object, the given object.
	 * @return - type boolean, indicates if the given object is a member of
	 * the membersList of the class.
	 */
	public boolean contains(Object object) {
		if (this.membersList.contains(object)) {
			return true;
		}

		return false;
	}
}
