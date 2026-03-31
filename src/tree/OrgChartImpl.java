package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class OrgChartImpl implements OrgChart{

	//Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();

	@Override
	public void addRoot(Employee e) {
		// TODO Auto-generated method stub
		GenericTreeNode<Employee> rootEmployee = new GenericTreeNode<Employee>(e);
		nodes.add(rootEmployee);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDirectReport(Employee manager, Employee newPerson) {
		// TODO Auto-generated method stub
		for(int i = 0; i < nodes.size(); i++)
		{
			GenericTreeNode<Employee> currentEmployee = nodes.get(i);
			if(currentEmployee.data.equals(manager))
			{
				GenericTreeNode<Employee> newE = new GenericTreeNode<Employee>(newPerson);
				
				// adds child to current employee's list of children
				nodes.get(i).addChild(newE);
				nodes.add(newE);
				break;
			}
		}
	}

	@Override
	public void removeEmployee(Employee firedPerson) {
		// TODO Auto-generated method stub
		// loop through nodes to find fired person
		// search all nodes to find supervisor (whoever has firedPerson in children list)
		// call supervisor.removeChild(firedPerson) promoting grandchildren internally; 
		// use the removeChild in GenericTreeNode.java
		// remove firedPerson from tree (nodes list)
		// break out of loop
	
		GenericTreeNode<Employee> supervisor = nodes.get(0);
		
		for(int i = 0; i < nodes.size(); i++)
		{
			GenericTreeNode<Employee> currentEmployee = nodes.get(i); // traverser
			for(int j = 0; j < currentEmployee.children.size(); j++)  // go through employee children
			{
				if(currentEmployee.children.get(j).equals(firedPerson)) // find if firee is in that list
				{
					supervisor = currentEmployee.children.get(j); // assign supervisor
				}
			}
		}
		
		for(int j = 0; j < nodes.size(); j++)
		{
			GenericTreeNode<Employee> currentEmployee = nodes.get(j); // traverser
			if(currentEmployee.equals(supervisor)) // traverse again. when get to supervisor,
			{
				supervisor.removeChild(firedPerson); // remove that firee from their child list
			}
			
			break;
		}
	}

	@Override
	public void showOrgChartDepthFirst() {
		// TODO Auto-generated method stub	
		if(nodes == null) {
			return; 
		}
		
		Stack<GenericTreeNode<Employee>> employeeStack=new Stack<>();
		
		employeeStack.push(nodes.get(0));
		
		while(!employeeStack.isEmpty()) {
			GenericTreeNode currentNode=employeeStack.pop();
			
			ArrayList<GenericTreeNode> childNodes = currentNode.children;
			
			Queue<GenericTreeNode> employeeQueue = new LinkedList<>();
			
			employeeQueue.add(nodes.get(0));
			while (!employeeQueue.isEmpty())
		    {
		        int n = employeeQueue.size();
		 
		        // If this node has children
		        while (n > 0)
		        {
		            // Dequeue an item from queue and print it
		            GenericTreeNode<Employee> p = employeeQueue.peek();
		            employeeQueue.remove();
		            System.out.print(p.data + " ");
		 
		            // Enqueue all children of the dequeued item
		            for (int i = 0; i < p.children.size(); i++)
		            	employeeQueue.add(p.children.get(i));
		            n--;
		        }
		         
		        // Print new line between two levels
		        System.out.println();
		    }
			System.out.println("=== DFS test complete ===");
		}
	}

	@Override
	public void showOrgChartBreadthFirst() {
		// TODO Auto-generated method stub
		if(nodes == null) {
			return; 
		}
		Queue<GenericTreeNode<Employee>> employeeQueue = new LinkedList<>(); 
		employeeQueue.add(nodes.get(0));
		
		while(!employeeQueue.isEmpty()) {
			int n=employeeQueue.size();
			
			while(n>0) {
				GenericTreeNode<Employee> peeked = employeeQueue.peek();
	            employeeQueue.remove();
	            System.out.print(peeked.data + " | ");
	 
	            for (int i = 0; i < peeked.children.size(); i++)
	            	employeeQueue.add(peeked.children.get(i));
	            n--;
	        }
	         
	        // Print new line between two levels
	        System.out.println();
		}
		System.out.println("=== BFS test complete ===");
	}
	
	
}
