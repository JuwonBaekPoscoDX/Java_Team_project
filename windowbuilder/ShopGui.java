package windowbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import character.Me;
import inventory.Inventory;
import item.Armor;
import item.Potion;
import item.Weapon;
import main.Main;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;

public class ShopGui extends JFrame {

	private JPanel contentPane;
	public static JPanel panel_1,panel_2,panel_3,panel_4;
	ImageIcon icon,icon2;
	int check;

	/**
	 * Launch the application.
	 */
			public static void run(Me me,Inventory invent,Potion hp, Potion mp, Weapon Ipad, Weapon Macbook, Weapon Note, Weapon TA, Armor Hood) {
				try {
					ShopGui frame = new ShopGui(me,invent,hp,mp,Ipad,Macbook,Note,TA,Hood);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public ShopGui(Me me,Inventory invent, Potion hp, Potion mp, Weapon Ipad, Weapon Macbook, Weapon Note, Weapon TA, Armor Hood) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BufferedImage hpPotion = null;
		BufferedImage mpPotion = null;
		try {
			hpPotion = ImageIO.read(this.getClass().getResource("/res/img/HPpotion.png"));
			mpPotion = ImageIO.read(this.getClass().getResource("/res/img/mpPotion.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("error! Didn't get picture!");
		}
		Image imgHP = hpPotion.getScaledInstance(88, 78, Image.SCALE_SMOOTH);
		Image imgMP = mpPotion.getScaledInstance(88, 78, Image.SCALE_SMOOTH);
		icon = new ImageIcon(imgHP);
		icon2 = new ImageIcon(imgMP);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(222, 151, 223, 122);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Information");
		lblNewLabel.setBounds(74, 6, 79, 16);
		panel.add(lblNewLabel);
		
		panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 146, 207, 127);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		//when enter 구매
		JButton btnNewButton_3 = new JButton("구매하기");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		btnNewButton_3.setBounds(24, 38, 117, 29);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("나가기");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(24, 73, 117, 29);
		panel_3.add(btnNewButton_4);
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 146, 207, 127);
		contentPane.add(panel_4);
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("나가기");
		btnNewButton.setBounds(37, 87, 119, 29);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("포션구매");
		btnNewButton_2.setBounds(37, 25, 119, 29);
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("장비구매");
		btnNewButton_1.setBounds(37, 56, 119, 29);
		panel_4.add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyInvent();
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyPotion();
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				shopBye(me,invent);
			}
		});
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 5, 444, 137);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button_1 = new JButton("New button");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyIpad(me,Ipad);
			}
		});
		button_1.setBounds(18, 6, 76, 72);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyHood(me,Hood);
			}
		});
		button_2.setBounds(106, 6, 76, 72);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyMacbook(me,Macbook);
			}
		});
		button_3.setBounds(194, 6, 76, 72);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyNote(me,Note);
			}
		});
		button_4.setBounds(282, 6, 76, 72);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyTA(me,TA);
			}
		});
		button_5.setBounds(362, 6, 76, 72);
		panel_1.add(button_5);
		
		JLabel lblNewLabel_3 = new JLabel("아이패드");
		lblNewLabel_3.setBounds(33, 90, 61, 16);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("새내기 후드티");
		lblNewLabel_4.setBounds(106, 90, 76, 16);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("맥북");
		lblNewLabel_5.setBounds(220, 90, 30, 16);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("선배의 필기노트");
		lblNewLabel_6.setBounds(282, 84, 86, 28);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("TA 세션");
		lblNewLabel_7.setBounds(384, 90, 43, 16);
		panel_1.add(lblNewLabel_7);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 427, 130);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_5 = new JButton(icon);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyHpPotion(me,hp);
			}
		});
		btnNewButton_5.setBounds(79, 6, 88, 78);
		panel_2.add(btnNewButton_5);
		
		JButton button = new JButton(icon2);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyMpPotion(me,mp);
			}
		});
		button.setBounds(239, 6, 88, 78);
		panel_2.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("HP 포션");
		lblNewLabel_1.setBounds(89, 96, 61, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MP 포션");
		lblNewLabel_2.setBounds(249, 96, 61, 16);
		panel_2.add(lblNewLabel_2);
		
		panel_3.setVisible(false);
		panel_2.setVisible(false);
		panel_1.setVisible(false);
		
	}
	
	public int buyInvent() {
		panel_3.setVisible(true);
		panel_1.setVisible(true);
		panel_4.setVisible(false);
		
		return 2;
	}
	public int buyPotion() {
		panel_3.setVisible(true);
		panel_2.setVisible(true);
		panel_4.setVisible(false);
		
		return 1;
	}
	public int shopBye(Me me,Inventory invent) {
		Main.getStart(me,invent);
		return 0;
	}
	public int buyHpPotion(Me me, Potion hp) {
		System.out.println("HP 포션을 구매하였습니다! 10골드 차감.");
		me.setGold(me.getGold()-10);
		check = goldCheck(me,10);
		if(check != 1) hp.setNumber(hp.getNumber()+1);
		return 1;
	}
	public int buyMpPotion(Me me,Potion mp) {
		System.out.println("MP 포션을 구매하였습니다! 10골드 차감.");
		me.setGold(me.getGold()-10);
		check = goldCheck(me,10);
		if(check != 1) mp.setNumber(mp.getNumber()+1);
		return 1;
	}
	public int buyIpad(Me me,Weapon Ipad) {
		System.out.println("아이패드를 구매하였습니다. 공격력 +5 ");
		me.setGold(me.getGold()-20);
		check =goldCheck(me,20);
		if(check != 1) Ipad.setIs_bought(true);
		return 1;
	}
	public int buyHood(Me me,Armor Hood) {
		System.out.println("새내기 후드티를 구매하였습니다. 방어력 +5 ");
		me.setGold(me.getGold()-20);
		check = goldCheck(me,20);
		if(check != 1) Hood.setIs_bought(true);
		return 1;
	}
	public int buyMacbook(Me me,Weapon Macbook) {
		System.out.println("맥북을 구매하였습니다. 공격력 +7 ");
		me.setGold(me.getGold()-30);
		check = goldCheck(me,30);
		if(check != 1) Macbook.setIs_bought(true);
		return 1;
	}
	public int buyNote(Me me,Weapon Note) {
		System.out.println("선배의 필기노트를 구매하였습니다. 공격력 +10 ");
		me.setGold(me.getGold()-50);
		check = goldCheck(me,50);
		if(check != 1) Note.setIs_bought(true);
		return 1;
	}
	public int buyTA(Me me,Weapon TA) {
		System.out.println("TA 세션을 들었습니다. 공격력 +12 ");
		me.setGold(me.getGold()-60);
		check = goldCheck(me,60);
		if(check != 1) TA.setIs_bought(true);
		return 1;
	}
	
	public int goldCheck(Me me,int i) {
		if(me.getGold() < 0) {
			me.setGold(me.getGold()+i);
			JOptionPane.showMessageDialog(null, "Gold가 부족합니다!");
			return 1;
		}
		return 0;
		
	}
}