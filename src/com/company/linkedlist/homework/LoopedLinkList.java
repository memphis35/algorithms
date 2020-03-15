package com.company.linkedlist.homework;

import com.company.exceptions.EmptyListException;
import com.company.linkedlist.linklist.Link;

/**
 * 5.3. Циклическим списком называется связанный список, в котором последний
 * элемент содержит ссылку на первый элемент. Существует много способов реализа-
 * ции циклических списков. Иногда объект списка содержит указатель на «начало»
 * списка. Однако в этом случае список уже не похож на замкнутый круг, а больше
 * напоминает обычный список, у которого конец связан с началом. Создайте класс
 * для односвязного списка, не имеющий ни начала, ни конца. Доступ к списку осу-
 * ществляется по единственной ссылке current, которая может указывать на любой
 * элемент списка. Ссылка перемещается по списку так, как требуется пользователю
 * (ситуация, для которой идеально подходит циклический список, представлена
 * в проекте 5.5). Список должен поддерживать операции вставки, поиска и удаления.
 * Вероятно, удобнее выполнять эти операции с элементом, следующим за тем, на
 * который указывает current. (Так как список является односвязным, вы не сможе-
 * те вернуться к предыдущему элементу без полного прохождения всей цепочки.)
 * Также следует предусмотреть возможность вывода содержимого списка (хотя его
 * придется разбить в некоторой точке для вывода на экран). Метод step(), который
 * перемещает current к следующему элементу, тоже может пригодиться.
 */
public class LoopedLinkList {

    private Link current;

    private Link getCurrent() {
        return current;
    }

    public void insert(String data) {
        Link element = new Link(data);
        if (isEmpty()) {
            current = element;
            element.next = element;
        } else if (current.equals(current.next)) {
            current.next = element;
            element.next = current;
        } else {
            element.next = current.next;
            current.next = element;
        }
    }

    public void next() {
        if (current.next != null) {
            current = current.next;
        }
    }

    public Link delete() throws EmptyListException {
        Link result = current.next;
        Link temp = current.next;
        if (!isEmpty()) {
            if (current.equals(current.next)) {
                current = null;
            } else {
                temp = temp.next;
                current.next = temp;
            }
        } else {
            throw new EmptyListException("Empty list.");
        }
        next();
        return result;
    }

    private boolean isEmpty() {
        return current == null;
    }

    public void clear() {
        while (current != null) {
            delete();
        }
    }

    public static void main(String[] args) {
        LoopedLinkList example = new LoopedLinkList();
        example.insert("Mike");
        example.insert("Alex");
        example.insert("Fiona");
        example.insert("Shaun");
        System.out.println(example.getCurrent().getData());
        while (!example.isEmpty()) {
            System.out.println(example.delete().getData());
        }
    }

}
