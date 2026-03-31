package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		
	}

	@Override
	public void showOrgChartDepthFirst() {
		// TODO Auto-generated method stub	
		
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
	            System.out.print(peeked.data + " ");
	 
	            for (int i = 0; i < peeked.children.size(); i++)
	            	employeeQueue.add(peeked.children.get(i));
	            n--;
	        }
	         
	        // Print new line between two levels
	        System.out.println();
		}
		
	}
	
	
}
