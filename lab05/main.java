package ua.khpi.oop.Shpylka05;

import java.io.*;
import java.util.*;
public class main {
	public static void main(String[] args) {
class Helper{

    static String remover(String S){
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
		return string;

    }
}
class Container implements Iterable<String> {
    String[] our_strings = {};
    String s;

    @Override
    public Iterator<String> iterator(){
        Iterator<String> it = new Iterator<String>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < our_strings.length && our_strings[currentIndex] != null;
            }

            @Override
            public String next() {
                return our_strings[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    String to_string(){

        StringBuilder temp_buffer = new StringBuilder();

        for (String our_string : our_strings) {
            temp_buffer.append(our_string);
            temp_buffer.append(',');
        }
        return temp_buffer.toString();
    }

    void add(String string){
        s = string;
        int i;
        int length = our_strings.length;

        String[] new_arr = new String[length + 1];

        for (i = 0; i < length; i++){
            new_arr[i] = our_strings[i];
        }

        new_arr[length] = string;

        our_strings = new_arr;
    }

    void clear(){
        our_strings = new String[0];
    }

    Object[] to_array(){
        Object[] resulting_object = new Object[our_strings.length];
        int i = 0;
        for (String S : our_strings){
            resulting_object[i] = S;
            i++;
        }


        return resulting_object;
    }

    int size(){
        return our_strings.length + 1;
    }

    boolean contains(String string){
        for (String S : our_strings){
            if (Objects.equals(S, string)){
                return true;
            }
        }
        return false;
    }

    boolean contains_all(Container container){
        return this == container;
    }

    boolean remove(String string) {
        int length = our_strings.length;

        String[] new_arr = new String[length - 1];

        for (int i = 0, k = 0; i < length; i++){
            if (our_strings[i].equals(string)) {
                continue;
            }
            new_arr[k++] = our_strings[i];
        }

        our_strings = new_arr;
        return true;
    }

    void remover_all(){
        int i;
        int length = our_strings.length;

        String[] new_arr = new String[length];

        for (i = 0; i < length; i++){
            our_strings[i] = Helper.remover(our_strings[i]);
            new_arr[i] = our_strings[i];
        }

        our_strings = new_arr;
    }

    void remover_index(int index){
        int i;
        int length = our_strings.length;

        String[] new_arr = new String[length];

        for (i = 0; i < length; i++){
            if (i == index){
                our_strings[i] = Helper.remover(our_strings[i]);
            }
            new_arr[i] = our_strings[i];
        }

        our_strings = new_arr;
    }
    void sort(){
        for(int i = 0; i < this.size(); i++) {
            for (int j = i + 1; j < this.size(); j++){

                if(our_strings[i].toLowerCase().compareTo(our_strings[j].toLowerCase()) > 0){

                    String temp = our_strings[i];
                    our_strings[i] = our_strings[j];
                    our_strings[j] = temp;
                }
            }
        }
    }

    boolean compare_strings(int index1, int index2){
        return our_strings[index1].equals(our_strings[index2]);
    }
}
	}
}


 
	

