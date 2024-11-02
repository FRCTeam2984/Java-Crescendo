// This is a simple Java program.
// FileName : "HelloWorld.java".

class Main {
	// Your program begins with a call to main().
	// Prints "Hello, World" to the terminal window.
	// public static void main(String args[])
	// {
	// 	System.out.println("Hello, World");
	// }
	WPI_TalonFX left_front = new WPI_TalonFX(FRONT_LEFT_ID);
    WPI_TalonFX right_front = new WPI_TalonFX(FRONT_RIGHT_ID);
    WPI_TalonFX left_back = new WPI_TalonFX(BACK_LEFT_ID);
    WPI_TalonFX right_back = new WPI_TalonFX(BACK_RIGHT_ID);
}
