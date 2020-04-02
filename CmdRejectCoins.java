package asm3;

/**
 * the CmdRejectCoins class that inherits the class command
 * it is used to perform the action of rejecting all coins from Coin Slot
 */
public class CmdRejectCoins extends Command {
	
	/**
	 * the execute method that performs rejecting all coins and return the result
	 * @param v the VendingMachine object that is passed into the method
	 * @param cmdPart the String of the command content
	 * @return the command execution result
	 */
	public String execute(VendingMachine v, String cmdPart) {
		String result="";
		if(cmdPart == "") {
			result = v.rejectCoin();
		}
		return result;
	}
}
