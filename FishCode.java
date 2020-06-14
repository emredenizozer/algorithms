import java.util.Stack;

public class FishCode {
    public static int getAliveFishes(int[] weightArr, int[] directionArr) {
        Stack<Integer> stack = new Stack<>();
        int alives = 0;

        for (int i = 0; i < weightArr.length ; i++) {
            int weight = weightArr[i];

            if (directionArr[i] == 1) {
                stack.push(weight);
            } else {
                int top = stack.isEmpty() ? -1 : stack.pop();

                while (top != -1 && top < weight) {
                    top = stack.isEmpty() ? -1 : stack.pop();
                }

                if (top == -1) {
                    alives++;
                } else {
                    stack.push(top);
                }
            }
        }

        return stack.size() + alives;
    }

    public static void main(String[] args) {
        int[] weight1 = {8, 12, 5, 9, 10};
        int[] dir1 = {-1, 1, 1, -1, -1};

        int[] weight2 = {5, 4, 3, 2, 6};
        int[] dir2 = {-1, 1, -1, -1, -1};

        int[] weight3 = {5, 4, 3, 2, 6};
        int[] dir3 = {1, 1, -1, 1, -1};

        int[] weight4 = {4, 8, 6, 9, 3, 1};
        int[] dir4 = {-1, 1, 1, -1, -1, 1};

        System.out.println("Alive fish count: " + getAliveFishes(weight1, dir1));
        System.out.println("Alive fish count: " + getAliveFishes(weight2, dir2));
        System.out.println("Alive fish count: " + getAliveFishes(weight3, dir3));
        System.out.println("Alive fish count: " + getAliveFishes(weight4, dir4));
    }
}