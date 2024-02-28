package com.main;
import java.util.*;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// deklerasi variable yang akan digunakan dan objek yang akan dipakai
		Scanner userInput = new Scanner(System.in);
		Random randomNum = new Random();
		int hargaAwal = 0;
		byte paymentPoint = 0;
		String customerName;
		byte orderQuantity;
		int hargaAkhir;
		String cupType;
		int hargaItem;
		int hargaCup;
		String paymentMethod;
		String orderMenu;
		byte totalDisc = 0;
		int inputUang;
				
		while (true) {
			boolean exit = false;
			
			// tampilan menu awal
			System.out.println("FixTue");
			System.out.println("======");
			System.out.println("1. Order Drink");
			System.out.println("2. Exit");
			
			// mengambil pilihan menu user
			System.out.print("Select menu >> ");
			byte menuSelect = userInput.nextByte();
			
			switch(menuSelect) {
			// menu order drink
			case 1:
				// input user name
				while(true) {
					System.out.print("Nama customer [5 - 15 characters] >> ");
					userInput.nextLine();
					customerName = userInput.nextLine();
					if (customerName.length() >= 5){
						break;
					}
				}
				
				// input pesanan
				while(true) {
					System.out.println("Menu");
					System.out.println("======");
					System.out.println("Brown Sugar 20000");
					System.out.println(" Red Bean   17000");
					System.out.println("  Oats      15000");
					
					System.out.print("Select order >> ");
					orderMenu = userInput.nextLine();
					
					if (orderMenu.compareTo("Brown Sugar") == 0) {
						hargaAwal += 20000;
						hargaItem = 20000;
						break;
					} else if (orderMenu.compareTo("Red Bean") == 0) {
						hargaAwal += 17000;
						hargaItem = 17000;
						break;
					} else if (orderMenu.compareTo("Oats") == 0) {
						hargaAwal += 15000;
						hargaItem = 15000;
						break;
					}
					
				}
				
				// input cup type
				while(true) {
					System.out.println("Cup Type");
					System.out.println("======");
					System.out.println("Small  0");
					System.out.println("Medium 2000");
					System.out.println("Large  5000");
					
					System.out.print("Cup type >> ");
					cupType = userInput.next();
					
					if (cupType.compareTo("Small") == 0  ) {
						hargaCup = 0;
						break;
					} else if (cupType.compareTo("Medium") == 0) {
						hargaAwal += 2000;
						hargaCup = 2000;
						break;
					} else if (cupType.compareTo("Large") == 0) {
						hargaAwal += 5000;
						hargaCup = 5000;
						break;
					}
				}
				
				// input sugar
				while(true) {
					System.out.println("Sugar Type");
					System.out.println("======");
					System.out.println("Less");
					System.out.println("Normal");
					
					System.out.print("Cup type >> ");
					String sugarType = userInput.next();
					
					if (sugarType.compareTo("Less") == 0 || sugarType.compareTo("Normal") == 0) {
						break;
					}
				}
				
				// quantity
				while (true) {
					System.out.print("Input order quantity >> ");
					orderQuantity = userInput.nextByte();
					
					if (orderQuantity > 0) {
						break;
					}
				}
				
				// payment method
				while(true) {
					System.out.println("Payment Method");
					System.out.println("======");
					System.out.println("Transfer");
					System.out.println("QRIS");
					
					System.out.print("Payment Method >> ");
					paymentMethod = userInput.next();
					
					if (paymentMethod.compareTo("Transfer") == 0) {
						paymentPoint += 5;
						break;
					} else if (paymentMethod.compareTo("QRIS") == 0) {
						paymentPoint += 10;
						break;
					}
				}
				
				// kalkulasi harga
				hargaAwal = hargaAwal * orderQuantity;
				
				if (hargaAwal > 100000) {
					totalDisc = (byte) (customerName.length() + paymentPoint);
					hargaAkhir = hargaAwal - ((hargaAwal/100) * totalDisc);
					
				} else {
					hargaAkhir = hargaAwal;
				}
				
				// generate bill number
				int randomPertama = randomNum.nextInt(10);
				int randomKedua = randomNum.nextInt(10);
				int randomKetiga = randomNum.nextInt(10);
				
				String billNumber = "BL" + randomPertama + randomKedua + randomKetiga;
				
				// print bill information
				String discPrint = (double) totalDisc + "%";
				System.out.println("==================================");
				System.out.println("|        Bill Information        |");
				System.out.println("==================================");
				System.out.printf("| Bill ID        : %-14s|\n", billNumber);
				System.out.printf("| Customer Name  : %-14s|\n", customerName);
				System.out.printf("| Drink Name     : %-14s|\n", orderMenu);
				System.out.printf("| Drink Price    : %-14d|\n", hargaItem);
				System.out.printf("| Cup Type       : %-14s|\n", cupType);
				System.out.printf("| Cup Price      : %-14d|\n", hargaCup);
				System.out.printf("| Quantity       : %-14d|\n", orderQuantity);
				System.out.printf("| Payment Method : %-14s|\n", paymentMethod);
				System.out.printf("| Total Discount : %-14s|\n", discPrint);
				System.out.printf("| Total Price    : %-14s|\n", hargaAkhir);
				System.out.println("==================================");
				
				// masukan nominal uang untuk pembayaran
				while(true) {
					System.out.print("Nominal uang anda >> ");
					inputUang = userInput.nextInt();
					
					if (inputUang >= hargaAkhir) {
						break;
					}
				}
				
				// hitung kembalian
				int uangKembalian = inputUang - hargaAkhir;
				System.out.println("Uang kembalian >> " + uangKembalian);
				
				break;
				
			// exit menu	
			case 2:
				exit = true;
				break;
			default:
				break;
			}
			if (exit == true) {
				break;
			}
				
		}
		System.out.println("Thanks for Ordering FixTue");
	}
}
