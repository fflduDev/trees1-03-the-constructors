package tree;
// LEEDLELEEDLELEEDLELEEE
public class testOrgChart {

	public static void main(String[] args) {

		

		// fill the org chart
		OrgChart company = new OrgChartImpl();
		
		Employee e1 = new Employee("Jack", 1001, "CEO");
		Employee e2 = new Employee("Katie", 1002, "Project Manager");
		Employee e3 = new Employee("Ben", 1021, "Designer");
		Employee e4 = new Employee("Rosy", 1001, "Lawyer");
		Employee e5 = new Employee("Tania", 1090, "Project Manager");
		Employee e6 = new Employee("Magnus", 1131, "PM Secretary");
		Employee e7 = new Employee("Anish", 1290, "Market Researcher");
		Employee e8 = new Employee("Jack B", 1324, "Coder");
		Employee e9 = new Employee("Layla", 1253, "Intern");
		Employee e10 = new Employee("Jade", 1923, "CEO Secretary");
		
		company.addRoot(e1);              // adds Jack
		company.addDirectReport(e1, e2);  // adds Katie under Jack
		company.addDirectReport(e1, e5);  // adds Tania under Jack
		company.addDirectReport(e1, e10); // adds Jade under Jack
		company.addDirectReport(e2, e3);  // adds Ben under Katie
		company.addDirectReport(e2, e4);  // adds Rosy under Katie
		company.addDirectReport(e5, e6);  // adds Magnus under Tania
		company.addDirectReport(e5, e7);  // adds Anish under Tania
		company.addDirectReport(e7, e8);  // adds Jack B under Anish
		company.addDirectReport(e7, e9);  // adds Layla under Anish
		
		/*
		 * Our tree:
		 *                          Jack
		 *            /               |         \
		 *          Katie           Tania        Jade
		 *         /     \          /   \
		 *       Ben    Rosy    Magnus  Anish
		 *                              /    \
		 *                         Jack B    Layla
		 */
		
		// show it depth first
		company.showOrgChartDepthFirst();
		
		// show breadth first
		company.showOrgChartBreadthFirst();
		
		// and remove some people
		company.removeEmployee(e4); // removes Rosy under Katie
		company.removeEmployee(e5); // removes Tania under Jack
									// transfers Magnus and Anish under Jack,
									// Jack B and Layla remain under Anish
		System.out.println("\nRemoved employees. Testing again...\n");
		
		/*
		 * Our tree after removals:
		 *                          Jack
		 *            /           /       \         \
		 *          Katie      Jade      Magnus    Anish 
		 *         /                     		   /   \
		 *       Ben                		  Jack B    Layla                             
		 */
		
		// show it depth first
		company.showOrgChartDepthFirst();
		
		// show breadth first
		company.showOrgChartBreadthFirst();
		

	}

}
