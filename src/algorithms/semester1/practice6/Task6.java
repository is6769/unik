package algorithms.semester1.practice6;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class CustomLinkedList<T> {
    private Node<T> head;
    private int size;

    public CustomLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addAfter(T data, int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        Node<T> newNode = new Node<>(data);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public CustomLinkedList<T> getTailList() {
        if (isEmpty() || head.next == null) {
            return new CustomLinkedList<>();
        }

        CustomLinkedList<T> tailList = new CustomLinkedList<>();
        tailList.head = head.next;
        tailList.size = size - 1;
        return tailList;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();

        System.out.println("Список пуст: " + list.isEmpty());

        System.out.println("\nДобавление элементов:");
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.print("После добавления в начало: ");
        list.printList();

        list.addLast(4);
        list.addLast(5);
        System.out.print("После добавления в конец: ");
        list.printList();

        list.addAfter(6, 2);
        System.out.print("После добавления после 3-го элемента: ");
        list.printList();

        // Размер списка
        System.out.println("\nРазмер списка: " + list.size());

        // Проверка на пустоту после добавления элементов
        System.out.println("Список пуст: " + list.isEmpty());

        // Получение списка без первого элемента
        System.out.println("\nСписок без первого элемента:");
        CustomLinkedList<Integer> tailList = list.getTailList();
        tailList.printList();
    }
}