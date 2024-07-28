package org.example;

public class TaskTrio implements Runnable{

    private int max;
    private PrintTrio printTrio;
    private String numberType;


    public TaskTrio(int max,PrintTrio printTrio, String numberType){
        this.max=max;
        this.printTrio=printTrio;
        this.numberType= numberType;
    }
    @Override
    public void run() {
        int number = 0;
        switch(numberType) {
            case("ONE"):
                number=1;
                break;
            case("TWO"):
                number=2;
                break;
            case ("THREE"):
                number=3;
                break;
        }
        while(number<=max){
            if(number%3==1){
                printTrio.printOne(number);
            }
            else if (number%3==2){
                printTrio.printTwo(number);
            }
            else {
                printTrio.printThree(number);
            }
            number+=3;
        }
    }
}
