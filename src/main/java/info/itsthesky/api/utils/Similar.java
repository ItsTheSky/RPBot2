package info.itsthesky.api.utils;

public interface Similar<T> {

	/**
	 * Check if this object is similar to another one.
	 * @param other The other object to compare.
	 * @return true if this object is similar to the other one.
	 */
	boolean isSimilar(T other);

}
