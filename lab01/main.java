package ua.khpi.oop.Shpylka01;

public class main {
	static void display(String n) {
		int odd = 0; //счетчик не четных 
	    int even = 0;
		for (int i = 0; i < n.length(); i++) 
	          if ((n.charAt(i) - '0') % 2 == 0) even++;// charAt задает начальный индекс
	          else odd++;

	      System.out.println("Нечетных: "  + odd + "\nЧетных: " + even);
	}
	static void display2(int n) {
		int count;
	      for (count = 0; n > 0; ++count) {
	        n &= n - 1;
	      }
	      System.out.println("Количество единиц: " + count);
	}
		 public static void main(String[] args) {
			    int recordBook = 0x31517; //номер зачетки в 16-ном 
			    String recordBookString = String.valueOf(recordBook);
			    long number = 380992319493l; //Номер телефона в 10-ном
			    String numberString =  Long.toString(number); // Номер телефона через строку 
			    int last2 = 0b1100; // 2 последние цыфри в 2-ном
			    String last2String = String.valueOf(last2);
			    int last4 = 031; // 4 последние цыфри в 8-ном
			    String last4String = String.valueOf(last4);
			    int surname = 24; // Номер варианта
			    String surnameString = String.valueOf(surname);
			    int form = surname - 1;
			    int b = (26 % form) + 1;
			    String bString = String.valueOf(b);
			    int c = b + 64;
			    String cString = String.valueOf(c);
			    System.out.println ("Номер зачетки: " + recordBook + "\nНомер телефона: " + number + "\n2 последние цыфры: " + last2 + "\n4 последние цыфры: " 
			    + last4 + "\nЗначение операций: " + c + "\nБуква английского алфавита:" + (char)c); //Вывод
			    System.out.println("Четность");
			    System.out.println("Первое: ");
			    display(recordBookString);
			    System.out.println("Второе: ");
			    display(numberString);
			    System.out.println("Третье: ");
			    display(last2String);
			    System.out.println("Четвертое: ");
			    display(last4String);
			    System.out.println("Пятое: ");
			    display(surnameString);
			    System.out.println("Шестое: ");
			    display(bString);
			    System.out.println("Седьмое: ");
			    display(cString);
			    System.out.println("Количество единиц");
			    System.out.println("Первое: ");
			    display2(recordBook);
			    System.out.println("Второе: ");
			    display2(last2);
			    System.out.println("Третье: ");
			    display2(last4);
			    System.out.println("Четвертое: ");
			    display2(surname);
			    System.out.println("Пятое: ");
			    display2(b);
			    System.out.println("Шестое: ");
			    display2(c);
		}
}



