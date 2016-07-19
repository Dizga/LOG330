package org.pbit.ci.travis.java;

public class Calcul {

  public double Variance(double tab[]){
  
    int nbVal;
	  double moyenne;
	  double variance;
  
    moyenne = Somme(tab)/tab.length;
		nbVal = tab.length;
		
		double[] tabDistance = new double[nbVal];
		for(int i=0;i<tab.length;i++){
			tabDistance[i]=(tab[i]-moyenne)*(tab[i]-moyenne);
		}
		variance = Somme(tabDistance)/(nbVal-1);
  }

  public double Somme(double tab[]){
		double result = 0;
		for(double donne:tab){
			result+=donne;
		}
		return result;
	}
}
