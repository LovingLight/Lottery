package Lotter;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LotteryFunction extends Layout_Design {

	public static void main(String[] args) throws IOException {
		LotteryFunction frm = new LotteryFunction();

		frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frm.setVisible(true);
	}

	Data data = new Data();

	LotteryFunction() throws IOException {
		super();
		this.setBounds(super.getBounds());

		set_boxTheme();
		displayData(String.valueOf(boxTheme.getSelectedItem()));

		c.setFocusable(true);
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					getResult();
					System.out.println("Pressed");
				} else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					if (listName.getSelectedIndex() > 0)
						listName.remove(listName.getSelectedIndex());
					if (listwards.getSelectedIndex() > 0)
						listwards.remove(listwards.getSelectedIndex());
				}else if(e.getKeyCode() == KeyEvent.VK_S) {
					System.out.println("S");
					try {
						saveNewData();
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}else if(e.getKeyCode()==KeyEvent.VK_D) {
					System.out.println("D");
					try {
						data.removeData(String.valueOf(boxTheme.getSelectedItem()));
						boxTheme.removeItem(boxTheme.getSelectedItem());
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		listName.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				cond = true;

				for (int i = 0; i < listwards.getItemCount(); i++)
					listwards.deselect(i);

				for (int i = 0; i < listoutput.getItemCount(); i++)
					listoutput.deselect(i);

				if (listName.isSelected(0)) {
					addElement();
				} else {
					pCenter.remove(txt);
					pCenter.setVisible(false);
					pCenter.setVisible(true);
				}
			}
		});

		listwards.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cond = false;

				for (int i = 0; i < listName.getItemCount(); i++)
					listName.deselect(i);

				for (int i = 0; i < listoutput.getItemCount(); i++)
					listoutput.deselect(i);

				if (listwards.isSelected(0)) {
					addElement();
				} else {
					pCenter.remove(txt);
					pCenter.setVisible(false);
					pCenter.setVisible(true);
				}

			}
		});

		listoutput.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				for (int i = 0; i < listwards.getItemCount(); i++)
					listwards.deselect(i);

				for (int i = 0; i < listName.getItemCount(); i++)
					listName.deselect(i);
			}
		});

		boxTheme.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					displayData(String.valueOf(boxTheme.getSelectedItem()));
				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}

		});

		boxTheme.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					getResult();
					System.out.println("pressed");
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					System.out.println("S");
					try {
						saveNewData();
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}else if(e.getKeyCode()==KeyEvent.VK_D) {
					System.out.println("D");
					try {
						data.removeData(String.valueOf(boxTheme.getSelectedItem()));
						boxTheme.removeItem(boxTheme.getSelectedItem());
//						displayData(String.valueOf(boxTheme.getItemAt(0)));
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		listName.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					getResult();
					System.out.println("pressed");
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					System.out.println("S");
					try {
						saveNewData();
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}else if(e.getKeyCode()==KeyEvent.VK_D) {
					System.out.println("D");
					try {
						data.removeData(String.valueOf(boxTheme.getSelectedItem()));
						boxTheme.removeItem(boxTheme.getSelectedItem());
//						displayData(String.valueOf(boxTheme.getItemAt(0)));
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		listwards.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					getResult();
					System.out.println("pressed");
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					System.out.println("S");
					try {
						saveNewData();
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}else if(e.getKeyCode()==KeyEvent.VK_D) {
					System.out.println("D");
					try {
						data.removeData(String.valueOf(boxTheme.getSelectedItem()));
						boxTheme.removeItem(boxTheme.getSelectedItem());
//						displayData(String.valueOf(boxTheme.getItemAt(0)));
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		listoutput.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					getResult();
					System.out.println("pressed");
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					System.out.println("S");
					try {
						saveNewData();
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

	}

	protected void getResult() {
		String result[] = new String[listwards.getItemCount()];
		String temp = new String();
		int pos;

		listoutput.removeAll();

		for (int i = 0; i < listwards.getItemCount() - 1; i++) {
			do {
				pos = (int) (Math.random() * listName.getItemCount());
				temp = listName.getItem(pos);
			} while (check(temp, result) || pos == 0);

			listoutput.add(temp);
		}
	}

	private boolean check(String str, String[] result) {
		for (int i = 0; i < result.length; i++) {
			if (str.equals(result[i]))
				return true;
		}
		return false;
	}

	protected void addElement() {
		pCenter.add(txt, BorderLayout.SOUTH);
		pCenter.setVisible(false);
		pCenter.setVisible(true);

		txt.addKeyListener(new KeyAdapter() {
			String temp = new String();

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					temp = txt.getText();
					txt.setText("");
					if (temp.compareTo("") != 0) {
						// cond = true => AddName
						// cond = false => AddWards
						if (cond) {
							System.out.println("Add Name");
							listName.add(temp);
							Names.add(temp);
						} else {
							System.out.println("Add Wards");
							listwards.add(temp);
							Wards.add(temp);
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					pCenter.remove(txt);
					pCenter.setVisible(false);
					pCenter.setVisible(true);
				}

			}
		});
	}

	private void displayData(String Theme) throws IOException {
		if (data.getAllTheme().contains(Theme)) {
			boxTheme.setEditable(false);
			data.getData(Theme);
			set_listWards(data.getWardsData());
			set_listName(data.getNaemsData());
			listoutput.removeAll();
		} else {
			setNewData();
		}

	}

	private void set_boxTheme() throws IOException {
		ArrayList temp = new ArrayList();
		temp = data.getAllTheme();
		for (int i = 0; i < temp.size(); i++) {
			boxTheme.addItem(temp.get(i));
		}
//		boxTheme.removeItemAt(boxTheme.getItemCount() - 1);
		boxTheme.addItem("新增");
	}

	private void set_listWards(ArrayList data) {
		listwards.removeAll();
		Wards = data;
		for (int i = 0; i < Wards.size(); i++) {
			listwards.add(String.valueOf(Wards.get(i)));
		}
	}

	private void set_listName(ArrayList data) {
		listName.removeAll();
		Names = data;
		for (int i = 0; i < Names.size(); i++) {
			listName.add(String.valueOf(Names.get(i)));
		}

	}

	private void setNewData() {
		boxTheme.setEditable(true);
		listwards.removeAll();
		listName.removeAll();
		listoutput.removeAll();
		listwards.add("新增");
		listName.add("新增");
	}
	
	private void saveNewData() throws IOException{
		Wards = new ArrayList();
		Names = new ArrayList();
		
		for(int i=0;i<listwards.getItemCount();i++) {
			Wards.add(listwards.getItem(i));
		}
		
		for(int i=0;i<listName.getItemCount();i++) {
			Names.add(listName.getItem(i));
		}
		
		boxTheme.removeItem("新增");
		boxTheme.addItem(boxTheme.getSelectedItem());
		boxTheme.addItem("新增");
		
		data.addNewData(String.valueOf(boxTheme.getSelectedItem()), Wards, Names);
		boxTheme.setEditable(false);
	}

}
