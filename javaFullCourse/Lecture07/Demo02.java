public class Demo02 {
	public static void main(String [] args) {
		// switch statement 
	/* 	int i = 3;
		switch (i) {
			case 1:
				System.out.println(" i is 1");
				break;
			case 2:
				System.out.println("i is 2");
				break;
			case 3:
				System.out.println("i is 3");
				break;
			default:
				System.out.println("i is greater then 3 ");

		*/

		// without break statement
		int j = 1;
		switch (j) {
			case 1:
				System.out.println(" j is 1");
				
			case 2:
				System.out.println("j is 2");
				
			case 3:
				System.out.println("j is 3");
				
			default:
				System.out.println("j is greater then 3 ");

		} // o/p will be 
		/* i is 1
i is 2
i is 3
i is greater then 3  */
        // if write the same code using if-else-if statemnent
		// int k = 1;
		// if(k == 1) {
		// 	System.out.println(" k is 1");
		// }
		// else if(k == 2) {
		// 	System.out.println("k is 2");
		// }
		// else if(k == 3) {
		// 	System.out.println("k is 3");
		// }
		// else {
		// 	System.out.println("k is greater then 3 ");
		// } // o/p will be k is 1 because in if-else-if ladder if a statement is true then it wont check the other statements or if a statement is false then it will check other statement		
		
		 

		 int j = 5;
        int k = 1;
        switch(j) {
            case 4:
                System.out.println("j is 4");
                break;
            case 5:
                switch(k) {
                    case 1:
                        switch(j) {

                        }
                    case 2:
                        break;
                }
            default:
                System.out.println("j is not 4 && 5");
                break;
			}
	}
}
