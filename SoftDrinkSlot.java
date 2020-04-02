package asm3;

/**
 * 
 * the softdrinkslot class that represents soft drink slot including name, price and quantity of corresponding drink
 *
 */
public class SoftDrinkSlot {
	private String name;
	private int price;
	private int quantity;
	
	/**
	 * the softdrinkslot object that represents the current drink properties
	 * @param name the string of the name of the drink
	 * @param price the integer value of the price of the drink
	 * @param quantity the integer value of the quantity of the drink
	 */
	public SoftDrinkSlot(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * the newQuantity is to set the new quantiy of the softdrink slot
	 * @param newQuantity the integer value of the new quantity to be passed to the method 
	 */
	public void newQuantity (int newQuantity) {
		quantity = newQuantity;
	}
	/**
	 * the getQuantity is to get the quantity of the softdrink in the slot
	 * @return the integer value of the quantity required
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * the getPrice is to get the price of the softdrink in the slot
	 * @return the integer value of the price required
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * the getName is to get the name of the softdrink in the slot
	 * @return the string of the name required
	 */
	public String getName() {
		return name;
	}
}
