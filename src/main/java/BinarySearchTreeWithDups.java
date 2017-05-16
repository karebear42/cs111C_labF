import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = null;
		if (isEmpty())
			setRootNode(new BinaryNode<T>(newEntry));
		else
			result = addEntryHelperIterative(newEntry);
		return result;
	}

	// ??? IMPLEMENT THIS METHOD
	private T addEntryHelperIterative(T newEntry) {
		// IMPORTANT: METHOD MUST BE ITERATIVE!!
		// IMPORTANT: METHOD MUST BE ITERATIVE!!
		BinaryNodeInterface<T> currentNode = getRootNode();
		assert currentNode != null;
		T result = null;
		boolean found = false;
		
		while (!found) {
			T currentEntry = currentNode.getData();
			int comparison = newEntry.compareTo(currentEntry);

			if (comparison == 0) {
				//newEntry matches currentEntry
				//go into right subtree and add as normal
				//for BST
				if (currentNode.hasRightChild())
					currentNode = currentNode.getRightChild();
					continue;
				
			}else if (comparison < 0) {
				if (currentNode.hasLeftChild())
					currentNode = currentNode.getLeftChild();
				else {
					found = true;
					currentNode.setLeftChild(new BinaryNode<T>(newEntry));
				} // end if
			} else {
				assert comparison > 0;

				if (currentNode.hasRightChild())
					currentNode = currentNode.getRightChild();
				else {
					found = true;
					currentNode.setRightChild(new BinaryNode<T>(newEntry));
				}
			}
		}

		return result;
		
	}
	
	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesIterative(T searchVal) {
		public ArrayList<T> getAllEntriesLessThanIterative(T searchVal) {
		StackInterface<BinaryNodeInterface<T>> nodeStack = new LinkedStack<>();
		BinaryNodeInterface<T> currentNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();
		
		while (!nodeStack.isEmpty() || (currentNode != null)) {
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			if (!nodeStack.isEmpty()) {
				BinaryNodeInterface<T> nextNode = nodeStack.pop();
				assert nextNode != null;
				T currentEntry = nextNode.getData();
				int comparison = searchVal.compareTo(currentEntry);
				if (comparison > 0) {
					entryList.add(nextNode.getData());
					}
				currentNode = nextNode.getRightChild();
			} // end if

		} // end while

		return entryList;

	

	}

	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesRecursive(T searchVal) {
		// this initial code is meant as a suggestion to get your started- feel
		// free to use it or delete it!
		BinaryNodeInterface<T> rootNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();
		// getAllEntriesHelper(searchVal, rootNode, entryList);
		
		return entryList;
	}

	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesLessThanIterative(T searchVal) {
		// this initial code is meant as a suggestion to get your started- feel
		// free to use it or delete it!
		ArrayList<T> entryList = new ArrayList<T>();

		// Hint: consider using a stack to mimic recursion!
		// Stack<BinaryNodeInterface<T>> nodeStack = new
		// Stack<BinaryNodeInterface<T>>();
		// nodeStack.push(getRootNode());

		// while(!nodeStack.isEmpty()) {
		// }
		
		return entryList;
	}

	// ??? IMPLEMENT THIS METHOD
	public ArrayList<T> getAllEntriesLessThanRecursive(T searchVal) {
		// this initial code is meant as a suggestion to get your started- feel
		// free to use it or delete it!
		BinaryNodeInterface<T> rootNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();
		// getAllEntriesLessThanHelper(searchVal, rootNode, entryList);
		
		return entryList;
	}



}
