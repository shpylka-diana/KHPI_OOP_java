package ua.khpi.oop.Shpylka06;

import java.io.*;
import java.util.*;

class main{
    public static void main(String[] args){

        Menu our_menu = new Menu();
        our_menu.menu_start();
    }
}

class Menu{
    String s;
    int x, y;

    void menu_start() {
        Scanner input = new Scanner(System.in);
        Container cont = new Container();

        for (;;){

            System.out.println("Choose an option:" + "\n1) Input data" + "\n2) Show data" + "\n3) Make ALL calculations" 
            + "\n4) Make INDEX calculations" + "\n5) Show array" + "\n6) Clear array" + "\n7) Contains your word" 
            + "\n8) Delete your word" + "\n9) Serialize" + "\n10) Deserialize" + "\n11) Sort array" + "\n12) Compare 2 words in array by index"
            + "\n13) Show array size" + "\n14) Exit" + "Your choice:");


            int choice = input.nextInt();

            if (choice < 1 || choice >= 14){
                System.out.println("\n>Wrong input!");
                System.exit(1);
            }
            else if (choice == 1){
                System.out.println("\n>Enter data:");
                input.nextLine();
                s = input.nextLine();
                cont.add(s);
                System.out.println("\n>Done!");
            }
            else if (choice == 2){
                System.out.println(s);
                System.out.println("\n>Done!");
            }
            else if (choice == 3){
                cont.remover_all();
                System.out.println("\n>Done!");
            }
            else if (choice == 4){
                System.out.println("\n>Enter data:");
                input.nextLine();
                x = input.nextInt();
                cont.remover_index(x);
                System.out.println("\n>Done!");
            }
            else if (choice == 5){
                System.out.println(cont.to_string());
                System.out.println("\n>Done!");
            }
            else if (choice == 6){
                cont.clear();
                System.out.println("\n>Done!");
            }
            else if (choice == 7){
                System.out.println("\n>Enter data:");
                input.nextLine();
                s = input.nextLine();
                System.out.println(cont.contains(s));
                System.out.println("\n>Done!");
            }
            else if (choice == 8){
                System.out.println("\n>Enter data:");
                input.nextLine();
                s = input.nextLine();
                if (cont.remove(s)){
                    System.out.println("\n>Done!");
                } else{
                    System.out.println(">Not done!");
                }
            }
            else if (choice == 9){
                try {
                    cont.serialize();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("\n>Done!");
            }
            else if (choice == 10){
                try {
                    cont.deserialize();
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
                System.out.println("\n>Done!");
            }
            else if (choice == 11){
                cont.sort();
                System.out.println("\n>Done!");
            }
            else if (choice == 12){
                System.out.println("\n>Enter first index: ");
                input.nextLine();
                x = input.nextInt();
                System.out.println("\n>Enter second index:");
                input.nextLine();
                y = input.nextInt();
                System.out.println(cont.compare_strings(x, y));
                System.out.println("\n>Done!");
            }
            else if (choice == 13){
                System.out.println(cont.size());
                System.out.println("\n>Done!");
            }
        }
    }
}


class Helper{

    static String remover(String S){
        String result = S.trim().replaceAll("[^a-zA-Z-\\s-,.!?;:]", "");        
        result = result.replaceAll(" +", " ");                                  
        result = result.replaceAll("(?<=[,.!?;:])(?!$)", " ");                  

        return result;
    }
}

class Container implements Iterable<String> {
    String[] our_strings = {"Vol12vo", "BM   W", "Fo $ rd", "Maz&   da"};
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

    void serialize() throws IOException {
        String name = "Serialized.ser";

        Object obj = this.to_string();
        FileOutputStream fileOut = new FileOutputStream(name);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();

        System.out.println("\nData written to: " + name);
    }

    void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("Serialized.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object obj = in.readObject();

        System.out.println(obj.toString());
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