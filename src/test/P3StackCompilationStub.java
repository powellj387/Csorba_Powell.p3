
package test;

import war.ULEmptyStackException;
import war.ULStack;


/**
 * This class is designed to help you test whether your ULStack code will compile in my JUnit tests.
 * Be sure that you can compile this class, unmodified.  
 * If your code does not compile with this class, I will not be able to test your code.
 * If your code does compile with this class, odds are good it will compile in my JUnit tests.
 * Your code compiling with this class is not a sufficient level of testing.
 * @author Joe Meehean
 *
 */

public class P3StackCompilationStub {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		ULStack<Integer> stack = new ULStack<>();
		stack.clear();
		ULStack<Integer> copy = stack.clone();
		boolean empty = stack.empty();
		Integer i = Integer.valueOf(8);
		stack.push(i);
		Integer i2 = stack.top();
		i2 = stack.pop();
		int size = stack.size();
		RuntimeException e1 = new ULEmptyStackException();
		RuntimeException e2 = new ULEmptyStackException("hello");
	}
}
