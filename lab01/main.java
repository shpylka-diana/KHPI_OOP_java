package ua.khpi.oop.Shpylka01;

public class main {
	static void display(String n) {
		int odd = 0; //������� �� ������ 
	    int even = 0;
		for (int i = 0; i < n.length(); i++) 
	          if ((n.charAt(i) - '0') % 2 == 0) even++;// charAt ������ ��������� ������
	          else odd++;

	      System.out.println("��������: "  + odd + "\n������: " + even);
	}
	static void display2(int n) {
		int count;
	      for (count = 0; n > 0; ++count) {
	        n &= n - 1;
	      }
	      System.out.println("���������� ������: " + count);
	}
		 public static void main(String[] args) {
			    int recordBook = 0x31517; //����� ������� � 16-��� 
			    String recordBookString = String.valueOf(recordBook);
			    long number = 380992319493l; //����� �������� � 10-���
			    String numberString =  Long.toString(number); // ����� �������� ����� ������ 
			    int last2 = 0b1100; // 2 ��������� ����� � 2-���
			    String last2String = String.valueOf(last2);
			    int last4 = 031; // 4 ��������� ����� � 8-���
			    String last4String = String.valueOf(last4);
			    int surname = 24; // ����� ��������
			    String surnameString = String.valueOf(surname);
			    int form = surname - 1;
			    int b = (26 % form) + 1;
			    String bString = String.valueOf(b);
			    int c = b + 64;
			    String cString = String.valueOf(c);
			    System.out.println ("����� �������: " + recordBook + "\n����� ��������: " + number + "\n2 ��������� �����: " + last2 + "\n4 ��������� �����: " 
			    + last4 + "\n�������� ��������: " + c + "\n����� ����������� ��������:" + (char)c); //�����
			    System.out.println("��������");
			    System.out.println("������: ");
			    display(recordBookString);
			    System.out.println("������: ");
			    display(numberString);
			    System.out.println("������: ");
			    display(last2String);
			    System.out.println("���������: ");
			    display(last4String);
			    System.out.println("�����: ");
			    display(surnameString);
			    System.out.println("������: ");
			    display(bString);
			    System.out.println("�������: ");
			    display(cString);
			    System.out.println("���������� ������");
			    System.out.println("������: ");
			    display2(recordBook);
			    System.out.println("������: ");
			    display2(last2);
			    System.out.println("������: ");
			    display2(last4);
			    System.out.println("���������: ");
			    display2(surname);
			    System.out.println("�����: ");
			    display2(b);
			    System.out.println("������: ");
			    display2(c);
		}
}



