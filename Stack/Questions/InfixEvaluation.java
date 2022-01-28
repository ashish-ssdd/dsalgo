package Stack.Questions;

import java.util.Stack;

public class InfixEvaluation {

    public static int precedence(String token){
        switch(token){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }

        return -1;
    }
    //Evaluate infix expression with stacks in one pass
    public int expressionEvaluation(String[] tokens){
        //using two stacks without converting to postfix expression
        Stack<Integer> operand = new Stack<>();
        Stack<String> operator = new Stack<>();
        for(String token: tokens ){
            if( token == "("){
                operator.push(token);
            } else if(token == ")"){
                while(operator.peek() != "("){
                    int output = performOperation(operand, operator);
                    operand.push(output);
                }
                operator.pop();
            } else if(isOperator(token)){
                while(!operator.isEmpty() && precedence(token) <= precedence(operator.peek())){
                    int output = performOperation(operand, operator);
                    operand.push(output);
                }
                operator.push(token);
            } else{
                operand.push(Integer.parseInt(token));
            }
        }

        while( !operator.isEmpty()){
            int output = performOperation(operand, operator);
            operand.push(output);
        }

        return operand.pop();

    }

    public boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }

    public int performOperation(Stack<Integer> operand, Stack<String> operator){
        int a = operand.pop();
        int b = operand.pop();

        String opeartion = operator.pop();
        switch(opeartion){
            case "+":
                return a + b;
            case "-":
                return b - a;
            case "*":
                return a * b;
            case "/":
                return b / a;
        }
        return 0;
    }
    
}
