class FindMaximum {
	int[] test_arr;

	public int find_maximum(int[] arr) {
		int i;
		int maximum;
		int value;

		i = 1;
		maximum = arr[0];
		while (i < arr.length) {
			value = arr[i];
			if (maximum < value) {
				maximum = value;
			} else {
				maximum = i;
			}
			// i = i + 1;
		}

		return maximum;
	}

	public int build_test_arr() {
		test_arr = new int[5];
		test_arr[0] = 14;
		test_arr[1] = 28;
		test_arr[2] = 0;
		test_arr[3] = 0-5; // No unary minus in Java--
		test_arr[4] = 12;

		return 0;
	}

	public int[] get_array() {
		return test_arr;
	}

	public static void main(String[] args) {
		FindMaximum fm;

		fm = new FindMaximum();
		fm.build_test_arr();

		ioPlus.printResult(fm.find_maximum(fm.get_array()));
	}
}
