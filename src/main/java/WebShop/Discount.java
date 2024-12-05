package WebShop;

public class Discount {
   /**
     * @param price
     * @param discount
     * @return
     * @throws ArithmeticException
     */
    public double dis(double price, double discount) throws ArithmeticException {
        if (discount == 0) {
            throw new ArithmeticException("The discount can not be null!");
        }
        return (double) price * (discount / 100);
    }
}
