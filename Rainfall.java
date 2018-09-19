

import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;

class Rainfall{
		public	String state;
		public	int year;
			
		public	double jan ; 
		public	double feb ; 
		public	double mar ; 
		public	double apr ; 
		public	double may ; 
		public	double jun ; 
		public	double jul ; 
		public	double aug ; 
		public	double sep ; 
		public	double oct ; 
		public	double nov ; 
		public	double dec ;	
		public	double annual ;
		
		
    
		public Rainfall(String s,int y,double a,double b,double c,double d,double e,double f,double g,double h,double i,double j,double k,double l,double total) {
		state =s;
		year =y;
		
		jan =a;
		feb =b;
		mar =c;
		apr =d;
		may =e;
		jun =f;
		jul =g;
		aug =h;
		sep =i;
		oct =j;
		nov =k;
		dec =l;
		
		annual =total;
	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String value=args[0];
		Scanner input = new Scanner(new File(value));
    
		input.useDelimiter(",|\n");
		ArrayList<Rainfall> rain = new ArrayList<Rainfall>();
			int i=0;
		while(input.hasNext()){
		
			String state = input.next();
			int year = Integer.parseInt(input.next());
			
			double jan = input.nextDouble();
			double feb = input.nextDouble();
			double mar = input.nextDouble();
			double apr = input.nextDouble();
			double may = input.nextDouble();
			double jun = input.nextDouble();
			double jul = input.nextDouble();
			double aug = input.nextDouble();
			double sep = input.nextDouble();
			double oct = input.nextDouble();
			double nov = input.nextDouble();
			double dec = input.nextDouble();
			
			double annual = input.nextDouble();
			
			Rainfall  newRain= new Rainfall(state, year, jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec, annual);
		
			rain.add(newRain);
			
		
		
		}	
		String location1="COASTAL KARNATAKA";
		String location2="NORTH INTERIOR KARNATAKA";
		String location3="SOUTH INTERIOR KARNATAKA";
		
		double costa_karna_avg=calculateavg(location1,rain);
		System.out.println("Average rainfall of costal karnatak  =   " +costa_karna_avg);
		System.out.println("");
		
		double north_karna_avg= calculateavg(location2,rain);
		double south_karna_avg= calculateavg(location3,rain);
	
		display_max_anual_sub_karna(costa_karna_avg ,north_karna_avg ,south_karna_avg);
		
	


		double sum=0;
		double count =0;
		double[] kerela_state_avg=new double[12];
		String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
		for (Rainfall ele:rain){
		String temp=ele.state;
		temp = temp.replaceAll("\\r", "");
		
		if(temp.toLowerCase().equals(("KERALA").toLowerCase())){			
					kerela_state_avg[0]+=ele.jan;
					kerela_state_avg[1]+=ele.feb;
					kerela_state_avg[2]+=ele.mar;
					kerela_state_avg[3]+=ele.apr;
					kerela_state_avg[4]+=ele.may;
					kerela_state_avg[5]+=ele.jun;
					kerela_state_avg[6]+=ele.jul;
					kerela_state_avg[7]+=ele.aug;
					kerela_state_avg[8]+=ele.sep;
					kerela_state_avg[9]+=ele.oct;
					kerela_state_avg[10]+=ele.nov;
					kerela_state_avg[11]+=ele.dec;
				
				count ++;
			}
			
			
		}
		
		double first=-1;
		double sec=-1;
		double third=-1;
		
		int first_ind=-1;
		int sec_ind=-1;
		int third_ind=-1;
		//for(int k=0;k<12;k++)
		//System.out.println(kerela_state_avg[k]);
		for(int inc=0;inc<12;inc++){
			if(kerela_state_avg[inc]>first){
					third=sec;
					sec=first;
					first=kerela_state_avg[inc];
					
					third_ind=sec_ind;
					sec_ind=first_ind;
					first_ind=inc;
					}
					
			else if(kerela_state_avg[inc]>sec){
					third=sec;
					sec=kerela_state_avg[inc];
					
					third_ind=sec_ind;
					sec_ind=inc;
					}
			else if(kerela_state_avg[inc]>third){
					third=kerela_state_avg[inc];
					
					third_ind=inc;
					}
			
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Hightst amount of rainfal in kerela are in the months");
		System.out.println("");
		System.out.println(months[first_ind]+" "+first);
		System.out.println(months[sec_ind]+" "+sec);
		System.out.println(months[third_ind]+" "+third);
		
	}
	
	public static double calculateavg(String location,ArrayList<Rainfall> rain){
		
		double sum=0;
		double count =0;
	
		for (Rainfall elements:rain){
		String temp=elements.state;
		temp = temp.replaceAll("\\r", "");

		if(location.toLowerCase().equals(temp.toLowerCase())){
				
				sum=sum+elements.annual;
				count ++;
			}

			
		}
		double avg=sum/count;
			return avg;
			
	}
	
	public static void display_max_anual_sub_karna(double costa_karna_avg ,double north_karna_avg,double south_karna_avg){
		if(costa_karna_avg>north_karna_avg){
		
			if(costa_karna_avg>south_karna_avg){
				System.out.println("Costal Karnatak Avg Rainfall =   " +costa_karna_avg);
				if(south_karna_avg>north_karna_avg){
					System.out.println("South Interior Karnatak Avg Rainfall =   " +south_karna_avg);
					System.out.println("North Interior Karnatak Avg Rainfall =   " +north_karna_avg);
				}
				else {
					System.out.println("North Interior Karnatak Avg Rainfall =   " +north_karna_avg);
					System.out.println("South Interior Karnatak Avg Rainfall =   " +south_karna_avg);
				}
			}
			else {
				System.out.println("South Interior Karnatak Avg Rainfall =   " +south_karna_avg);
				if(costa_karna_avg>north_karna_avg){
					System.out.println("Costal Karnatak Avg Rainfall =   " +costa_karna_avg);
					System.out.println("North Interior Karnatak Avg Rainfall =   " +north_karna_avg);
				}
				else {
					System.out.println("North Interior Karnatak Avg Rainfall =   " +north_karna_avg);
					System.out.println("Costal Karnatak Avg Rainfall =   " +costa_karna_avg);
					
				}
					
			}
		}
		
		else {
			if(north_karna_avg>south_karna_avg){
				System.out.println("North Interior Karnatak Avg Rainfall =   " +north_karna_avg);
				if(south_karna_avg>costa_karna_avg){
					System.out.println("South Interior Karnatak Avg Rainfall =   " +south_karna_avg);
					System.out.println("Costal Karnatak Avg Rainfall =   " +costa_karna_avg);
				}
				else{
					System.out.println("Costal Karnatak Avg Rainfall =   " +costa_karna_avg);
					System.out.println("South Interior Karnatak Avg Rainfall =   " +south_karna_avg);
				}
			}
		else{ 
				System.out.println("South Interior Karnatak Avg Rainfall =   " +south_karna_avg);
				if(costa_karna_avg>north_karna_avg){
					System.out.println("Costal Karnatak Avg Rainfall =   " +costa_karna_avg);
					System.out.println("North Interior Karnatak Avg Rainfall =   " +north_karna_avg);
				}
				else {
					System.out.println("North Interior Karnatak Avg Rainfall =   " +north_karna_avg);
					System.out.println("Costal Karnatak Avg Rainfall =   " +costa_karna_avg);
					
				}
			}
		}
		
		
		
		
	}
}