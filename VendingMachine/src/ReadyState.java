public class ReadyState implements VendingMachineState {
    private final VendingMachine vendingMachine;
    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already Selected");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("coin inserted : " + coin);
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note insterted : " + note);
        checkPaymentStatus();
    }

    private void checkPaymentStatus() {
        if(vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()){
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product and make payment.");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return.");
    }
}
