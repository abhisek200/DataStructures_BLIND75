package com.abpanda.LinkedLists.SinglyLinkedList;


/*
 * head|001 -> 1|222 (001) -> 2|333 (222) -> 3|null (444) -> Tail|444
 * ->
 * Create Head and tail with null ->
 * create blank node and assign value to it and reference to null ->
 * Link head and tail with these node.
 *
 * */
public class mainSLL {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.createSLL(12);
        System.out.println(sll.head.value);

        sll.insertInSLL(2, 1);
        sll.insertInSLL(6, 2);
        sll.insertInSLL(9, 3);

        sll.traverSll();

        sll.searchSll(10);
        sll.searchSll(4);
        sll.searchSll(9);


    }
}
