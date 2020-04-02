package asm3;

import java.util.ArrayList;

/**
 * The vending machine class is used to represent all the operations in a vending machine
 *
 */
public class VendingMachine {	
	
	private ArrayList<Integer> coinChanger;
	private ArrayList<Integer> coinSlot;
	private ArrayList<SoftDrinkSlot> softDrinkSlots;
	
		/**
		 * The vending machine object of the coinChanger, coinSlot, softDrinkSlots arraylist of every vending machine 
		 */
		public VendingMachine() {
			coinChanger = new ArrayList<Integer>();
			coinSlot = new ArrayList<Integer>();
			softDrinkSlots = new ArrayList<SoftDrinkSlot>();
		}
		
		/**
		 * The addCoinToCoinChanger method is to add an integer value of a coin into the coinChnager slot
		 * @param c integer value to be passed into the addCoinToCoinChanger method 
		 */
		public void addCoinToCoinChanger(Integer c) {
			coinChanger.add(c);
		}
		
		/**
		 * The addSoftDrinkSlot method is to add a softDrinkSlot object into the SoftDrinkSlot
		 * @param s SoftDrinkSlot object to be passed into the addSoftDrinkSlot method 
		 */
		public void addSoftDrinkSlot(SoftDrinkSlot s) {
			softDrinkSlots.add(s);
		}
		
		/**
		 * The addCoinToCoinSlot method is to add an integer value of a coin into the coinSlot 
		 * @param c integer value to be passed into the addCoinToCoinSlot method 
		 */
		public void addCoinToCoinSlot(Integer c) {
			coinSlot.add(c);
		}
		
		/**
		 * The getCoinSlotTotal is used to calculate the integer value of sum of all coins in the coinSlot
		 * @return the integer value of the sum
		 */
		public int getCoinSlotTotal() {
			int total = 0;
			for (int i: coinSlot) {
				total += i;
			}
			return total;
		}
		
		/**
		 * The rejectCoin method is used to empty all coins in the coinSlot and return all coins inserted
		 * @return the string of reject what kind of coins and the total amount of rejected coins
		 */
		public String rejectCoin() {
			String result ="";
			
			//check if the coin is empty or not
			if (!coinSlot.isEmpty()) {
				
				//sort the coinslot in an ascending order
				sortAscend(coinSlot);
				
				//total amount of rejected coins
				int total = 0;
				
				result += "Rejected ";
				for (int i : coinSlot) {
					result+= "$";
					result += i;
					result += ", ";
				}
				//eliminate the extra comma and whitespace generated in the last loop
				result = result.substring(0, result.length()-2);
				result += ". $";
				total = getCoinSlotTotal();
				result += total;
				result += " in Total.";
				
				//clear all coins inserted
				coinSlot.clear();
				return result;
			}
			else {
				//cant reject if the coinslot is empty
				result += "Rejected no coin!";
				return result;
			}
		}
		
		/**
		 * the sortAscend method is to sort an  arraylist into an ascending order by bubble sort
		 * @param arr an ArrayList to be passed into the sortAscend method to be sorted
		 */
		public void sortAscend(ArrayList<Integer> arr) {
			for (int i = 0; i < arr.size(); i++) {
				for (int j = arr.size()-1; j > i; j--) {
					if (arr.get(i) > arr.get(j)){
						int temp = arr.get(i);
						arr.set(i,arr.get(j));
						arr.set(j,temp);
					}
				}
			}
		}
		
		/**
		 * the sortDescend method is to sort an  arraylist into an descending order by bubble sort
		 * @param arr an ArrayList to be passed into the sortDescend method to be sorted
		 */
		public void sortDescend(ArrayList<Integer> arr) {
			for (int i = 0; i < arr.size(); i++) {
				for (int j = arr.size()-1; j > i; j--) {
					if (arr.get(i) < arr.get(j)){
						int temp = arr.get(i);
						arr.set(i,arr.get(j));
						arr.set(j,temp);
					}
				}
			}
		}
		
