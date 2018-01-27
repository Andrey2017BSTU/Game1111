package game1111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class Field{
    static char mas[][] = new char [10][10];
     static int r1,r2 ;
    void inField(int obs){
        int k = 0;
        for (int l=0;l < mas.length;l++){//написал заполнение массива буквами О 
    for (int m=0;m < mas[l].length;m++){
      mas[l][m]='O';
      }}
         while(k<obs){
            r1=(int)(Math.random()*10);
            r2=(int)(Math.random()*10);
            mas[r1][r2]='l';
            if (mas[9][0] != 'l' && mas[0][9] != 'l') {  
                k++;
            }  
        }    
    }
    void printField(){
        for (char[] ma : mas) {// Тут переписал цикл
            for (int j = 0; j < mas.length; j++) {
                System.out.print(ma[j] + "\t");
            } 
            System.out.println();
        }
    }
}

class Hero{
    int x=0, y=9, step = 0;
    void hh(){
        Field.mas[y][x]='X';
        Field.mas[0][9]='Y';//цель
    }
    
    
}

class Game{
    private int getDirection(){
        int direction = 0;
        

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            direction = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            System.out.println("Ошибка ввода!!!");
        }
      b=direction;
      return direction;
    }
    
    Hero h = new Hero();
    Field f = new Field();
    int b=0;
    void move(){  int y1, y2, x1, x2;
        switch(b){
            case 8: /*if (Field.mas[--h.y][h.x]==1) {h.y++;System.out.println ("Game Over");break;}else *//*b=8;*/y1=++h.y; h.y--; Field.mas[y1][h.x]='O'; break ;///добил идею свою наконец 
            case 2: /*if (Field.mas[++h.y][h.x]==1) {h.y--;System.out.println ("Game Over");break;}else*//* b=2;*/y2=--h.y; h.y++; Field.mas[y2][h.x]='O'; break;// блять ебался с этим пока наконец не понял,
            case 4: /*if (Field.mas[h.y][--h.x]==1) {h.x++;System.out.println ("Game Over");break;}else*/ /*b=4;*/x1=++h.x; h.x--; Field.mas[h.y][x1]='O'; break;///что ты массив задал через y;x ,а не 
            case 6: /*if (Field.mas[h.y][++h.x]==1) {h.x--;System.out.println ("Game Over");break;}else */x2=--h.x; h.x++; Field.mas[h.y][x2]='O';/*b=6;*/ break;// через x;y 
            //default: System.out.println("Неверное направление!");
        
        }
    }
        boolean check_move(){ boolean a = true;
        switch(getDirection()){
        case 8: if (Field.mas[--h.y][h.x]=='l') {++h.y;System.out.println ("Game Over");a=false;}break;
        case 2: if (Field.mas[++h.y][h.x]=='l') {h.y--;System.out.println ("Game Over");a=false;}break;
        case 4: if (Field.mas[h.y][--h.x]=='l') {h.x++;System.out.println ("Game Over");a=false;}break;
        case 6: if (Field.mas[h.y][++h.x]=='l') {h.x--;System.out.println ("Game Over");a=false;}break;
       // default: System.out.println("Неверное направление!");
        } return a;
       // System.out.println(h.x);
    }
        boolean check_direction (){ boolean napr=false;
        if (b!=8 && b!=2 && b!=4 && b!=6){
        napr=false;
        }
        else napr=true;
        return napr;
        }
        
   
    void startGame(){
        f.inField(10);//добавил препятствий
        while(h.x!=9 || h.y!=0){//попробовать написать первый заход также ,дальше что б сначала ход потом поле, что б сообщение об ошибке было после поля ,а не перед
            h.hh();
            f.printField();
            if (check_move()==true)
                move();
            
         else {
                System.exit(0);
            }
            if (check_direction()==false){
            System.out.println("Неверное направление");//тут баг маленький есть   
            check_move();//когда неврное нажатие срабатывает и ты по-новому нажимаешь
            }//старое положение героя остаётся
            else {//и дальше всё норм хз как пофиксить
                move();
            }
        }
        System.out.println ("This game is yours)))\nCongratulations");
    }
}
    
public class Game1111 {

    public static void main(String[] args) {
       Game gm = new Game();
       gm.startGame();
    }
}
