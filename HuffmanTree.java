import java.util.HashMap;
import java.util.PriorityQueue;
/**
Huffman Tree Class
*/
public class HuffmanTree
{
	/**root of the tree*/
	private HuffmanNode root;
	
	/**map for the tree*/
	private HashMap<String, Integer> map;
	
	/**queue for the tree*/
	private PriorityQueue<HuffmanNode> queue;
	
	/**
	constructor that takes in a string
	@param s String that is going to be turned into huffman code
	*/
	public HuffmanTree(String s)
	{
		map = new HashMap<String, Integer>(); //creates map and queue
		queue = new PriorityQueue<HuffmanNode>();
		for(int i = 0; i < s.length(); i++)
		{
			if(map.containsKey(s.substring(i, i + 1))) //calls substring method to get character in the string
				map.put(s.substring(i, i + 1), map.get(s.substring(i, i + 1)) + 1); //if character is already in map, readd the key with the value increased by one
			else
			{
				map.put(s.substring(i, i + 1), 1); //adds key with a value of one if the key is not already in the map
			}
		}
		createQueue();
		createTree();
	}
	
	/**
	creates the queue
	@return PriorityQueue<HuffmanNode> returns the priority queue
	*/
	public PriorityQueue<HuffmanNode> createQueue()
	{
		String[] keys =  map.keySet().toArray(new String[0]); //creates a string array of the keys, can use key to access the value
		for(int i = 0; i < keys.length; i++)
		{
			queue.add(new HuffmanNode(keys[i], map.get(keys[i])));
		}
		return queue;
	}
	
	/**
	creates the tree
	@return HuffmanNode returns the root of the tree
	*/
	public HuffmanNode createTree()
	{
		while(queue.size() > 1) //goes through loop until siz of queue is one
		{
			HuffmanNode end = queue.poll();  //takes out first two nodes in the queue
			HuffmanNode end2 = queue.poll();
			HuffmanNode toAdd = new HuffmanNode(end.getValue() + end2.getValue(), end.getCount() + end2.getCount());  //combines the 2 nodes that were taken out
			root = toAdd;  //assigns root to toAdd so after last iteration root will be top of tree
			queue.add(toAdd);  //readds combination of the 2 nodes
			toAdd.setLeft(end);  //assigns left and right pointers for toAdd
			toAdd.setRight(end2);
		}
		return root;
	}
	
	/**
	returns the HuffmanCode of an inputted String
	@param s String that is going to be turned into HuffmanCode
	@return String returns the HuffmanCode of the inputted String
	*/
	public String encode(String s)
	{
		String output = "";
		for(int i = 0; i < s.length(); i++) //iterates through charcaters in the string
		{
			HuffmanNode node = root;
			while((node.getLeft() != null) && (node.getRight() != null)) //goes until node is a leaf
			{
				if(node.getLeft().getValue().contains(s.substring(i, i + 1))) //goes to left pointer if the left pointer contains character in the String
				{
					node = node.getLeft();
					output += "1";  //1 is added to output if iteration goes to left node
				}
				else if(node.getRight().getValue().contains(s.substring(i, i + 1)))
				{
					node = node.getRight();
					output += "0";  //0 is added to output if iteration goes to right node
				}
			}
		}
		return output;
	}
	
	/**
	returns the String value of an inputted HuffmanCode
	@param s inputted huffman code that is turned into a word
	@return String returns String of the huffman code
	*/
	public String decode(String s)
	{
		String output = "";
		int i = 0;
		while(i < s.length()) //iterates through HuffmanCode
		{
			HuffmanNode node = root;
			while((node.getLeft() != null) && (node.getRight() != null))  //interation goes until node is a leaf
			{
				if(s.substring(i, i + 1).equals("1"))  //iteration goes left if character in huffman code is 1
					node = node.getLeft();
				else if(s.substring(i, i + 1).equals("0"))  //iteration goes right if character in huffman code is 0
					node = node.getRight();
				i++;
			}
			output += node.getValue();  //value at node is added to output, should be a single letter
		}
		return output;
	}
	
	/**
	returns String representation of the tree
	@return String returns String representation of the tree
	*/
	public String toString()
	{
		return root.toString();
	}
	
}