package com.kelas;
import java.util.*;

// class Player
class Player{
    public String name;
    public int speed;
    public int healthPoint;
    
    // player berlari
    public void run(){
        if(this.healthPoint > 0){
            System.out.println(this.name + " sedang berlari");
        } else {
            System.out.println(this.name + " diam");
        }
    }
    
    // status kesehatan player
    public void isDead(){
        if(this.healthPoint <= 0){
            System.out.println(this.name + " telah mati");
        }else if(this.healthPoint > 0 && this.healthPoint <= 50){
            System.out.println(this.name + " sedang sekarat, health point = " + this.healthPoint);
        }else if(this.healthPoint > 50 && this.healthPoint <= 70){
            System.out.println(this.name + " masih sehat, health point = " + this.healthPoint);
        }else{
            System.out.println(this.name + " sehat bugar, health point = " + this.healthPoint);
        }
    }
    
    // player menyerang
    int action(int inputUser, String penyerang, int healthPointKorban){
        if(inputUser == 1){
            healthPointKorban = healthPointKorban - 15;
            System.out.println(penyerang + " menembak lawan");
            return healthPointKorban ;
        }else if(inputUser == 2){
            healthPointKorban = healthPointKorban - 10;
            System.out.println(penyerang + " memukul lawan");
            return healthPointKorban ;
        }else{
            System.out.println(penyerang + " berlari");
            return healthPointKorban ;              
        }
    }
    
    // show
    int winner(int kondisi,String player1, String player2, int healthPoint1, int healthPoint2){
        if(healthPoint1 > 0 && healthPoint2 > 0 ){
            return 1;
        }else if(healthPoint1 <= 0 && healthPoint2 > 0 ){
            System.out.println("Pemenang = " + player2);
            return 0;
        }else if(healthPoint1 > 0 && healthPoint2 <= 0 ){
            System.out.println("Pemenang = " + player2);
            return 0;
        }else{
            return 0;
        }
    }  
}

public class Main {
    public static void main(String[] args) {
        int pilihan, i = 1;
        // input user
        Scanner inputData = new Scanner(System.in);
        
        // objek player
        Player player1 = new Player();
        Player player2 = new Player();
        
        // rules
        System.out.println("==== RULES =====");
        System.out.println("Aksi\n-Ditembak -15\n-Dipukul -10\n-Berlari -0");
        System.out.println("Health Point\n<=0 Mati\n>0 & <=50 sekarat\n>50 & <=70 masih sehat\n>70 sehat bugar\n");
        
        // data player1 & player2
        System.out.println("Player 1 : ");
        System.out.print("Nama : "); player1.name = inputData.next();
        System.out.print("Speed : "); player1.speed = inputData.nextInt();
        System.out.print("Health Point : "); player1.healthPoint = inputData.nextInt();
        System.out.print("\n");
        System.out.println("Player 2 : ");
        System.out.print("Nama : "); player2.name = inputData.next();
        System.out.print("Speed : "); player2.speed = inputData.nextInt();
        System.out.print("Health Point : "); player2.healthPoint = inputData.nextInt();
       
        // pilihan aksi
        System.out.println("\nPilihan aktivitas : ");
        System.out.println("1. Menembak\n2. Memukul\n3. Berlari\n");
        
        // looping sampai salah satu player menang
        while( i != 0){
            // memasukkan aksi
            System.out.print("aksi " + player1.name + " : ");
            player2.healthPoint = player1.action(pilihan = inputData.nextInt(), player1.name,player2.healthPoint);
            System.out.print("\n");
            player1.run();
            player1.isDead();
            System.out.print("\n");
            player2.run();
            player2.isDead();
            i = player1.winner(i, player1.name, player2.name, player1.healthPoint, player2.healthPoint);
            
            System.out.print("\naksi " + player2.name + " : ");
            player1.healthPoint = player1.action(pilihan = inputData.nextInt(), player2.name,player1.healthPoint);      
            System.out.print("\n");
            player1.run();
            player1.isDead();
            System.out.print("\n");
            player2.run();
            player2.isDead();
            i = player2.winner(i, player1.name, player2.name, player1.healthPoint, player2.healthPoint);
        }
    }
    }

