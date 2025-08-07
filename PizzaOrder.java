package CodingUpdeshMasterChallenge;

import java.util.Scanner;
public class PizzaOrder {
    static Scanner sc=new Scanner(System.in);
    static String customerName =null;
    static String customerEmail = null;
    static long phoneNo = 0;
    static String address = null;
    public static void main(String[] args) {
        System.out.print("Enter the customer name:");
        customerName=sc.nextLine();
        System.out.print("Enter the customer Email:");
        customerEmail=sc.next();
        System.out.print("Enter the phone no:");
        phoneNo=sc.nextLong();
        sc.nextLine();
        System.out.print("Enter the address:");
        address=sc.nextLine();
        displayMenu();
    }


    public static  void displayCustomerDetails(String name,String email,long phoneNo,String address)
    {
        System.out.println("Customer name : "+name);
        System.out.println("Customer Email : "+email);
        System.out.println("Customer phone no : "+phoneNo);
        System.out.println("Customer address : "+address);
    }

    static void displayMenu(){
        float totalPricePizza = 0;
        float totalPriceGarlicBread = 0;
        float totalPriceBeverages =0;
        int smallSizeNoOfPizzas = 0;
        int mediumSizeNoOfPizza =0;
        int largeSizeNoOfPizza =0;
        int noOfGarlicBreadOrdered = 0;
        int noOfBeveragesOrdered = 0;
        boolean condition = true;
        char size = '\u0000';
        do
        {
            System.out.println("Select the items to order");
            System.out.println("Sl No         Item Category");
            System.out.println("------------------------------");
            System.out.println("1)Pizza");
            System.out.println("  Price of One Regular Pizza : $9.99");
            System.out.println("  Price of One Medium Pizza : $11.99");
            System.out.println("  Price of One Large Pizza : $13.99");
            System.out.println("2)Garlic Bread");
            System.out.println("   Price of One Garlic Bread : $5.99");
            System.out.println("3)Beverages");
            System.out.println("   Price of the Beverage    : $1.99");
            System.out.println("Enter 1 for Pizza, 2 for Garlic Bread and 3 for Beverages and others number for nothing you can ordered");
            System.out.println("===============================================================");
            System.out.print("Enter the choice:");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:

                    System.out.print("Enter the no of pizza ordered:");
                    int noOfPizzas = sc.nextInt();
                    System.out.println("-----size---------");
                    System.out.println("write l for large\nwrite m for medium\nwrite s for small");
                    System.out.print("Enter the size of pizza:");
                    size = sc.next().charAt(0);
                    if(size == 's')
                    {
                        smallSizeNoOfPizzas += noOfPizzas;
                    } else if (size == 'm') {
                        mediumSizeNoOfPizza += noOfPizzas;
                    }
                    else if(size == 'l')
                    {
                        largeSizeNoOfPizza +=noOfPizzas;
                    }
                    else {
                        System.out.println("sorry,please Enter the correct size of pizza!");
                    }
                    float price = getPriceOfPizzaBasedOnSize(size);
                    totalPricePizza += calculatePriceOfPizza(noOfPizzas,price);

                    break;
                case 2:
                    System.out.print("No of Garlic Bread Ordered:");
                    noOfGarlicBreadOrdered += sc.nextInt();
                    float priceOfGarlic =  getPriceOfGarlicBread();
                    totalPriceGarlicBread = calculatePriceOfGarlicBread(noOfGarlicBreadOrdered,priceOfGarlic);
                    break;
                case 3:
                    System.out.print("No of Beverages Ordered:");
                    noOfBeveragesOrdered += sc.nextInt();
                    float priceOfBeverages = getPriceOfBeverage();
                    totalPriceBeverages = calculatePriceOfBeverage(noOfBeveragesOrdered,priceOfBeverages);
                    break;
                default:
                    condition = false;
            }
        }while (condition);
       float totalBill=calculateTotalBill(totalPricePizza,totalPriceGarlicBread,totalPriceBeverages);
       float actualBill = calculateDiscountAndReturnBillAmount(totalBill);
       displayOrderDetails(largeSizeNoOfPizza,mediumSizeNoOfPizza,smallSizeNoOfPizzas,noOfGarlicBreadOrdered,noOfBeveragesOrdered,totalBill,actualBill,size);
    }

    public static float getPriceOfPizzaBasedOnSize(char size)
    {
        boolean checkSizeOfPizza ;
        float priceOfPizza=0;
        do
        {

            switch (size){
                case 'l':
                    priceOfPizza = 13.99f;
                    checkSizeOfPizza =false;
                    break;
                case 'm':
                    priceOfPizza = 11.99f;
                    checkSizeOfPizza =false;
                    break;
                case 's':
                    priceOfPizza=9.99f;
                    checkSizeOfPizza = false;
                    break;
                default:
                    System.out.println("Enter the correct size:");
                    size =sc.next().charAt(0);
                    checkSizeOfPizza = true;
            }

        } while (checkSizeOfPizza);
        return  priceOfPizza;
    }

    public static float getPriceOfGarlicBread()
    {
        return 5.99f;
    }

    public static float getPriceOfBeverage()
    {
        return 1.99f;
    }

    public static float calculatePriceOfPizza(int noOfPizza,float priceOfPizza)
    {
        return noOfPizza*priceOfPizza;
    }

    public static float calculatePriceOfGarlicBread(int noOfGarlicBread,float priceOfGarlicBread){
        return noOfGarlicBread*priceOfGarlicBread;
    }

    public static float calculatePriceOfBeverage(int noOfBeverages,float priceOfBeverages){
        return noOfBeverages*priceOfBeverages;
    }

    public static float calculateTotalBill(float totalPizzaPrice,float totalGarlicBreadPrice,float totalBeveragePrice)
    {
        return (totalPizzaPrice+totalGarlicBreadPrice+totalBeveragePrice);
    }

    public static float calculateDiscountAndReturnBillAmount(float totalBillAmount)
    {
        if(totalBillAmount>50)
        {
            return (totalBillAmount-((totalBillAmount*10)/100));
        }
        else {
            return totalBillAmount;
        }
    }

    public static void displayOrderDetails(int largeNoOfPizza,int mediumNoOfPizza,int smallNoOfPizza ,int noOfGarlicBread,int noOfBeverages,
                                    float totalPrize,float totalPrizeAfterDiscount,char pizzaSize)
    {
        System.out.println("Order Details");
        displayCustomerDetails(customerName,customerEmail,phoneNo,address);
        System.out.println("-------------------------------------");
        System.out.println("The number of pizzas ordered of large size : "+largeNoOfPizza);
        System.out.println("The number of pizzas ordered of medium size : "+mediumNoOfPizza);
        System.out.println("The number of pizzas ordered of small size : "+smallNoOfPizza);
        System.out.println("The number of garlic bread ordered : "+noOfGarlicBread);
        System.out.println("The number of beverages ordered    : "+noOfBeverages);
        System.out.println("--------------------------------------------------------------");
        System.out.println("The Total Bill Amount is      : "+totalPrize);
        System.out.println("The Discounted Bill Amount is : "+totalPrizeAfterDiscount);
    }
}
