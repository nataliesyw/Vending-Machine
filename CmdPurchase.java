package asm3;

/**
 * 
 * the the CmdPurchase class that inherits the class command
 * it is used to perform the action of vending the softdrink and return the minimum amount of the change
 *
 */
public class CmdPurchase extends Command {
	@Override
	
	/**
	 * the execute method that performs vending the softdrink and returning the command result
	 * @param v the VendingMachine object that is passed into the method
	 * @param cmdPart the String of the command content
	 * @return the string of the command purchase result 
	 */
	public String execute(VendingMachine v, String cmdPart) {
		return v.purchaseDrink(cmdPart);
	}
}
