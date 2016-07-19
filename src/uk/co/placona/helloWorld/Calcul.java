package uk.co.placona.helloWorld;

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
		variance = Somme(tabDistance)/(nbVal);
		return variance;
  	}
  	
  	public double Correlation(double tabXY[][]){
  
    		int nbVal = tabXY[0].length;
	  	double[] tabSXY,tabSXX,tabSYY;
		double sX,sY,sXX,sXY,sYY;
	  	double correlation;
  
    		tabSXY = multiplication(tabXY[0],tabXY[1]);
		tabSXX = multiplication(tabXY[0],tabXY[0]);
		tabSYY = multiplication(tabXY[1],tabXY[1]);
		sX = Somme(tabXY[0]);
		sY = Somme(tabXY[1]);
		sXX = Somme(tabSXX);
		sXY = Somme(tabSXY);
		sYY = Somme(tabSYY);
		correlation = (nbVal*sXY-sX*sY)/Math.sqrt((nbVal*sXX-sX*sX)*(nbVal*sYY-sY*sY));
		return correlation;
  	}
  	
  	public double RegLin(double tabXY[][],boolean choix){
  
    		int nbVal = tabXY[0].length;
	  	double[] tabSXY,tabSXX;
		double sXX,sXY,mX,mY,b1,b2;
  
  		tabSXY = multiplication(tabXY[0],tabXY[1]);
		tabSXX = multiplication(tabXY[0],tabXY[0]);
    		mX = Somme(tabXY[0])/nbVal;
		mY = Somme(tabXY[1])/nbVal;
		sXX = Somme(tabSXX);
		sXY = Somme(tabSXY);
		b1= (sXY-nbVal*mX*mY)/(sXX-nbVal*mX*mX);
        	b2= mY-b1*mX;
		if(choix){
			return b1;
		}else{
			return b2;
		}
  	}
  	
  	public double RegLinB1(double sXY,double sXX,int nbVal,double mX,double mY){
  		return (sXY-nbVal*mX*mY)/(sXX-nbVal*mX*mX);
  	}
  	public double RegLinB2(double b1,double mX,double mY){
  		return mY-b1*mX;
  	}

  	public double Somme(double tab[]){
		double result = 0;
		for(double donne:tab){
			result+=donne;
		}
		return result;
	}
	public static double[] multiplication(double tab[],double tab1[]){
		double[] multi =new double[tab.length];
		for (int i=0;i<tab.length;i++){
			multi[i]=tab[i]*tab1[i];
		}
		return multi;
	}
}
