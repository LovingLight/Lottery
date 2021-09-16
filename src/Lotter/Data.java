package Lotter;

import java.io.*;
import java.util.*;

public class Data {

	private String url = new String("D:/Java/Java training/Lottery/data.txt");
	protected String newTheme = new String();
	protected ArrayList newWards = new ArrayList();
	protected ArrayList newNames = new ArrayList();
	private ArrayList WardsData = new ArrayList();
	private ArrayList NamesData = new ArrayList();

	public void addTheme(String Theme) throws IOException {
		BufferedWriter file = new BufferedWriter(new FileWriter(url, true));

		try {
			file.write("\n" + Theme + "\n");
		} catch (IOException ex) {
			ex.getMessage();
		}

		file.close();
	}

	public void addWards(ArrayList Wards) throws IOException {

		BufferedWriter file = new BufferedWriter(new FileWriter(url, true));

		try {
			for (int i = 0; i < Wards.size(); i++) {
				file.write(String.valueOf(Wards.get(i)) + "\n");
			}

//			file.write("\n");
		} catch (IOException ex) {
			ex.getMessage();
		}

		file.close();
	}

	public void addNames(ArrayList Names) throws IOException {

		BufferedWriter file = new BufferedWriter(new FileWriter(url, true));

		try {
			for (int i = 0; i < Names.size(); i++) {
				file.write(String.valueOf(Names.get(i)) + "\n");
			}

		} catch (IOException ex) {
			ex.getMessage();
		}

		file.write("\n");

		file.close();
	}

	public void addNewData(String Theme, ArrayList Wards, ArrayList Names) throws IOException {
		addTheme(Theme);
		addWards(Wards);
		addNames(Names);
	}

	public void removeData(String Theme) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(url));

		ArrayList Themes = getAllTheme();
		ArrayList SaveData = new ArrayList();
		
		System.out.println(Themes);

		if (Themes.contains(Theme))
			Themes.remove(Theme);
		else
			return;
		
		System.out.println(Themes);

		for (int i = 0; i < Themes.size(); i++) {
			getData(String.valueOf(Themes.get(i)));
			SaveData.add("\n");
			SaveData.add(String.valueOf(Themes.get(i)));
			SaveData.add("\n");

			for (int j = 0; j < WardsData.size(); j++) {
				SaveData.add(WardsData.get(j));
				SaveData.add("\n");
			}

			for (int j = 0; j < NamesData.size(); j++) {
				SaveData.add(NamesData.get(j));
				SaveData.add("\n");
			}

			SaveData.add("\n");
		}
		
		System.out.println("SaveData : "+SaveData);

		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(url));

		for (int i = 0; i < SaveData.size(); i++) {
			fileWriter.write(String.valueOf(SaveData.get(i)));
		}

		fileReader.close();
		fileWriter.close();
	}

	public void getData(String scr_Theme) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader(url));

		String space = new String();
		String temp = new String();

		String Theme = new String();
		WardsData = new ArrayList();
		NamesData = new ArrayList();

		while (file.ready()) {
			
			space = temp;
			temp = file.readLine();

			if(space.compareTo("") == 0 && temp.compareTo(scr_Theme) == 0) {
				// get Theme
				newTheme = temp;

				// get Wards
				temp = file.readLine();
				do {
					WardsData.add(temp);
					temp = file.readLine();
				} while (temp.compareTo("�s�W") != 0);

				// get Names
				do {
					NamesData.add(temp);
					temp = file.readLine();
				} while (temp.compareTo("") != 0);
			}
				

		}

		file.close();

	}

	public ArrayList getAllTheme() throws IOException {

		BufferedReader file = new BufferedReader(new FileReader(url));
		ArrayList Themes = new ArrayList();
		String temp = new String();
		String space = new String();

//		Themes.add(file.readLine());

		while (file.ready()) {
			space = temp;
			temp = file.readLine();
			if (space.compareTo("") == 0 && temp.compareTo("") != 0) {
				Themes.add(temp);
			}

		}

		file.close();

		return Themes;
	}

	public ArrayList getNaemsData() {
		return NamesData;
	}

	public ArrayList getWardsData() {
		return WardsData;
	}

	public void removeAll() throws IOException {
		BufferedWriter file = new BufferedWriter(new FileWriter(url));

		try {
			file.write("");
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

//	public static void main(String[] args) throws IOException {
//		Data d = new Data();
//
//		d.removeAll();
//
//		d.newTheme = "���\";
//
//		d.newWards.add("�s�W");
//		d.newWards.add("eat");
//
//		d.newNames.add("�s�W");
//		d.newNames.add("�کi");
//		d.newNames.add("�C��");
//		d.newNames.add("����");
//
//		d.addNewData(d.newTheme, d.newWards, d.newNames);
//
//		d.newTheme = "���\";
//
//		d.newNames = new ArrayList();
//		d.newNames.add("�s�W");
//		d.newNames.add("����");
//		d.newNames.add("���u�\");
//		d.newNames.add("����");
//		d.newNames.add("�ۤv�N");
//		d.addNewData(d.newTheme, d.newWards, d.newNames);
//
//		d.newTheme = "���\";
//		d.newNames = new ArrayList();
//		d.newNames.add("�s�W");
//		d.newNames.add("���u�\");
//		d.newNames.add("����");
//		d.newNames.add("�N�N");
//		d.newNames.add("�q�j�Q��");
//		d.newNames.add("�ۤv�N");
//		d.addNewData(d.newTheme, d.newWards, d.newNames);
//
//		System.out.println("���\ : ");
//		d.getData("���\");
//		
//		System.out.println("���\ : ");
//		d.getData("���\");
//
//		d.removeData("���\");
//
//		System.out.println(d.getAllTheme());
//
//	}

}
