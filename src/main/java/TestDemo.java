import java.util.Random;


public class TestDemo {
	
	/*
	 *Tests to see if both parameters, a and b, have a sum greater than zero.
	 *If not, it will throw an illegal argument exception.
	 */

		public int addPositive(int a, int b) {
			if(a > 0 && b > 0) {
				return a + b;
			} else {
				throw new IllegalArgumentException ("Both parameters must be positive!");
			}
			
		}
		
		/*
		 *This method contains a random int by calling the "getRandomInt()" method and 
		 *returns the square of that integer.
		 */
		
		int randomNumberSquared() {
			int i = getRandomInt();
			return i * i;
		}
			 int getRandomInt() {
				 Random random = new Random();
				  return random.nextInt(10) + 1;

			
			}
			

		}
	


