package uchidb;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;

/**
 * This file contains the class that implements Containers.java
 */

public class alexContainers<T, S> implements Containers<T, S> {

  public Map<S,T> aCmap;

  // Create and return a set that stores the array of T objects
	// You do not need to create your own set implementation and
	// can use an existing set class.
	public Set<T> initSet(T[] tArray) {
    Set<T> newSet = new HashSet<T>(Arrays.asList(tArray));
    return newSet;
  }

	// Create and return a list that stores an the array of T objects
	// You do not need to create your own list implementation and
	// can use an existing list class.
	public List<T> initList(T[] tArray) {
    List<T> newList = Arrays.asList(tArray);
    return newList;
  }

	// Create and return an empty map that will use type S as keys, and T as values
	// You do not need to create your own map implementation and
	// can use an existing map class.
	public Map<S,T> initEmptyMap() {
    Map<S,T> newMap = new HashMap<S,T>();
    return newMap;
  }

	// Store the map in a local field variable -- often called a setter
	public void storeMap(Map<S,T> mapToStoreInClass) {
    this.aCmap = mapToStoreInClass;
  }

	// Add a key value to the stored/local map with a boolean indicating whether to overwrite existing value
	// The return value indicates if you added the key value pair to the map
	// You do not need to check if the value changed or not (e.g. no need to compare values)
	public boolean addToMap(S key, T value, boolean overwriteExistingKey) {
    boolean existingValue = aCmap.containsKey(key);
    boolean added = false;

    if(!existingValue || overwriteExistingKey) {
      this.aCmap.put(key, value);
      added = true;
    }

    return added;
  }

	// Return a value from the stored/local map based on the key
	public T getValueFromMap(S key) {
    T val = this.aCmap.get(key);
    return val;
  }

	// An overloaded function to get a value from the store/local map, but with a default value
	// if the key is not present in the map.
	public T getValueFromMap(S key, T defaultValue) {
    boolean keyExists = this.aCmap.containsKey(key);
    if (keyExists) {
      return this.aCmap.get(key);
    }
    else {
      return defaultValue;
    }

  }
}
