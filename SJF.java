package testing;

import java.util.Scanner;
import java.util.Arrays;
public class SJF {
	int[] WT,BT,TT;
	int rep;
	Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("\t Copy rights of Sheraz Ahmed");
		System.out.println("\n\t****** SJF ******");
		SJF task1=new SJF();
		task1.storeBT();
		task1.displayWaitTime(task1.getWaitTime());
		task1.displayTurnaroundTime(task1.getTurnaroundTime());
		task1.showGanttChart();
		System.out.println("\t Copy rights of Sheraz Ahmed");
		}
		public SJF(){
		System.out.println("\nEnter total number of pocesses : ");
		rep=s.nextInt();
		WT=new int[rep];
		BT=new int[rep];
		TT=new int[rep];
	}
	
	public void storeBT(){
		for(int i=0;i<rep;i++){
			System.out.print("\nEnter the Burst Time of Process "+(i+1)+" : ");
			BT[i]=s.nextInt();
		}
		Arrays.sort(BT);
		
	}
	public int[] getWaitTime(){
		for(int x=0;x<rep;x++){
			for(int i=0;i<x;i++){
				if(x==0){
					WT[x]=0;
					continue;
				}else{
					WT[x]+=BT[i];
				}
			}
		}
		return WT;
	}
	
	public void displayWaitTime(int[] array){
		System.out.println("\n\t****** Waiting Time ******\n");
		for(int x=0;x<rep;x++){
			System.out.print("Process # "+(x+1)+" : \t "+array[x]+"\n");
		}
		
		System.out.println("\n\t=> Average Waiting Time for "+rep+" Processes : "+calculateAvgWT()+"\n");
	}
	public int calculateAvgWT(){
		int sum=0;
		for(int x=0;x<rep;x++){
			sum+=WT[x];
		}
		return sum/rep;
	}
	
	public int[] getTurnaroundTime(){
		for(int x=0;x<rep;x++){
			TT[x]=BT[x]+WT[x];
		}
		return TT;
	}
	
	public void displayTurnaroundTime(int[] array){
		System.out.println("\n\t****** Turnaround Time ******\n");
		for(int x=0;x<rep;x++){
			System.out.print("Process # "+(x+1)+" : \t "+array[x]+"\n");
		}
		
		System.out.println("\t=> Average Turnaround Time for "+rep+" Processes : "+calculateAvgTT()+"\n");
	}
	public int calculateAvgTT(){
		int sum=0;
		for(int x=0;x<rep;x++){
			sum+=TT[x];
		}
		return sum/rep;
	}
	public void showGanttChart(){
		System.out.println("\n\t****** Gantt Chart ******\n");
		for(int x=0;x<=rep;x++){
			if(x!=rep){
				System.out.print("|__p"+(x+1)+"___");
			}else{
				System.out.print("|");
			}
	}
		System.out.print("\n0");
		for(int x=0;x<rep;x++){
			if(TT[x]<10){
				System.out.print("       "+TT[x]);
			}else{
				System.out.print("      "+TT[x]);
			}
	}
		
	}
	
}
