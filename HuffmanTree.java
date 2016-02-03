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
	
	public HuffmanNode createTree()
	{
		while(queue.size() > 1)
		{
			HuffmanNode end = queue.poll();
			HuffmanNode end2 = queue.poll();
			HuffmanNode toAdd = new HuffmanNode(end.getValue() + end2.getValue(), end.getCount() + end2.getCount());
			root = toAdd;
			queue.add(toAdd);
			toAdd.setLeft(end);
			toAdd.setRight(end2);
		}
		return root;
	}
	
	public String encode(String s)
	{
		String output = "";
		for(int i = 0; i < s.length(); i++)
		{
			HuffmanNode node = root;
			while(node.getLeft() != null)
			{
				if(node.getLeft().getValue().contains(s.substring(i, i + 1)))
				{
					node = node.getLeft();
					output += "1";
				}
				else if(node.getRight().getValue().contains(s.substring(i, i + 1)))
				{
					node = node.getRight();
					output += "0";
				}
			}
		}
		return output;
	}
	
	public String toString()
	{
		return root.toString();
	}
	
}