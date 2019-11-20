import java.util.Arrays;
import java.util.stream.Stream;

public class SortNumbers {
	
	public static int[] sortNumbersAccordingToSumOfDigits(String input)	
	{
		Stream<String> inputAsStrArray = Stream.of(input.split(" "));
		int[] intArray = inputAsStrArray.mapToInt(Integer::parseInt).toArray();

		return Arrays.stream(intArray)
				.boxed()
				.sorted((b, a) -> {
					Integer aSum = String.valueOf(a).chars().map(Character::getNumericValue).sum();
					Integer bSum = String.valueOf(b).chars().map(Character::getNumericValue).sum();

				    if (aSum == bSum) {
				    	return a.compareTo(b);
				    }
					return bSum.compareTo(aSum);
				})
				.mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		String input = "12 54 8 19 39 5000 45 23 65 1 9 28 11 2000 11";
     	System.out.println(Arrays.toString(sortNumbersAccordingToSumOfDigits(input)));
	}

}
