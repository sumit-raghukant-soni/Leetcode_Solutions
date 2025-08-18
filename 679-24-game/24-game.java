class Solution {
    char cardP[][] = new char[24][4], k = 0;
    char signP[][] = new char[384][3];
    char signsO[] = {'+', '-', '/', '*'};
    List<String> lst = new ArrayList<>(), finalList = new ArrayList<>();
    public boolean judgePoint24(int[] cards) {
        char signs[] = new char[3];
        char[] cards2 = { (char) (cards[0] + '0'), (char) (cards[1] + '0'), (char) (cards[2] + '0'), (char) (cards[3] + '0')};
        
        perm1(cards2, 0);
        k=0;
        perm2(signs, 0);

        for(int i=0; i<24; i++){
            for(int j=0; j<384; j++){
                StringBuilder str = new StringBuilder();
                for(int k=0; k<4; k++){
                    str.append(cardP[i][k]);
                    if(k < 3) str.append(signP[j][k]);
                }
                lst.add(str.toString());
            }
        }

        // System.out.println(lst.size());

        for(int l=0; l<9216; l++){
            for(int i=0; i<6; i+=2){
                StringBuilder str = new StringBuilder(lst.get(l));
                str.insert(i, '(');
                str.append(')');
                for(int j=i+4; j<=7; j+=2){
                    str.insert(j, ")");
                    str.insert(j+2, "(");
                    finalList.add(str.toString());
                    str.deleteCharAt(j+2);
                    str.deleteCharAt(j);
                    if(j+2 > 7 && i != 0) finalList.add(str.toString());
                }
            }
        }

        // System.out.println(finalList);

        Double val = 24.0;
        for(String str : finalList){
            double tmp = evaluateExpression(str);
            if(Math.abs(tmp - val) < 1e-6) return true;
        }

        return false;
    }

    private void perm1(char cards[], int i){
        if(i == 4){
            for(int l=0; l<4; l++) cardP[k][l] = cards[l];
            k++;
            return;
        }

        for(int l=i; l<4; l++){
            char tmp = cards[l];
            cards[l] = cards[i];
            cards[i] = tmp;
            perm1(cards, i+1);
            tmp = cards[l];
            cards[l] = cards[i];
            cards[i] = tmp;
        }
    }

    private void perm2(char[] signs, int i){
        if(i == 3){
            for(int l=0; l<3; l++){
                signP[k][l] = signs[l];
            }
            k++;
            return;
        }

        for(int l=i; l<3; l++){
            for(int j=0; j<4; j++){
                char sign = signs[l];
                signs[l] = signsO[j];
                perm2(signs, i+1);
            }
        }
    }

    public static double evaluateExpression(String expression){
        char[] tokens = expression.toCharArray();

        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;

            if ((tokens[i] >= '0' && tokens[i] <= '9')
                || tokens[i] == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    sb.append(tokens[i]);
                    i++;
                }
                values.push(Double.parseDouble(sb.toString()));
                i--; 
            }
            else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            }
            else if (tokens[i] == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(
                        operators.pop(), values.pop(),
                        values.pop()));
                }
                operators.pop(); 
            }
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!operators.isEmpty()
                       && hasPrecedence(tokens[i],
                                        operators.peek()) ) {
                    values.push(applyOperator(
                        operators.pop(), values.pop(),
                        values.pop()));
                }
                operators.push(tokens[i]);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }

    private static boolean hasPrecedence(char operator1, char operator2){
        if (operator2 == '(' || operator2 == ')')
            return false;
        return (operator1 != '*' && operator1 != '/') || (operator2 != '+' && operator2 != '-');
    }

    private static double applyOperator(char operator, double b, double a){
        switch (operator) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0) return 0;
            return a / b;
        }
        return 0;
    }
}