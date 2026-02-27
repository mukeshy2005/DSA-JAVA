package javaFullCourse.Lecture08;

public class Demo02 {
    public static void main(String [] args) {
    /* short i = 1;
       i <<= 15;
       System.out.println(i);
       */
        // let us print a pattern
	/*
	 * 
	 **
	 ***
	 ****
	 *****
	*/
	    // for ( int i = 1 ; i <= 5 ; i++ ) {
		//     for (int j = 1 ; j <= i ; j++) {
		// 	    System.out.print("*");
		//     }
        //     System.out.println();
	    // }
/*
        for ( int i = 1 ; i <= 10 ; i++ ) {

            if ( i > 5 ) {
                continue;
            }
            System.out.println(i);
        }
	*/
	//   for ( int i = 1 ; i <= 10 ; i++ ) {
	// 	  for ( int j = 1 ; j <= i ; j++ ) {
	// 		  System.out.print("*");
	// 		  if ( j >= 5 ) {
	// 			  continue;
	// 		  }
	// 	  }
	// 	  System.out.println();
	//   }


    outer :for ( int i = 1 ; i <= 10 ; i++ ) {
		  inner: for ( int j = 1 ; j <= i ; j++ ) {
			  System.out.print("*");
			  if ( j >= 5 ) {
				  continue outer;
			  }
		  }
		  System.out.println();
	  }
    }
}
