package ua.khpi.oop.Shpylka08;

import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

public class main {
	private static final Object Customer = null;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		XMLEncoder encoder = new XMLEncoder(
		           new BufferedOutputStream(
		           new FileOutputStream("Beanarchiv.xml")));

		encoder.writeObject(Customer);
		encoder.close(); 
		String filename = "lab08.txt";
		String display = " ";
		do {
		System.out.println("����:" + "\n1)������� ����������" + "\n2)����� �������" + "\n3)�������� � ����");
		display = in.nextLine();
		switch (display){
		case "1":
		Route one = new Route("�6", 40, "12:35", "17:20", "�������", 5, 300, "�������", "����", "�������, �����, ���������");
		one.display1();
		break;
		case "2":
			while (true) {
			System.out.println("�������:");
			String human = in.nextLine();
			if (human.toLowerCase().equals("end")) {
				break;
			}
			System.out.println("�����������:");
			String consultant = in.nextLine();
			}
		case "3":
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
				var a = new Route("�6", 40, "12:35", "17:20", "�������", 5, 300, "�������", "����", "�������, �����, ���������");
		        oos.writeObject(a);
		        oos.close();
		        System.out.println("���� ��� �������");
		        XMLEncoder encoder1 = new XMLEncoder(
				           new BufferedOutputStream(
				           new FileOutputStream("Beanarchiv.xml")));

				encoder1.writeObject(Customer);
				encoder1.close(); 
		      }
		      catch(Exception ex){
		               
		              System.out.println(ex.getMessage());
		      }
		}
		}while(!display.isEmpty());
		
	}
}
class Bus_station {
	private String name_station;
	private int number_bus;
	private String arrival;
	private String departure;
	public Bus_station (String name_station, int number_bus, String arrival, String departure) {
		this.name_station = name_station;
		this.number_bus = number_bus;
		this.arrival = arrival;
		this.departure = departure;
	}
	public String getName_station() {
		return name_station;
	}
	public void setName_station(String name_station) {
		this.name_station = name_station;
	}
	public int getNumber_bus() {
		return number_bus;
	}
	public void setNumber_bus(int number_bus) {
		this.number_bus = number_bus;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
}
class Timetable extends Bus_station{
	String day;
	int places;
	int price;
	public Timetable(String name_station, int number_bus, String arrival, String departure, String day, int places, int price) {
		super(name_station, number_bus, arrival, departure);
		this.day = day;
		this.places = places;
		this.price = price;
	}
}
class Route extends Timetable implements Serializable{
	String start_town;
	String intermediate_cities;
	String last_town;
	public Route(String name_station, int number_bus, String arrival, String departure, String day, int places,
			int price, String start_town, String last_town, String intermediate_cities) {
		super(name_station, number_bus, arrival, departure, day, places, price);
		this.start_town = start_town;
		this.intermediate_cities = intermediate_cities;
		this.last_town = last_town;
	}
	void display1 () {
		System.out.println("�����������: " + getName_station() + "\n����� ��������: " + getNumber_bus() + "\n����� ��������: " + getArrival() 
		+ "\n����� �������: " + getDeparture() + "\n----------------------------------" + "\n����: " + day + "\n��������� �����: " + places 
		+ "\n���� � ���: " + price + "\n----------------------------------" + "\n������ ��������: " + start_town + "\n������������� ���������: " +
		intermediate_cities + "\n�������� �������: " + last_town);
	}
}