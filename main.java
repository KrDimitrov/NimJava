import java.util.Scanner;

class nim {
  static boolean run = true;
  static int mLeft = 15;
  static int playerLastTurn = 0;

  public static void main(String args[]){
    System.out.println("Welcome to the game of Nim!\nThe rules are simple, there are 15 matches in a pile.\nThe goal is to make your opponent take the last match.\nYou are alllowed to take the amount between 1 and 3");

    while(run){
      System.out.println("\nThere are " + mLeft + " matches left!");
      PlayersTurn();
      ComputersTurn();
    }
    sc.close();
  }

  static boolean ComputersTurn(){
    if(!run) return false;
    System.out.println("Its Computers Turn!");
    if(mLeft == 1){
      run = false;
      System.out.println("You Won!!");
      return true;
    }
    int took = 5 - playerLastTurn;
    if(took>3) took = 3;
    if(took <1) took =1;
    if((mLeft - took) == 0) took = 1;
    if((mLeft - took)<1) took = 3 - playerLastTurn;
    mLeft -= took;
    System.out.println("Computer took " + took + " matches!");
    return true;
  }

  static Scanner sc = new Scanner(System.in);
  static boolean PlayersTurn(){
    if(!run) return false;
    System.out.println("Its your Turn!");
    if(mLeft == 1){
      run = false;
      System.out.println("You Lost!!");
      return true;
    }
    System.out.print("How many matches do you take?: ");
    int took = sc.nextInt();
    if(took > 3 || took < 1){
      System.out.println("Read the rules!!");
      return false;
    }
    mLeft -= took;
    System.out.println("You Took " + took + " matches!");
    playerLastTurn = took;
    return true;

  }
}
