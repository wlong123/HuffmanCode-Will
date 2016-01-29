/**
	Node Class for Huffman Tree
*/
public class HuffmanNode implements Comparable<HuffmanNode>
{
	/**node to the left of this node*/
	private HuffmanNode left;
	
	/**node to the right of this node*/
	private HuffmanNode right;
	
	/**String value stored in this node*/
	private String value;
	
	/**number of times value occurs*/
	private int count;
	
	/**
	constructor that only takes in a String
	@param s String that is going to be assigned to value
	*/
	public HuffmanNode(String s)
	{
		left = null;
		right = null;
		value = s;
		count = 0;
	}
	
	/**
	constructor that takes in a string and an int
	@param s String that is going to be assigned to value
	@param i int that is going to be assigned to count
	*/
	public HuffmanNode(String s, int i)
	{
		left = null;
		right = null;
		value = s;
		count = i;
	}
	
	/**
	access for the left node
	@return HuffmanNode left node
	*/
	public HuffmanNode getLeft()
	{
		return left;
	}
	
	/**
	accessor for the right node
	@return HuffmanNode right node
	*/
	public HuffmanNode getRight()
	{
		return right;
	}
	
	/**
	accessor for value
	@return String return value
	*/
	public String getValue()
	{
		return value;
	}
	
	/**
	accessor for count
	@return int returns count
	*/
	public int getCount()
	{
		return count;
	}
	
	/**
	modifier for left
	@param node node that is going to be assigned to left
	*/
	public void setLeft(HuffmanNode node)
	{
		left = node;
	}
	
	/**
	modifier for right
	@param node node that is going to be assigned to right
	*/
	public void setRight(HuffmanNode node)
	{
		right = node;
	}
	
	/**
	modifier for value
	@param s String that is going to be assigned to value
	*/
	public void setValue(String s)
	{
		value = s;
	}
	
	/**
	modifier for count
	@param i int that is going to be assigned to count
	*/
	public void setCount(int i)
	{
		count = i;
	}
	
	/**
	toString method
	@return s String representation of the node
	*/
	public String toString()
	{
		String s = "";
		s += value + ": " + count;  //prints value with count
		return s;
	}
	
	/**
	compares this node with another inputted node
	@param node node that is compared to this node
	@return int difference between the counts in the nodes
	*/
	public int compareTo(HuffmanNode node)
	{
		return count - node.getCount();
	}
	
}