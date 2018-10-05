/**
 * The Searcher interface.
 * This interface defines a function that searches a solution 
 * through the given searchable.
 *
 * @param <T>
 *            - generic.
 */
public interface Searcher<T> {

	/**
	 * The search function.
	 * 
	 * This function searches a solution through the given searchable.
	 * 
	 * @param searchable
	 *            - to search through.
	 * @return - type String, represents the solution.
	 */
	public String search(Searchable<T> searchable);
}
