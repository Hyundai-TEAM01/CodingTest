import java.util.*;
class Solution {
    public long solution(String expression) {
			long answer = 0;
			boolean[] used = new boolean[3];
			char[][] ops = {{ '+', '-', '*' }, {'+', '*', '-'},
					{ '-', '+', '*' }, {'-', '*', '+'},
					{ '*', '-', '+' }, {'*', '+', '-'}};

			for(int i = 0; i < ops.length; i++) {
				answer = Math.max(answer, convert(expression,ops[i]));
			}

			return answer;
		}

		public long convert(String exp, char[] ops) {
			String[] numbers = exp.split("[*+-]+");
			String[] op = exp.split("[0-9]+");
			ArrayList<Long> li_nums = new ArrayList();
			ArrayList<Character> li_op = new ArrayList();

			for (int i = 0; i < numbers.length; i++) {
				li_nums.add(Long.parseLong(numbers[i]));
			}
			for (int i = 0; i < op.length; i++) {
				if (!op[i].equals("")) {
					li_op.add(op[i].charAt(0));
				}
			}

			for (int i = 0; i < 3; i++) {
				char now_op = ops[i];
				int r = 0;
				for (int j = 0; j < li_op.size(); j++) {
					if (li_op.get(j) == now_op) {
						int idx = j - r;

						if (now_op == '-') {
							long sum = li_nums.remove(idx) - li_nums.remove(idx);
							li_nums.add(idx, sum);
							r++;
						} else if (now_op == '+') {
							long sum = li_nums.remove(idx) + li_nums.remove(idx);
							li_nums.add(idx, sum);
							r++;
						} else {
							long sum = li_nums.remove(idx) * li_nums.remove(idx);
							li_nums.add(idx, sum);
							r++;
						}

					}
				}
				while (li_op.contains(now_op)) {
					li_op.remove((Object)now_op);
				}
			}

			return Math.abs(li_nums.get(0));
		}

}