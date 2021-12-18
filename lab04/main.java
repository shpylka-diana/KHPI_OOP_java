package ua.khpi.oop.Shpylka04;
import java.util.HashMap;
import java.util.Scanner;
public class main {
	public static void main(String[] args){
	    System.out.println("Введите текст");
	    Scanner in = new Scanner(System.in);
	    String string = in.nextLine();
	    String display = " ";
			do {
	        System.out.println ("Меню:\n1)Ваше предложение\n2)Результат\n3)Для выхода нажмите Enter\n" 
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
	        			System.out.println("Выбранна неверная цифра");
	        			break;
	        	    }
	}while(!display.isEmpty());
	        
}

	    
	        		static void help () {
	        	    	System.out.println("Розработала: Шпилька Диана\nСтудента группы: КИТ-320\n"
	        	    			+ "По заданию: Ввести текст. Найти и вывести, сколько раз повторяется в тексте \n"
	        	    			+ "каждое слово. Результат вывести в виде таблицы.\n"
	        	    			+ "Программа может подсчитать все повторяющиесь слова.\n");
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
	        		    	System.out.println("Начальное предложение: " + t + "\nДелим на массив слов по пробелам: " + words);
	        		    } 
	        			
	        	    }
	    
	    }
	

