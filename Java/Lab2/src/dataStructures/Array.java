package dataStructures;

public class Array {
	
	String[] id;
	/*
	 * @param args
	 */
	
	
	public void matriculation() {
		id = new String[5];
		id[0] = "40329070";
		id[1] = "40324659";
		id[2] = "40320412";
		id[3] = "40652348";
		id[4] = "40242545";
		int max = id.length;
		System.out.println("Welcome To Matriculation");
		System.out.println("The size of the array is " + max);
		System.out.println("The current students who are Matriculated are:");
		
		for( int i = 0; i <max; i++) {
			System.out. println(id[i]);
		}
		
		
		System.out.println("Registering new Student");
		id = new String[6];
		max = id.length;
		id[0] = "40329070";
		id[1] = "40324659";
		id[2] = "40320412";
		id[3] = "40652348";
		id[4] = "40242545";
		id[5] = "40125489";
		System.out.println("The size of the array is " + max);
		System.out.println("The current students who are Matriculated are");
		
		for(int i = 0; i < max; i++) {
			System.out.println(id[i]);
		}
		
		
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array array = new Array();
		array.matriculation();
		
	
		
		
	}

}