		/**
		 * the returnChange method is to return the amount of coin change after purchase
		 * @param current_price the integer value of current price of the product being purchase and is passed into the returnChange method
		 * @param index the integer value of the index in the SoftDrinkSlot ArrayList that the softdrink is being purchased and is passed into the returnChange method
		 * @param quantity the integer value of the current quantity of the product being purchase and is passed into the returnChange method
		 * @return the string of purchasing status, amount paid and the amount of the coin returned
		 */
		public String returnChange(int current_price, int index, int quantity) {
			
			//an ArrayList that is temporarily storing the coin to be returned
			ArrayList<Integer> temp ;
			temp = new ArrayList<Integer>();
			
			//amount that is Needed To Change (ntc)
			int ntc=0;
			
			//coin item that is in the coinChanger
			int coin = 0;
			ntc = getCoinSlotTotal() - current_price;
			
			//sort coinChanger
			sortDescend(coinChanger);
			
			String result ="";
			// check each coin item in the sorted coinChanger
			// if less than or equal: can return the change and temporarily save in temp
			for (int i = 0; i < coinChanger.size(); i++) {
				coin = coinChanger.get(i);
				if (coin <= ntc) {
					ntc = ntc - coin;
					temp.add(coin);
				}
				//break when the amount that is Needed To Change is zero
				if (ntc == 0) {
					break;
				}
			}
			
			//successful payment if the amount that is Needed To Change is zero
			if (ntc == 0) {
				
				//sort the temp in an ascending order
				sortAscend(temp);
				
				//Concatenate the result string
				result += "Success!";
				result += " Paid $" + getCoinSlotTotal() + ". Change: ";
				for (int i = 0; i < temp.size(); i++) {
					result += "$";
					result += temp.get(i);
					result += ", ";
				}
				//eliminate the extra comma and whitespace generated in the last loop
				result = result.substring(0, result.length()-2);
				result += ".";
				
				//remove the coin item in coinChanger that is pulled out to the temp ArrayList
				int temp_coin;
				for (int i = 0; i < temp.size(); i ++) {
					temp_coin = temp.get(i);
					for(int j = 0; j < coinChanger.size();j++) {
						if (temp_coin == coinChanger.get(j)) {
							coinChanger.remove(j);
							break;
						}
					}
				}
				
				//add all coin items into coinSlot to coinChanger
				for (int i = 0; i < coinSlot.size(); i++) {
					coinChanger.add(coinSlot.get(i));
				}
				//clear all coinslot
				coinSlot.clear();
				//the quantity of the softdrink that is being purchased softDrinkSlots minus one
				softDrinkSlots.get(index).newQuantity(quantity-1);
			}
			else {
				//sufficient amount but insufficient change if ntc != 0
				result += "Insufficient change!";		
			}
			return result;
		}
		
		/**
		 * the purchaseDrink method that is able to check amount of stock and coins inserted to purchase a drink
		 * @param drink the string of softdrink that is going to be purchased
		 * @return the string of purchase status, amount paid and change amount
		 */
		public String purchaseDrink(String drink) {
			//the curremt price and current quantity of the softdrink being purchased
			int current_price =0;
			int current_quantity=0;
			//the index in the SoftDrinkSlot ArrayList that the softdrink is being purchased
			int index=0;
			
			String result = "Purchasing " + drink + "... ";
			//check which item of softdrink matches the drink that is being purchased
			for (int i=0; i <  softDrinkSlots.size(); i ++) {
				if (drink == softDrinkSlots.get(i).getName()) {
					current_price = softDrinkSlots.get(i).getPrice();
					current_quantity = softDrinkSlots.get(i).getQuantity();
					index = i;
				}
			}
			//out of stock if current quantity = 0
			if (current_quantity == 0) {
				result += "Out of stock!";
			}
			else {
				//insufficient amount if amount of coins inserted is less than the current price
				if (getCoinSlotTotal() < current_price) {
					result += "Insufficient amount! Inserted $" + getCoinSlotTotal() + " but needs $" + current_price + ".";
				}
				// return the change if the amount of coins inserted is larger than the current price
				else if (getCoinSlotTotal() > current_price) {
					result += returnChange(current_price, index, current_quantity);
				}
				//successful payment and no change if the amount of coins inserted is equal to  the current price
				else if (getCoinSlotTotal() == current_price){
					result += "Success!";
					result += " Paid $" + getCoinSlotTotal();
					result += ". No change.";
					for (int i = 0; i < coinSlot.size(); i++) {
						coinChanger.add(coinSlot.get(i));
					}
					//clear all coinslot
					coinSlot.clear();
					//the quantity of the softdrink that is being purchased softDrinkSlots minus one
					softDrinkSlots.get(index).newQuantity(current_quantity-1);
				}
			}
			return result;
		}
	}