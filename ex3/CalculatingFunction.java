/**
 * The CalculatingFunction interface.
 * This is a generic interface that has a calc function that calculates the
 * distance between 2 objects (type T).
 * @param <T> - generic.
 */
public interface CalculatingFunction<T> {
	
	/**
	 * The calc function.
	 * This function calculates the distance between 2 objects.
	 * @param object1 - type T, the first object.
	 * @param object2 - type T, the second object.
	 * @return - type double, the calculated distance.
	 */
	public double calc(T object1, T object2);

}
