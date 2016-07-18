import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/*
 * tp1
 * 
 * 
*/
public class TP extends JPanel{
	static int nbVal;
	static double mean;
	static double variance;
	static double deviation;
	static double confidence;

	public static void main(String[] args){
		double[] tab;
		double t90 = 2.132;			//valeur t pour df = 4
		double t80 = 1.533;
		double t70 = 1.19;
		
		TP first = new TP();
		tab = first.chooseFile();
		
		mean = Add(tab)/tab.length;
		nbVal = tab.length;
		
		double[] tabDistance = new double[nbVal];
		for(int i=0;i<tab.length;i++){
			tabDistance[i]=(tab[i]-mean)*(tab[i]-mean);
		}
		variance = Add(tabDistance)/(nbVal-1);
		deviation = Math.sqrt(variance);
		
		confidence = deviation*Math.sqrt(nbVal);
		
		System.out.println("Intervalle 90 : " + (900-t90*confidence)+" < 900 < "+ (900+t90*confidence));
		System.out.println("Intervalle 80 : " + (900-t80*confidence)+" < 900 < "+ (900+t80*confidence));
		System.out.println("Intervalle 70 : " + (900-t70*confidence)+" < 900 < "+ (900+t70*confidence));
	}
	public double[] chooseFile(){
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(TP.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            Scanner sc;
			try {
				sc = new Scanner(file);
				double[] tab = new double[sc.nextInt()];
	            for (int i=0;i<tab.length;i++){
	            	tab[i]=sc.nextDouble();
	            }
	            sc.close();
	            return tab;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
		}
		return null;
	}
	
	public static double Add(double tab[]){
		float result = 0;
		for(double donne:tab){
			result+=donne;
		}
		return result;
	}
}
