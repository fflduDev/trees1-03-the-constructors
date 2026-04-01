package tree;
import java.util.ArrayList;

public class GenericTreeNode<E> {
	E data;
	//<some list of children>
	ArrayList<GenericTreeNode<E>> children;
	
	public GenericTreeNode(E theItem) {
		data = theItem;
		children = new ArrayList<>();
	}
	
	public void addChild(GenericTreeNode<E> theItem) {
		children.add(theItem);
	}
	
	public void removeChild(E theItem) {
		// this one is a little harder.
		// what do you do when the item has children?
		// I suggest "give them to the parent"
		
		// locate child in children ArrayList
		for(int i = 0; i < children.size(); i++)
		{
			if(children.get(i).data.equals(theItem))
			{
				if(children.get(i).children.isEmpty()) // if item has no children,
				{
					// remove them from parent's list of children -> done
					children.remove(children.get(i));
				}
				else // if item has children, give them to its parent
				{
					// kind of a parent.addChild([its children])
					// remove it from its parent's list of children -> done
					for(int j = 0; j < children.get(i).children.size(); j++)
					{
						children.add(children.get(i).children.get(j));
					}
					children.remove(children.get(i));
				}
			break;
			}
		}
	}
	
	
} 
