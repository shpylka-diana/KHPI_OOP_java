 package ua.khpi.oop.Shpylka03;
import java.util.*;
public class main {
	public static void main(String[] args)
	{
	    System.out.println("Введите текст");
	    Scanner in = new Scanner(System.in);//Создание контейнера для ввода
	    String string = in.nextLine();//Ввод
	    String[] words = string.split("\\s+");//Разбитие предложения на массив слов
	    HashMap<String, Integer> wordToCount = new HashMap<>();//позволяет искать элемменты в строке
	    for (String word : words)
	    {
	        if (!wordToCount.containsKey(word))// запрашивает ключ(слово стринг)
	        {
	            wordToCount.put(word, 0);// определяет отдельные слова
	        }
	        wordToCount.put(word, wordToCount.get(word) + 1);//ищет совпадения слов
	    }
	    for (String word : wordToCount.keySet())//возвращает найденые совпадения слов
	    {
	        System.out.println(word + " " + wordToCount.get(word));
	    }
	}
}
