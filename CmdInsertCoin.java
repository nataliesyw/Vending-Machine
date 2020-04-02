package asm3;

/**
 * the the CmdInsertCoin class that inherits the class command
 * it is used to perform the action of inserting a coin in coin slot
 *
 */
public class CmdInsertCoin extends Command {
	@Override
	/**
	 * the execute method that performs inserting a coin and returning the command result
	 * @param v the VendingMachine object that is passed into the method
	 * @param cmdPart the String of the command content
	 * @return the string of the coin inserted and total amount of coins inserted
	 */
	public String execute(VendingMachine v, String cmdPart) {
		Integer coin = Integer.valueOf(cmdPart);
		v.addCoinToCoinSlot(coin);
		Integer total = v.getCoinSlotTotal();
		return ("Inserted a $" + cmdPart + " coin. $" + total +" in Total.");
	}
}
