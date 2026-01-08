/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Chamindi
 */
public class HanoiTower {public static void hanoiTower(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        
        hanoiTower(n - 1, source, target, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        hanoiTower(n - 1, auxiliary, source, target);
    }

    
     
    public static void main(String[] args) {
        int n = 3; 
        System.out.println("Solving Tower of Hanoi with " + n + " disks:");
        hanoiTower(n, 'A', 'B', 'C');
    }
}
      
    
    

