package com.driver;

public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;

    private String[] contents = {"Base Price Of The Pizza: ",
    "Extra Cheese Added: ",
    "Extra Toppings Added: ",
    "Paperbag Added: ",
    "Total Price: "
    };

    private int[] prices = new int[5];
    private boolean[] wanted = new boolean[5];

    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        // your code goes here
        if(isVeg) prices[Ingredients.BASE_PRICE.ordinal()] = 300;
        else prices[Ingredients.BASE_PRICE.ordinal()] = 400;
        wanted[Ingredients.BASE_PRICE.ordinal()] = true;

        price = 0;
        price+= prices[Ingredients.BASE_PRICE.ordinal()];
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        // your code goes here
        if(wanted[Ingredients.CHEESE.ordinal()]) return;
        wanted[Ingredients.CHEESE.ordinal()] = true;
        prices[Ingredients.CHEESE.ordinal()] = 80;

        price+=prices[Ingredients.CHEESE.ordinal()];
    }

    public void addExtraToppings(){
        // your code goes here
        if(wanted[Ingredients.TOPPINGS.ordinal()]) return;
        wanted[Ingredients.TOPPINGS.ordinal()] = true;

        if(isVeg) prices[Ingredients.TOPPINGS.ordinal()] = 70;
        else prices[Ingredients.TOPPINGS.ordinal()] = 120;

        price+=prices[Ingredients.TOPPINGS.ordinal()];
    }

    public void addTakeaway(){
        if(wanted[Ingredients.PAPERBAG.ordinal()]) return;
        wanted[Ingredients.PAPERBAG.ordinal()] = true;

        prices[Ingredients.PAPERBAG.ordinal()] = 20;

        price+=prices[Ingredients.PAPERBAG.ordinal()];
    }

    public String getBill(){
        // your code goes here
        wanted[Ingredients.TOTAL.ordinal()] = true;
        prices[Ingredients.TOTAL.ordinal()] = price;

        bill = "";

        for(int i=0;i< wanted.length;i++) {
            if (wanted[i] && prices[i]!=0) {
                bill += (contents[i] + prices[i] + "\n");
            }
        }

        return this.bill;
    }

    public void giveCheeseAndToppings(){
        addExtraCheese();
        addExtraToppings();
    }
}

enum Ingredients {
    BASE_PRICE,
    CHEESE,
    TOPPINGS,
    PAPERBAG,
    TOTAL;
}
