public class VendingMachine {
    private static VendingMachine vendingMachineInstance;
    Inventory inventory;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private VendingMachineState currentState;
    private Product selectedProduct;
    private double totalPayment;


    private VendingMachine()
    {
        inventory = new Inventory();
        this.idleState = new IdleState(this);
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this);
        this.returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        selectedProduct = null;
        totalPayment = 0.0;
    }

    public static synchronized VendingMachine getInstance() {
        if (vendingMachineInstance == null){
           vendingMachineInstance = new VendingMachine();
        }
        return vendingMachineInstance;
    }

    public void selectProduct(Product product){
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note){
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    void setState(VendingMachineState vendingMachineState) {
        currentState = vendingMachineState;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void resetSelectedProduct() {
        this.selectedProduct = null;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    public void addNote(Note note) {
        totalPayment += note.getValue();
    }

    public void resetPayment() {
        totalPayment = 0.0;
    }

}
