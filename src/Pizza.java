import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author qianq
 */
public class Pizza {

    @Test
    public void givenPizaOrder_whenReady_thenDeliverable() {
        Pizza pizza = new Pizza();
        pizza.setPizzaStatus(PizzaStatus.READY);
        assertTrue(pizza.isDeliverable());
        pizza.printTimeToDelivery();
    }

    private PizzaStatus pizzaStatus;

    public PizzaStatus getPizzaStatus() {
        return this.pizzaStatus;
    }
    public void setPizzaStatus(PizzaStatus pizzaStatus) {
        this.pizzaStatus = pizzaStatus;
    }

    public enum PizzaStatus {
        /**
         * 下单
         */
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        /**
         * 准备
         */
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        /**
         * 交付
         */
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}
        public boolean isReady() {return false;}
        public boolean isDelivered() {return false;}

        public int getTimeToDelivery() {
            return this.timeToDelivery;
        }

        PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.pizzaStatus.isReady();
    }

    public void printTimeToDelivery() {
        System.out.println(this.getPizzaStatus().getTimeToDelivery());
    }
}
