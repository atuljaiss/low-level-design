public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to the inventory
        Product coke = new Product("Coke", 15, 111);
        Product pepsi = new Product("Pepsi", 15, 222);
        Product water = new Product("Water", 10, 333);

        vendingMachine.inventory.addProduct(coke, 5);
        vendingMachine.inventory.addProduct(pepsi, 3);
        vendingMachine.inventory.addProduct(water, 2);

        // Select a product
        vendingMachine.selectProduct(coke);

        // Insert coins
        vendingMachine.insertCoin(Coin.COIN_5);
        vendingMachine.insertCoin(Coin.COIN_5);
        vendingMachine.insertCoin(Coin.COIN_2);

        // Insert a note
        vendingMachine.insertNote(Note.NOTE_10);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();

        // Select another product
        vendingMachine.selectProduct(pepsi);

        // Insert insufficient payment
        vendingMachine.insertCoin(Coin.COIN_1);

        // Try to dispense the product
        vendingMachine.dispenseProduct();

        // Insert more coins
        vendingMachine.insertCoin(Coin.COIN_5);
        vendingMachine.insertCoin(Coin.COIN_5);
        vendingMachine.insertCoin(Coin.COIN_5);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();

    }
}