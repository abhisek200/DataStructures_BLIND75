package com.abpanda.Trees;

public class Main {
    public static void main(String[] args) {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode drinks2 = new TreeNode("ColdDrinks");
        TreeNode drinks21 = new TreeNode("Beer");
        TreeNode drinks22 = new TreeNode("Wine");
        TreeNode drinks3 = new TreeNode("HotDrinks");
        TreeNode drinks31 = new TreeNode("Tea");
        TreeNode drinks32 = new TreeNode("Coffee");
        drinks.addChild(drinks2);
        drinks.addChild(drinks3);
        drinks2.addChild(drinks21);
        drinks2.addChild(drinks22);
        drinks3.addChild(drinks32);
        drinks3.addChild(drinks31);
        System.out.println(drinks.print(0));
    }
}
