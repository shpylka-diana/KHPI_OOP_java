package ua.khpi.oop.Shpylka04;
import java.util.HashMap;
import java.util.Scanner;
public class main {
	public static void main(String[] args){
	    System.out.println("������� �����");
	    Scanner in = new Scanner(System.in);
	    String string = in.nextLine();
	    String display = " ";
			do {
	        System.out.println ("����:\n1)���� �����������\n2)���������\n3)��� ������ ������� Enter\n" 
	    + "----------------------------------\n" + 
	        		"Help -h\n" + "Debug -d");
	        
	        		display = in.nextLine();
	        		switch (display) {
	        		case "1":
	        			System.out.println(string);
	        			break;
	        		case "2":
	        			String[] words = string.split("\\s+");
	        		    HashMap<String, Integer> wordToCount = new HashMap<>();
	        		    for (String word : words)
	        		    {
	        		        if (!wordToCount.containsKey(word))
	        		        {
	        		            wordToCount.put(word, 0);
	        		        }
	        		        wordToCount.put(word, wordToCount.get(word) + 1);
	        		    }
	        		    for (String word : wordToCount.keySet())
	        		    {
	        		    	System.out.println(word + " " + wordToCount.get(word));
	        		    } 	
	        			break;
	        		case "-h":
	        			help();
	        			break;
	        		case "-d":
	        			debag(string);
	        		default: 
	        			System.out.println("�������� �������� �����");
	        			break;
	        	    }
	}while(!display.isEmpty());
	        
}

	    
	        		static void help () {
	        	    	System.out.println("�����������: ������� �����\n�������� ������: ���-320\n"
	        	    			+ "�� �������: ������ �����. ����� � �������, ������� ��� ����������� � ������ \n"
	        	    			+ "������ �����. ��������� ������� � ���� �������.\n"
	        	    			+ "��������� ����� ���������� ��� ������������� �����.\n");
	        	    }
	        	    static void debag (String t) {
	        	    	String string = "";
	        	    	String[] words = string.split("\\s+");
	        		    HashMap<String, Integer> wordToCount = new HashMap<>();
	        		    for (String word : words)
	        		    {
	        		        if (!wordToCount.containsKey(word))
	        		        {
	        		            wordToCount.put(word, 0);
	        		        }
	        		        wordToCount.put(word, wordToCount.get(word) + 1);
	        		    }
	        		    for (String word : wordToCount.keySet())
	        		    {
	        		    	System.out.println("��������� �����������: " + t + "\n����� �� ������ ���� �� ��������: " + words);
	        		    } 
	        			
	        	    }
	    
	    }
	

