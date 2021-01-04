package com.formos.smoothie_vendor;

import com.formos.smoothie_vendor.constant.Ingredient;
import com.formos.smoothie_vendor.error.LowIngredientQuantityException;
import com.formos.smoothie_vendor.error.NotEnoughIngredientQuantityException;
import com.formos.smoothie_vendor.util.AppUtil;
import com.formos.smoothie_vendor.util.UserUtil;
import com.formos.smoothie_vendor.util.ValidateUtil;

import java.util.Map;
import java.util.Scanner;

public class Main {

    private static int MIN_QUANTITY = 4;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) {
        boolean hasAuth = false;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Login to app by default user: admin/admin");
                System.out.println("Your username: ");
                String username = sc.nextLine();
                System.out.println("Your password: ");
                String password = sc.nextLine();
                UserUtil userUtil = UserUtil.getInstance();
                hasAuth = userUtil.authenticate(username, password);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (!hasAuth);
        System.out.println("Login successful");
        do {
            try {
                System.out.println("Menu: \n1. View inventory\n2. Sell smoothie\n3. Exit");
                System.out.println("Your choose: ");
                String input = sc.nextLine();
                switch (input) {
                    case "1": {
                        Inventory inventory = Inventory.getInstance();
                        System.out.println(inventory);
                        break;
                    }
                    case "2": {
                        System.out.println("Choose smoothie: \n1. Strawberry\n2. Banana\n3. Mango");
                        String option = sc.nextLine();
                        System.out.println("Input quantity : ");
                        int quantity = Integer.parseInt(sc.nextLine());
                        Map<Ingredient, Integer> spentIngredients;
                        switch (option) {
                            case "1": {
                                spentIngredients = AppUtil.makeStrawberrySmoothie(quantity);
                                break;
                            }
                            case "2": {
                                spentIngredients = AppUtil.makeBananaSmoothie(quantity);
                                break;
                            }
                            case "3": {
                                spentIngredients = AppUtil.makeMangoSmoothie(quantity);
                                break;
                            }
                            default: {
                                throw new IllegalArgumentException("Wrong input !!!");
                            }
                        }
                        System.out.println(String.format("Made %d smoothies !!!", quantity));
                        stringBuilder = new StringBuilder("You used:");
                        for(Map.Entry<Ingredient, Integer> entry: spentIngredients.entrySet()) {
                            stringBuilder.append("\n" + entry.getKey().name() + ": " + entry.getValue());
                        }
                        System.out.println(stringBuilder.toString());
                        ValidateUtil.checkInventory(MIN_QUANTITY);
                        break;
                    }
                    case "3": {
                        System.out.println("Goodbye!!!");
                        System.exit(1);
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Wrong input !!!");
                    }
                }
            }
            catch (NotEnoughIngredientQuantityException ex) {
                System.err.println(String.format("ERROR: %s", ex.getMessage()));
            }
            catch (LowIngredientQuantityException ex) {
                System.err.println(String.format("WARNING: %s", ex.getMessage()));
            }
            catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (true);
    }

}
