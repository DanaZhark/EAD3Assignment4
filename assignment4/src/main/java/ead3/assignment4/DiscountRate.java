package ead3.assignment3;

public class DiscountRate {
    static Double premium = 0.8;
    static Double gold = 0.85;
    static Double silver = 0.9;
    static Double member = 0.9;

    static Double totalSum = 0.0;

    public static void discountService(Double price, String membership) {
        switch (membership) {
            case "Premium":
                price *= premium;
                totalSum += price;
                break;
            case "Gold":
                price *= gold;
                totalSum += price;
                break;
            case "Silver":
                price *= silver;
                totalSum += price;
                break;
        }
    }

    public static void discountProduct(Double price) {
        price *= member;
        totalSum += price;
    }

    public static void printTotalSum() {
        System.out.println("Total sum: " + totalSum + "$");
    }

    public static void setTotalSum(Double totalSum) {
        DiscountRate.totalSum = totalSum;
    }

    public static Double getTotalSum() {
        return totalSum;
    }
}
