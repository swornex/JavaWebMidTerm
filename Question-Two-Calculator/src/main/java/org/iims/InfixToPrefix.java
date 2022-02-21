package org.iims;

import java.util.Stack;

public class InfixToPrefix {

        static int priority(char c){
            switch (c){
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
            }
            return -1;
        }

        public static String infixToPrefix(String expression){
            StringBuilder output = new StringBuilder();
            StringBuilder input = new StringBuilder(expression);
            Stack<Character> stack = new Stack<>();

            input.reverse();

            char [] charsExpression = new String(input).toCharArray();

            for (int i = 0; i < charsExpression.length; i++) {

                if (charsExpression[i] == '(') {
                    charsExpression[i] = ')';
                    i++;
                }
                else if (charsExpression[i] == ')') {
                    charsExpression[i] = '(';
                    i++;
                }
            }

            for (char exp : charsExpression) {
                if (priority(exp) > 0) {
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(exp))
                        output.append(stack.pop());

                    stack.push(exp);
                } else if (exp == ')') {
                    char x = stack.pop();

                    while (x != '(') {
                        output.append(x);
                        x = stack.pop();
                    }
                } else if (exp == '(')
                    stack.push(exp);
                else
                    output.append(exp);
            }

            for (int i = 0; i <=stack.size() ; i++)
                output.append(stack.pop());

            return output.reverse().toString();
        }
    }


