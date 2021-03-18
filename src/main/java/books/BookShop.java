package books;

import java.util.List; 

public class BookShop {

    private final String name;

    /**
     * Constructor of the class Book shop
     * @param name name of the book shop
     */
    public BookShop(String name){
        this.name = name;
    }

    /**
     * method to compute the cost of a basket
     * @param books array corresponding to the number of each harry potter book the client desire to buy (books.length should return 5)
     * @return the cost in euro with the discount
     */
    public double cost(int[] books){
        public double cost(int[] books){
            double []ReductionRate = {1, 0.93, 0.86, 0.72, 0.65}; 
            int []Reduction = new int[5]; 
            
            public Double DeterminePrice(List<Integer> basket) {
                if (basket == null || basket.isEmpty()) {
                    return 0.0;
                }
                int []booksInOrder = DetermineBooksInOrder(basket); 
                DetermineReduction(booksInOrder); 
                bestReduction();
                double price = 0.0; 
                for (int i = 0; i<Reduction.length;i++) {
                    price += (8 * (i+1) * Reduction[i]) * ReductionRate[i]; 
                }
                return price; 
            }
            protected void bestReduction() {
                while (Reduction[2]>0 && Reduction[4]>0) {
                    Reduction[2]--; 
                    Reduction[4]--; 
                    Reduction[3] += 2; 
                }
            }
            protected void DetermineReduction(int[]booksInOrder) {
                if (booksInOrder == null) {
                    return; 
                }
                int otherThanZero = 0; 
                for (int i = 0; i < booksInOrder.length; i++) {
                    if (booksInOrder[i]>0) {
                        otherThanZero++; 
                        booksInOrder[i]--; 
                    }
                }
                if (otherThanZero > 0) {
                    Reduction[otherThanZero - 1] += 1; 
                    DetermineReduction(booksInOrder);
                }
            }
            private int[]DetermineBooksInOrder(List<Integer>basket){
                int[] result = new int[5]; 
                for (int book : basket) {
                    result[book - 1]++; 
                }
                return result;
    }
}
