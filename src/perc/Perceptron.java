package perc;

import java.io.IOException;

/**
 * 
 * @author lpbus
 *	Class Perceptron that emulates a perceptron
 */
public class Perceptron {
	double weightA;
	double weightB;
	double bias;
	double LearningConstant;
	/**
	 * Set the weights of the perceptron entries
	 * @param A weight of the first entry
	 * @param B weight of the second entry
	 */
	public void setWeights(double A, double B){
		this.weightA =A;
		this.weightB =B;
	}
	/**
	 * Set the bias of the perceptron
	 * @param bias quantity of bias
	 */
	public void setBias(double bias){
		this.bias=bias;
	}
	public void setLearningConstant(double LearningConstant){
		this.LearningConstant=LearningConstant;
	}
	/**
	 * 
	 * @param A 
	 * @param B
	 * @return 1 if the sum of weights are above 0, 0 if not
	 * @throws IOException When the input is niether 0 or 1 for both parameters
	 */
	public int feed(int A, int B) throws IOException{
		if(A!=1 && A!= 0 && B!=1 && B!=0){
			throw new IOException("Expected 1 or 0");
		}
		return A*weightA+B*weightB+bias>0?1:0;
	}


}
