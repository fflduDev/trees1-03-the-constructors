package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;


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
		// call supervisor.removeChild(firedPerson) promoting grandchildren internally
		// remove firedPerson from tree (nodes list)
		// break out of loop
	
		GenericTreeNode<Employee> supervisor = nodes.get(0);
		
		for(int i = 0; i < nodes.size(); i++)
		{
			GenericTreeNode<Employee> currentEmployee = nodes.get(i); // traverser
			for(int j = 0; j < currentEmployee.children.size(); j++)  // go through employee children
			{
				if(currentEmployee.children.get(j).data.equals(firedPerson)) // find if firee is in that list, compare data
				{
					supervisor = currentEmployee; // assign supervisor
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
		}
		
		// removes from nodes list
		for(int k = 0; k < nodes.size(); k++)
		{
			if(nodes.get(k).data.equals(firedPerson))
			{
				nodes.remove(nodes.get(k));
			}
		}
		

	}

	@Override
	public void showOrgChartDepthFirst() {
		// TODO Auto-generated method stub

		if (nodes.isEmpty()) {
			return;
		} 
		
		GenericTreeNode<Employee> root = nodes.get(0);
		
		Stack<GenericTreeNode<Employee>> stack = new Stack<>();
		
		stack.push(root);
		
		while(!stack.empty()) {
			GenericTreeNode<Employee> currentNode=stack.pop();
			System.out.println("Current: "+ currentNode.data);
			
			ArrayList<GenericTreeNode<Employee>> childNodes=currentNode.children;
			
			for(int i=0;i<childNodes.size();i++) {
				stack.push(childNodes.get(i));
			}
			
		}
		System.out.println("=== DFS test complete ===");
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
