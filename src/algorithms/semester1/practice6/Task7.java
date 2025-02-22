//package algorithms.semester1.practice6;
//
//class Node<T> {
//    T data;
//    Node<T> next;
//
//    public Node(T data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//
//class LinkedList<T> {
//    private Node<T> head;
//
//    public boolean equals(LinkedList<T> other) {
//        Node<T> current1 = this.head;
//        Node<T> current2 = other.head;
//
//        while (current1 != null && current2 != null) {
//            if (!current1.data.equals(current2.data)) {
//                return false;
//            }
//            current1 = current1.next;
//            current2 = current2.next;
//        }
//        return current1 == null && current2 == null;
//    }
//
//    public boolean isSubset(LinkedList<T> L2) {
//        Node<T> current1 = this.head;
//        while (current1 != null) {
//            if (!containsElement(L2, current1.data)) {
//                return false;
//            }
//            current1 = current1.next;
//        }
//        return true;
//    }
//
//    private boolean containsElement(LinkedList<T> list, T element) {
//        Node<T> current = list.head;
//        while (current != null) {
//            if (current.data.equals(element)) {
//                return true;
//            }
//            current = current.next;
//        }
//        return false;
//    }
//
//    public boolean hasDuplicates() {
//        Node<T> current = head;
//        while (current != null) {
//            Node<T> runner = current.next;
//            while (runner != null) {
//                if (current.data.equals(runner.data)) {
//                    return true;
//                }
//                runner = runner.next;
//            }
//            current = current.next;
//        }
//        return false;
//    }
//
//    public void moveFirstToEnd() {
//        if (head == null || head.next == null) {
//            return;
//        }
//        Node<T> first = head;
//        head = head.next;
//        Node<T> current = head;
//        while (current.next != null) {
//            current = current.next;
//        }
//        current.next = first;
//        first.next = null;
//    }
//
//    public void moveLastToFront() {
//        if (head == null || head.next == null) {
//            return;
//        }
//        Node<T> current = head;
//        Node<T> previous = null;
//        while (current.next != null) {
//            previous = current;
//            current = current.next;
//        }
//        previous.next = null;
//        current.next = head;
//        head = current;
//    }
//
//    public void appendList(LinkedList<T> L2) {
//        if (L2.head == null) {
//            return;
//        }
//        if (this.head == null) {
//            this.head = L2.head;
//            return;
//        }
//        Node<T> current = this.head;
//        while (current.next != null) {
//            current = current.next;
//        }
//        Node<T> current2 = L2.head;
//        while (current2 != null) {
//            current.next = new Node<>(current2.data);
//            current = current.next;
//            current2 = current2.next;
//        }
//    }
//
//    public void reverse() {
//        Node<T> prev = null;
//        Node<T> current = head;
//        Node<T> next;
//        while (current != null) {
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//        head = prev;
//    }
//
//    public void removeDuplicates() {
//        if (head == null) {
//            return;
//        }
//        Node<T> current = head;
//        while (current != null) {
//            Node<T> runner = current;
//            while (runner.next != null) {
//                if (current.data.equals(runner.next.data)) {
//                    runner.next = runner.next.next;
//                } else {
//                    runner = runner.next;
//                }
//            }
//            current = current.next;
//        }
//    }
//
//    public void add(T data) {
//        Node<T> newNode = new Node<>(data);
//        if (head == null) {
//            head = newNode;
//            return;
//        }
//        Node<T> current = head;
//        while (current.next != null) {
//            current = current.next;
//        }
//        current.next = newNode;
//    }
//
//    public void printList() {
//        Node<T> current = head;
//        while (current != null) {
//            System.out.print(current.data + " -> ");
//            current = current.next;
//        }
//        System.out.println("null");
//    }
//}
//
//public class Task7 {
//    public static void main(String[] args) {
//        System.out.println("=== Инициализация тестовых списков ===");
//        LinkedList<Integer> L1 = new LinkedList<>();
//        LinkedList<Integer> L2 = new LinkedList<>();
//
//        L1.add(1);
//        L1.add(2);
//        L1.add(3);
//        System.out.print("L1: ");
//        L1.printList();
//
//        L2.add(1);
//        L2.add(2);
//        L2.add(3);
//        L2.add(3);
//        System.out.print("L2: ");
//        L2.printList();
//
//        System.out.println("\n=== Тест а) Проверка на равенство списков ===");
//        System.out.println("L1 равен L2: " + L1.equals(L2));
//        L2.add(4);
//        System.out.print("L2 после добавления элемента: ");
//        L2.printList();
//        System.out.println("L1 равен L2: " + L1.equals(L2));
//
//        System.out.println("\n=== Тест б) Проверка вхождения всех элементов L1 в L2 ===");
//        System.out.println("Все элементы L1 входят в L2: " + L1.isSubset(L2));
//        L1.add(5);
//        System.out.print("L1 после добавления 5: ");
//        L1.printList();
//        System.out.println("Все элементы L1 входят в L2: " + L1.isSubset(L2));
//
//        System.out.println("\n=== Тест в) Проверка наличия дубликатов ===");
//        LinkedList<Integer> L3 = new LinkedList<>();
//        L3.add(1);
//        L3.add(2);
//        L3.add(2);
//        L3.add(3);
//        System.out.print("L3 с дубликатом: ");
//        L3.printList();
//        System.out.println("L3 имеет дубликаты: " + L3.hasDuplicates());
//        System.out.println("L1 имеет дубликаты: " + L1.hasDuplicates());
//
//        System.out.println("\n=== Тест г) Перенос первого элемента в конец ===");
//        System.out.print("L1 до переноса: ");
//        L1.printList();
//        L1.moveFirstToEnd();
//        System.out.print("L1 после переноса: ");
//        L1.printList();
//
//        System.out.println("\n=== Тест д) Перенос последнего элемента в начало ===");
//        System.out.print("L1 до переноса: ");
//        L1.printList();
//        L1.moveLastToFront();
//        System.out.print("L1 после переноса: ");
//        L1.printList();
//
//        System.out.println("\n=== Тест е) Добавление элементов L2 в конец L1 ===");
//        System.out.print("L1 до добавления: ");
//        L1.printList();
//        System.out.print("L2: ");
//        L2.printList();
//        L1.appendList(L2);
//        System.out.print("L1 после добавления L2: ");
//        L1.printList();
//
//        System.out.println("\n=== Тест ж) Разворот списка ===");
//        System.out.print("L1 до разворота: ");
//        L1.printList();
//        L1.reverse();
//        System.out.print("L1 после разворота: ");
//        L1.printList();
//
//        System.out.println("\n=== Тест з) Удаление дубликатов ===");
//        LinkedList<Integer> L4 = new LinkedList<>();
//        L4.add(1);
//        L4.add(2);
//        L4.add(2);
//        L4.add(3);
//        L4.add(3);
//        L4.add(1);
//        System.out.print("L4 до удаления дубликатов: ");
//        L4.printList();
//        L4.removeDuplicates();
//        System.out.print("L4 после удаления дубликатов: ");
//        L4.printList();
//
//        System.out.println("\n=== Тесты граничных случаев ===");
//
//        LinkedList<Integer> emptyList = new LinkedList<>();
//        System.out.println("Операции с пустым списком:");
//        emptyList.moveFirstToEnd();
//        emptyList.moveLastToFront();
//        emptyList.reverse();
//        System.out.print("Пустой список после операций: ");
//        emptyList.printList();
//
//        LinkedList<Integer> singleElementList = new LinkedList<>();
//        singleElementList.add(1);
//        System.out.println("\nОперации со списком из одного элемента:");
//        System.out.print("До: ");
//        singleElementList.printList();
//        singleElementList.moveFirstToEnd();
//        singleElementList.moveLastToFront();
//        singleElementList.reverse();
//        System.out.print("После: ");
//        singleElementList.printList();
//    }
//}