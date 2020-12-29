package walk.random.average;
import java.util.*;

public class WalkAverage
{
   public static int randomWalk(int  x)
   {
	   Random random = new Random();                   //new random object
	   int i;                                          //declare variable outside of loop to be able to use outside of loop
	   int position = 0;                               //same with this
	   
	   for (i=0; Math.abs(position) < x; i++)          //loops as long as the absolute value of the position is less than
	   {
		   int n = random.nextInt(2);                  //returned random value of 0 or 1 stored in n
	       if (n == 0)                                 //different outcomes depending on what is in n
	       {
	    	   position -=1;                           //1 is subtracted from the position
	       }
	       if (n == 1)
	       {
	           position +=1;                           //1 is added to position
	       }
	   }
	   return i;                                       //returns the number of steps it took to get to desired walk length
   }
   
   public static double walkAverage(int x)
   {
	   int n = 0;                                      //declare variable to be able to use outside for loop
      
	   for(int i = 1; i <= 10000; i++)                 //runs the same randomWalk 10,000 times
	   {
		   n += randomWalk(x);                         //adds number of steps taken to get to walk size to n
	   }
      
	   double average = n/10000.0;                     //finds average number (in 10,000 tries) of steps taken to get to certain walk size
      
	   return average;                                 //returns the average
   }
   
   public static void main(String[] args)
   {
	   Scanner input = new Scanner(System.in);         //scanner object created to read user input
      
	   System.out.println("What size walk do you want to test?");
	   int x = input.nextInt();                        //stores users desired walk size into variable x
      
	   System.out.println("For a walk size of "+x+", after "+
	   "10,000 tries, on average it took "+walkAverage(x)+
	   " steps to get there.");                        //tells the user how many steps on average does it take to get to that walk size
   }
}