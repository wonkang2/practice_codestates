
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calc cal = new Calc();
        // ***********************************
        System.out.println("=== Java Calculator 시작 ===");
        System.out.print("새로운 정수 입력 : ");
        cal.setNum(br.readLine());
        while (cal.isOn()) {
            System.out.print("연산자 입력 : ");
            cal.setOperator(br.readLine());
            System.out.print("새로운 정수 입력 : ");
            cal.setNum(br.readLine());
            cal.calculation();
        }
        // ***********************************
        System.out.println("=== Java Calculator 종료 ===");
    }
}

class Calc {
    private boolean isOn;
    private double result = 0;
    private double num;
    private String operator;

    public Calc() {
        this.isOn = true;
    }

    public void setNum(String num) {
        if (result == 0) {
            this.result = Integer.parseInt(num);
        } else {
            this.num = Integer.parseInt(num);
        }
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void calculation() {
        switch (operator) {
            case "+":
                result += num;
                break;
            case "-":
                result -= num;
                break;
            case "/":
                if (num == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    this.isOn = false;
                    return;
                }
                result /= num;
                break;
            case "*":
                result *= num;
                break;
            case "=":
                this.isOn = false;
                break;
            default:
                System.out.println("지원하지 않은 연산입니다.");
                this.isOn = false;
                return;
        }

        if (result % 1 <= 0) {
            System.out.println("결과 : " + (long) result);
        } else {
            System.out.println("결과 : " + result);

        }
    }
    public boolean isOn() {
        return isOn;
    }
}

