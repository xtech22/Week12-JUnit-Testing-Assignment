import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource; 


class TestDemoTest {

	//Creates a new object of TestDemo
	
	TestDemo testDemo = new TestDemo();
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	/*
	 *Tests the value of expectException. If false, assert that when TestDemo.addPositive is called, the result is the same as parameter "expected".
	 *If true, it throws an instance of the "IllegalArgumentException" class.
	 */
	
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly() {
		int a = 0;
		int b = 0;
		int expected = 0;
		boolean expectException = true;
		
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> 
		    testDemo.addPositive(a, b))
	        .isInstanceOf(IllegalArgumentException.class);	
		}
	}
	/*
	 *This method returns a stream of "Arguments". Each parameter set is wrapped in a "arguments" method call.
	 *Each argument helps test the "addPositive" method so that it runs correctly.
	 */
		static Stream<Arguments> argumentsForAddPositive() {
			return Stream.of(
					Arguments.arguments(2, 4, 6, false),
					Arguments.arguments(-2, 5, 3, false),
					Arguments.arguments(0, 6, 6, false),
					Arguments.arguments(1, 3, 4, false),
					Arguments.arguments(-5, 5, 0, true)
					);

	}
		/*
		 *This method tests "randomNumberSquared()". It creates a mock of "TestDemo" using "Mokito" spy.
		 *The mocked "TestDemo" object is then programmed to return 6 when the "getRandomInt()" method is called.
		 */	
		
	@Test 
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(6).when(mockDemo).getRandomInt();
		
		int sixSquared = mockDemo.randomNumberSquared();
		
		assertThat(sixSquared).isEqualTo(36);
	}
		
}
