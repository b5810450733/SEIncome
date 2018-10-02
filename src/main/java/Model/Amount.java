package Model;

public class Amount {
    private long totalAmount;

    public Amount() {
        this.totalAmount = totalAmount;
    }

    public long getTotalAmount() {

        return totalAmount;
    }

    public void setTotalAmount(int type,int totalAmount) {
        if (type == 1){
            addAmount(totalAmount);
        }if (type == 0){
            decreseAmount(totalAmount);
        }
    }

    public void addAmount(int i){
        this.totalAmount += i;
    }

    public void decreseAmount(int i){
        this.totalAmount -= i;
    }

}
