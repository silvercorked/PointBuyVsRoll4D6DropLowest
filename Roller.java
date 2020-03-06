import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Roller {

	private int sides;
	private int numODice;
	private int sum;
	private BigDecimal runs;
	private ArrayList<Integer> values;
	private ArrayList<BigDecimal> sums;
	private BigDecimal probability;
	private Random rand;
	
	public Roller(int s, int n) {
		this.sides = s;
		values = new ArrayList<Integer>();
		this.numODice = n;
		this.runs = new BigDecimal(0);
		this.sums = new ArrayList<BigDecimal>();
		this.rand = new Random();
	}
	
	public void simulator() {
		sum = 0;
		runs = runs.add(BigDecimal.ONE);
		for(int i = 0; i < this.numODice; i++) {
			values.add(rand.nextInt(this.sides + 1));
			
		}
		Collections.sort(values);
		for(int i = 1; i < this.numODice; i++)
		{
			sum+=values.get(i);
		}
		values.clear();
		sums.add(new BigDecimal(sum));
		calculateProb();
	}
	
	private void calculateProb() {
		BigDecimal probTop = new BigDecimal(0);
		for(int i = 0; i < sums.size(); i++) {
			probTop = probTop.add(sums.get(i));
		}
		probability = probTop;
	}
	
	public BigDecimal getProbability() {
		return this.probability;
	}
	
	public BigDecimal getRuns() {
		return this.runs;
	}
}
