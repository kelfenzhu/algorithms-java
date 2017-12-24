package algorithms.sort;

public class SorterUtils {
	/**
	 * 
	 * @param dataSet
	 * @param col
	 *            - order by which column void
	 */
	public static void mergeSort(String[][] dataSet, int col) {
		if (dataSet == null || dataSet.length < 2) {
			return;
		}
		int len = 1;
		String[][] tempList = new String[dataSet.length][2];
		while (len < dataSet.length) {
			for (int i = 0; i < dataSet.length; i += 2 * len) {
				merge(dataSet, tempList, i, len, col);
			}
			System.arraycopy(tempList, 0, dataSet, 0, dataSet.length);
			len = 2 * len;
		}

	}

	/**
	 * Merge two ordered sub arrays.
	 * 
	 * @param dataSet
	 * @param temp
	 * @param start - first sub array index
	 * @param len - sub array length
	 * @param col
	 *            - order by which column void
	 */
	private static void merge(String[][] dataSet, String[][] temp, int start, int len, int col) {
		// first sub array
		int a_index = start;
		int a_len = start + len;

		// second sub array
		int b_index = start + len;
		int b_len = b_index + len;

		int tempListIndex = start;
		while (a_index < a_len && b_index < b_len && b_index < dataSet.length) {
			if (dataSet[a_index][col].compareTo(dataSet[b_index][col]) > 0) {
				temp[tempListIndex++] = dataSet[b_index++];
			} else {
				temp[tempListIndex++] = dataSet[a_index++];
			}
		}

		while (a_index < a_len && a_index < temp.length) {
			temp[tempListIndex++] = dataSet[a_index++];
		}

		while (b_index < b_len && b_index < temp.length) {
			temp[tempListIndex++] = dataSet[b_index++];
		}

	}
}
