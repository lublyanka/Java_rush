package com.javarush.task.task21.task2113;
import java.util.*;
import java.util.stream.Stream;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public Horse getWinner(){
        Horse winner = horses.stream().max(Comparator.comparing(Horse::getDistance)).get();
    return winner;
    }
    public void printWinner(){
        System.out.print("Winner is " + getWinner().getName() + "!");
    }
    public void run(){
        try {
            for (int i = 0; i < 100; i++) {
                move();
                print();
                Thread.sleep(200);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getStackTrace());
        }

    }
    public void move(){
        for (ListIterator<Horse> it = horses.listIterator(); it.hasNext(); ) {
            it.next().move();
        }
    }
    public void print(){
        for (ListIterator<Horse> it = horses.listIterator(); it.hasNext();){
            it.next().print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }


    }
    public static void main(String[] args) {

        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Рябушка",3,0));
        horses.add(new Horse("Конек-горбунок",3,0));
        horses.add(new Horse("Шпионка",3,0));
        game= new Hippodrome(horses);

        game.run();

        game.printWinner();
    }

}
