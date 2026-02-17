package Programs;

class Echo {
    // --- INSTANCE VARIABLE (The State) ---
    // WHAT IT IS: The "memory" of the object.
    // USE: Every Echo object has its own separate 'count' variable.
    // It starts at 0.
    int count = 0;

    // --- METHOD (The Behavior) ---
    // WHAT IT IS: An action the object can perform.
    // USE: When called, it prints text to the screen.
    void hello() {
        System.out.println("helloooo... ");
    }
}

//
class EchoTestDrive {

    // --- MAIN METHOD (The Entry Point) ---
    // WHAT IT IS: The place where Java starts executing instructions.
    // USE: Without this, the program cannot run.
    public static void main(String [] args) {

        // --- OBJECT CREATION (Instantiation) ---
        // WHAT IT IS: Making "instances" (copies) of the Blueprint.
        // USE: We create two separate objects. They don't know about each other yet.
        Echo e1 = new Echo();
        
        Echo e2 = new Echo();  // <--- Pulled from the pool ("Echo e2 = new Echo();")
        // to get 24 as output instead of 10 we have to  make the e2=e1

        // --- LOCAL VARIABLE ---
        // WHAT IT IS: A temporary counter just for this main method.
        int x = 0;

        // --- WHILE LOOP (Control Flow) ---
        // WHAT IT IS: A loop that runs as long as the condition is true.
        // USE: Runs 4 times (0, 1, 2, 3).
        while ( x < 4 ) {  // <--- Pulled from pool ("x < 4")

            // --- METHOD CALL ---
            // WHAT IT IS: Triggering an action on an object.
            e1.hello();

            // --- UPDATING STATE (The key part you found!) ---
            // WHAT IT IS: Changing the memory of object e1.
            // USE: Increases e1's count by 1 *before* we do the math below.
            e1.count = e1.count + 1;  // <--- Pulled from pool

            // --- CONDITIONAL LOGIC (If Statement 1) ---
            // WHAT IT IS: A check to see if we are on the LAST loop.
            // USE: Only adds 1 to e2 when x is exactly 3.
            if ( x ==3 ) {  // <--- Pulled from pool
                e2.count = e2.count + 1;
            }

            // --- CONDITIONAL LOGIC (If Statement 2) ---
            // WHAT IT IS: A check to see if we are past the FIRST loop.
            // USE: Adds e1's current value to e2.
            if ( x >0 ) {   // <--- Pulled from pool
                e2.count = e2.count + e1.count;
            }

            // --- INCREMENT LOOP COUNTER ---
            // USE: Move to the next loop number.
            x = x + 1;
        }

        // --- OUTPUT ---
        // USE: Print the final result (which is 10).
        System.out.println(e2.count);
    }
}
// Now there is one more question we want to get 24 as count value
