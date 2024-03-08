package week2;

public class TwoStackAlgorithm {
    public static Double calculate(String expression) {

        String[] str=expression.split("\\s+");
        Queue<String> queue= new Queue<>();

        for(String s:str){
            queue.enqueue(s);
        }

        Stack<String> op = new Stack<>();
        Stack<Double> val = new Stack<>();
        while (!queue.isEmpty()){
            String string1= queue.dequeue();
            //skip (
            if (string1.equals("("));

            else if (string1.equals("+") || string1.equals("-") ||
                     string1.equals("/") || string1.equals("√") ||
                    string1.equals("^") || string1.equals("*") || string1.equals("%"))
                op.push(string1);

            else if (string1.equals(")"))
            {
                String op1 = op.pop();
                double v = val.pop();

                if (op1.equals("+")) v = val.pop() + v;
                else if (op1.equals("^")) v = Math.pow(val.pop(), v);
                else if (op1.equals("*")) v = val.pop() * v;
                else if (op1.equals("√")) v = Math.sqrt(v);
                else if (op1.equals("-")) v = val.pop() - v;
                else if (op1.equals("%")) v = val.pop() % v;
                else if (op1.equals("/")) v = val.pop() / v;

                val.push(v);
            }
            else val.push(Double.parseDouble(string1));
        }
        return val.pop();
    }
}
