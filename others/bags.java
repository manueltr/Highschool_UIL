package others;

public class bags implements Comparable<bags>
{
	private int value;
	private int weight;
	private String name;
	private double valuePerWeight;
	
	public bags(int value, int weight, String name)
	{
		this.value=value;
		this.weight=weight;
		this.name=name;
		valuePerWeight=((double)value)/weight;
	}
	
	public String name()
	{
		return name;
	}
	
	public int value()
	{
		return value;
	}
	
	public double VPW()
	{
		return valuePerWeight;
	}
	
	public int weight()
	{
		return weight;
	}

	public int compareTo(bags arg0)
	{
		return Double.valueOf(valuePerWeight).compareTo(arg0.valuePerWeight);
	}
}
